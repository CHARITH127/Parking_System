package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ManagementFormController {

    public AnchorPane managementContext;
    public AnchorPane boarderContext;

    public void InparkingWindow(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ParkingForm.fxml");
        Parent load = FXMLLoader.load(resource);
        boarderContext.getChildren().clear();
        boarderContext.getChildren().add(load);

    }

    public void GotToOnDeliverINterface(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DiliveryForm.fxml");
        Parent load = FXMLLoader.load(resource);
        boarderContext.getChildren().clear();
        boarderContext.getChildren().add(load);
    }

    public void gotoAddVehicle(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        boarderContext.getChildren().clear();
        boarderContext.getChildren().add(load);
    }

    public void gotoAddDriver(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriverForm.fxml");
        Parent load = FXMLLoader.load(resource);
        boarderContext.getChildren().clear();
        boarderContext.getChildren().add(load);
    }

    public void logOut(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING,"Are you sure to logOut...", ButtonType.YES,ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult()==ButtonType.YES){
            URL resource = getClass().getResource("../view/DashboardForm.fxml");
            Parent load = FXMLLoader.load(resource);
            load.getStylesheets().add("/Styles/StyleSheet.css");
            Stage window =(Stage) boarderContext.getScene().getWindow();
            window.setScene(new Scene(load));
        }

    }

}
