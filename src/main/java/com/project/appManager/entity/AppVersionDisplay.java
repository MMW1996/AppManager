package com.project.appManager.entity;

import java.util.Date;
/**
 * @author:MMW
 * @package: com.project.appManager.entity
 * @time: 2021/6/27 12:07
 * @day: 星期日
 */
public class AppVersionDisplay extends AppVersion {

    // 软件名称
    private String softwarename;
    // 发布状态名
    private String publishname;
    // 最新更新时间
    private Date latestModifyDate;

    public String getSoftwarename() {
        return softwarename;
    }

    public void setSoftwarename(String softwarename) {
        this.softwarename = softwarename;
    }

    public String getPublishname() {
        return publishname;
    }

    public void setPublishname(String publishname) {
        this.publishname = publishname;
    }

    public Date getLatestModifyDate() {
        return latestModifyDate;
    }

    public void setLatestModifyDate(Date latestModifyDate) {
        this.latestModifyDate = latestModifyDate;
    }
}
