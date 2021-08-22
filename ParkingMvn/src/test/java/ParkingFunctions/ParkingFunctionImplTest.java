package ParkingFunctions;

import Entity.Vehicle;
import Exceptions.InvalidLotSizeException;
import Exceptions.InvalidSlotException;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ParkingFunctionImplTest extends TestCase {

    private final ByteArrayOutputStream outContent	= new ByteArrayOutputStream();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void testCreateParking() throws InvalidLotSizeException {
        ParkingFunction parkingFunction = new ParkingFunctionImpl();
        parkingFunction.createParking(6);
        assertTrue("createdparkingof6slots".equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));
        System.setOut(null);
    }


    @Test
    public void testFailedCreateParking() throws Exception {
        ParkingFunction parkingFunction = new ParkingFunctionImpl();
        parkingFunction.createParking(0);
         exceptionRule.expect(InvalidLotSizeException.class);
         exceptionRule.expectMessage("Invalid ParkingFunction Lot size");
         System.setOut(null);
    }


    @Test
    public void testParkVehicle() throws InvalidLotSizeException {
        ParkingFunction parkingFunction = new ParkingFunctionImpl();
        parkingFunction.createParking(6);
        parkingFunction.parkVehicle(new Vehicle("KA-01-HH-1234", 21));
        String[]outputs = outContent.toString().split("\\R");
        assertEquals("Car with vehicle registration number KA-01-HH-1234 has been parked at slot number 1",outputs[1].trim());
        System.setOut(null);
    }

    @Test
    public void testParkMultipleVehicle() throws InvalidLotSizeException {
        ParkingFunction parkingFunction = new ParkingFunctionImpl();
        parkingFunction.createParking(6);
        parkingFunction.parkVehicle(new Vehicle("KA-01-HH-1234", 21));
        parkingFunction.parkVehicle(new Vehicle("KA-01-HH-1235", 20));
        parkingFunction.parkVehicle(new Vehicle("KA-01-HH-1236", 23));
        parkingFunction.parkVehicle(new Vehicle("MH-01-HH-1237", 21));
        String[]outputs = outContent.toString().split("\\R");
        assertEquals("Car with vehicle registration number MH-01-HH-1237 has been parked at slot number 4",outputs[4].trim());
        System.setOut(null);
    }

    @Test
    public void testGetVehicleParkingSlotNumbers() throws InvalidLotSizeException {
        ParkingFunction parkingFunction = new ParkingFunctionImpl();
        parkingFunction.createParking(6);
        parkingFunction.parkVehicle(new Vehicle("KA-01-HH-1234", 21));
        parkingFunction.getVehicleParkingSlotNumbers(21);
        String[]outputs = outContent.toString().split("\\R");
        assertEquals("1", (outputs[2]).trim());
        System.setOut(null);
    }

    @Test
    public void testGetVehicleParkingSlotNumbersFailed() throws InvalidLotSizeException {
        ParkingFunction parkingFunction = new ParkingFunctionImpl();
        parkingFunction.createParking(6);
        parkingFunction.parkVehicle(new Vehicle("KA-01-HH-1234", 21));
        parkingFunction.getVehicleParkingSlotNumbers(22);
        String[]outputs = outContent.toString().split("\\R");
        assertEquals("No parked car matched the query", (outputs[2]).trim());
        System.setOut(null);
    }

    @Test
    public void testGetParkingSlotNumber() throws InvalidLotSizeException {
        ParkingFunction parkingFunction = new ParkingFunctionImpl();
        parkingFunction.createParking(6);
        parkingFunction.parkVehicle(new Vehicle("KA-01-HH-1234", 21));
        parkingFunction.getParkingSlotNumber("KA-01-HH-1234");
        String[]outputs = outContent.toString().split("\\R");
        assertEquals("1",(outputs[2]).trim());
        System.setOut(null);
    }

    @Test
    public void testGetParkingSlotNumberFailed() throws InvalidLotSizeException {
        ParkingFunction parkingFunction = new ParkingFunctionImpl();
        parkingFunction.createParking(6);
        parkingFunction.parkVehicle(new Vehicle("KA-01-HH-1234", 21));
        parkingFunction.getParkingSlotNumber("KA-01-HH-1235");
        String[]outputs = outContent.toString().split("\\R");
        assertEquals("No parked car matched the query",(outputs[2]).trim());
        System.setOut(null);
    }

    @Test
    public void testGetVehicleNumberList() throws InvalidLotSizeException  {
        ParkingFunction parkingFunction = new ParkingFunctionImpl();
        parkingFunction.createParking(6);
        parkingFunction.parkVehicle(new Vehicle("KA-01-HH-1234", 21));
        parkingFunction.getVehicleNumberList(21);
        String[]outputs = outContent.toString().split("\\R");
        assertEquals("KA-01-HH-1234", (outputs[2]).trim());
        System.setOut(null);
    }

    @Test
    public void testVacateParking() throws InvalidLotSizeException, InvalidSlotException {
        ParkingFunction parkingFunction = new ParkingFunctionImpl();
        parkingFunction.createParking(6);
        parkingFunction.parkVehicle(new Vehicle("KA-01-HH-1234", 21));
        parkingFunction.vacateParking(1);
        String[]outputs = outContent.toString().split("\\R");
        assertEquals("Slot number 1 vacated, the car with vehicle registration number KA-01-HH-1234 left the space ,the driver of the car was of age: 21",(outputs[2]).trim());
        System.setOut(null);
    }
}