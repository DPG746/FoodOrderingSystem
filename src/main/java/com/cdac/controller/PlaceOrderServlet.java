//package com.cdac.controller;

package main.java.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import main.java.dao.OrderDAO;
import main.java.model.CartItem;

@WebServlet("/placeorder")
public class PlaceOrderServlet
extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        try {

            HttpSession session =
            request.getSession(false);

            String username =
            (String)session.getAttribute(
            "username");

            ArrayList<CartItem> cart =
            (ArrayList<CartItem>)
            session.getAttribute(
            "cart");

            OrderDAO dao =
            new OrderDAO();

            dao.saveOrder(
            username,
            cart);

            response.sendRedirect(
            "success.jsp");

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}
