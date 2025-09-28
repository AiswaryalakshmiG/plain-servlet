package com.example.servlet;

import com.example.dao.StudentDAO;
import com.example.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;

public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2>Add Student</h2>");
        out.println("<form method='post' action='add'>");
        out.println("Name: <input type='text' name='name'><br>");
        out.println("Age: <input type='number' name='age'><br>");
        out.println("Mark: <input type='number' step='0.01' name='mark'><br>");
        out.println("<input type='submit' value='Add'>");
        out.println("</form>");
        out.println("<a href='list'>View Students</a>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            Student s = new Student();
            s.setName(req.getParameter("name"));
            s.setAge(Integer.parseInt(req.getParameter("age")));
            s.setMark(Double.parseDouble(req.getParameter("mark")));

            new StudentDAO().addStudent(s);

        } catch (Exception e) {
            e.printStackTrace();
            res.getWriter().println(e.getMessage());
            return;
        }
        res.sendRedirect("list");
    }
}
