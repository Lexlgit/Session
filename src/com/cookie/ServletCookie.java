package com.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletCookie",urlPatterns = {"/ServletCookie","/cookie"})
public class ServletCookie extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("cookie");
        //Set the request encoding format
        req.setCharacterEncoding("utf-8");
        //Set the response Encoding format
        resp.setContentType("text/html;charset=utf-8");
        //Creating Cookie object
        Cookie cookie1 = new Cookie("A","AA");
        Cookie cookie2 = new Cookie("B","BB");

        cookie2.setMaxAge(3600*24*3);
        cookie2.setPath("/Cookie_war_exploded/gcs");
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }
}
/**
 * Cookie (浏览器端数据存储技术 声明在服务器端)
 * 解决发送的不同请求之间数据共享的问题
 * 创建cookie对象: Cookie cookie = new Cookie(String name, String value);
 * 响应cookie对象给客户端： resp.addCookie(cookie);

 *临时存储：数据存储在浏览器内存中 浏览器关闭 数据消失
 *定时存储：cookie2.setMaxAge(ms);  设置cookie的有效期 有效期内 cookie数据存储在客户端硬盘中
 * 设置有效路径：cookie2.setPath("aaa"); 默认情况下 每次请求都会携带cookie，设置有效路径后 非有效路径不携带cookie信息。
 *
 * */