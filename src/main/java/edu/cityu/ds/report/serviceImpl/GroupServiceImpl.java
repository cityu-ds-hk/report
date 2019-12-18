package edu.cityu.ds.report.serviceImpl;

import edu.cityu.ds.report.mapper.GroupMapper;
import edu.cityu.ds.report.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by starice on 2019-12-18.
 */
@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupMapper groupMapper;
	
	@Override
	public int getCount() {
		return 0;
	}
	
	@Override
	public Map<String, List> getAreaCount() {
		return null;
	}
	
	@Override
	public Map<String, List> getIncreasedCountTrend(Timestamp lTime, Timestamp rTime, String city) {
		return null;
	}
	
	@Override
	public List<Map<String, List>> getCategoryGroups() {
		return null;
	}

	@Override
	public List<Map<String, Object>> listGroupNumByCategoryCity() {
		return groupMapper.listGroupNumByCategoryCity();
	}

	@Override
	public List<Map<String, Object>> listGroupNumByCity() {
		return groupMapper.listGroupNumByCity();
	}

	@Override
	public List<Map<String, Object>> listGroupNumByDate(String period, int interval, String startDate, String endDate, Integer cityId) {
		String period_format = "%Y";
		if(period != null) {
			if("YEAR".equals(period.toUpperCase())) {
				// period_format = "%Y"
			} else if("MONTH".equals(period.toUpperCase())) {
				period_format = "%Y-%m";
			} else if("DAY".equals(period.toUpperCase())) {
				period_format = "%Y-%m-%d";
			}
		}

		return groupMapper.listGroupNumByDate(period_format, interval, startDate, endDate, cityId);
	}
}
