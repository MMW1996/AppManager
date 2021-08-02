package com.project.appManager.controller;

import com.project.appManager.service.AppCategoryService;
import com.project.appManager.utils.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author:MMW
 * @package: com.project.appManager.controller
 * @time: 2021/6/22 19:37
 * @day: 星期二
 */

@SuppressWarnings("All")
@RestController
public class AppCategoryController {
    @Autowired
    private AppCategoryService appCategoryService;

    /**
     * 异步加载所有level1信息
     * @return
     */
    @RequestMapping("getLevelOne")
    public String getLevelOne(){

        return JacksonUtil.convertToString(appCategoryService.getCategoryLevelOne());
    }

    /**
     * 异步加载所有level2信息
     * @return
     */
    @RequestMapping("getLevelTwo")
    public String getLevelTwo(){
        return JacksonUtil.convertToString(appCategoryService.getCategoryLevelTwo());
    }

    /**
     * 异步加载所有level3信息
     * @return
     */
    @RequestMapping("getLevelThree")
    public String getLevelThere(){
        return JacksonUtil.convertToString(appCategoryService.getCategoryLevelThree());
    }

    /**
     * 根据level1 id查对应
     * @param id
     * @return
     */
    @RequestMapping("levelOneChange")
    public String levelOneChange(Long id){
       return JacksonUtil.convertToString(appCategoryService.levleOneChangeInfo(id));
    }

    @RequestMapping("levelTwoChange")
    public String levelTwoChange(Long id){
        return JacksonUtil.convertToString(appCategoryService.levleTwoChangeInfo(id));
    }

    @RequestMapping("levelThreeChange")
    public String levelThreeChange(Long id){
        return JacksonUtil.convertToString(appCategoryService.levleThreehangeInfo(id));
    }

    @RequestMapping("getLevelTwoById")
    public String getLevelTwoById(Long id){
        return JacksonUtil.convertToString(appCategoryService.getCategoryLevelTwoById(id));
    }

    @RequestMapping("getLevelThreeById")
    public String getLevelThreeById(Long id){
        return JacksonUtil.convertToString(appCategoryService.getCategoryLevelThreeById(id));
    }



}
