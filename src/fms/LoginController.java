/*
$This Project is Licenced to Ubed Shaikh, Kanchan Jogi, Shubhangi Kamale.
$Source code is not editable without permission of anyone mentioned above.
$Project under Development.
$Copyright to Friends Microsoftwares 2018.
 */
package fms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import com.jfoenix.controls.JFXButton;
import fms.Database.LoginModel;
import static fms.FMS.fxml;
import java.sql.SQLException;
import javafx.scene.control.Label;

/**
 * FlassXML Controller class
 *
 * @author Ubed, Shubhangi, Kanchan
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane rootpane;
    public static AnchorPane rootP;

    @FXML
    private PasswordField pass;

    @FXML
    TextField id;
    public static String uid;
    @FXML
    private JFXButton exit;

    @FXML
    private Label loginlabel;

    @FXML
    private JFXButton reset;

    @FXML
    private Label title;

    public LoginModel loginModel = new LoginModel();
    @FXML
    private Label dblabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (!FMS.isSplashLoaded) {
            loadSplashScreen();
        }
        if (!loginModel.isDbConnected()) {
            dblabel.setText("Not Connected to Database");
        }
    }

    private void loadSplashScreen() {
        try {
            FMS.isSplashLoaded = true;

            AnchorPane pane = FXMLLoader.load(getClass().getResource(("UI/SplashFXML.fxml")));
            rootpane.getChildren().setAll(pane);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);
            fadeOut.play();

            fadeOut.setOnFinished((e) -> {
                try {
                    AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("UI/Login.fxml")));
                    rootpane.getChildren().setAll(parentContent);

                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void loadHome(ActionEvent event) throws IOException, SQLException {
        uid = id.getText();
        if (loginModel.isLogin(uid, pass.getText())) {
            Pane pane = FXMLLoader.load(getClass().getResource("UI/Home.fxml"));
            rootpane.getChildren().setAll(pane);
        } else {
            loginlabel.setText("User ID & Password is Wrong!");
            FMS.fxml.alertbox("", "", "User ID & Password is Wrong!");
        }
    }

    @FXML
    private void resetcontent(ActionEvent event) {
        id.setText("");
        pass.setText("");
        loginlabel.setText("Login Using Your E-mail ID & Password");
    }

    @FXML
    private void exitapp(ActionEvent event) {
        FMS.fxml.ExitApp();
    }

    @FXML
    private void loadRegisteration(ActionEvent event) throws IOException {
        FMS.fxml.loadfxml("UI/register.fxml","Create New Account");
    }

    @FXML
    private void help(ActionEvent event) throws IOException {
        fxml.loadfxml("UI/Help.fxml", "");
    }
}
