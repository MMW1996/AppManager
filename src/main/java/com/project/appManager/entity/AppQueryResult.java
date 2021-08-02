package com.project.appManager.entity;

/**
 * @author:MMW
 * @package: com.project.appManager.entity
 * @time: 2021/6/24 17:03
 * @day: 星期四
 */
public class AppQueryResult extends AppInfo {
    // 分类信息
    private String category;
    // 平台名
    private String platformName;
    // 状态信息名
    private String statusName;
    // 最新版本号
    private String versionNo;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    @Override
    public String toString() {
        return "AppQueryResult{" +
                "category='" + category + '\'' +
                ", platformName='" + platformName + '\'' +
                ", statusName='" + statusName + '\'' +
                ", versionNo='" + versionNo + '\'' +
                '}';
    }
}
