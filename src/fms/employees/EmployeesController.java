/*
$This Project is Licenced to Ubed Shaikh, Kanchan Jogi, Shubhangi Kamale.
$Source code is not editable without permission of anyone mentioned above.
$Project under Development.
$Copyright to Friends Microsoftwares 2018.
 */
package fms.employees;

import fms.Database.DBConnection;
import fms.LoadFxml;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ubed
 */
public class EmployeesController implements Initializable {

    @FXML
    private TableView<EmpTable> emptable;
    @FXML
    private TableColumn<EmpTable, String> col_id;
    @FXML
    private TableColumn<EmpTable, String> col_name;
    @FXML
    private TableColumn<EmpTable, String> col_address;
    @FXML
    private TableColumn<EmpTable, String> col_mono;
    @FXML
    private TableColumn<EmpTable, String> col_mail;
    @FXML
    private TableColumn<EmpTable, String> col_salary;
    ObservableList<EmpTable> oblist = FXCollections.observableArrayList();
    Connection con = DBConnection.Connector();
    LoadFxml fxml = new LoadFxml();
    @FXML
    public AnchorPane empdata;
    public AnchorPane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String sql = "select * from  employees";
        try {

            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                oblist.add(new EmpTable(rs.getString("userid"), rs.getString("Name"), rs.getString("Address"),
                        rs.getString("Mobile"), rs.getString("Email"), rs.getString("Salary")));
            }

            col_id.setCellValueFactory(new PropertyValueFactory<>("emp_id"));
            col_name.setCellValueFactory(new PropertyValueFactory<>("emp_name"));
            col_address.setCellValueFactory(new PropertyValueFactory<>("emp_address"));
            col_mono.setCellValueFactory(new PropertyValueFactory<>("emp_mobile"));
            col_mail.setCellValueFactory(new PropertyValueFactory<>("emp_email"));
            col_salary.setCellValueFactory(new PropertyValueFactory<>("emp_salary"));

            emptable.setItems(oblist);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void updateemp(ActionEvent event) throws IOException {
        fxml.loadfxml("employees/updateemp.fxml", "Update Employee");
    }

    @FXML
    private void rememp(ActionEvent event) throws IOException {
        fxml.loadfxml("employees/rememp.fxml", "Remove Employee");
    }

    @FXML
    private void addemp(ActionEvent event) throws IOException {
        fxml.loadfxml("employees/addemp.fxml", "Add Employee");
    }

}
