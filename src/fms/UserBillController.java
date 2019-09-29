/*
$This Project is Licenced to Ubed Shaikh, Kanchan Jogi, Shubhangi Kamale.
$Source code is not editable without permission of anyone mentioned above.
$Project under Development.
$Copyright to Friends Microsoftwares 2018.
 */
package fms;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import fms.Database.BillModel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Ubed
 */
public class UserBillController implements Initializable {

    BillModel billmodel = new BillModel();
    boolean file = true;
    @FXML
    private TextField uname;
    @FXML
    private TextField umono;
    @FXML
    private JFXButton ex;
    @FXML
    private Pane billpane;
    @FXML
    private TextField getcode;
    @FXML
    private JFXTextField warrenty;
    @FXML
    private ChoiceBox<String> cb;
    @FXML
    private Label dt;
    @FXML
    private Label brand;
    @FXML
    private Label model;
    @FXML
    private Label colour;
    @FXML
    private Label type;
    @FXML
    private Label price;
    @FXML
    private Label total;
    @FXML
    private JFXButton reset;
    public String sdate;
    @FXML
    private Label billno;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cb.setItems(FXCollections.observableArrayList("SmartPhone", "FeaturePhone", "Tablet", "Accessory"));
        Date date1 = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YY");
        sdate = dateFormat.format(date1);
        dt.setText(sdate);
        try {
            billmodel.getbillid();
            billno.setText(String.valueOf(BillModel.bill_id+1));
        } catch (SQLException exC) {
            Logger.getLogger(UserBillController.class.getName()).log(Level.SEVERE, null, exC);
        }
    }

    @FXML
    private void resetbill(ActionEvent event) throws IOException {
        uname.setText("");
        umono.setText("");
        warrenty.setText("");
    }

    @FXML
    private void closebill(ActionEvent event) {
        ex.getScene().getWindow().hide();
    }

    @FXML
    private void pcode(ActionEvent event) throws SQLException {
        String ctype = cb.getValue();
        String pcode = getcode.getText();
        billmodel.getBill(ctype, pcode);
        brand.setText(billmodel.manu);
        model.setText(billmodel.model);
        price.setText(billmodel.price);
        total.setText(billmodel.price);
        colour.setText(billmodel.color);
        type.setText(ctype);
    }

    @FXML
    private void printbill(ActionEvent event) {
        if (billmodel.savebill(uname.getText(), umono.getText(), sdate)) {
            Node node = billpane;
            PrinterJob job = PrinterJob.createPrinterJob();
            if (job != null) {
                boolean success = job.printPage(node);
                job.endJob();
            }
        }
    }
}
