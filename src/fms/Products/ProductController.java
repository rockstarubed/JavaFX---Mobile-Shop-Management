/*
$This Project is Licenced to Ubed Shaikh, Kanchan Jogi, Shubhangi Kamale.
$Source code is not editable without permission of anyone mentioned above.
$Project under Development.
$Copyright to Friends Microsoftwares 2018.
 */
package fms.Products;

import com.jfoenix.controls.JFXButton;
import fms.Database.ProductModel;
import fms.FMS;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author ubed
 */
public class ProductController implements Initializable {

    @FXML
    private TextField p_code;
    @FXML
    private TextField p_manu;
    @FXML
    private TextField p_model;
    @FXML
    private TextField p_colour;
    @FXML
    private TextField p_price;
    @FXML
    private JFXButton ex;
    @FXML
    private Label status;

    ProductModel productModel = new ProductModel();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void add(ActionEvent event) throws SQLException {
        if (productModel.addproduct(p_code.getText(), p_manu.getText(), p_model.getText(), p_colour.getText(), p_price.getText())) {
            FMS.fxml.alertbox("", "Database Updated", "Product Added to Stock");
        } else {
            FMS.fxml.alertbox("", "Fialed to Add", "Something Went Wrong");
        }
    }

    @FXML
    public void exit(ActionEvent event) {
        ex.getScene().getWindow().hide();
    }

    @FXML
    public void fetch(ActionEvent event) throws SQLException {
        if (productModel.fetchpro(p_code.getText())) {
            p_manu.setText(productModel.manu);
            p_model.setText(productModel.model);
            p_colour.setText(productModel.color);
            p_price.setText(productModel.price);
        } else {
            FMS.fxml.alertbox("Error!", "Exception Occured", "Check Product Code");
        }
    }

    @FXML
    public void update(ActionEvent event) throws SQLException {
        if (productModel.updatep(p_code.getText(), p_manu.getText(), p_model.getText(), p_colour.getText(), p_price.getText())) {
            FMS.fxml.alertbox("", "Product Updated", "");
        } else {
            FMS.fxml.alertbox("error", "Unable to Update", "");
        }
    }

    @FXML
    public void delete(ActionEvent event) {
        if (productModel.delete(p_code.getText())) {
            status.setText("Prodcut removed");
        } else {
            status.setText("Unabel to remove product");
        }
    }

}
