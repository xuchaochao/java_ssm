package com.heitian.ssm.service.impl;

import com.heitian.ssm.controller.UserController;
import com.heitian.ssm.dao.UserDao;
import com.heitian.ssm.model.User;
import com.heitian.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xcc on 2017/5/25.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private Logger log = Logger.getLogger(UserController.class);

    @Resource
    private UserDao userDao;


    public User getUserById(Long userId) {
        return userDao.selectUserById(userId);
    }


    public User getSalaryById(Long userId) {
        return userDao.selectSalaryById(userId);
    }

    public List<User> getTopSalary() {

        return userDao.selectTopSalary();
    }

//    public User getTopSalary() {
//
//        return userDao.selectTopSalary();
//    }


    public User getUserByPhoneOrEmail(String emailOrPhone, Short state) {
        return userDao.selectUserByPhoneOrEmail(emailOrPhone,state);
    }
    
    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }
}
