package starfleet;

import java.util.Set;

public class TransportShip extends MySpaceship{
    protected String className = "TransportShip";
    private int cargoCapacity;
    private int passengerCapacity;
    private final int basicAnnualMaintenanceCost = 3000;

    public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
        super(name,commissionYear,maximalSpeed,crewMembers);
        this.cargoCapacity = cargoCapacity;
        this.passengerCapacity = passengerCapacity;
    }

    public int getCargoCapacity() { return cargoCapacity; }
    public int getPassengerCapacity(){ return passengerCapacity; }

    @Override
    public int getAnnualMaintenanceCost() {
        return basicAnnualMaintenanceCost + (5 * cargoCapacity) + (3 * passengerCapacity);
    }
    @Override
    public String toString(){
        return className + '\n'
                + super.toString() + '\n'
                + "\tCargoCapacity=" + cargoCapacity + '\n'
                + "\tPassengerCapacity=" + passengerCapacity;
    }


}
