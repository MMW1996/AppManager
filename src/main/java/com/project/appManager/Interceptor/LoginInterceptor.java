package com.project.appManager.Interceptor;

import com.project.appManager.entity.DevUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author:MMW
 * @package: com.project.appManager.Interceptor
 * @time: 2021/7/4 17:37
 * @day: 星期日
 */

// 创建拦截器 (原理: Servlet Filter)
@SuppressWarnings("All")
public class LoginInterceptor  implements HandlerInterceptor {

    /*
     * 拦截请求 不拦截jsp页面， 在请求进入Controller之前执行
     * 返回true允许进入
     * 返回false不允许进入
     *
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        DevUser devUser = (DevUser)session.getAttribute("devUser");
        if(devUser!=null){
            return true;
        }else{
            response.sendRedirect("/devlogin.jsp");
        }
        return false;
    }

    /*
     * 请求完成后，视图生成前执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("hi there is postHandle");
    }

    /*
     * afterCompletion 在完全处理完请求之后被调用，可用于清理资源等
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("hi there is afterCompletion");

    }
}
