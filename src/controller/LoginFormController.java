package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    public AnchorPane loginFormContext;
    public JFXButton btnCacel;

    public void goToManagemnt(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ManagementForm.fxml");
        Parent load = FXMLLoader.load(resource);
        load.getStylesheets().add("/Styles/StyleSheet.css");
        Stage window = (Stage) loginFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
