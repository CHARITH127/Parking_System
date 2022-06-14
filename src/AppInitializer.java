import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        Controller newController= new Controller();
        newController.addVehicle(new Van("KA-4563","Van",1000,7));
        newController.addVehicle(new Van("58-3567","Van",1500,4));
        newController.addVehicle(new Van("GF-4358","Van",800,4));
        newController.addVehicle(new Van("CCB-3568","Van",1800,8));
        newController.addVehicle(new lorry("KB-3668","Cargo Lorry",2500,2));
        newController.addVehicle(new lorry("JJ-9878","Cargo Lorry",3000,2));
        newController.addVehicle(new lorry("GH-5772","Cargo Lorry",4000,3));
        newController.addVehicle(new lorry("XY-4456","Cargo Lorry",3500,2));
        newController.addVehicle(new lorry("YQ-3536","Cargo Lorry",2000,2));
        newController.addVehicle(new lorry("CBB-3566","Cargo Lorry",2500,2));
        newController.addVehicle(new lorry("QH-3444","Cargo Lorry",5000,4));
        newController.addVehicle(new Van("LM-6679","Van",1500,4));
        newController.addVehicle(new Van("QA-4358","Van",1800,6));
        newController.addVehicle(new Bus("NA-3434","Bus",3500,60));

        newController.addDrivers(new Driver("Sumith Kumara","7835348345v","B6474845","Pandura","0725637456"));
        newController.addDrivers(new Driver("Amila Pathirathna","882625373v","B3354674","Galle","0717573583"));
        newController.addDrivers(new Driver("Jithmal Perera","9283289272v","B3674589","Horana","0772452457"));
        newController.addDrivers(new Driver("Sumith Dissanayaka","9425245373","B8366399 ","Kaluthara","0782686390"));
        newController.addDrivers(new Driver("Sumanasiri Herath", "8976544373V", "B3537538", "Beruwala" ,"0772534436"));
        newController.addDrivers(new Driver("Awantha Fernando", "9173537839V" ,"B3554789" ,"Colombo" ,"0714534356"));
        newController.addDrivers(new Driver("Charith Sudara" ,"9573536833V", "B6835836", "Baththaramulla" ,"0771536662"));
        newController.addDrivers(new Driver("Prashan Dineth", "9362426738V" ,"B2683536" ,"Wadduwa","0715353434"));
        newController.addDrivers(new Driver("Chethiya Dilan" ,"9162353436V" ,"B6836836" ,"Panadura" ,"0772436737"));
        newController.addDrivers(new Driver("Dushantha Perera" ,"9255556343V", "B3334435" ,"Matara" ,"0777245343"));
        newController.addDrivers(new Driver("Sumith Udayanga" ,"8735354355V", "B3573783" ,"Galle" ,"0703635442"));
        newController.addDrivers(new Driver("Dinesh Udara" ,"9026344373V" ,"B5343783" ,"Hettimulla" ,"0713456878"));
        newController.addDrivers(new Driver("Udana Chathuranga" ,"9692653338V", "B7888632", "Kottawa", "0772442444"));
        newController.addDrivers(new Driver("Mohommad Riaz", "9124537733V" ,"B3638537" ,"Kaluthara" ,"0777544222"));
        newController.addDrivers(new Driver("Sandun Kumara" ,"9563524267V" ,"B2263333" ,"Panadura" ,"0772325544"));
        newController.addDrivers(new Driver("Priyanga Perera" ,"9135343537V" ,"B3853753", "Matara", "0723344562"));

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL resource = getClass().getResource("view/DashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        load.getStylesheets().add("/Styles/StyleSheet.css");
        primaryStage.setTitle("Parking System");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(event ->{
            System.exit(0);
        });
    }


}
