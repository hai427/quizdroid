package edu.washington.hai427.quizdroid;

import java.util.ArrayList;

/**
 * Created by Hai on 2/14/2017.
 */

public class Question {
    String text;
    ArrayList<String> answers;
    int correctAnswer;

    public Question(String text, int correctAnswer) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.answers = new ArrayList<String>();
    }

    public void addAnswer(String answer) {
        answers.add(answer);
    }
}
