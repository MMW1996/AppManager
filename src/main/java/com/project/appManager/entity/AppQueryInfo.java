package com.project.appManager.entity;

/*
 * @author:MMW
 * @package: com.project.appManager.entity
 * @time: 2021/6/24 15:43
 * @day: 星期四
 */

/**
 * 封装app查询信息
 */
public class AppQueryInfo {
    private String querySoftwareName;
    private Long queryStatus;
    private Long queryFlatformId;
    private Long queryCategoryLevel1;
    private Long queryCategoryLevel2;
    private Long queryCategoryLevel3;
    private Integer pageIdx;
    private Long id;

    public Integer getPageIdx() {
        return pageIdx;
    }
    public void setPageIdx(Integer pageIdx) {
        this.pageIdx = pageIdx;
    }

    public String getQuerySoftwareName() {
        return querySoftwareName;
    }

    public void setQuerySoftwareName(String querySoftwareName) {
        this.querySoftwareName = querySoftwareName;
    }

    public Long getQueryStatus() {
        return queryStatus;
    }

    public void setQueryStatus(Long queryStatus) {
        this.queryStatus = queryStatus;
    }

    public Long getQueryFlatformId() {
        return queryFlatformId;
    }

    public void setQueryFlatformId(Long queryFlatformId) {
        this.queryFlatformId = queryFlatformId;
    }

    public Long getQueryCategoryLevel1() {
        return queryCategoryLevel1;
    }

    public void setQueryCategoryLevel1(Long queryCategoryLevel1) {
        this.queryCategoryLevel1 = queryCategoryLevel1;
    }

    public Long getQueryCategoryLevel2() {
        return queryCategoryLevel2;
    }

    public void setQueryCategoryLevel2(Long queryCategoryLevel2) {
        this.queryCategoryLevel2 = queryCategoryLevel2;
    }

    public Long getQueryCategoryLevel3() {
        return queryCategoryLevel3;
    }

    public void setQueryCategoryLevel3(Long queryCategoryLevel3) {
        this.queryCategoryLevel3 = queryCategoryLevel3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AppQueryInfo{" +
                "querySoftwareName='" + querySoftwareName + '\'' +
                ", queryStatus=" + queryStatus +
                ", queryFlatformId=" + queryFlatformId +
                ", queryCategoryLevel1=" + queryCategoryLevel1 +
                ", queryCategoryLevel2=" + queryCategoryLevel2 +
                ", queryCategoryLevel3=" + queryCategoryLevel3 +
                ", pageIdx=" + pageIdx +
                ", id=" + id +
                '}';
    }
}
