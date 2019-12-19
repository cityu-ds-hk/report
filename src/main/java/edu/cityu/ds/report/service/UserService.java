package edu.cityu.ds.report.service;

import edu.cityu.ds.report.entity.User;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface UserService {
    User loginIn(String userName, String password);

    User getUserById(Integer id) throws Exception;
    
    int getCount();
	
	Map<String, Object> getAreaCount();
	
	Map<String, Object> getIncreasedCountTrend(Timestamp lTime, Timestamp rTime, Integer cityId);
	
	List<Map<String, List>> getmTopicMembers();
	
}
