package com.project.appManager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.appManager.entity.*;

import com.project.appManager.mapper.AppInfoMapper;
import com.project.appManager.mapper.AppVersionMapper;
import com.project.appManager.service.AppInfoService;
import com.project.appManager.utils.AppQueryInfoCondition;
import com.project.appManager.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:MMW
 * @package: com.project.appManager.service.impl
 * @time: 2021/6/24 17:20
 * @day: 星期四
 */
@Service("appInfoService")
@Transactional
@SuppressWarnings("All")
public class AppInfoServiceImpl implements AppInfoService {
    @Autowired
    private AppInfoMapper appInfoMapper;
    @Autowired
    private AppVersionMapper appVersionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return appInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AppInfo record) {
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public int insertSelective(AppInfo appInfo) {
        return appInfoMapper.insertSelective(appInfo);
    }

    @Override
    public List<AppInfo> selectByExample(AppInfoExample example) {
        return null;
    }

    @Override
    public AppInfo selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(AppInfo record) {
        return appInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AppInfo record) {
        return 0;
    }

    @Override
    public AppQueryInfoCondition getAppQueryResultInfo(AppQueryInfo info) {
        AppQueryInfoCondition appQueryInfoCondition = new AppQueryInfoCondition();
        appQueryInfoCondition.setAppQueryInfo(info);
        PageHelper.startPage(info.getPageIdx(),5);
        List<AppQueryResult> appInfo = appInfoMapper.getAppInfo(info);
        PageInfo<AppQueryResult> pageInfo = new PageInfo<>(appInfo);
        appQueryInfoCondition.setPageInfo(pageInfo);
        return appQueryInfoCondition;
    }

    @Override
    public AppQueryInfoCondition getAppQueryResultInfoByNoPass(AppQueryInfo info) {
        AppQueryInfoCondition appQueryInfoCondition = new AppQueryInfoCondition();
        appQueryInfoCondition.setAppQueryInfo(info);
        PageHelper.startPage(info.getPageIdx(),5);
        List<AppQueryResult> appInfoByNoPass = appInfoMapper.getAppInfoByNoPass(info);
        PageInfo<AppQueryResult> pageInfo = new PageInfo<>(appInfoByNoPass);
        appQueryInfoCondition.setPageInfo(pageInfo);
        return appQueryInfoCondition;
    }

    @Override
    public AppQueryResult getAppInfoById(Long id) {
        return appInfoMapper.getAppInfoById(id);
    }

    @Override
    public AppInfo getAppInfoByAPKName(String apkName) {
        AppInfoExample appInfoExample = new AppInfoExample();
        AppInfoExample.Criteria criteria = appInfoExample.createCriteria();
        criteria.andApknameEqualTo(apkName);
       return appInfoMapper.selectByExample(appInfoExample).get(0);
    }

    @Override
    @Transactional
    public int deleteAppInfo(Long id) {
        // 首先删除app版本apk文件
        AppVersionExample appVersionExample = new AppVersionExample();
        AppVersionExample.Criteria criteria = appVersionExample.createCriteria();
        criteria.andAppidEqualTo(id);
        List<AppVersion> appVersions = appVersionMapper.selectByExample(appVersionExample);
        for(AppVersion appVersion:appVersions){
            String path = appVersion.getApklocpath();
            FileUploadUtil.deleteFile(path);
            System.out.println("删除apk文件:" + path);
        }
        // 删除版本信息
        appVersionMapper.deleteVersionByAppId(id);
        // 删除appInfo
        return appInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更改AppInfo状态信息
     * @param id
     * @param status
     * @return
     */
    @Override
    public int modAppInfoStatus(Long id, Long status) {
        AppInfo appInfo = new AppInfo();
        appInfo.setId(id);
        appInfo.setStatus(status);
        int i = appInfoMapper.updateByPrimaryKeySelective(appInfo);
        return i;
    }
}
