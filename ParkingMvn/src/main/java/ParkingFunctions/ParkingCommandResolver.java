package ParkingFunctions;

import Enums.ParkingCommands;
import Entity.Vehicle;
import Exceptions.InvalidCommandException;
import Exceptions.InvalidLotSizeException;
import Exceptions.InvalidSlotException;
import Exceptions.ParkingFullException;
import Validation.CommandValidation;

public class ParkingCommandResolver {
  ParkingFunction parking = new ParkingFunctionImpl();

  public void execute(String input) throws InvalidSlotException, InvalidCommandException, InvalidLotSizeException, ParkingFullException {

    String[] inputs = input.split(" ");
    String key = inputs[0];
    CommandValidation commandValidation = new CommandValidation();

    if(!commandValidation.validateInputCommand(inputs))
    {
      throw new InvalidCommandException("Command given is invalid");
    }

    ParkingCommands command = commandValidation.getCommandConstant(key);

    switch (command) {
      case CREATE_PARKING:
        int capacity = Integer.parseInt(inputs[1]);
        parking.createParking(capacity);
        break;

      case PARK:
        Vehicle vehicle = new Vehicle(inputs[1], Integer.valueOf(inputs[3]));
        parking.parkVehicle(vehicle);
        break;

      case VACATE:
        int slotNumber = Integer.parseInt(inputs[1]);
        parking.vacateParking(slotNumber);
        break;

      case VEHICLE_NUMBER_FOR_DRIVER:
        int driverAge = Integer.parseInt(inputs[1]);
        parking.getVehicleNumberList(driverAge);
        break;

      case SLOT_NUMBERS_FOR_DRIVER:
        int driverAgeForSlots = Integer.parseInt(inputs[1]);
        parking.getVehicleParkingSlotNumbers(driverAgeForSlots);
        break;

      case SLOT_NUMBERS_FOR_VEHICLE_NUMBER:
        String vehicleNumber = inputs[1];
        parking.getParkingSlotNumber(vehicleNumber);

        break;

      default:
        break;
    }
  }
}
