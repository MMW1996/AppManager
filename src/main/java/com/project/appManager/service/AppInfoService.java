package com.project.appManager.service;

import com.github.pagehelper.PageInfo;
import com.project.appManager.entity.AppInfo;
import com.project.appManager.entity.AppInfoExample;
import com.project.appManager.entity.AppQueryInfo;
import com.project.appManager.entity.AppQueryResult;
import com.project.appManager.utils.AppQueryInfoCondition;

import java.util.List;

/**
 * @author:MMW
 * @package: com.project.appManager.service
 * @time: 2021/6/24 17:20
 * @day: 星期四
 */
public interface AppInfoService {

    int deleteByPrimaryKey(Long id);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    List<AppInfo> selectByExample(AppInfoExample example);

    AppInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);

    AppQueryInfoCondition getAppQueryResultInfo(AppQueryInfo info);

    AppQueryInfoCondition getAppQueryResultInfoByNoPass(AppQueryInfo info);

    AppQueryResult getAppInfoById(Long id);

    AppInfo getAppInfoByAPKName(String apkName);

    int deleteAppInfo(Long id);

    int modAppInfoStatus(Long id,Long status);

}
