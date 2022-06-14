package controller;
import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashboardFormController {

    public AnchorPane dashboardContext;
    public ComboBox cmbvehicleId;
    public TextField txtVehicleType;
    public ComboBox cmbDriver;
    public JFXButton btnParkVehicle;
    public Label lblParkingSlot;
    public JFXButton btnDiliveryShift;
    public JFXButton btnManagement;
    public Label lblDate;
    public Label lblTime;
    public VBox vBox;


    Vehicle[] vehicle = Controller.getVehicleArray();

    String time ;
    public void initialize() throws ParseException {
        btnDiliveryShift.setVisible(false);
        btnParkVehicle.setVisible(true);

        for (int i=0; i<vehicle.length;i++){
            cmbvehicleId.getItems().add(vehicle[i].getVehicleNumber());
        }

        Driver[] driver=Controller.getDriverlist();
        for (int i=0; i<driver.length;i++){
            cmbDriver.getItems().add(driver[i].getName());
        }


      /*  Thread timerThread = new Thread(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy \nHH:mma");
            while (true) {
                try {
                    Thread.sleep(1000); //1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String time = simpleDateFormat.format(new Date());
                Platform.runLater(() -> {
                    lbletime.setText(time);
                });
            }
        });   timerThread.start();*/

/*        Thread clock = new Thread() {
            public void run() {
                for (;;) {
                    DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
                    Calendar cal = Calendar.getInstance();

                    int second = cal.get(Calendar.SECOND);
                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR);
                    //System.out.println(hour + ":" + (minute) + ":" + second);
                    lbletime.setText(hour + ":" + (minute) + ":" + second);

                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        //...
                    }
                }
            }
        };
        clock.start();*/

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO,event -> {
            DateTimeFormatter formatter =DateTimeFormatter.ofPattern("HH:mm:ss");
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy:MM:dd");
            lblDate.setText(LocalDateTime.now().format(formatter1));
            lblTime.setText(LocalDateTime.now().format(formatter));
            time=lblDate.getText()+" "+lblTime.getText();
        }),new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();



    }


    String ans;
    int slot;
    String vehicleType;
    String driverName;


    public void getValue(ActionEvent actionEvent) {

        ans=cmbvehicleId.getSelectionModel().getSelectedItem().toString();



        //Button Disable statements-------------------------------------------------

        for(int i =0 ; i<ParkingFormController.parkingList.size() ; i++){
            if(ans.equals(ParkingFormController.parkingList.get(i).getParkVehicleNumber())){
                btnParkVehicle.setVisible(false);
                btnDiliveryShift.setVisible(true);
                break;
            }else{
                for(int j =0 ; j<DiliveryFormController.diliveryVehicles.size() ; j++){
                    if(ans.equals(DiliveryFormController.diliveryVehicles.get(j).getVehicleNumber())){
                        btnParkVehicle.setVisible(true);
                        btnDiliveryShift.setVisible(false);
                        break;
                    }else{
                        btnParkVehicle.setVisible(true);
                        btnDiliveryShift.setVisible(false);
                        break;
                    }
                }
            }
        }


        //vehicle type selection----------------------------------------------------------------------------

        for(int i=0;i<vehicle.length;i++){
            if(ans.equals(vehicle[i].getVehicleNumber())){
                txtVehicleType.setText(vehicle[i].getVehicleType());
                vehicleType=vehicle[i].getVehicleType();

            }else{
                continue;
            }
        }

        //slot selection---------------------------------------------------------
        slot =Controller.getslot(ans);
        if(slot==0){
            lblParkingSlot.setText("On Parking");
        }else if(slot==(-3)){
            lblParkingSlot.setText("Parking is full..");
        }else{
            lblParkingSlot.setText(String.valueOf(slot));
        }
    }


    String[] driverNameList = new String[16];
    int nextIndex=0;
    public void setVehicleOnDelivery(ActionEvent actionEvent) {    //set on Delivery
        //driverNameList[nextIndex++]=ans;
        if(cmbDriver.getSelectionModel().isEmpty()){
            new Alert(Alert.AlertType.WARNING,"Driver has not selected..",ButtonType.CLOSE).show();
        }else {
            for(int i=0; i<driverNameList.length ;i++){

                if(driverName.equals(driverNameList[i])){
                    new Alert(Alert.AlertType.WARNING,"This driver has already out..",ButtonType.CLOSE).show();
                    break;
                }else {
                   DiliveryFormController.deliveryVehicle(ans,vehicleType,driverName,time);
                   ParkingFormController.deletePark(ans,vehicleType,String.valueOf(slot),time);
                    Controller.deliver(ans);
                    lblParkingSlot.setText("Deliverd");
                    driverNameList[nextIndex++]=driverName;
                    break;
                }

            }
        }
    }



    public void setVehiclePark(ActionEvent actionEvent) {   // set on park
       ParkingFormController.parking(ans,vehicleType,String.valueOf(slot),time);
      DiliveryFormController.deleteVehicle(ans,vehicleType,driverName,time);
       Controller.park(ans,slot);
       lblParkingSlot.setText("Parked");
    }

    public void setDriver(ActionEvent actionEvent) { // get the driver name
         driverName = cmbDriver.getSelectionModel().getSelectedItem().toString();
    }

    public void goToLoginForm(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/loginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        load.getStylesheets().add("/Styles/StyleSheet.css");
        Stage window = (Stage) dashboardContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }


}