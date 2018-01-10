package com.tutorialspoint.hits_counter_15;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.util.*;

/**
 * Created by anbo06131 on 1/10/2018.
 */
@WebFilter(urlPatterns = {"/*"})
public class SiteHitCounter implements Filter {

    private int hitCount;

    ServletContext servletContext;

    public void  init(FilterConfig config) throws ServletException {
        servletContext = config.getServletContext();
        // Reset hit counter.
        hitCount = 0;
    }

    public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws java.io.IOException, ServletException {

        // increase counter by one
        hitCount++;

        // Print the counter.
        System.out.println("Site visits count :"+ hitCount);

        servletContext.log("Site visits count :"+ hitCount);

        // Pass request back down the filter chain
        chain.doFilter(request,response);
    }

    public void destroy() {
        // This is optional step but if you like you
        // can write hitCount value in your database.
    }
}
