package com.tutorialspoint.client_request_03;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by anbo06131 on 12/7/2017.
 */
@WebServlet(value = "/display_header")
public class DisplayHeaderServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "HTTP Header Request Example";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                            "<html>\n" +
                            "<head><title>" + title + "</title></head>\n" +
                            "<body bgcolor = \"#f0f0f0\">\n" +
                            "<h1 align = \"center\">" + title + "</h1>\n" +
                            "<table width = \"100%\" border = \"1\" align = \"center\">\n" +
                            "<tr bgcolor = \"#949494\">\n" +
                            "<th>Header Name</th><th>Header Value(s)</th>\n" +
                            "</tr>\n"
        );

        Enumeration headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String paramName = (String) headerNames.nextElement();
            out.print("<tr><td>" + paramName + "</td>\n");
            String paramValue = request.getHeader(paramName);
            out.println("<td> " + paramValue + "</td></tr>\n");
        }
        out.println("</table>\n");
        createRequestMethodsTable(request, out);
    }

    private void createRequestMethodsTable(HttpServletRequest request, PrintWriter out) {
        String title = "HttpServletRequest methods";
        out.println("<html>\n" +
                            "<head><title>" + title + "</title></head>\n" +
                            "<body bgcolor = \"#f0f0f0\">\n" +
                            "<h1 align = \"center\">" + title + "</h1>\n" +
                            "<table width = \"100%\" border = \"1\" align = \"center\">\n" +
                            "<tr bgcolor = \"#949494\">\n" +
                            "<th>Method name</th><th>result</th>\n" +
                            "</tr>\n");

        out.println("</table>\n");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

