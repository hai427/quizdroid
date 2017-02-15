package edu.washington.hai427.quizdroid;

/**
 * Created by Hai on 2/14/2017.
 */
public class TopicRepository {
    private static TopicRepository ourInstance = new TopicRepository();

    public static TopicRepository getInstance() {
        return ourInstance;
    }

    Topic[] topics = new Topic[3];

    private TopicRepository() {

    }
}
