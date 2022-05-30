package starfleet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter {
    private int shipCounter = 0;
    static List<Weapon> weapons = new ArrayList<>();;

    public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
        super(name,commissionYear,maximalSpeed,crewMembers,weapons);
        shipCounter++;
        super.className = "StealthCruiser";
    }

    public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
        this(name,commissionYear,maximalSpeed,crewMembers,weapons);
        //weapons = new ArrayList<>();
        weapons.add(new Weapon("Laser Cannons", 10, 100));
    }

    @Override
    public int getAnnualMaintenanceCost() {
        return super.getAnnualMaintenanceCost() + (50 * shipCounter);
    }

}
