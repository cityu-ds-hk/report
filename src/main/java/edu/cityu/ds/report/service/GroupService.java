package edu.cityu.ds.report.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by starice on 2019-12-18.
 */

public interface GroupService {

	int getCount();
	
	Map<String, Object> getAreaCount();
	
	Map<String, Map<String, Object>> getCategoryGroups();
	
	Map<String, Object> getIncreasedCountTrend(Timestamp lTime, Timestamp rTime, Integer cityId);

	Map<String, Object> getCategoryCount();

	List<Map<String, Object>> listGroupNumByDate(String period, int interval, String startDate, String endDate, Integer cityId);
	
	Integer addGroup(int userId, String groupName, Integer categoryId, Integer topicId, Integer cityId, String visibility, Timestamp created);
	
	Map<String, List> getCityCategoryGroupMap(String cityName);
	
	Map<String, Object> getCityGroupSize(String cityName);
}
