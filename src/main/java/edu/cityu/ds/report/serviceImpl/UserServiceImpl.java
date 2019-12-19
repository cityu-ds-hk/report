package edu.cityu.ds.report.serviceImpl;

import edu.cityu.ds.report.entity.User;
import edu.cityu.ds.report.exception.EntityNotExistException;
import edu.cityu.ds.report.mapper.MemberMapper;
import edu.cityu.ds.report.mapper.UserMapper;
import edu.cityu.ds.report.service.UserService;
import edu.cityu.ds.report.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public User loginIn(String userName, String password) {
        return userMapper.getInfo(userName, password);
    }

    @Override
    public User getUserById(Integer id) throws Exception {
        User user = userMapper.getUserById(id);
        if(user == null)
            throw new EntityNotExistException(String.format("user %d not exist", id), "");
        return user;
    }
    
    @Override
    public int getCount() {
        return memberMapper.getCount();
    }
    
    @Override
    public Map<String, Object> getAreaCount() {
        List<Map<String, Object>> list =  memberMapper.listMemberNumByCity();

        return CommonUtils.listMap2Map(list, "city_id", "num");
    }
    
    @Override
    public Map<String, Object> getIncreasedCountTrend(Timestamp lTime, Timestamp rTime, Integer cityId) {
        String lTimeStr = lTime == null ? null : CommonUtils.timestampFormat.format(lTime);
        String rTimeStr = rTime == null ? null : CommonUtils.timestampFormat.format(lTime);

        List<Map<String, Object>> list = memberMapper.listMemberNumByDate("%Y", 1,
                lTimeStr, rTimeStr, cityId);
        return CommonUtils.listMap2Map(list, "time", "num");
    }
    
    @Override
    public List<Map<String, List>> getmTopicMembers() {
        return null;
    }
    
}
