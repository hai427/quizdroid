package edu.washington.hai427.quizdroid;

/**
 * Created by Hai on 2/14/2017.
 */

public class Question {
    String text;
    String answerOne;
    String answerTwo;
    String answerThree;
    String answerFour;
    int correctAnswer;

    public Question(String text, String answerOne, String answerTwo, String answerThree,
                    String answerFour, int correctAnswer) {
        this.text = text;
        this.answerOne = answerOne;
        this.answerTwo = answerTwo;
        this.answerThree = answerThree;
        this.answerFour = answerFour;
        this.correctAnswer = correctAnswer;
    }
}
