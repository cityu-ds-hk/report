package edu.cityu.ds.report.service;

import edu.cityu.ds.report.entity.User;

public interface UserService {
    User loginIn(String userName, String password);

    User getUserById(Integer id) throws Exception;
}
