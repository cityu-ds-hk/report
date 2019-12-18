package edu.cityu.ds.report.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by starice on 2019-12-18.
 */

public interface EventService {
	
	int getCount();
	
	Map<String, List> getAreaCount();
	
	Map<String, List> getIncreasedCountTrend(Timestamp lTime, Timestamp rTime, String city);
	
	List<Map<String, List>> getCategoryGroups();
}
