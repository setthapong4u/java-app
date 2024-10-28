package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/vulnerable")
public class VulnerableApp extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Output a basic HTML response
        out.println("<html><body>");
        out.println("<h1>Vulnerable App</h1>");
        out.println("<p>This servlet is working correctly.</p>");
        out.println("</body></html>");
        
        // Close the output stream
        out.close();
    }
}
