package edu.washington.hai427.quizdroid;

import android.app.Application;
import android.util.Log;

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

        Topic math = new Topic("Math", "Math questions", "Lots of math questions here");
        Topic science = new Topic("Science", "Science questions", "Lots of science questions here");
        Topic marvel = new Topic("Marvel Heroes", "Marvel questions", "Lots of Marvel questions here");

        topicRepo.topics[0] = math;
        topicRepo.topics[1] = science;
        topicRepo.topics[2] = marvel;

        math.questions = new Question[4];
        science.questions = new Question[4];
        marvel.questions = new Question[4];

        for (int i=0; i<math.questions.length; i++) {
            math.questions[i] = new Question("What is math blah?", "Blah One", "Blah Two", "Blah Three",
                    "Blah Four", 1);
            science.questions[i] = new Question("What is science blah?", "Blah One", "Blah Two", "Blah Three",
                    "Blah Four", 2);
            marvel.questions[i] = new Question("What is marvel blah?", "Blah One", "Blah Two", "Blah Three",
                    "Blah Four", 3);
        }
    }
}
