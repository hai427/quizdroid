package edu.washington.hai427.quizdroid;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Bundle bundle = new Bundle();
        bundle.putInt("questionsAnswered", 3);

        Fragment topicOverviewFragment = new TopicOverviewFragment();

        topicOverviewFragment.setArguments(bundle);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, topicOverviewFragment);
        fragmentTransaction.commit();
    }
}
