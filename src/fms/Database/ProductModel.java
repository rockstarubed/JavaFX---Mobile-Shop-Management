/*
$This Project is Licenced to Ubed Shaikh, Kanchan Jogi, Shubhangi Kamale.
$Source code is not editable without permission of anyone mentioned above.
$Project under Development.
$Copyright to Friends Microsoftwares 2018.
 */
package fms.Database;

import fms.CategoriesController;
import static fms.Database.BillModel.conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubed
 */
public class ProductModel {

    Connection con;
    String query;
    PreparedStatement stmt;
    ResultSet rs;
    public String manu, model, color, price;

    public ProductModel() {
        conection = DBConnection.Connector();
        if (conection == null) {

            System.out.println("connection not successful");
            System.exit(1);

        }
    }

    public boolean addproduct(String pid, String manu, String model, String color, String price) {
        try {
            query = "insert into  " + CategoriesController.cata + " values(?,?,?,?,?)";
            stmt = conection.prepareStatement(query);
            stmt.setString(1, pid);
            stmt.setString(2, manu);
            stmt.setString(3, model);
            stmt.setString(4, color);
            stmt.setString(5, price);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean fetchpro(String code) throws SQLException {
        query = "select * from  " + CategoriesController.cata + " where pcode=?";
        stmt = conection.prepareStatement(query);
        stmt.setString(1, code);
        rs = stmt.executeQuery();
        while (rs.next()) {
            manu = rs.getString("Manufacturer");
            model = rs.getString("Model");
            color = rs.getString("Color");
            price = rs.getString("Price");
        }
        return true;
    }

    public boolean updatep(String code, String manu, String model, String color, String price) {
        try {
            query = "update  " + CategoriesController.cata + " set Manufacturer=?,Model=?,Color=?,Price=? where pcode=?";
            stmt = conection.prepareStatement(query);
            stmt.setString(1, manu);
            stmt.setString(2, model);
            stmt.setString(3, color);
            stmt.setString(4, price);
            stmt.setString(5, code);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(String text) {
        try {
            query = "delete from  " + CategoriesController.cata + " where pcode=?";
            stmt = conection.prepareStatement(query);
            stmt.setString(1, text);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
