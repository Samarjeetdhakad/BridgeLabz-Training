package com.bridgelabz.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("user");
        String password = request.getParameter("pwd");

        if ("admin".equals(username) && "1234".equals(password)) {

            request.setAttribute("user", username);

            request.getRequestDispatcher("loginSuccess.jsp")
                   .forward(request, response);

        } else {

            response.setContentType("text/html");

            response.getWriter().println("<h2>Invalid Username or Password</h2>");
            response.getWriter().println("<a href='login.html'>Try Again</a>");
        }
    }
}