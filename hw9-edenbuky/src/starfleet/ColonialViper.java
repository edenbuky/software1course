package starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter {

    private final int basicAnnualMaintenanceCost = 4000;

    public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
                         List<Weapon> weapons) {
        super(name,commissionYear,maximalSpeed,crewMembers,weapons);
        super.className = "ColonialViper";
    }
    @Override
    public int getAnnualMaintenanceCost() {
        return basicAnnualMaintenanceCost + super.weaponsAnnualMaintenanceCost + ((int)(500 * getMaximalSpeed()))
                + (500 * super.getCrewMembers().size());
    }

}
