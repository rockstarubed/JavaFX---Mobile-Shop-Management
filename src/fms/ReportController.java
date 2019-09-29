/*
$This Project is Licenced to Ubed Shaikh, Kanchan Jogi, Shubhangi Kamale.
$Source code is not editable without permission of anyone mentioned above.
$Project under Development.
$Copyright to Friends Microsoftwares 2018.
 */
package fms;

import fms.Database.DBConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class ReportController implements Initializable {

    @FXML
    private TableView<Report> report_table;
    @FXML
    private TableColumn<Report, String> c_bill;
    @FXML
    private TableColumn<Report, String> c_soldto;
    @FXML
    private TableColumn<Report, String> c_mono;
    @FXML
    private TableColumn<Report, String> c_soldon;
    @FXML
    private TableColumn<Report, String> c_soldby;
    @FXML
    private TableColumn<Report, String> c_pid;
    ObservableList<Report> bill_list = FXCollections.observableArrayList();
    Connection con = DBConnection.Connector();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            String sql = "select * from orders";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                bill_list.add(new Report(rs.getString("bill_no"), rs.getString("c_name"), rs.getString("mono"), rs.getString("product"), rs.getString("Date"), rs.getString("seller")));
            }
            c_bill.setCellValueFactory(new PropertyValueFactory<>("billid"));
            c_soldto.setCellValueFactory(new PropertyValueFactory<>("cname"));
            c_mono.setCellValueFactory(new PropertyValueFactory<>("cmob"));
            c_soldby.setCellValueFactory(new PropertyValueFactory<>("soldby"));
            c_soldon.setCellValueFactory(new PropertyValueFactory<>("date"));
            c_pid.setCellValueFactory(new PropertyValueFactory<>("pid"));
            report_table.setItems(bill_list);
        } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static class Report {

        String billid, cname, cmob, pid, date, soldby;

        public Report() {
        }

        public Report(String billid, String cname, String cmob, String pid, String date, String soldby) {
            this.billid = billid;
            this.cname = cname;
            this.cmob = cmob;
            this.pid = pid;
            this.date = date;
            this.soldby = soldby;
        }

        public String getBillid() {
            return billid;
        }

        public void setBillid(String billid) {
            this.billid = billid;
        }

        public String getCname() {
            return cname;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

        public String getCmob() {
            return cmob;
        }

        public void setCmob(String cmob) {
            this.cmob = cmob;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getSoldby() {
            return soldby;
        }

        public void setSoldby(String soldby) {
            this.soldby = soldby;
        }
    }

}
