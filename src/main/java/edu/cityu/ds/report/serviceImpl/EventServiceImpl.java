package edu.cityu.ds.report.serviceImpl;

import edu.cityu.ds.report.mapper.EventMapper;
import edu.cityu.ds.report.service.EventService;
import edu.cityu.ds.report.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by starice on 2019-12-18.
 */
@Service
public class EventServiceImpl  implements EventService {

	@Autowired
	private EventMapper eventMapper;
	
	@Override
	public int getCount() {
		return eventMapper.getCount();
	}
	
	@Override
	public Map<String, Object> getAreaCount() {
		List<Map<String, Object>> list =  eventMapper.listEventNumByCity();

		return CommonUtils.listMap2Map(list, "city_id", "num");
	}

	@Override
	public Map<String, Map<String, Object>> getCategoryGroups() {
		List<Map<String, Object>> list = eventMapper.listEventNumByCategoryCity();

		return CommonUtils.listMap2MapMap(list, "category_id", "city_id", "num");
	}

		@Override
	public Map<String, Object> getIncreasedCountTrend(Timestamp lTime, Timestamp rTime, Integer cityId) {
		String lTimeStr = lTime == null ? null : CommonUtils.timestampFormat.format(lTime);
		String rTimeStr = rTime == null ? null : CommonUtils.timestampFormat.format(lTime);

		List<Map<String, Object>> list;
		if(cityId == null) {
			list = eventMapper.listEventNumByDate("%Y-%m", 1, lTimeStr, rTimeStr);
		} else {
			list = eventMapper.listEventNumByDateWithCity("%Y-%m", 1, lTimeStr, rTimeStr, cityId);
		}

		return CommonUtils.listMap2Map(list, "time", "num");
	}

	@Override
	public Map<String, Object> getCategoryCount() {
		List<Map<String, Object>> list = eventMapper.listEventNumByCategory();

		return CommonUtils.listMap2Map(list, "category_id", "num");
	}

}
