package com.example.servlettest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.StudentDAO;
import com.example.model.Student;

public class TestEditStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            int testId = 1; 
            Student s = new StudentDAO().getStudentById(testId);

            if (s != null) {
                out.println("<h2>Fetched Student for Edit</h2>");
                out.println("<p>ID: " + s.getId() + "</p>");
                out.println("<p>Name: " + s.getName() + "</p>");
                out.println("<p>Age: " + s.getAge() + "</p>");
                out.println("<p>Mark: " + s.getMark() + "</p>");
            } else {
                out.println("<h2>No Student Found with ID " + testId + "</h2>");
            }
        } catch (Exception e) {
            e.printStackTrace(out);
            out.println("<h2>Failed to Fetch Student</h2>");
        }
    }
}
