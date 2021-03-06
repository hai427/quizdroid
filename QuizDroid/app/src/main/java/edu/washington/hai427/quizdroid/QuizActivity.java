package edu.washington.hai427.quizdroid;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;

public class QuizActivity extends AppCompatActivity {
    Topic topic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        int position = getIntent().getIntExtra("Position", 0);

        QuizApp quizApp = (QuizApp) getApplication();

        topic = quizApp.topicRepo.topics.get(position);

        Bundle bundle = new Bundle();
        bundle.putInt("questionsAnswered", topic.questions.size() - 1);

        Fragment topicOverviewFragment = new TopicOverviewFragment();

        topicOverviewFragment.setArguments(bundle);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, topicOverviewFragment);
        fragmentTransaction.commit();
    }
}
