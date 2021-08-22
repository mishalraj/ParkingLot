package Entity;

public class Vehicle {
    private String vehicleNumber;
    private int driverAge;

    public Vehicle(String vehicleNumber, int driverAge) {
        this.vehicleNumber = vehicleNumber;
        this.driverAge = driverAge;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(int driverAge) {
        this.driverAge = driverAge;
    }
}
