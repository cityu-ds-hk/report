package edu.cityu.ds.report.intercepter;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthIntercepter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("userName");
        if (user!=null){
            return true;
        }else{
            request.setAttribute ( "message","没有权限请先登录" );
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
    }

}
