package com.project.appManager.utils;

import com.github.pagehelper.PageInfo;
import com.project.appManager.entity.AppQueryInfo;
import com.project.appManager.entity.AppQueryResult;

/**
 * @author:MMW
 * @package: com.project.appManager.utils
 * @time: 2021/6/24 18:51
 * @day: 星期四
 */
public class AppQueryInfoCondition {

    private AppQueryInfo appQueryInfo;
    private PageInfo<AppQueryResult> pageInfo;

    public AppQueryInfo getAppQueryInfo() {
        return appQueryInfo;
    }
    public void setAppQueryInfo(AppQueryInfo appQueryInfo) {
        this.appQueryInfo = appQueryInfo;
    }

    public PageInfo<AppQueryResult> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<AppQueryResult> pageInfo) {
        this.pageInfo = pageInfo;
    }
}
