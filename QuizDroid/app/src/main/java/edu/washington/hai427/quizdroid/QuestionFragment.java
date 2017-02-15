package edu.washington.hai427.quizdroid;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {

    private static final String TAG = "question";
    int selected;

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Topic topic = ((QuizActivity) getActivity()).topic;

        View v = inflater.inflate(R.layout.activity_question, container, false);

        final Button submitButton = (Button) v.findViewById(R.id.submit);
        submitButton.setEnabled(false);
        submitButton.setClickable(false);

        final RadioGroup radioGroup = (RadioGroup) v.findViewById(R.id.radioGroup);
        for (int i=0; i<4; i++) {
            RadioButton button = (RadioButton) radioGroup.getChildAt(i);
            button.setText(topic.questions[getArguments().getInt("questionsAnswered")].answers[i] + "");
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                submitButton.setEnabled(true);
                submitButton.setClickable(true);

                // Check which radio button was clicked
                switch(checkedId) {
                    case R.id.questionOne:
                        Log.i(TAG, "Submitting 1");
                        selected = 0;
                    case R.id.questionTwo:
                        Log.i(TAG, "Submitting 2");
                        selected = 1;
                    case R.id.questionThree:
                        Log.i(TAG, "Submitting 3");
                        selected = 2;
                    case R.id.questionFour:
                        Log.i(TAG, "Submitting 4");
                        selected = 3;
                }
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment answerFragment = new AnswerFragment();

                Bundle bundle = getArguments();
                bundle.putInt("answer", selected);
                answerFragment.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, answerFragment);
                fragmentTransaction.commit();
            }
        });

        return v;
    }
}
