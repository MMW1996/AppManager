package com.project.appManager.controller;

import com.project.appManager.entity.DataDictionary;
import com.project.appManager.service.DataDictionaryService;
import com.project.appManager.utils.JacksonUtil;
import com.project.appManager.utils.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author:MMW
 * @package: com.project.appManager.controller
 * @time: 2021/6/22 18:21
 * @day: 星期二
 */
@SuppressWarnings("All")
@Controller
public class DataDictionaryController {

    @Autowired
    private DataDictionaryService dataDictionaryService;

    @Autowired
    private SystemConstant systemConstant;

    /**
     * 异步加载app状态信息
     * @return String
     */
    @RequestMapping("getAppStatus")
    @ResponseBody
    public String getAppStatus(){
        return JacksonUtil.convertToString(dataDictionaryService.getDataDictionaryInfo(systemConstant.APP_STATUS));
    }

    /**
     * 异步加载app所属平台信息
     * @return String
     */
    @RequestMapping("getAppPlatform")
    @ResponseBody
    public String getAppPlatform(){
        return JacksonUtil.convertToString(dataDictionaryService.getDataDictionaryInfo(systemConstant.APP_PLATFORM));
    }


}
