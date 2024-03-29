package edu.cityu.ds.report.controller;

import edu.cityu.ds.report.entity.Result;
import edu.cityu.ds.report.service.EventService;
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
@RestController
@Tag(name = "Event Interfaces", description = "Rest API of event function")
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public int getCount(HttpServletRequest request){
		return eventService.getCount();
	}
	
	@RequestMapping(value = "/areaCount", method = RequestMethod.GET)
	public Result getAreaCount(HttpServletRequest request){
		Map<String, Object> map = eventService.getAreaCount();
		if(map!=null && map.size()!=0){
			return new Result(200, null, null,  map);
		}else{
			return new Result(202, null, "Program Failed!", null);
		}
	}
	
	@RequestMapping(value = "/increasedCountTrend", method = RequestMethod.POST)
	public Result getTimeTrend(@RequestBody(required = false) Map<String, Object>map, HttpServletRequest request){
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

		Map<String, Object>  mapResult = eventService.getIncreasedCountTrend(lTime, rTime, cityId);

		if(mapResult!=null && mapResult.size()!=0){
			return new Result(200, null, null,  mapResult);
		}else{
			return new Result(202, null, "Program Failed!", null);
		}
	}
	
	@RequestMapping(value = "/categoryGroups", method = RequestMethod.POST)
	public Result getCategoryGroups(HttpServletRequest request){
		Map<String, Map<String, Object>> mapList = eventService.getCategoryGroups();
		if(mapList!=null){
			return new Result(200, null, null, mapList);
		}else{
			return new Result(202, null, "Program Failed!", null);
		}
	}

	@RequestMapping(value = "/categoryCount", method = RequestMethod.POST)
	public Result getCategoryCount(HttpServletRequest request){
		Map<String, Object> map = eventService.getCategoryCount();
		if(map!=null){
			return new Result(200, null, null, map);
		}else{
			return new Result(202, null, "Program Failed!", null);
		}
	}
	
	//draw map
	@RequestMapping(value = "/cityEventMap/{city}", method = RequestMethod.POST)
	public Result getCityEventMap(@PathVariable(value = "city") String city, HttpServletRequest request){
		List<Double> center = new ArrayList<Double>();
		if(city .equals("San Francisco")){
			center.add(37.78);
			center.add(-122.42);
		}else if(city .equals("New York")){
			center.add(40.785091);
			center.add(-73.968285);
		}else{
			center.add(41.881832);
			center.add(-87.623177);
		}
//		this map returns lists of lat, lon, size grouped by category
		Map<String, List> map = eventService.getCityEventMap(city);
		map.put("center", center);
		if(map!=null && map.size()!=0){
			return new Result(200, null, null, map);
		}else{
			return new Result(202, null, "Program Failed", null);
		}
	}
}
