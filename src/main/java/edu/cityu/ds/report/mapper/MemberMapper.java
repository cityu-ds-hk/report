package edu.cityu.ds.report.mapper;

import java.util.List;
import java.util.Map;

public interface MemberMapper {

    int getCount();

    List<Map<String, Object>> listMemberNumByCity();

    List<Map<String, Object>> listMemberNumByDate(String period, int interval, String startDate, String endDate, Integer cityId);

}
