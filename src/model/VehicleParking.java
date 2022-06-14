package model;

public class VehicleParking {
     private String parkVehicleNumber;
     private String parksVehicleType;
     private String parkingSlot;
     private String timeDate;

    public VehicleParking(String parkVehicleNumber, String parksVehicleType, String parkingSlot, String timeDate) {
        this.parkVehicleNumber = parkVehicleNumber;
        this.parksVehicleType = parksVehicleType;
        this.parkingSlot = parkingSlot;
        this.timeDate = timeDate;
    }

    public String getParkVehicleNumber() {
        return parkVehicleNumber;
    }

    public void setParkVehicleNumber(String parkVehicleNumber) {
        this.parkVehicleNumber = parkVehicleNumber;
    }

    public String getParksVehicleType() {
        return parksVehicleType;
    }

    public void setParksVehicleType(String parksVehicleType) {
        this.parksVehicleType = parksVehicleType;
    }

    public String getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(String parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }
}
