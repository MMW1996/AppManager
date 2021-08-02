package com.project.appManager.mapper;

import com.project.appManager.entity.AppVersion;
import com.project.appManager.entity.AppVersionDisplay;
import com.project.appManager.entity.AppVersionExample;
import java.util.List;
public interface AppVersionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppVersion record);

    int insertSelective(AppVersion record);

    List<AppVersion> selectByExample(AppVersionExample example);

    AppVersion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppVersion record);

    int updateByPrimaryKey(AppVersion record);

    List<AppVersionDisplay> versionHistory(Long appId);

    void deleteVersionByAppId(Long appId);

}