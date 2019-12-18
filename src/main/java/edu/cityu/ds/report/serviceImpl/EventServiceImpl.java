package edu.cityu.ds.report.serviceImpl;

import edu.cityu.ds.report.service.EventService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by starice on 2019-12-18.
 */
@Service
public class EventServiceImpl  implements EventService {
	
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
}
