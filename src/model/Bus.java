package model;

public class Bus implements Vehicle {

    private  String availablity;
    private String vehicleNumber;
    private String vehicleType;
    private int maximumWeight;
    private int numOfPassengers;

    public Bus(String vehicleNumber, String vehicleType, int maximumWeight, int numOfPassengers) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.maximumWeight = maximumWeight;
        this.numOfPassengers = numOfPassengers;
        this.availablity="Available";
    }


    @Override
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    @Override
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber=vehicleNumber;
    }

    @Override
    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public void setVehicleType(String vehicleType) {

        this.vehicleType=vehicleType;
    }

    @Override
    public int getMaximumWeight() {
        return maximumWeight;
    }

    @Override
    public void setMaximumWeight(int maximumWeight) {

        this.maximumWeight=maximumWeight;
    }

    @Override
    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    @Override
    public void setNumOfPassengers(int numOfPassengers) {

        this.numOfPassengers=numOfPassengers;
    }

    @Override
    public String getAvailabality() {
        return availablity;
    }

    @Override
    public void settAvailabality(String availabality) {
        this.availablity=availabality;
    }
}
