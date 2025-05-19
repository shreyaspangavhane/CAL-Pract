package com.studentapp.dao;

import com.studentapp.model.Student;
import com.studentapp.util.DBUtil;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {
            while (rs.next()) {
                list.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addStudent(Student s) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO students(name, email) VALUES (?, ?)")) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStudent(Student s) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=?, email=? WHERE id=?")) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setInt(3, s.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudent(int id) {
        try (Connection conn = DBUtil.getConnection();
             CallableStatement cs = conn.prepareCall("{call delete_student(?)}")) {
            cs.setInt(1, id);
            return cs.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Student getStudentById(int id) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE id=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}