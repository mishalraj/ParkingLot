# ParkingLot


Prerequisite:

JDK 15

junit 4.12

Maven 3.1.0



How to run :

1. Clone the repo
2. navigate to the cloned folder 
3. navigate to ParkingMvn
4. locate .jar file inside ParkingMvn -> target -> ParkingMvn-1.0-SNAPSHOT.jar
5. locate test input file (i have attached a sample file inside  ParkingMvn -> target -> classes -> inputfile.txt ) other files can also be used
6. mvn install
7. java -jar {path to jar file}  {path to text file}



Currently implemented Functions for parking lot are :

public void createParking(int slotSize) throws InvalidLotSizeException;

public void parkVehicle(Vehicle vehicle) throws ParkingFullException;

public void getVehicleParkingSlotNumbers(int age);

public void getParkingSlotNumber(String vehicleNumber);

public void getVehicleNumberList(int age);

public void vacateParking(int slotNumber) throws InvalidSlotException;







