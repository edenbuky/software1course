package starfleet;
import java.util.Objects;
import java.util.Set;

public abstract class MySpaceship implements Spaceship{
    private String name;
    private int commissionYear;
    private float maximalSpeed;
    //private final int firePower = 10;
    private Set<? extends CrewMember> crewMembers;

    public MySpaceship (String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers){
        this.name = name;
        this.commissionYear = commissionYear;
        this.maximalSpeed = maximalSpeed;
        this.crewMembers = crewMembers;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCommissionYear() {
        return commissionYear;
    }

    @Override
    public float getMaximalSpeed() {
        return maximalSpeed;
    }

    @Override
    public int getFirePower() {
        return 10;
    }

    @Override
    public Set<? extends CrewMember> getCrewMembers() {
        return crewMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MySpaceship)) return false;
        MySpaceship that = (MySpaceship) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
    @Override
    public int compareTo(Spaceship o) {
        MySpaceshipComparator comp = new MySpaceshipComparator();
        return comp.compare(this,o);
    }

    public String toString() {
        return  "\tName=" + getName() + '\n' +
                "\tCommissionYear=" + getCommissionYear() + '\n' +
                "\tMaximalSpeed=" + getMaximalSpeed() + '\n' +
                "\tFirePower=" + getFirePower() + '\n' +
                "\tCrewMembers=" + getCrewMembers().size();
    }
}
