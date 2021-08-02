package com.project.appManager.service;


import com.project.appManager.entity.DevUser;
import com.project.appManager.entity.DevUserExample;

import java.util.HashMap;
import java.util.List;

/**
 * @author:MMW
 * @package: com.project.appManager.service
 * @time: 2021/6/21 19:41
 * @day: 星期一
 */
public interface DevUserService {
    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);

    List<DevUser> selectByExample(DevUserExample example);

    DevUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);

    Integer selectByDevCode(String devCode);
    

    DevUser loginCheck(String devCode,String DevPassword);

}
