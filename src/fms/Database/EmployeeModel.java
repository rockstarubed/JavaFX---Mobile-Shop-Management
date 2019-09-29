/*
$This Project is Licenced to Ubed Shaikh, Kanchan Jogi, Shubhangi Kamale.
$Source code is not editable without permission of anyone mentioned above.
$Project under Development.
$Copyright to Friends Microsoftwares 2018.
 */
package fms.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ubed
 */
public class EmployeeModel {
    String sql=null;
    PreparedStatement pstmt;
    Connection conection;
    public String user,name, address,mobile,email,salary;
    ResultSet rs = null;

    public EmployeeModel() {
        conection = DBConnection.Connector();
        if (conection == null) {

            System.out.println("connection not successful");
            System.exit(1);
        }
    }

    public boolean add(String user,String name,String address,String mobile,String email,String salary) throws SQLException {
        sql = "INSERT INTO employees VALUES(?,?,?,?,?,?)";
        try {
            pstmt = conection.prepareStatement(sql);
            pstmt.setString(1, user);
            pstmt.setString(2, name);
            pstmt.setString(3, address);
            pstmt.setString(4, mobile);
            pstmt.setString(5, email);
            pstmt.setString(6, salary);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public void fetch(String id) throws SQLException{
        user=id;
        sql="select * from employees where userid=?";
        pstmt = conection.prepareStatement(sql);
        pstmt.setString(1, user);
        rs=pstmt.executeQuery();
        while(rs.next()){
            name=rs.getString("Name");
            address=rs.getString("Address");
            mobile=rs.getString("Mobile");
            email=rs.getString("Email");
            salary=rs.getString("Salary");
        }
        pstmt.close();
        rs.close();
    }

    public boolean update(String name,String address,String mobile,String email,String salary) throws SQLException {
 
           String update="UPDATE employees SET Name= ?,Address= ?,Mobile= ?,Email= ?,Salary= ? where userid=?";
            pstmt = conection.prepareStatement(update);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setString(3, mobile);
            pstmt.setString(4, email);
            pstmt.setString(5, salary);
            pstmt.setString(6, user);
            pstmt.executeUpdate();
            return true;
    }

    public boolean del(String text) throws SQLException {
        sql = "delete from employees where userid=?";
        pstmt=conection.prepareStatement(sql);
        pstmt.setString(1, text);
        pstmt.executeUpdate();
        return true;
        
    }
}
