package edu.cityu.ds.report.mapper;

import edu.cityu.ds.report.entity.User;

public interface UserMapper {

    User getInfo(String userName, String password);

    User getUserById(Integer id);
}
