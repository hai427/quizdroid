package edu.washington.hai427.quizdroid;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopicOverviewFragment extends Fragment {

    public TopicOverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Topic topic = ((QuizActivity) getActivity()).topic;

        View v = inflater.inflate(R.layout.activity_topic_overview, container, false);
        TextView title = (TextView) v.findViewById(R.id.name);
        TextView description = (TextView) v.findViewById(R.id.description);
        TextView numberOfQuestions = (TextView) v.findViewById(R.id.numberOfQuestions);

        title.setText(topic.title);
        description.setText(topic.longDesc);
        numberOfQuestions.setText(topic.questions.size() + "");

        Button begin;

        begin = (Button) v.findViewById(R.id.begin);

        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Fragment questionFragment = new QuestionFragment();

                questionFragment.setArguments(getArguments());
                Bundle bundle = (Bundle) getArguments();
                bundle.putInt("score", 0);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, questionFragment);
                fragmentTransaction.commit();
            }
        });

        return v;
    }

}
