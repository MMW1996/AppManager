package com.project.appManager.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:MMW
 * @package: com.team.student.utils
 * @time: 2021/6/15 17:42
 * @day: 星期二
 */
public class MyConverter implements Converter<String,Date> {

    @Override
    public Date convert(String s) {
        if(s==null){
            throw new RuntimeException("Empty Date");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("Failed Convert");
        }
    }
}

