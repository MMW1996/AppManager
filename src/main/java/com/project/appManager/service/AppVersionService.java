package com.project.appManager.service;

import com.project.appManager.entity.AppVersion;
import com.project.appManager.entity.AppVersionDisplay;
import com.project.appManager.entity.AppVersionExample;

import java.util.List;

/**
 * @author:MMW
 * @package: com.project.appManager.service
 * @time: 2021/6/29 18:56
 * @day: 星期二
 */
public interface AppVersionService {
    int deleteByPrimaryKey(Long id);

    int insert(AppVersion record);

    int insertSelective(AppVersion record);

    List<AppVersion> selectByExample(AppVersionExample example);

    AppVersion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppVersion record);

    int updateByPrimaryKey(AppVersion record);

    List<AppVersionDisplay> versionHistory(Long appId);

    void deleteVersionByAppId(Long appId);

    int addVersion(AppVersion appVersion);
}
