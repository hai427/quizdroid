package edu.washington.hai427.quizdroid;

import java.util.ArrayList;

/**
 * Created by Hai on 2/14/2017.
 */

public class Topic {
    String title;
    String shortDesc;
    String longDesc;
    ArrayList<Question> questions;

    public Topic(String title, String shortDesc, String longDesc) {
        this.title = title;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        questions = new ArrayList<Question>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }
}
