package com.fly.heart.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * created by tanghuosong 2017/5/29
 * description: 通用工具类
 **/
public class Common {

    /**
     * 日期转换 ：将java.util.Date类型转换为java.sql.Date
     */
     public static java.sql.Date getSqlDate(java.util.Date date) {
        Long times = date.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");//设定格式
         java.util.Date timeDate = null;
         try {
             timeDate = dateFormat.parse(date.toString());//util类型
         }catch (ParseException e){
             e.printStackTrace();
         }
         java.sql.Date dateTime = new java.sql.Date(timeDate.getTime());
         return dateTime;
    }
}
