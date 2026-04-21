package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/VisitServlet")
public class VisitServlet_8b extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        int visitCount = 1;
        boolean found = false;

        // Get existing cookies
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {

                // Check visit count cookie
                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue());
                    visitCount++;
                    found = true;
                }
            }
        }

        // Create / Update cookies
        Cookie nameCookie = new Cookie("username", username);
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));

        // Set expiry (example: 30 seconds for demo)
        nameCookie.setMaxAge(30);
        visitCookie.setMaxAge(30);

        response.addCookie(nameCookie);
        response.addCookie(visitCookie);

        // Output
        out.println("<html><body>");

        out.println("<h2>Welcome back " + username + "!</h2>");
        out.println("<h3>You have visited this page " + visitCount + " times.</h3>");

        // Show all cookies
        out.println("<h3>List of Cookies:</h3>");

        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("<p>");
                out.println("Name: " + c.getName() + "<br>");
                out.println("Value: " + c.getValue());
                out.println("</p><hr>");
            }
        } else {
            out.println("<p>No cookies found</p>");
        }

        // Expiry message
        out.println("<p><b>Note:</b> Cookies will expire in 30 seconds. Refresh after that to see reset.</p>");

        out.println("</body></html>");
    }
}