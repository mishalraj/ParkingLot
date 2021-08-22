package Validation;

import Enums.ParkingCommands;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for validation of each command in the text file
 */


public class CommandValidation {
    /**
     * Assumption that only the commands provided in the sample doc are the commands to be executed
     * HashMap to store the length of each command scenario possible
     * using static block to initialize the map
     */
    private static Map<ParkingCommands, Integer> commandsQuerySize = new HashMap<>();
    static {
        commandsQuerySize.put(ParkingCommands.CREATE_PARKING, 2);
        commandsQuerySize.put(ParkingCommands.PARK, 4);
        commandsQuerySize.put(ParkingCommands.VACATE, 2);
        commandsQuerySize.put(ParkingCommands.SLOT_NUMBERS_FOR_DRIVER, 2);
        commandsQuerySize.put(ParkingCommands.SLOT_NUMBERS_FOR_VEHICLE_NUMBER, 2);
        commandsQuerySize.put(ParkingCommands.VEHICLE_NUMBER_FOR_DRIVER, 2);
    }

  public boolean validateInputCommand(String[] inputLine) {
    if (commandsQuerySize.containsKey(getCommandConstant(inputLine[0]))) {
      if (commandsQuerySize.get(getCommandConstant(inputLine[0])) == inputLine.length) {
        return true;
      }
    }
    return false;
  }

  public ParkingCommands getCommandConstant(String inputCommand) {
    ParkingCommands command = null;
    switch (inputCommand) {
      case "Create_parking_lot":
        command = ParkingCommands.CREATE_PARKING;
        break;

      case "Park":
        command = ParkingCommands.PARK;
        break;

      case "Leave":
        command = ParkingCommands.VACATE;
        break;

      case "Vehicle_registration_number_for_driver_of_age":
        command = ParkingCommands.VEHICLE_NUMBER_FOR_DRIVER;
        break;

      case "Slot_numbers_for_driver_of_age":
        command = ParkingCommands.SLOT_NUMBERS_FOR_DRIVER;
        break;

      case "Slot_number_for_car_with_number":
        command = ParkingCommands.SLOT_NUMBERS_FOR_VEHICLE_NUMBER;
        break;

      default:
        break;
    }
    return command;
  }
}
