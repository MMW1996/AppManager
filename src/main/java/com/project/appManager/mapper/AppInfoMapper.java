package com.project.appManager.mapper;

import com.project.appManager.entity.AppInfo;
import com.project.appManager.entity.AppInfoExample;
import com.project.appManager.entity.AppQueryInfo;
import com.project.appManager.entity.AppQueryResult;

import java.util.List;

public interface AppInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    List<AppInfo> selectByExample(AppInfoExample example);

    AppInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);

    List<AppQueryResult> getAppInfo(AppQueryInfo info);

    List<AppQueryResult> getAppInfoByNoPass(AppQueryInfo info);

    AppQueryResult getAppInfoById(Long id);


}