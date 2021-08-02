package com.project.appManager.service;

import com.project.appManager.entity.BackendUser;
import com.project.appManager.entity.BackendUserExample;

import java.util.List;

/**
 * @author:MMW
 * @package: com.project.appManager.service
 * @time: 2021/6/22 16:10
 * @day: 星期二
 */
public interface BackendUserService {

    int deleteByPrimaryKey(Long id);

    int insert(BackendUser record);

    int insertSelective(BackendUser record);

    List<BackendUser> selectByExample(BackendUserExample example);

    BackendUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BackendUser record);

    int updateByPrimaryKey(BackendUser record);

    BackendUser backendLogin(String userCode,String userPassword);
}
