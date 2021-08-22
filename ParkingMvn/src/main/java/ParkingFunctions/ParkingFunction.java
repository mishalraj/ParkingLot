package ParkingFunctions;

import Entity.Vehicle;
import Exceptions.InvalidLotSizeException;
import Exceptions.InvalidSlotException;

import java.util.List;

/**
 * PARKINGFUNCTION used for different functional methods used in parking system.
 *
 * @see ParkingFunctionImpl
 */
public interface ParkingFunction {

  public void createParking(int slotSize) throws InvalidLotSizeException;

  public void parkVehicle(Vehicle vehicle);

  public void getVehicleParkingSlotNumbers(int age);

  public void getParkingSlotNumber(String vehicleNumber);

  public void getVehicleNumberList(int age);

  public void vacateParking(int slotNumber) throws InvalidSlotException;
}
