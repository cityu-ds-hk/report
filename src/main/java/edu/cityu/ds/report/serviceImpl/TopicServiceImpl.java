package edu.cityu.ds.report.serviceImpl;

import edu.cityu.ds.report.mapper.TopicMapper;
import edu.cityu.ds.report.service.TopicService;
import edu.cityu.ds.report.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by starice on 2019-12-19.
 */
@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicMapper topicMapper;

	@Override
	public Map<String, Object> getTopTopics(Integer limit) {
		List<Map<String, Object>> list =topicMapper.listTopGroupTopics(limit);
		return CommonUtils.listMap2Map(list, "topic_id", "num");
	}
}
