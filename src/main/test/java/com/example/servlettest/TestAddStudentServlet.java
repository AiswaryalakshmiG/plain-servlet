package com.example.servlettest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.StudentDAO;
import com.example.model.Student;

public class TestAddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            Student s = new Student("Test Student", 20, 85.5);

            new StudentDAO().addStudent(s);

            out.println("<h2>Student Added Successfully!</h2>");
            out.println("<p>Name: " + s.getName() + "</p>");
            out.println("<p>Age: " + s.getAge() + "</p>");
            out.println("<p>Mark: " + s.getMark() + "</p>");
        } catch (Exception e) {
            e.printStackTrace(out);
            out.println("<h2>Failed to Add Student</h2>");
        }
    }
}
