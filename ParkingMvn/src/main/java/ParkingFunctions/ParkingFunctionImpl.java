package ParkingFunctions;

import Entity.ParkingSlot;
import Entity.Vehicle;
import Exceptions.InvalidLotSizeException;
import Exceptions.InvalidSlotException;
import Exceptions.ParkingFullException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public class ParkingFunctionImpl implements ParkingFunction{

  private List<ParkingSlot> parkingSlots= new ArrayList<>();

  @Override
  public void createParking(int slotSize) throws InvalidLotSizeException {
    if (slotSize <= 0 || slotSize > 1000) {
        throw new InvalidLotSizeException("Invalid ParkingFunction Lot size");
    }

    for (int i = 1; i <= slotSize; i++) {
      parkingSlots.add(new ParkingSlot(i, UUID.randomUUID().toString()));
    }

    System.out.println("Created parking of " + slotSize + " slots");
  }

  @Override
  public void parkVehicle(Vehicle vehicle) throws ParkingFullException {

    ParkingSlot nextSlot = getEmptySlot();

    nextSlot.parkVehicle(vehicle);

    System.out.println(
        "Car with vehicle registration number "
            + vehicle.getVehicleNumber()
            + " has been parked at slot number "
            + nextSlot.getSlotNumber());
  }

  /**
   * To get all the parking slot numbers which match the drivers age
   * @param driverAge
   */

  @Override
  public void getVehicleParkingSlotNumbers(int driverAge) {
    List<Integer> slotList =
        parkingSlots.stream()
            .filter(
                c ->
                    c.getParkedVehicle() != null
                        && c.getParkedVehicle().getDriverAge() == driverAge)
            .map(ParkingSlot::getSlotNumber)
            .collect(Collectors.toList());
    if (slotList.isEmpty()) {
      System.out.println("No parked car matched the query");
      return;
    }

    for (Integer i : slotList) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  /**
   *
   * To get parking slot number matching the vehicle number
   * @param vehicleNumber
   */

  @Override
  public void getParkingSlotNumber(String vehicleNumber) {
    List<Integer> slotList =
        parkingSlots.stream()
            .filter(
                c ->
                    c.getParkedVehicle() != null
                        && c.getParkedVehicle().getVehicleNumber().equals(vehicleNumber))
            .map(ParkingSlot::getSlotNumber)
            .collect(Collectors.toList());
    if (slotList.isEmpty()) {
      System.out.println("No parked car matched the query");
      return;
    }
    System.out.println(slotList.get(0));
  }

  /**
   * Get list of vehicle number matching the criteria for driver's age
   * @param driverAge
   */

  @Override
  public void getVehicleNumberList(int driverAge) {
    List<String> vehicleList =
        parkingSlots.stream()
            .filter(
                c ->
                    c.getParkedVehicle() != null
                        && c.getParkedVehicle().getDriverAge() == driverAge)
            .map(ParkingSlot::getParkedVehicle)
            .map(Vehicle::getVehicleNumber)
            .collect(Collectors.toList());
    if (vehicleList.isEmpty()) {
      System.out.println("No parked car matched the query");
      return;
    }

    for (String s : vehicleList) {
      System.out.print(s + " ");
    }
    System.out.println();
  }

  /**
   * Assumptions for this that slot number should be between 0-1000 exclusive of both
   * @param slotNumber
   * @throws InvalidSlotException
   */
  @Override
  public void vacateParking(int slotNumber) throws InvalidSlotException {
    if (slotNumber <= 0 || slotNumber > 1000) {
      throw new InvalidSlotException("Invalid Slot number");
    }

    ParkingSlot slot = parkingSlots.get(slotNumber - 1);

    if (slot != null) {
      String vehicleNumber = slot.getParkedVehicle().getVehicleNumber();
      int age = slot.getParkedVehicle().getDriverAge();

      slot.vacateLot();
      System.out.println(
          "Slot number "
              + slotNumber
              + " vacated, the car with vehicle registration number "
              + vehicleNumber
              + " left the space ,the driver of the car was of age: "
              + age);

    } else {
      throw new InvalidSlotException("Invalid Slot number");
    }
  }


  /**
   * Check the empty slot nearest to entry point
   * @return
   * @throws ParkingFullException
   */

  private ParkingSlot getEmptySlot() throws ParkingFullException {
    for (ParkingSlot slot : parkingSlots) {
      if (!slot.isSlotEmpty()) {
        return slot;
      }
    }
    throw new ParkingFullException("ParkingFunction is already Full");
  }
}
