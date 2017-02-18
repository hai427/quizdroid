package edu.washington.hai427.quizdroid;

import java.util.ArrayList;

/**
 * Created by Hai on 2/14/2017.
 */
public class TopicRepository {
    private static TopicRepository ourInstance = new TopicRepository();

    public static TopicRepository getInstance() {
        return ourInstance;
    }

    ArrayList<Topic> topics;

    private TopicRepository() {
        topics = new ArrayList<Topic>();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }
}
