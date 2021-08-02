package com.project.appManager.service;

import com.project.appManager.entity.AppCategory;
import com.project.appManager.entity.AppCategoryExample;

import java.util.HashMap;
import java.util.List;

/**
 * @author:MMW
 * @package: com.project.appManager.service
 * @time: 2021/6/22 19:11
 * @day: 星期二
 */
public interface AppCategoryService {
    int deleteByPrimaryKey(Long id);

    int insert(AppCategory record);

    int insertSelective(AppCategory record);

    List<AppCategory> selectByExample(AppCategoryExample example);

    AppCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppCategory record);

    int updateByPrimaryKey(AppCategory record);

    // 获取一级分类
    List<AppCategory> getCategoryLevelOne();

    // 获取二级分类
    List<AppCategory> getCategoryLevelTwo();
    // 通过id获取二级分类
    List<AppCategory> getCategoryLevelTwoById(Long id);

    // 获取三级分类
    List<AppCategory> getCategoryLevelThree();

    List<AppCategory> getCategoryLevelThreeById(Long id);




    // 一级列表改变
    HashMap<String,Object> levleOneChangeInfo(Long id);
    // 二级列表改变
    HashMap<String,Object> levleTwoChangeInfo(Long id);
    // 三级列表改变
    HashMap<String,Object> levleThreehangeInfo(Long id);



}
