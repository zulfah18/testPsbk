/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ifunpas.psbk.supplierRelationManagement.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.ifunpas.psbk.supplierRelationManagement.database.DBConnection;

/**
 *
 * @author saefulrizky
 */
public class UserDAO {

    public static boolean login(String user, String password) {
        Connection connection = null;
        try {
            connection = DBConnection.connect();

            PreparedStatement ps = connection.prepareStatement("select \"user\" , pass from infouser where \"user\" =? and pass=? ");
            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            DBConnection.close(connection);
        }
    }
}
