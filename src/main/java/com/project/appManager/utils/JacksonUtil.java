package com.project.appManager.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * @author:MMW
 * @package: com.team.student.com.team.student.utils
 * @time: 2021/6/13 10:16
 * @day: 星期日
 */
public class JacksonUtil {

    private static final String PATTERN     =  "yyyy-MM-dd";
    private static ObjectMapper om          =   new ObjectMapper();

    /**
     * 默认日期格式 yyyy-MM-dd
     * @param obj Object
     * @return String
     */
    public static String convertToString(Object obj){
        return convertToString(obj,PATTERN);
    }

    /**
     * 按给定日期格式pattern转换
     * @param obj Object
     * @param pattern 给定日期格式
     * @return String
     */
    public static String convertToString(Object obj,String pattern){
        om.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        om.setDateFormat(new SimpleDateFormat(pattern));
        try {
            return om.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
