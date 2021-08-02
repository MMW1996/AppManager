package com.project.appManager.service.impl;

import com.project.appManager.entity.AppInfo;
import com.project.appManager.entity.AppVersion;
import com.project.appManager.entity.AppVersionDisplay;
import com.project.appManager.entity.AppVersionExample;
import com.project.appManager.mapper.AppVersionMapper;
import com.project.appManager.service.AppInfoService;
import com.project.appManager.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:MMW
 * @package: com.project.appManager.service.impl
 * @time: 2021/6/29 18:57
 * @day: 星期二
 */

@Service
@Transactional
@SuppressWarnings("All")
public class AppVersionServiceImpl  implements AppVersionService {
    @Autowired
    private AppVersionMapper appVersionMapper;
    @Autowired
    private AppInfoService appInfoService;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(AppVersion record) {
        return 0;
    }

    @Override
    public int insertSelective(AppVersion record) {
        return appVersionMapper.insertSelective(record);
    }

    @Override
    public List<AppVersion> selectByExample(AppVersionExample example) {
        return null;
    }

    @Override
    public AppVersion selectByPrimaryKey(Long id) {
        return appVersionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AppVersion record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(AppVersion record) {
        return 0;
    }

    @Override
    public List<AppVersionDisplay> versionHistory(Long appId) {
        return appVersionMapper.versionHistory(appId);
    }

    @Override
    public void deleteVersionByAppId(Long appId) {
    }

    @Override
    public int addVersion(AppVersion appVersion) {
        // 添加版本信息
        appVersionMapper.insertSelective(appVersion);
        // 修改app信息的最新版
        // 需要取到新插入到数据库中的appVersion的id
        // 这里就可以用到mybatis的orm特性，
        AppInfo appInfo = new AppInfo();
        // 修改appInfo
        appInfo.setId(appVersion.getAppid());
        appInfo.setVersionid(appVersion.getId());
        return appInfoService.updateByPrimaryKeySelective(appInfo);
    }


}
