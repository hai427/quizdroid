package edu.washington.hai427.quizdroid;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class AnswerFragment extends Fragment {

    public AnswerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_answer, container, false);

        final int questionsAnswered = getArguments().getInt("questionsAnswered", 0);
        Button finish;
        finish = (Button) v.findViewById(R.id.finish);
        if (questionsAnswered == 0) {
            finish.setText("Finish");
        } else {
            finish.setText("Next");
        }

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (questionsAnswered == 0) {
                    intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                } else {
                    Fragment questionFragment = new QuestionFragment();

                    Bundle bundle = getArguments();
                    int questionsAnswered = bundle.getInt("questionsAnswered");
                    bundle.putInt("questionsAnswered", questionsAnswered - 1);

                    questionFragment.setArguments(bundle);

                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, questionFragment);
                    fragmentTransaction.commit();
                }
            }
        });

        return v;
    }
}
