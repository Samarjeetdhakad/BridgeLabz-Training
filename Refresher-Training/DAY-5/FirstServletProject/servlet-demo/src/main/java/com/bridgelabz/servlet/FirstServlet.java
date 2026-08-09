package com.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet{

	 private static final long serialVersionUID = 1L;

	    @Override
	    protected void doGet(HttpServletRequest request,
	                         HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        out.println("<html>");
	        out.println("<body>");
	        out.println("<h2>Hello World</h2>");
	        out.println("<h3>Welcome to My First Servlet</h3>");
	        out.println("<h3>time: " + LocalDate.now() + "<h3>");
	        out.println("<body>");
	        out.println("<html>");
	        out.close();
	    }
	    
}
