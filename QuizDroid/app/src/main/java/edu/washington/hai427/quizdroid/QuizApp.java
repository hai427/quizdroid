package edu.washington.hai427.quizdroid;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

/**
 * Created by Hai on 2/14/2017.
 */

public class QuizApp extends Application{
    private static final String TAG = "QuizApp";
    TopicRepository topicRepo;

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: Running");
        topicRepo = TopicRepository.getInstance();
    }
}
