package com.bbs.javaweb.servlet;

import javax.servlet.*;
import java.io.IOException;

public class aservlet implements Servlet {
    public aservlet(){
        System.out.println("aservlet");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("aservlet init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        int i=1;

        System.out.println("aservlet servlet");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("aservlet destroy");

    }
}
