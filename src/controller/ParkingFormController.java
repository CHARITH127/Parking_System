package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.VehicleParking;

public class ParkingFormController {

    public AnchorPane parkingContext;
    public TableView tblParking;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colVehicleSlot;
    public TableColumn colVehiclePakedTime;

   static ObservableList<VehicleParking> parkingList=FXCollections.observableArrayList();

   public void initialize() {
        colVehicleNumber.setCellValueFactory(new PropertyValueFactory("ParkVehicleNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("ParksVehicleType"));
        colVehicleSlot.setCellValueFactory(new PropertyValueFactory<>("ParkingSlot"));
        colVehiclePakedTime.setCellValueFactory(new PropertyValueFactory<>("TimeDate"));

        tblParking.setItems(parkingList);

   }

    public static void parking(String ans,String type,String slot,String date){
        //System.out.println(ans+" "+type+" "+slot+" "+date);
        VehicleParking vehicleParking = new VehicleParking(ans,type,slot,date);
        parkingList.add(vehicleParking);

    }

    public static void deletePark(String ans,String type,String slot,String date){

        parkingList.removeIf(vehicleParking -> (vehicleParking.getParkVehicleNumber().equals(ans)));

    }

}
