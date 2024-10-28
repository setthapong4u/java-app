package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/vulnerable")
public class VulnerableApp extends HttpServlet {

    // Hardcoded credentials (Insecure)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "password";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userInput = request.getParameter("input");

        // SQL Injection vulnerability
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                response.getWriter().println("User: " + rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Command injection vulnerability
        Runtime.getRuntime().exec("echo " + userInput);
    }
}
