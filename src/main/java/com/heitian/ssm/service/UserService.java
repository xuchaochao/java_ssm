package com.heitian.ssm.service;

import com.heitian.ssm.model.User;

import java.util.List;

/**
 * Created by xcc on 2017/5/25.
 */
public interface UserService {

    List<User> getAllUser();

    User getUserByPhoneOrEmail(String emailOrPhone, Short state);

    User getUserById(Long userId);
    User getSalaryById(Long userId);
    List<User> getTopSalary();
//    User getTopSalary();

}
