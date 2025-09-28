package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.StudentDAO;
import com.example.model.Student;

public class ListStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2>Student List</h2>");
        out.println("<a href='add'>Add Student</a><br><br>");
        out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Age</th><th>Mark</th><th>Actions</th></tr>");
        try {
            List<Student> list = new StudentDAO().getAllStudents();
            for (Student s : list) {
                out.println("<tr>");
                out.println("<td>" + s.getId() + "</td>");
                out.println("<td>" + s.getName() + "</td>");
                out.println("<td>" + s.getAge() + "</td>");
                out.println("<td>" + s.getMark() + "</td>");
                out.println("<td><a href='edit?id=" + s.getId() + "'>Edit</a> | <a href='delete?id=" + s.getId() + "'>Delete</a></td>");
                out.println("</tr>");
            }
        } catch (Exception e) { e.printStackTrace(); }
        out.println("</table>");
    }
}
