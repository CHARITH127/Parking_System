package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Controller;
import model.Driver;

public class AddDriverFormController {

    public AnchorPane AddDriverContext;
    public TextField txtDriverName;
    public TextField txtNic;
    public TextField txtLicenseNumber;
    public TextField txtContactNumber;
    public TextArea txtAddress;

    public void AddDriver(ActionEvent actionEvent) {
        String driverName= txtDriverName.getText();
        String driverNic = txtNic.getText();
        String licenseNumber = txtLicenseNumber.getText();
        String contactNumber = txtLicenseNumber.getText();
        String address =txtAddress.getText();

        //Validation part---------------------------
            Driver newDriver = new Driver(driverName,driverNic,licenseNumber,contactNumber,address);
            Controller.addDrivers(newDriver);

    }
}
