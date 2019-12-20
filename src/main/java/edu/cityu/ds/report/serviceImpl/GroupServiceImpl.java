package edu.cityu.ds.report.serviceImpl;

import edu.cityu.ds.report.mapper.GroupMapper;
import edu.cityu.ds.report.service.GroupService;
import edu.cityu.ds.report.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Override
	public List<Map<String, Object>> listGroupNumByDate(String period, int interval, String startDate, String endDate, Integer cityId) {
		return null;
	}
	
	/**
	 * topic and category are in different tables
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer addGroup(int userId, String groupName, Integer categoryId, Integer topicId, Integer cityId, String visibility, Timestamp created) {
		return null;
	}
	
	@Override
	public Map<String, Object>  getCityGroupSize(String cityName) {
		List<Map<String, Object>>  result = groupMapper.getCityGroupSize(cityName);
		Map<String, Object> map =  CommonUtils.listMap2Map(result, "bin", "num");
		return map;
	}
	
	@Override
	public Map<String, List> getCityCategoryGroupMap(String cityName) {
		List<Map<String, Object>> result = groupMapper.getCityCategoryGroupMap(cityName);
		Map<String, List> map = CommonUtils.commonMaplist2Map(result, new String[]{"vlat", "vlon", "num", "category_id"});
		return map;
	}
	
}
