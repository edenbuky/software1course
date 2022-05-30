package starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter{
    private final int basicAnnualMaintenanceCost = 3500;

    public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
                       List<Weapon> weapons) {
        super(name,commissionYear,maximalSpeed,crewMembers,weapons);
        super.className = "CylonRaider";
    }
    @Override
    public int getAnnualMaintenanceCost() {
        return basicAnnualMaintenanceCost + super.weaponsAnnualMaintenanceCost + ((int)(1200 * getMaximalSpeed()))
                + (500 * super.getCrewMembers().size());
    }


}
