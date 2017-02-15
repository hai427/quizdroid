package edu.washington.hai427.quizdroid;

/**
 * Created by Hai on 2/14/2017.
 */

public class Question {
    String text;
    String[] answers;
    int correctAnswer;

    public Question(String text, String answerOne, String answerTwo, String answerThree,
                    String answerFour, int correctAnswer) {
        this.text = text;
        this.answers = new String[4];
        answers[0] = answerOne;
        answers[1] = answerTwo;
        answers[2] = answerThree;
        answers[3] = answerFour;
        this.correctAnswer = correctAnswer;
    }
}
