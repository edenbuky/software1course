package starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends Fighter{
    private int numberOfTechnicians;
    private final int basicAnnualMaintenanceCost = 5000;

    public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
        super(name,commissionYear,maximalSpeed,crewMembers,weapons);
        this.numberOfTechnicians = numberOfTechnicians;
        super.className = "Bomber";
    }

    public int getNumberOfTechnicians() {
        return numberOfTechnicians;
    }

    @Override
    public int getAnnualMaintenanceCost() {
        double discount = 1 - (0.1 * numberOfTechnicians);
        return (int)((basicAnnualMaintenanceCost + super.weaponsAnnualMaintenanceCost)* discount);
    }
    @Override
    public String toString() {
        return super.toString() + '\n'
                + "\tNumberOfTechnicians=" + numberOfTechnicians;
    }
}
