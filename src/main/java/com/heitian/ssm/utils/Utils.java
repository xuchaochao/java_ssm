package com.heitian.ssm.utils;

import com.heitian.ssm.controller.UserController;
import org.apache.log4j.Logger;

/**
 * Created by xcc on 2017/5/25.
 */
public class Utils {

    private static  Logger log = Logger.getLogger(UserController.class);

    public static void suanfa(String suanfaName) throws InterruptedException {
       if(suanfaName.equals("3k")){
           Thread.sleep(3000);
           log.info("------3k渣渣的算法-----");
       }else {
           log.info("------30k大牛的算法-----");
       }
    }
}
