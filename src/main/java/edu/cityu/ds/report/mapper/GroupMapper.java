package edu.cityu.ds.report.mapper;

import edu.cityu.ds.report.entity.Group;

import java.util.List;
import java.util.Map;

public interface GroupMapper {

    int getCount();

    Group getGroupById(Integer groupId);

    List<Map<String, Object>> listGroupNumByCategoryCity();

    List<Map<String, Object>> listGroupNumByCity();

    List<Map<String, Object>> listGroupNumByCategory();

    List<Map<String, Object>> listGroupNumByDate(String period, int interval, String startDate, String endDate, Integer cityId);
    
    List<Map<String, Object>> getCityGroupSize(String cityName);
	
    List<Map<String, Object>> getCityCategoryGroupMap(String cityName);
}
