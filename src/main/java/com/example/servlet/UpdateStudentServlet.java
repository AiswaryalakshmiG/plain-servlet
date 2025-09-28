package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.StudentDAO;
import com.example.model.Student;

public class UpdateStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            Student s = new Student();
            s.setId(Integer.parseInt(req.getParameter("id")));
            s.setName(req.getParameter("name"));
            s.setAge(Integer.parseInt(req.getParameter("age")));
            s.setMark(Double.parseDouble(req.getParameter("mark")));

            new StudentDAO().updateStudent(s);
        } catch(Exception e){ e.printStackTrace(); }
        res.sendRedirect("list");
    }
}
