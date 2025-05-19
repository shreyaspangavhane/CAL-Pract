package com.mvcapp.controller;

import com.mvcapp.model.Message;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class MessageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Message msg = new Message("Hello from MVC Servlet!");
        request.setAttribute("message", msg);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/message.jsp");
        dispatcher.forward(request, response);
    }
}