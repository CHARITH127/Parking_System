package model;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.w3c.dom.ls.LSOutput;
import sun.security.util.ArrayUtil;

import java.util.ArrayList;

public class Controller {

   private static Vehicle[] vehicleList = new Vehicle[14];
   private static Driver[] driverlist = new Driver[16];
   private static int nextIndexVehicle=0;
    private static int nextIndexDrivers=0;

   public static void addVehicle(Vehicle vehicle){
       if(nextIndexVehicle>=14){
           Vehicle[] newVehicleList = new Vehicle[(vehicleList.length+1)];
           for(int i=0;i<vehicleList.length;i++){
               newVehicleList[i]=vehicleList[i];
           }
           newVehicleList[nextIndexVehicle++]=vehicle;
           vehicleList=newVehicleList;
       }else{
           vehicleList[nextIndexVehicle++]=vehicle;
       }

   }

    public static Vehicle[] getVehicleArray() {
        return vehicleList;
    }

    public static void addDrivers(Driver driver){
       if(nextIndexDrivers>=16){
           Driver[] newDriver = new Driver[(driverlist.length+1)];
           for(int i=0; i<driverlist.length;i++){
               newDriver[i]=driverlist[i];
           }
           newDriver[nextIndexDrivers++]=driver;
           driverlist=newDriver;
       }else{
           driverlist[nextIndexDrivers++]=driver;
       }

    }

    public static Driver[] getDriverlist() {
        return driverlist;
    }

    public static int getslot(String index){
       for(int i=0;i<vehicleList.length;i++ ){

           if(vehicleList[i].getVehicleNumber().equals(index)){

               for(int j=0; j<vehicleList.length;j++){
                   if(vehicleList[i].getVehicleType().equals(vehicleList[j].getVehicleType())){
                        if(vehicleList[j].getAvailabality().equals(index)){
                            return 0;
                        }
                   }
               }


               for (int j=0; j<vehicleList.length;j++){

                   if(vehicleList[i].getVehicleType().equals(vehicleList[j].getVehicleType())){
                       if(vehicleList[j].getAvailabality().equals("Available")){
                           return (j+1);
                       }
                   }
               }

           }
       }
       return -3;
    }

    public static void park(String number, int slot){
       vehicleList[slot-1].settAvailabality(number);
        //System.out.println("true");
    }

    public static void deliver(String number){
       for(int i=0;i<14 ;i++){
           if(vehicleList[i].getAvailabality().equals(number)){
               vehicleList[i].settAvailabality("Available");
           }
       }
    }

}