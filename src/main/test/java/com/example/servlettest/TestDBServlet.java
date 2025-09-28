package com.example.servlettest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servlet.DBConnection;

public class TestDBServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest req, HttpServletResponse res)
	            throws ServletException, IOException {
	        res.setContentType("text/html");
	        PrintWriter out = res.getWriter();

	        try (Connection con = DBConnection.getConnection()) {
	            if (con != null) {
	                out.println("<h2>DB Connected Successfully!</h2>");
	            } else {
	                out.println("<h2>DB Connection Failed</h2>");
	            }
	        } catch (Exception e) {
	            e.printStackTrace(out);
	        }
	    }

}
