package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.vehicleDiliver;

public class DiliveryFormController {

    public AnchorPane diveryWindowContext;
    public TableView tblDilivery;
    public TableColumn colVehicleNo;
    public TableColumn colVehicleType;
    public TableColumn colDriverName;
    public TableColumn colLeftTime;


   static ObservableList<vehicleDiliver> diliveryVehicles = FXCollections.observableArrayList();

    public void initialize(){
        colVehicleNo.setCellValueFactory(new PropertyValueFactory<>("VehicleNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("VehicleType"));
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("DriverName"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory<>("Date"));

        tblDilivery.setItems(diliveryVehicles);
    }

    public static void deliveryVehicle(String vehicleNumber,String vehicleType,String driverName,String time){

        vehicleDiliver vehicleDiliver = new vehicleDiliver(vehicleNumber,vehicleType,driverName,time);
        diliveryVehicles.add(vehicleDiliver);
        System.out.println(driverName);
    }

    public static void deleteVehicle(String vehicleNumbe,String vehicleType,String driverName,String time){

        diliveryVehicles.removeIf(vehicleDiliver -> (vehicleDiliver.getVehicleNumber().equals(vehicleNumbe)));
    }
}
