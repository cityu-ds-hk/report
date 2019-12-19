package edu.cityu.ds.report.mapper;

import edu.cityu.ds.report.entity.Topic;

import java.util.List;
import java.util.Map;

public interface TopicMapper {

    List<Topic> listTopic();

    List<Map<String, Object>> listTopGroupTopics(Integer limit);


}
