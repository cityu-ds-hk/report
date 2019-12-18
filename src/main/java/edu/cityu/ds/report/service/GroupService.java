package edu.cityu.ds.report.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by starice on 2019-12-18.
 */

public interface GroupService {

	int getCount();
	
	Map<String, List> getAreaCount();
	
	List<Map<String, List>> getCategoryGroups();
	
	Map<String, List> getIncreasedCountTrend(Timestamp lTime, Timestamp rTime, String city);
}
