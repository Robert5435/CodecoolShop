package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/register"})
public class RegisterUserController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException{
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());

        engine.process("user/register.html", context, response.getWriter());

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName=request.getParameter("userName");
//        password to be hashed
        String password=request.getParameter("userPass");

        String email=request.getParameter("userEmail");


//        user to be added to DB
        User user = new User(userName,password,email);

        System.out.println(userName);
        response.sendRedirect(request.getContextPath() + "/");


    }
}
