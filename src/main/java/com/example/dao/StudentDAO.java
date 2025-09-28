package com.example.dao;

import java.sql.*;
import java.util.*;
import com.example.model.Student;
import com.example.servlet.DBConnection;

public class StudentDAO {

    public void addStudent(Student s) throws Exception {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                 "INSERT INTO student(name, age, mark) VALUES(?, ?, ?)")) {

            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setDouble(3, s.getMark());
            ps.executeUpdate();
        }
    }

    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM student ORDER BY id")) {

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                s.setMark(rs.getDouble("mark"));
                list.add(s);
            }
        }
        return list;
    }

    public Student getStudentById(int id) throws Exception {
        Student s = null;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE id=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    s = new Student();
                    s.setId(rs.getInt("id"));
                    s.setName(rs.getString("name"));
                    s.setAge(rs.getInt("age"));
                    s.setMark(rs.getDouble("mark"));
                }
            }
        }
        return s;
    }

    public void updateStudent(Student s) throws Exception {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                 "UPDATE student SET name=?, age=?, mark=? WHERE id=?")) {
            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setDouble(3, s.getMark());
            ps.setInt(4, s.getId());
            ps.executeUpdate();
        }
    }

    public void deleteStudent(int id) throws Exception {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
