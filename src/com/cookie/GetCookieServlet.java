package com.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetCookieServlet",urlPatterns = {"/GetCookieServlet","/gcs"})
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html,charset=utf-8");
        Cookie[] gcs = req.getCookies();//获取Cookie 对象 返回cookie对象数组
        if (gcs!= null){
            for (Cookie cookie:gcs) {
                  String name = cookie.getName();
                  String val = cookie.getValue();
                System.out.println(name + "|" + val);
            }
        }
    }
}
