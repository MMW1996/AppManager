package com.project.appManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:MMW
 * @package: com.project.appManager.controller
 * @time: 2021/7/4 17:42
 * @day: 星期日
 */
@Controller
public class LinkContrller {
    @RequestMapping("/link/toLogin")
    public String toLogin(){
        return "/devlogin";
    }

    @RequestMapping("/link/toList")
    public String toList(){
        return "/developer/appinfolist";
    }
}
