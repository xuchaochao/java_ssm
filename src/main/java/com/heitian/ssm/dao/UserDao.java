package com.heitian.ssm.dao;

import com.heitian.ssm.controller.UserController;
import com.heitian.ssm.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by   on 2016/7/15.
 */

@Repository
public interface UserDao {


    User selectUserById(@Param("userId") Long userId);
    User selectSalaryById(@Param("userId") Long userId);

    List<User> selectTopSalary();
//    User selectTopSalary();
    User selectUserByPhoneOrEmail(@Param("emailOrPhone") String emailOrPhone, @Param("state") Short state);

    List<User> selectAllUser();
}
