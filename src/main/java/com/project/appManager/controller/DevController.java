package com.project.appManager.controller;

import com.project.appManager.entity.DevUser;
import com.project.appManager.service.DevUserService;
import com.project.appManager.utils.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
/**
 * @author:MMW
 * @package: com.project.appManager.controller
 * @time: 2021/6/21 19:08
 * @day: 星期一
 */

@SuppressWarnings("All")
@Controller
public class DevController {
    @Autowired
    private DevUserService devUserService;
    /**
     * 开发者登录验证
     * @param devUser
     * @return String
     */
    @RequestMapping("devlogin")
    public String devlogin(String devCode, String devPassword, HttpSession session){
        DevUser devUser = devUserService.loginCheck(devCode, devPassword);
        if(devUser!=null){
            //session 保存用户信息
            // 登陆成功
            session.setAttribute("devUser",devUser);
            // 设置session有效期
            session.setMaxInactiveInterval(30 * 60);
            return "/developer/main";
        }else{
            // 登陆失败
            return "redirect:toLogin";
        }
    }

    /**
     * 检查用户名是否存在
     * @param devCode
     * @return String
     */
    @RequestMapping("checkNameExsit")
    @ResponseBody
    public String checkNameExsit(String devCode){
        return devUserService.selectByDevCode(devCode).toString();
    }

    /**
     * 登出 需要清除用户session [!important]
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpSession session){
        // session 作废
        session.removeAttribute("devUser");
        session.invalidate();
        return "redirect:/jsp/devlogin.jsp";
    }
}
