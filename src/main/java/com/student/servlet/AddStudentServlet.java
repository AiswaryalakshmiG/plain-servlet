package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.StudentDAO;
import com.example.model.Student;

public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2>Add Student</h2>");
        out.println("<form method='post' action='add'>");
        out.println("Name: <input type='text' name='name'><br>");
        out.println("Age: <input type='text' name='age'><br>");
        out.println("Mark: <input type='text' name='mark'><br>");
        out.println("<input type='submit' value='Add'>");
        out.println("</form>");
        out.println("<a href='list'>View Students</a>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            Student s = new Student();
            s.setName(req.getParameter("name"));
            s.setAge(Integer.parseInt(req.getParameter("age")));
            s.setMark(req.getParameter("mark"));

            new StudentDAO().addStudent(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        res.sendRedirect("list");
    }
}