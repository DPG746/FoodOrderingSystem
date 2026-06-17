//package com.cdac.controller;

package main.java.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import main.java.dao.UserDAO;

@WebServlet("/login")
public class LoginServlet
extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        try {

            String uname =
            request.getParameter(
            "username");

            String pwd =
            request.getParameter(
            "password");

            UserDAO dao =
            new UserDAO();

            if(dao.validateUser(
                    uname,pwd))
            {
                HttpSession session =
                request.getSession();

                session.setAttribute(
                "username",
                uname);

                response.sendRedirect(
                "menu.jsp");
            }
            else
            {
                response.getWriter()
                .println(
                "Invalid Login");
            }

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}
