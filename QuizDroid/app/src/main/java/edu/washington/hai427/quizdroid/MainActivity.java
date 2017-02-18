package edu.washington.hai427.quizdroid;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.security.Permission;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    QuizApp quizApp;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadFilesTask download = new DownloadFilesTask();
        download.execute();

        quizApp = (QuizApp) getApplication();
    }

    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    public File getAlbumStorageDir() {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS), "questions.json");
        if (!file.mkdirs()) {
            Log.e(TAG, "Directory not created");
        }
        return file;
    }

    private class DownloadFilesTask extends AsyncTask<URI, Void, Void> {

        TopicRepository topicRepo = ((QuizApp) getApplication()).topicRepo;

        protected Void doInBackground(URI... urls) {
            try {
                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if(permissionCheck == -1){
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
                }
                File file = new File(Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOWNLOADS), "questions.json");
                FileInputStream in = new FileInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder out = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    out.append(line);
                }
                String json = out.toString();
                JSONArray topics = new JSONArray(json);
                for (int i=0; i<topics.length(); i++) {
                    JSONObject topic = topics.getJSONObject(i);
                    String title = topic.getString("title");
                    String desc = topic.getString("desc");
                    JSONArray questions = topic.getJSONArray("questions");
                    Topic newTopic = new Topic(title, desc, desc);
                    for (int j=0; j<questions.length(); j++) {
                        JSONObject question = questions.getJSONObject(j);
                        String text = question.getString("text");
                        int answer = question.getInt("answer");
                        JSONArray answers = question.getJSONArray("answers");
                        Question newQuestion = new Question(text, answer);
                        for (int k=0; k<answers.length(); k++) {
                            String newAnswer = answers.getString(k);
                            newQuestion.addAnswer(newAnswer);
                        }
                    }
                    topicRepo.addTopic(newTopic);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            Log.e(TAG, "onPostExecute: Downloaded \" + result + \" bytes");
            afterDownload();
        }
    }

    public void afterDownload() {
        String[] topics = new String[quizApp.topicRepo.topics.size()];

        for (int i=0; i<topics.length; i++) {
            topics[i] = quizApp.topicRepo.topics.get(i).title;
        }

        ListView listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                topics);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                intent.putExtra("Position", position);
                startActivity(intent);
            }
        });
    }
}
