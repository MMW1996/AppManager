package com.project.appManager.controller;

import com.project.appManager.entity.AppVersion;
import com.project.appManager.service.AppVersionService;
import com.project.appManager.utils.FileUploadUtil;
import com.project.appManager.utils.JacksonUtil;
import com.project.appManager.utils.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author:MMW
 * @package: com.project.appManager.controller
 * @time: 2021/6/29 18:58
 * @day: 星期二
 */
@Controller
public class AppVersionController {
    @Autowired
    private AppVersionService appVersionService;

    @RequestMapping("versionHistory")
    @ResponseBody
    public String versionHisory(Long appId){
       return JacksonUtil.convertToString(appVersionService.versionHistory(appId));
    }

    @RequestMapping("addVersion")
    public String addVersion(AppVersion appVersion,
                             @RequestParam(value = "a_downloadlink")CommonsMultipartFile apkFile,
                             Long devId,
                             HttpServletRequest request,
                             Model model){
        model.addAttribute("appId",appVersion.getAppid());
        System.out.println("appId="+appVersion.getAppid());
        appVersion.setCreationdate(new Date());
        if(!apkFile.isEmpty()){
            String savePath = request.getSession().getServletContext().getRealPath(SystemConstant.APKUPLOADPATH);
            String fileName = FileUploadUtil.uploadFile(savePath, apkFile);
            appVersion.setApkfilename(apkFile.getOriginalFilename());
            appVersion.setApklocpath(savePath + "/" + fileName);
            appVersion.setDownloadlink(SystemConstant.APKUPLOADPATH + "/" + fileName);
        }
        appVersion.setCreatedby(devId);
        int i = appVersionService.insertSelective(appVersion);
        System.out.println(i);
        return "forward:/jsp/developer/appversionadd.jsp?appId=" + appVersion.getAppid();
    }
}
