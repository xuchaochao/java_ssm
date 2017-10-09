package com.heitian.ssm.controller;

import com.heitian.ssm.model.User;
import com.heitian.ssm.service.UserService;
import com.heitian.ssm.utils.Utils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xcc on 2017/5/25.
 */

@Controller
@RequestMapping("/salary")



public class UserController {

    int i=0;
    //手动设定在10000之前增加RT
    public  static  final  int TIMES=10000;
    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping("/all")
    public String showAll(HttpServletRequest request, Model model){
        log.info("查询所有用户信息");
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList",userList);
        return "all";
    }


    @RequestMapping(value="{id}", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    public @ResponseBody
        String showSalaryInJSON(@PathVariable String id) throws InterruptedException {
        long idLong = Long.parseLong(id);
        String userName= userService.getUserById(idLong).getUserName() ;
        String salary=userService.getSalaryById(idLong).getSalary();
        String salaryInfo ="{\"userName\":\""+userName+"\",\"salary\":\""+salary+"\"}";
        return salaryInfo;
    }

    @RequestMapping(value = "/top",produces = "application/json; charset=utf-8")
    public @ResponseBody
    String getTopSalaryInJSON() throws InterruptedException {
        List<User> userList =userService.getTopSalary();
        Utils.suanfa("30kdaniu");
        String topSalary=userList.get(0).getSalary();
        String userName= userList.get(0).getUserName();
        String topSalaryInfo ="{\"userName\":\""+userName+"\",\"salary\":\""+topSalary+"\"}";
        return topSalaryInfo;
    }

//  http://localhost:8080/salary?id=100&name=xcc
//    http://192.168.200.91:8080/salary?testId=100&testName=xcc

    @RequestMapping(method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    public @ResponseBody
    String showSalaryWithIdAndName(@RequestParam("testId") String id,
                                @RequestParam("testName") String workerName
                               ) throws InterruptedException {
        if(id.equals("") && workerName.equals("")){
            String salaryInfo ="{\"error\":\""+"请输入员工的id和姓名"+"\"}";
            return salaryInfo;
        } else if(workerName.equals("xcc")){

            long idLong = Long.parseLong(id);
            String userName= userService.getUserById(idLong).getUserName() ;
            String salary=userService.getSalaryById(idLong).getSalary();
            String salaryInfo ="{\"userName\":\""+userName+"\",\"salary\":\""+salary+"\"}";
//            String salaryInfo ="{\"userName\":\""+userName+"\",\"salary\":\""+{"before:200000,"}+"\"}";

            log.info(salaryInfo);
            log.info(salaryInfo);
            log.info(salaryInfo);
            log.info(salaryInfo);

            return salaryInfo;

        }else {
            String salaryInfo ="{\"error\":\""+"没有该员工"+"\"}";
            return salaryInfo;
        }

    }


}
