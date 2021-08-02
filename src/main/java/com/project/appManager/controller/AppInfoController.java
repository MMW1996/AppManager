package com.project.appManager.controller;

import com.project.appManager.entity.AppInfo;
import com.project.appManager.entity.AppQueryInfo;
import com.project.appManager.entity.AppQueryResult;
import com.project.appManager.entity.DevUser;
import com.project.appManager.service.AppInfoService;
import com.project.appManager.utils.AppQueryInfoCondition;
import com.project.appManager.utils.FileUploadUtil;
import com.project.appManager.utils.OSSFileUploadUtil;
import com.project.appManager.utils.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author:MMW
 * @package: com.project.appManager.controller
 * @time: 2021/6/23 19:24
 * @day: 星期三
 */
@Controller
@SuppressWarnings("All")
public class AppInfoController {
    @Autowired
    private AppInfoService appInfoService;
    /**
     * 获取app信息查询结果
     * @param info
     * @param model
     * @return
     */
    @RequestMapping("getQueryList")
    public String getQueryList(AppQueryInfo info, Model model){
        AppQueryInfoCondition resultInfo = appInfoService.getAppQueryResultInfo(info);
        model.addAttribute("queryInfo", resultInfo.getAppQueryInfo());
        model.addAttribute("pages", resultInfo.getPageInfo());
        return "/developer/appinfolist";
    }

    /**
     * app信息添加
     * @param appInfo
     * @return
     */
    @RequestMapping("appInfoAdd")
    public String appInfoAdd(AppInfo appInfo,
                             @RequestParam(value = "a_logoPicPath",required = false)CommonsMultipartFile file,
                             HttpServletRequest request,
                             HttpSession session,
                             Model model){
        // add appInfo
        appInfo.setDevid(((DevUser) session.getAttribute("devUser")).getId());
        int i = appInfoService.insertSelective(appInfo);  //
        if(i==1){
            // get add appInfo's id by apkName
            AppInfo updatedAppInfo = appInfoService.getAppInfoByAPKName(appInfo.getApkname());
            System.out.println(updatedAppInfo);
            // add to aliyun oss
            String fileName = OSSFileUploadUtil.logoUpdate(file, updatedAppInfo);
            System.out.println(fileName);
            if(fileName!=null){
                model.addAttribute("fileUploadError","success");
            }else{
                model.addAttribute("fileUploadError","fail");
            }
        }
        return "developer/appinfoadd";
    }

    @RequestMapping("getAppInfo")
    public String getAppInfo(Long id,Model model){
        AppQueryResult appInfo = appInfoService.getAppInfoById(id);
        model.addAttribute("appInfo",appInfo);
        return "/developer/appinfomodify";
    }

    @RequestMapping("appinfomodifysave")
    public String appinfomodifysave(AppInfo appInfo,@RequestParam(value = "attach") CommonsMultipartFile file,HttpSession session) {
        // if user upload image
        if(!file.isEmpty()){
            // upload to aliyun oss
            OSSFileUploadUtil.logoUpdate(file,appInfo);
        }
        // update appInfo
        int i = appInfoService.updateByPrimaryKeySelective(appInfo);
        if(i==1){
            // update success!
            return "developer/appinfolist";
        }else{
            // update fail!
            return "redirect:developer/appinfomodify?id=" + appInfo.getId();
        }
    }

    /**
     *
     * @param appId
     * @param oldPath
     * @return
     */
    @RequestMapping("delAppInfo")
    @ResponseBody
    public String delAppInfo(Long appId,String oldPath){
        // delete  logo
        OSSFileUploadUtil.delete(oldPath);
        System.out.println("删除图片: " + oldPath);
        // delete appInfo and version
        return "{\"res\":" + appInfoService.deleteAppInfo(appId) + "}";
    }
}
