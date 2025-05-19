package com.studentapp.controller;

import com.studentapp.dao.StudentDAO;
import com.studentapp.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student s = new Student();
        s.setName(request.getParameter("name"));
        s.setEmail(request.getParameter("email"));
        new StudentDAO().addStudent(s);
        response.sendRedirect("ListStudentsServlet");
    }
}