/*
$This Project is Licenced to Ubed Shaikh, Kanchan Jogi, Shubhangi Kamale.
$Source code is not editable without permission of anyone mentioned above.
$Project under Development.
$Copyright to Friends Microsoftwares 2018.
 */
package fms;

import fms.Database.RegisterModel;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ubed
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField userid;
    @FXML
    private PasswordField passwd;

    RegisterModel registerModel = new RegisterModel();
    @FXML
    private Label status;

    @FXML
    private Button ex;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addaccount(ActionEvent event) throws SQLException {
        if (userid.getText().equals("") && passwd.getText().equals("") && username.getText().equals("")) {
            status.setText("All fields are neccessary!");
            FMS.fxml.alertbox("Incomplete Data!", "", "All Fields are neccessary!.");
        } else if (registerModel.adduser(userid.getText(), passwd.getText(), username.getText())) {
            status.setText("User Account Created!");
            FMS.fxml.alertbox("Registeration Complete!", "Account Created!", "Account Added To Database.");
        } else {
            status.setText("All fields are neccessary!");
            FMS.fxml.alertbox("Incomplete Data!", "", "All Fields are neccessary!.");
        }
    }

    @FXML
    private void reset(ActionEvent event) {
        username.setText("");
        userid.setText("");
        passwd.setText("");
    }

    @FXML
    private void exit(ActionEvent event) {
        ex.getScene().getWindow().hide();
    }

}
