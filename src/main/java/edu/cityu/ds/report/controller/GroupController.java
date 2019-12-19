package edu.cityu.ds.report.controller;

import edu.cityu.ds.report.entity.Result;
import edu.cityu.ds.report.service.GroupService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by starice on 2019-12-18.
 */
@Configuration
@RequestMapping("/group")
@RestController
@Tag(name = "Group Interfaces", description = "Rest API of group function")
public class GroupController {
	
	@Autowired
	private GroupService groupService;
	
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public int getCount(HttpServletRequest request){
		return groupService.getCount();
	}
	
	/**
	 * The data format for drawing plotly pie and bar is :
	 *	var data = [{
	 *  	 	values: [19, 26, 55],
	 *   		labels: ['Residential', 'Non-Residential', 'Utility'],
	 *   		type: 'pie'
	 * 	}];
	 */
	@RequestMapping(value = "/areaCount", method = RequestMethod.GET)
	public Result getAreaCount(HttpServletRequest request){
		Map<String, Object> map = groupService.getAreaCount();
		if(map!=null && map.size()!=0){
			return new Result(200, null, null,  map);
		}else{
			return new Result(202, null, "Program Failed!", null);
		}
	}
	
	@RequestMapping(value = "/increasedCountTrend", method = RequestMethod.POST)
	public Result getTimeTrend(@RequestBody(required = false) Map<String, Object> map, HttpServletRequest request){

		Timestamp lTime = null;
		Timestamp rTime = null;
		Integer cityId = null;
		if(map != null) {
			if(map.get("lTime") != null && !"".equals(map.get("lTime").toString().trim())) {
				lTime = Timestamp.valueOf(map.get("lTime").toString());
			}
			if(map.get("rTime") != null && !"".equals(map.get("rTime").toString().trim())) {
				rTime = Timestamp.valueOf(map.get("rTime").toString());
			}
			if(map.get("cityId") != null) {
				cityId = Integer.valueOf(map.get("cityId").toString());
			}
		}

		Map<String, Object>  mapResult = groupService.getIncreasedCountTrend(lTime, rTime, cityId);
		if(mapResult != null && mapResult.size()!=0){
			return new Result(200, null, null,  mapResult);
		}else{
			return new Result(202, null, "Program Failed!", null);
		}
	}
	
	/**
	 *	var data = [trace1, trace2, trace3];
	 *	var trace3 = {
	 *   		x: [1, 2, 3, 4],
	 *  		y: [12, 13, 14, 15],
	 *   		mode: 'markers',
	 *   		marker: {
	 *     		size: [18, 11, 2, 3],
	 *       		color: ['rgb(120,120,120)', 'rgb(120,120,120)', 'red', 'rgb(120,120,120)'],
	 *       		opacity: [0.2, 0.2, 0.6, 0.2]
	 *   		},
	 *   		type: 'scatter'
	 * 	};
	 */
	@RequestMapping(value = "/categoryGroups", method = RequestMethod.POST)
	public Result getCategoryGroups(HttpServletRequest request){
		Map<String, Map<String, Object>> mapList = groupService.getCategoryGroups();
		if(mapList!=null){
			return new Result(200, null, null, mapList);
		}else{
			return new Result(202, null, "Program Failed!", null);
		}
	}

	@RequestMapping(value = "/categoryCount", method = RequestMethod.POST)
	public Result getCategoryCount(HttpServletRequest request){
		Map<String, Object> map = groupService.getCategoryCount();
		if(map!=null){
			return new Result(200, null, null, map);
		}else{
			return new Result(202, null, "Program Failed!", null);
		}
	}
}
