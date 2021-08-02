package com.project.appManager.mapper;

import com.project.appManager.entity.AppCategory;
import com.project.appManager.entity.AppCategoryExample;
import java.util.List;

public interface AppCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppCategory record);

    int insertSelective(AppCategory record);

    List<AppCategory> selectByExample(AppCategoryExample example);

    AppCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppCategory record);

    int updateByPrimaryKey(AppCategory record);

    // 获取一级列表
    List<AppCategory> getCategoryLevelOne();
    // 获取三级列表
    List<AppCategory> getCategoryLevelTwo();
    // 获取二级列表
    List<AppCategory> getCategoryLevelThree();

    List<AppCategory> getLevelsById(Long id);

    List<AppCategory> getLevelsByParentid(Long parentid);


    
}