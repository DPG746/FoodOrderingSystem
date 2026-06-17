//package com.cdac.dao;

package main.java.dao;

import java.sql.*;

import main.java.util.DBUtil;

public class UserDAO {

    public boolean validateUser(
            String username,
            String password)
    throws Exception
    {
        Connection con =
        DBUtil.getConnection();

        PreparedStatement ps =
        con.prepareStatement(
        "select * from users where username=? and password=?");

        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs =
        ps.executeQuery();

        return rs.next();
    }
}
