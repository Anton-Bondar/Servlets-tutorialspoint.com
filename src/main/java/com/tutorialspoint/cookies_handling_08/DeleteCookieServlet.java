package com.tutorialspoint.cookies_handling_08;

import com.sun.deploy.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by anbo06131 on 12/21/2017.
 */
@WebServlet(value = "/delete_cookie")
public class DeleteCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name == null || name.isEmpty()) {
            resp.sendError(400);
        }
        Cookie[] cookies = req.getCookies();
        PrintWriter out = resp.getWriter();
        boolean found = false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
                resp.sendRedirect("/hello_form+cookie");
                found = true;
            }
        }
        if (!found) {
            resp.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
