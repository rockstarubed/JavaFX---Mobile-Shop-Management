/*
$This Project is Licenced to Ubed Shaikh, Kanchan Jogi, Shubhangi Kamale.
$Source code is not editable without permission of anyone mentioned above.
$Project under Development.
$Copyright to Friends Microsoftwares 2018.
 */
package fms.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ubed
 */
public class RegisterModel {

    Connection conection;

    public RegisterModel() {
        conection = DBConnection.Connector();
        if (conection == null) {

            System.out.println("connection not successful");
            System.exit(1);
        }
    }

    public boolean adduser(String user, String pass, String name) {
        String sql = "INSERT INTO users VALUES(?,?,?)";
        try {
            PreparedStatement pstmt;
            pstmt = conection.prepareStatement(sql);
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            pstmt.setString(3, name);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
