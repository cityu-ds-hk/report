package edu.cityu.ds.report.serviceImpl;

import edu.cityu.ds.report.entity.User;
import edu.cityu.ds.report.exception.EntityNotExistException;
import edu.cityu.ds.report.mapper.UserMapper;
import edu.cityu.ds.report.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

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
}
