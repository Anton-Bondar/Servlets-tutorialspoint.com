package com.tutorialspoint.cookies_handling_08;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by anbo06131 on 12/19/2017.
 */
@WebServlet(value = "/hello_form+cookie")
public class HelloFormCookiesServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create cookies for first and last names.
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");

        if (first_name != null) {
            Cookie firstName = new Cookie("first_name", first_name);
            firstName.setMaxAge(60 * 60 * 24);
            response.addCookie(firstName);
        }

        if (last_name != null) {
            Cookie lastName = new Cookie("last_name", last_name);
            lastName.setMaxAge(60 * 60 * 24);
            response.addCookie(lastName);
        }


        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Setting Cookies Example";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                            "<html>\n" + "<head><title>" + title + "</title>" + "</head>\n" +
                            "<body bgcolor = \"#f0f0f0\">\n" +
                            "<h1 align = \"center\">" + title + "</h1>\n" +
                            "<ul>\n" +
                            "  <li><b>First Name</b>: "
                            + request.getParameter("first_name") + "\n" +
                            "  <li><b>Last Name</b>: "
                            + request.getParameter("last_name") + "\n" +
                            "</ul>\n");

        Cookie cookie = null;
        Cookie[] cookies = null;

        // Get an array of Cookies associated with this domain
        cookies = request.getCookies();

        if (cookies != null) {
            out.println("<h2> Found Cookies Name and Value</h2>");

           out.println("<table width = \"100%\" border = \"1\" align = \"center\">\n" +
                    "<tr bgcolor = \"#949494\">\n" +
                    "<th>Name</th>"+
                    "<th>Value</th>"+
                    "<th>Action button</th>\n</tr>\n");

            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                out.print("<tr><td>" + cookie.getName() + "</td>");
                out.print("<td>" + cookie.getValue() + "</td>");
                out.print("<td>" +"<form action=\"/delete_cookie?name="+cookie.getName()+"\""+" method=\"post\">"+
                "<input type=\"submit\" name=\"delete_btn\" value=\"delete\" />"
                +"</form>"
                + "</td></tr>");

            }
        } else {
            out.println("<h2>No cookies founds</h2>");
        }
        out.println("\n</table>");
        out.println("\n</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

