package com.tutorialspoint.form_example_02;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by anbo06131 on 12/5/2017.
 *
 * Input URL example: http://localhost:8080/HelloForm?first_name = ZARA&last_name = ALI
 */
public class HelloFormServlet extends HttpServlet {

    private static final String RESPONSE_TITLE = "Using GET Method to Read Form Data";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                            "<html>\n" +
                            "<head><title>" + RESPONSE_TITLE + "</title></head>\n" +
                            "<body bgcolor = \"#f0f0f0\">\n" +
                            "<h1 align = \"center\">" + RESPONSE_TITLE + "</h1>\n" +
                            "<ul>\n" +
                            "  <li><b>First Name</b>: "
                            + request.getParameter("first_name") + "\n" +
                            "  <li><b>Last Name</b>: "
                            + request.getParameter("last_name") + "\n" +
                            "</ul>\n" +
                            "</body>" +
                            "</html>"
        );
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
