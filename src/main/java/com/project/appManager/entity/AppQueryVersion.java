package com.project.appManager.entity;

/**
 * @author:MMW
 * @package: com.project.appManager.entity
 * @time: 2021/6/25 12:18
 * @day: 星期五
 */
public class AppQueryVersion extends AppVersion {
    // 软件名称
    private String softwarename;
    // 发布状态
    private String publishstatusname;

    public String getSoftwarename() {
        return softwarename;
    }

    public void setSoftwarename(String softwarename) {
        this.softwarename = softwarename;
    }

    public String getPublishstatusname() {
        return publishstatusname;
    }

    public void setPublishstatusname(String publishstatusname) {
        this.publishstatusname = publishstatusname;
    }
}
