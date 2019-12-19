package edu.cityu.ds.report.serviceImpl;

import edu.cityu.ds.report.mapper.GroupMapper;
import edu.cityu.ds.report.service.GroupService;
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
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupMapper groupMapper;
	
	@Override
	public int getCount() {
		return groupMapper.getCount();
	}
	
	@Override
	public Map<String, Object> getAreaCount() {

		List<Map<String, Object>> list = groupMapper.listGroupNumByCity();

		return CommonUtils.listMap2Map(list, "city_id", "num");
	}
	
	@Override
	public Map<String, Object> getIncreasedCountTrend(Timestamp lTime, Timestamp rTime, Integer cityId) {
		String lTimeStr = lTime == null ? null : CommonUtils.timestampFormat.format(lTime);
		String rTimeStr = rTime == null ? null : CommonUtils.timestampFormat.format(lTime);

		List<Map<String, Object>> list = groupMapper.listGroupNumByDate("%Y", 1,
				lTimeStr, rTimeStr, cityId);
		return CommonUtils.listMap2Map(list, "time", "num");
	}

	@Override
	public Map<String, Object> getCategoryCount() {

		List<Map<String, Object>> list = groupMapper.listGroupNumByCategory();

		return CommonUtils.listMap2Map(list, "category_id", "num");
	}

	@Override
	public Map<String, Map<String, Object>> getCategoryGroups() {
		List<Map<String, Object>> list = groupMapper.listGroupNumByCategoryCity();

		return CommonUtils.listMap2MapMap(list, "category_id", "city_id", "num");
	}
}
