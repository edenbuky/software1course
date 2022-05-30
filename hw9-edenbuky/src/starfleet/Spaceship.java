package starfleet;

import java.util.Set;

public interface Spaceship extends Comparable<Spaceship>{

    public String getName();
    public int getCommissionYear();
    public float getMaximalSpeed();
    public int getFirePower();
    public Set<? extends CrewMember> getCrewMembers();
    public int getAnnualMaintenanceCost();


}