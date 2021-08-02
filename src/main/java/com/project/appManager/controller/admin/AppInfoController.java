package com.project.appManager.controller.admin;

import com.project.appManager.entity.AppQueryInfo;
import com.project.appManager.entity.AppQueryResult;
import com.project.appManager.entity.AppVersion;
import com.project.appManager.service.AppInfoService;
import com.project.appManager.service.AppVersionService;
import com.project.appManager.utils.AppQueryInfoCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @author:MMW
 * @package: com.project.appManager.controller.admin
 * @time: 2021/7/1 15:51
 * @day: 星期四
 */

@Controller("/appinfoController2")
public class AppInfoController {
    @Autowired
    private AppInfoService appInfoService;
    @Autowired
    private AppVersionService appVersionService;

    @RequestMapping("/getAppInfoByNoPass")
    public String getAppInfoByNoPass(AppQueryInfo info, Model model){
        AppQueryInfoCondition condition = appInfoService.getAppQueryResultInfoByNoPass(info);
        model.addAttribute("queryInfoCondition",condition.getAppQueryInfo());
        model.addAttribute("pageInfo",condition.getPageInfo());
        return "/backend/applist";
    }

    @RequestMapping(value = "/getNoPassAppInfo")
    public String getNoPassAppInfo(Long appid, Long versionid ,String category, Model model){
        System.out.println("category:" + category);
        try{
            if(category!=null){
                category = new String(category.getBytes("iso8859-1"), StandardCharsets.UTF_8);
                System.out.println("category:" + category);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        // 查询被审核的appInfo 及其 最新版本
        AppQueryResult appInfo = appInfoService.getAppInfoById(appid);
        appInfo.setCategory(category);
        model.addAttribute("appInfo",appInfo);
        AppVersion appVersion = appVersionService.selectByPrimaryKey(versionid);
        model.addAttribute("appVersion",appVersion);
        return "/backend/appcheck";
    }

    @RequestMapping("check")
    @ResponseBody
    public String check(Long status,Long id){
        int i = appInfoService.modAppInfoStatus(id, status);
        return "{\"res\":"+ i +"}";
    }

    @RequestMapping("apkDownload")
    public void apkDownload(String link, HttpServletResponse response) throws Exception{
        File file = new File(link);
        String fileName = file.getName();
        // 设置响应头
        response.setHeader("Content-Disposition","attachment;filename = " + java.net.URLEncoder.encode(fileName,"UTF-8"));
        // 设置响应类型
        response.setContentType("application/vnd.android.package-archive");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);
    }

}
