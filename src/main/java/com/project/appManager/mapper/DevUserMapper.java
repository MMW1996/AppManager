package com.project.appManager.mapper;

import com.project.appManager.entity.DevUser;
import com.project.appManager.entity.DevUserExample;
import java.util.HashMap;
import java.util.List;

public interface DevUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);

    List<DevUser> selectByExample(DevUserExample example);

    DevUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);

    Integer selectByDevCode(String devCode);
}