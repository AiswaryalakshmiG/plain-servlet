package com.example.servlettest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.StudentDAO;

public class TestDeleteStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
           
            int testId = 1;  

            new StudentDAO().deleteStudent(testId);

            out.println("<h2>Student Deleted Successfully!</h2>");
            out.println("<p>Deleted Student ID: " + testId + "</p>");
        } catch (Exception e) {
            e.printStackTrace(out);
            out.println("<h2>Failed to Delete Student</h2>");
        }
    }
}
