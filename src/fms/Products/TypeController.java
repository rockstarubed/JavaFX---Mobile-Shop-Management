/*
$This Project is Licenced to Ubed Shaikh, Kanchan Jogi, Shubhangi Kamale.
$Source code is not editable without permission of anyone mentioned above.
$Project under Development.
$Copyright to Friends Microsoftwares 2018.
 */
package fms.Products;

import fms.CategoriesController;
import fms.Database.DBConnection;
import fms.FMS;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ubed
 */
public class TypeController implements Initializable {

    @FXML
    private TableView<ModelTable> smarphone;
    @FXML
    private TableColumn<ModelTable, String> pcode;
    @FXML
    private TableColumn<ModelTable, String> manufacturer;
    @FXML
    private TableColumn<ModelTable, String> model;
    @FXML
    private TableColumn<ModelTable, String> colour;
    @FXML
    private TableColumn<ModelTable, String> price;

    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection con = DBConnection.Connector();
            String sql = "select * from  " + CategoriesController.cata;
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                oblist.add(new ModelTable(rs.getString("pcode"), rs.getString("Manufacturer"), rs.getString("Model"),
                        rs.getString("Color"), rs.getString("Price")));
            }

            pcode.setCellValueFactory(new PropertyValueFactory<>("pcode"));
            manufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
            model.setCellValueFactory(new PropertyValueFactory<>("model"));
            colour.setCellValueFactory(new PropertyValueFactory<>("colour"));
            price.setCellValueFactory(new PropertyValueFactory<>("price"));

            smarphone.setItems(oblist);
        } catch (SQLException ex) {
            System.out.print(ex);
            Logger.getLogger(TypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addp(ActionEvent event) throws IOException {
        FMS.fxml.loadfxml("Products/addproduct.fxml", "Add Product");
    }

    @FXML
    private void updatep(ActionEvent event) throws IOException {
        FMS.fxml.loadfxml("Products/updateproduct.fxml", "Update Product");
    }

    @FXML
    private void deletep(ActionEvent event) throws IOException {
        FMS.fxml.loadfxml("Products/deletproduct.fxml", "Delete Product");
    }
}
