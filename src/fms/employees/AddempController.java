/*
$This Project is Licenced to Ubed Shaikh, Kanchan Jogi, Shubhangi Kamale.
$Source code is not editable without permission of anyone mentioned above.
$Project under Development.
$Copyright to Friends Microsoftwares 2018.
 */
package fms.employees;

import com.jfoenix.controls.JFXButton;
import fms.Database.EmployeeModel;
import fms.FMS;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ubed
 */
public class AddempController implements Initializable {

    EmployeeModel empModel = new EmployeeModel();
    @FXML
    public TextField emp_id;
    public TextField emp_name;
    public TextField emp_add;
    public TextField emp_mob;
    public TextField emp_mail;
    public TextField emp_salary;
    @FXML
    public JFXButton ex;
    public AnchorPane add_emp;
    @FXML
    private Label status;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void addemp(ActionEvent event) throws SQLException {
        if (empModel.add(emp_id.getText(), emp_name.getText(), emp_add.getText(), emp_mob.getText(),
                emp_mail.getText(), emp_salary.getText())) {
            FMS.fxml.alertbox("Registeration Complete!", "Account Created!", "Account Added To Database.");
        } else {
            FMS.fxml.alertbox("Incomplete Data!", "", "All Fields are neccessary!.");
        }
    }

    public void reset(ActionEvent event) {
        emp_id.setText("");
        emp_name.setText("");
        emp_add.setText("");
        emp_mob.setText("");
        emp_mail.setText("");
        emp_salary.setText("");
    }

    @FXML
    public void exit(ActionEvent event) throws IOException {
        ex.getScene().getWindow().hide();
    }

    public void fetchemp(ActionEvent event) throws SQLException {
        empModel.fetch(emp_id.getText());
        emp_name.setText(empModel.name);
        emp_add.setText(empModel.address);
        emp_mob.setText(empModel.mobile);
        emp_mail.setText(empModel.email);
        emp_salary.setText(empModel.salary);
    }

    public void updateemp(ActionEvent event) throws SQLException {
        if (empModel.update(emp_name.getText(), emp_add.getText(), emp_mob.getText(), emp_mail.getText(), emp_salary.getText())) {
            FMS.fxml.alertbox("Success", "Update Successfull", "Changes Addes to Database");
        } else {
            FMS.fxml.alertbox("Failure", "Update Failed", "");
        }
    }

    @FXML
    private void delete(ActionEvent event) throws SQLException {
        if (empModel.del(emp_id.getText())) {
            status.setText("Employee Deleted");
        } else {
            status.setText("Unable to Delete Employee");
        }
    }

}
