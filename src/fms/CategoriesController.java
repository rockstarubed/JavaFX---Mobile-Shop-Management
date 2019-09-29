/*
$This Project is Licenced to Ubed Shaikh, Kanchan Jogi, Shubhangi Kamale.
$Source code is not editable without permission of anyone mentioned above.
$Project under Development.
$Copyright to Friends Microsoftwares 2018.
 */
package fms;

import static fms.FMS.fxml;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author mgm
 */
public class CategoriesController implements Initializable {

    public static Stage stage = new Stage();
    public static String cata;
    @FXML
    private Pane catagoriespane;
    @FXML
    private JFXButton home;
    @FXML
    private JFXButton exhome;
    @FXML
    private JFXButton logout;
    @FXML
    private ImageView accessPane;
    @FXML
    private ImageView smartPane;
    @FXML
    private ImageView featurePane;
    @FXML
    private ImageView tabsPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loadhome(ActionEvent event) throws IOException {
        Pane rootpane1 = FXMLLoader.load(getClass().getResource("UI/Home.fxml"));
        catagoriespane.getChildren().setAll(rootpane1);
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), rootpane1);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);
        fadeIn.play();
    }

    @FXML
    private void exit(ActionEvent event) {
        fxml.ExitApp();
    }

    @FXML
    private void openmain(ActionEvent event) throws IOException {
        AnchorPane rootpane = FXMLLoader.load(getClass().getResource("UI/Login.fxml"));
        catagoriespane.getChildren().setAll(rootpane);
    }

    @FXML
    public void loadSmartPhones(MouseEvent event) throws IOException {
        cata="smartphones";
        fxml.loadfxml("Products/Smartphone.fxml", "Samrtphones");
    }

    @FXML
    public void loadFeaturePhones(MouseEvent event) throws IOException {
        cata="featurephones";
        fxml.loadfxml("Products/Featurephones.fxml", "Featurephones");
    }

    @FXML
    public void loadTablets(MouseEvent event) throws IOException {
        cata="tablets";
        fxml.loadfxml("Products/Tablets.fxml", "Tablets");
    }

    @FXML
    public void loadAccessories(MouseEvent event) throws IOException {
        cata="accessories";
        fxml.loadfxml("Products/Accessories.fxml", "Accessories");
    }

    @FXML
    private void showabout(ActionEvent event) throws IOException {
        fxml.loadfxml("UI/About.fxml", "About This Software");
    }

    @FXML
    private void shwohelp(ActionEvent event) throws IOException {
        fxml.loadfxml("UI/Help.fxml", "");
    }

}
