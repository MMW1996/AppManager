package com.project.appManager.controller.admin;

import com.project.appManager.entity.BackendUser;
import com.project.appManager.service.BackendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author:MMW
 * @package: com.project.appManager.controller
 * @time: 2021/6/22 16:12
 * @day: 星期二
 */
@SuppressWarnings("All")
@Controller
public class BackenUserController {
    @Autowired
    BackendUserService backendUserService;
    @RequestMapping("backendlogin")
    public String backendlogin(String verifyCode,String userCode, String userPassword, HttpSession session){
        if(verifyCode.equalsIgnoreCase(session.getAttribute("codeValidate").toString())) {
            BackendUser backendUser = backendUserService.backendLogin(userCode, userPassword);
            session.setAttribute("backenduser", backendUser);
            return "/backend/main";
        }else{
            session.setAttribute("error","验证码不正确！");
            return "backendlogin";
        }
    }
}
