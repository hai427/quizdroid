package edu.washington.hai427.quizdroid;

/**
 * Created by Hai on 2/14/2017.
 */

public class Topic {
    String title;
    String shortDesc;
    String longDesc;
    Question[] questions;

    public Topic(String title, String shortDesc, String longDesc) {
        this.title = title;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
    }
}
