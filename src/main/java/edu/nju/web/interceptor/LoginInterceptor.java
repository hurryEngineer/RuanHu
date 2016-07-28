package edu.nju.web.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("user") != null) {
            return true;
        }
        String queryString = request.getQueryString();
        String fullUrl = null;
        if (queryString==null){
            fullUrl = request.getRequestURI();
        }else{
            fullUrl = request.getRequestURI()+"?"+queryString;
        }
        System.out.println(fullUrl);

        request.getSession().setAttribute("formerUrl", fullUrl);
        response.sendRedirect("/login");

        return false;
    }
}
