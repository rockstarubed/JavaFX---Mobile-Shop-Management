/*
$This Project is Licenced to Ubed Shaikh, Kanchan Jogi, Shubhangi Kamale.
$Source code is not editable without permission of anyone mentioned above.
$Project under Development.
$Copyright to Friends Microsoftwares 2018.
 */
package fms;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Ubed, Shubhangi, Kanchan
 */
public class HomeController implements Initializable {

    LoadFxml fxml = new LoadFxml();
    @FXML
    private Button logout;
    @FXML
    private Pane rootpane1;
    @FXML
    private JFXButton exhome;
    @FXML
    private Label welcome;
    @FXML
    private ImageView employeemanager;
    @FXML
    private ImageView billgenerator;
    @FXML
    private ImageView help;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void openmain(ActionEvent event) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("UI/Login.fxml"));
        rootpane1.getChildren().setAll(pane1);
    }

    @FXML
    private void exit(ActionEvent event) {
        fxml.ExitApp();
    }

    @FXML
    private void showabout(ActionEvent event) throws IOException {
        fxml.loadfxml("UI/About.fxml", "About This Software");
    }

    @FXML
    private void loadproduct(MouseEvent event) throws IOException {
        Pane catagoriespane = FXMLLoader.load(getClass().getResource("UI/categories.fxml"));
        rootpane1.getChildren().setAll(catagoriespane);
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), rootpane1);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);
        fadeIn.play();
    }

    @FXML
    private void loademployees(MouseEvent event) throws IOException {
        fxml.loadfxml("employees/Employees.fxml", "Emplyee Manger");
    }

    @FXML
    private void loadbill(MouseEvent event) throws IOException {
        fxml.loadfxml("UI/UserBill.fxml", "Bill");
    }

    @FXML
    private void showhelp(ActionEvent event) throws IOException {
         fxml.loadfxml("UI/Help.fxml", "");
    }

    @FXML
    private void showhelp1(MouseEvent event) throws IOException {
        fxml.loadfxml("UI/Report.fxml", "");
    }

}
