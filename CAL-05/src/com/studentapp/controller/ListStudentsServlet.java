package com.studentapp.controller;

import com.studentapp.dao.StudentDAO;
import com.studentapp.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ListStudentsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = new StudentDAO().getAllStudents();
        request.setAttribute("students", students);
        RequestDispatcher rd = request.getRequestDispatcher("list-students.jsp");
        rd.forward(request, response);
    }
}