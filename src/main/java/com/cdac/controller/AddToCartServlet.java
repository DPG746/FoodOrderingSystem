//package com.cdac.controller;
package main.java.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import main.java.model.CartItem;

@WebServlet("/addcart")
public class AddToCartServlet
extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        HttpSession session =
        request.getSession(false);

        if(session == null)
        {
            response.sendRedirect(
            "login.html");
            return;
        }

        String food =
        request.getParameter("food");

        int qty =
        Integer.parseInt(
        request.getParameter("qty"));

        double price =
        Double.parseDouble(
        request.getParameter("price"));

        double total =
        qty * price;

        CartItem item =
        new CartItem(
        food,
        qty,
        total);

        ArrayList<CartItem> cart =
        (ArrayList<CartItem>)
        session.getAttribute("cart");

        if(cart == null)
        {
            cart =
            new ArrayList<>();
        }

        cart.add(item);

        session.setAttribute(
        "cart",
        cart);

        response.sendRedirect(
        "cart.jsp");
    }
}
