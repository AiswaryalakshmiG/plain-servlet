package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.StudentDAO;

public class DeleteStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            new StudentDAO().deleteStudent(id);
        } catch(Exception e){ e.printStackTrace(); }
        res.sendRedirect("list");
    }
}
