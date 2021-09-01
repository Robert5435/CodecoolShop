package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.thymeleaf.context.WebContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/login"})
public class LoginUserController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException{
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());

        engine.process("user/login.html", context, response.getWriter());

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName=request.getParameter("userName");
        String password=request.getParameter("userPass");


//        looking for userName in DB then looking for it's matching password




//        if password is matching set session
        if(password.equals("admin123")){
            HttpSession session=request.getSession();
            session.setAttribute("userName",userName);
            response.sendRedirect("/");
        }
        else{
            response.sendRedirect("/login");
        }

        response.sendRedirect("/");

    }
}

