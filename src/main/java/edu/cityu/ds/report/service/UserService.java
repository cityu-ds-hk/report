package edu.cityu.ds.report.service;

import edu.cityu.ds.report.entity.User;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface UserService {
    User loginIn(String userName, String password);

    User getUserById(Integer id) throws Exception;
    
    int getCount();
	
	Map<String, List> getAreaCount();
	
	Map<String, List> getIncreasedCountTrend(Timestamp lTime, Timestamp rTime, String city);
	
	List<Map<String, List>> getmTopicMembers();
}
