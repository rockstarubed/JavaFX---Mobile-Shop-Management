/*
$This Project is Licenced to Ubed Shaikh, Kanchan Jogi, Shubhangi Kamale.
$Source code is not editable without permission of anyone mentioned above.
$Project under Development.
$Copyright to Friends Microsoftwares 2018.
 */
package fms.Database;

import fms.LoginController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ubed Shaikh
 */
public class BillModel {

    public String manu;
    public String model;
    public String color;
    public String price;
    public String name, address, mono, pid;
    public static int bill_id;
    public String query = null;
    static Connection conection;
    public  PreparedStatement stmt = null;
    public  ResultSet rs = null;

    public BillModel() {
        conection = DBConnection.Connector();
        if (conection == null) {

            System.out.println("connection not successful");
            System.exit(1);
        }
    }

    public void getBill(String type, String id) throws SQLException {

        switch (type) {
            case "SmartPhone":
                query = "select * from smartphones where pcode = ?";
                pid = "S" + id;
                break;
            case "FeaturePhone":
                query = "select * from featurephones where pcode = ?";
                pid = "F" + id;
                break;
            case "Tablet":
                query = "select * from tablets where pcode = ?";
                pid = "T" + id;
                break;
            default:
                query = "select * from accessories where pcode = ?";
                pid = "A" + id;
                break;
        }
        try {
            stmt = conection.prepareStatement(query);
            stmt.setString(1, pid);
            rs = stmt.executeQuery();
            while (rs.next()) {
                manu = rs.getString("Manufacturer");
                model = rs.getString("Model");
                color = rs.getString("Color");
                price = rs.getString("Price");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            stmt.close();
            rs.close();
        }

    }

    public boolean savebill(String name, String mob, String date) {
        try {
            String sql = "insert into orders (c_name,mono,product,Date,seller) values(?,?,?,?,?)";
            stmt = conection.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, mob);
            stmt.setString(3, pid);
            stmt.setString(4, date);
            stmt.setString(5, LoginController.uid);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BillModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public  void getbillid() throws SQLException {
        String sql = "select max (bill_no) from orders";
        rs = conection.createStatement().executeQuery(sql);
        while(rs.next()){
            bill_id = rs.getInt("max (bill_no)");
        }
        /* stmt = conection.prepareStatement(sql);
        rs = stmt.executeQuery();
        bill_id = rs.getInt("bill_no");*/
   }
}
