package com.cdac.dao;

import java.sql.*;
import java.util.ArrayList;

import com.cdac.model.CartItem;
import com.cdac.util.DBUtil;

public class OrderDAO {

    public void saveOrder(
            String username,
            ArrayList<CartItem> cart)
    throws Exception
    {
        Connection con =
        DBUtil.getConnection();

        for(CartItem item : cart)
        {
            PreparedStatement ps =
            con.prepareStatement(
            "insert into orders(username,food_name,quantity,total_amount) values(?,?,?,?)");

            ps.setString(
            1, username);

            ps.setString(
            2, item.getFoodName());

            ps.setInt(
            3, item.getQuantity());

            ps.setDouble(
            4, item.getTotal());

            ps.executeUpdate();
        }
    }
}