package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.StudentDAO;
import com.example.model.Student;

public class EditStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student s = null;
        try { s = new StudentDAO().getStudentById(id); } catch(Exception e){ e.printStackTrace(); }

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2>Edit Student</h2>");
        out.println("<form method='post' action='update'>");
        out.println("<input type='hidden' name='id' value='" + s.getId() + "'>");
        out.println("Name: <input type='text' name='name' value='" + s.getName() + "'><br>");
        out.println("Age: <input type='text' name='age' value='" + s.getAge() + "'><br>");
        out.println("Mark: <input type='text' name='mark' value='" + s.getMark() + "'><br>");
        out.println("<input type='submit' value='Update'>");
        out.println("</form>");
        out.println("<a href='list'>Back to List</a>");
    }
}
