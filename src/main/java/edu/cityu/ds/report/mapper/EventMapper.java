package edu.cityu.ds.report.mapper;

import edu.cityu.ds.report.entity.Event;

import java.util.List;
import java.util.Map;

public interface EventMapper {

    int getCount();

    Event getEventById(Integer eventId);

    List<Map<String, Object>> listEventNumByCategoryCity();

    List<Map<String, Object>> listEventNumByCity();

    List<Map<String, Object>> listEventNumByCategory();

    List<Map<String, Object>> listEventNumByDate(String period, int interval, String startDate, String endDate);

    List<Map<String, Object>> listEventNumByDateWithCity(String period, int interval, String startDate, String endDate, Integer cityId);


}
