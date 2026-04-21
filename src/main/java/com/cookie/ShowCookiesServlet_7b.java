package com.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.PrintWriter;

@WebServlet("/ShowCookiesServlet")
public class ShowCookiesServlet_7bS extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Active Cookie List</h2>");

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("<p>");
                out.println("<b>Name:</b> " + c.getName() + "<br>");
                out.println("<b>Value:</b> " + c.getValue());
                out.println("</p><hr>");
            }
        } else {
            out.println("<p>No cookies found!</p>");
        }

        out.println("</body></html>");
    }
}