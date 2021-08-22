package Entity;

public class ParkingSlot {
    private int slotNumber;
    private String slotId;
    private boolean isSlotEmpty;
    private Vehicle parkedVehicle;

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public ParkingSlot(int slotNumber, String slotId) {
        this.slotNumber = slotNumber;
        this.slotId = slotId;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isSlotEmpty() {
        return isSlotEmpty;
    }

    public void setSlotEmpty(boolean slotEmpty) {
        isSlotEmpty = slotEmpty;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public void vacateLot() {
        parkedVehicle = null;
        this.isSlotEmpty = false;
        return;
    }

    public void parkVehicle(Vehicle parkVehicle) {
        this.parkedVehicle = parkVehicle;
        this.isSlotEmpty = true;
    }
}
