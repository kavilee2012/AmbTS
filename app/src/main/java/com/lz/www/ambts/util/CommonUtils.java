package com.lz.www.ambts.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016-07-09.
 */
public class CommonUtils {

    //把日期转为字符串
     public static String ConverToString(Date date)
     {
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
         return df.format(date);
     }

     //把字符串转为日期
     public static Date ConverToDate(String strDate) throws Exception
     {
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
         return df.parse(strDate);
     }

}
