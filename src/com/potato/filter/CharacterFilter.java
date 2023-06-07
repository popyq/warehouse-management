package com.potato.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @Author potato
 * @PackageName:com.potato.filter
 * @Description: TODO 设置过滤器
 * @Date 2022-12-10 16:58
 */
//@WebFilter("/*")
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //对请求中的编码做统一设置
        servletRequest.setCharacterEncoding("utf-8");
//        servletResponse.setContentType("text/html;charset=utf-8");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        // 获取路径
        String uri= req.getRequestURI();
        System.out.println("uri: "+uri);

        if (    uri.contains("registerServlet") ||  uri.contains("findByUsernameServlet")
             ||  uri.contains("reg.html")       || uri.contains("loginServlet")
             || uri.contains("layer")           ||  uri.contains("/js/")         || uri.contains("img")
             || uri.contains("bootstrap")       ||  uri.contains("favicon.ico")  || uri.contains("css")
             || uri.contains("login.html")
        ){
            System.out.println("放行了");
            filterChain.doFilter(servletRequest,servletResponse);
        }else{

            if (null != session.getAttribute("u")){
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                resp.sendRedirect("login.html");
            }

        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
