package edu.cityu.ds.report.controller;

import edu.cityu.ds.report.entity.Result;
import edu.cityu.ds.report.service.TopicService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by starice on 2019-12-19.
 */

@Configuration
@RequestMapping("/topic")
@RestController
@Tag(name = "Topic Interfaces", description = "Rest API of topic function")
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(value = "/topTopics", method = RequestMethod.GET)
	public Result getTopGroups(){
		int limit = 20;
		Map<String, List> map = topicService.getTopTopics(limit);
		if(map!=null && map.size()!=0){
			return new Result(200, null, null, map);
		}else{
			return new Result(202, null, "Program Failed", null);
		}
	}
}
