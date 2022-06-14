package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import model.Controller;
import model.Van;
import model.Vehicle;

public class AddVehicleFormController {

    public AnchorPane addVehicleContext;


    public JFXTextField txtVehicleNumber;
    public JFXTextField txtVehicleWeight;
    public JFXTextField txtNumberOfPassengers;
    public JFXComboBox cmbVehicleType;

    String vehicleType;
    public void initialize(){
        ObservableList vehicleTypes = FXCollections.observableArrayList();
        vehicleTypes.add(0,"Van");
        vehicleTypes.add(1,"Bus");
        vehicleTypes.add(2,"Cargo Lorry");
        cmbVehicleType.setItems(vehicleTypes);
    }
    public void getVehicleType(ActionEvent actionEvent) {
         vehicleType = cmbVehicleType.getSelectionModel().getSelectedItem().toString();
    }

    public void AddVehicle(ActionEvent actionEvent) {
        addVehicle();
    }

    public void addVehicle(){
        String venicleNumber = txtVehicleNumber.getText().toString();
        String vehicleType = cmbVehicleType.getSelectionModel().getSelectedItem().toString();
        int maximumWeight = Integer.parseInt(txtVehicleWeight.getText());
        int numberOfPasssengers = Integer.parseInt(txtNumberOfPassengers.getText());

        Vehicle newVehicle= new Van(venicleNumber,vehicleType,maximumWeight,numberOfPasssengers);
       Controller.addVehicle(newVehicle);
    }
}
