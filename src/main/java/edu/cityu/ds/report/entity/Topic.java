package edu.cityu.ds.report.entity;

public class Topic {

    private Integer topicId;

    private String topicName;

    private Integer mainTopicId;

    private Integer members;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Integer getMainTopicId() {
        return mainTopicId;
    }

    public void setMainTopicId(Integer mainTopicId) {
        this.mainTopicId = mainTopicId;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", topicName='" + topicName + '\'' +
                ", mainTopicId=" + mainTopicId +
                ", members=" + members +
                '}';
    }
}
