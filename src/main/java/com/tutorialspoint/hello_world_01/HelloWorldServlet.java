package com.tutorialspoint.hello_world_01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by anbo06131 on 12/5/2017.
 */
public class HelloWorldServlet extends HttpServlet {

    private String message;

    @Override
    public void init() throws ServletException {
        System.out.println("init servlet: "+ this.hashCode());
        message = "Hello World";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    @Override
    public void destroy() {
        System.out.println("destroy servlet: "+ this.hashCode());
    }
}
