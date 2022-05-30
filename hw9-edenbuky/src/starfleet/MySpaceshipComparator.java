package starfleet;

import java.util.Comparator;

public class MySpaceshipComparator implements Comparator<Spaceship> {

    public int compare(Spaceship o1, Spaceship o2) {
        int firePower = Integer.compare(o2.getFirePower(),o1.getFirePower());
        if (firePower != 0){
            return firePower;
        }
        int commissionYear = Integer.compare(o2.getCommissionYear(),o1.getCommissionYear());
        if (commissionYear != 0){
            return commissionYear;
        }
        int name = o1.getName().compareTo(o2.getName());
        return name;
    }
}
