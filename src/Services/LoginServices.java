/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DBConnection.SQLRun;
import model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Group name
 */
public class LoginServices {

    public User checkLogin(User user) {

        try {
            SQLRun objSQL = new SQLRun();
            ResultSet rs = objSQL.sqlQuery("Select * from user where "
                    + "email = '" + user.getUsername() + "' and "
                    + "password = '" + user.getPassword() + "' ");
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setRole(rs.getString("role"));

            } else {
                user = null;

            }
        } catch (SQLException ex) {
            user = null;
        }
        return user;
    }
}