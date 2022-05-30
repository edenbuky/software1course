package starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends MySpaceship{
    protected String className = "Fighter";
    private List<Weapon> weapons;
    protected int weaponsAnnualMaintenanceCost = -1;
    private int weaponsFirePower = -1;
    private final int basicAnnualMaintenanceCost = 2500;

    public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
        super(name,commissionYear,maximalSpeed,crewMembers);
        this.weapons = weapons;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    private void myCalcWeaponsCostAndPower(){
        weaponsAnnualMaintenanceCost = 0;
        weaponsFirePower = 0;
        for (Weapon weapon : weapons){
            weaponsAnnualMaintenanceCost += weapon.getAnnualMaintenanceCost();
            weaponsFirePower += weapon.getFirePower();
        }
    }

    @Override
    public int getFirePower() {
        if (weaponsFirePower == -1){ myCalcWeaponsCostAndPower();}
        return (super.getFirePower() + weaponsFirePower);
    }

    @Override
    public int getAnnualMaintenanceCost() {
        if (weaponsAnnualMaintenanceCost == -1){ myCalcWeaponsCostAndPower();}
        return basicAnnualMaintenanceCost + weaponsAnnualMaintenanceCost + ((int)(1000 * getMaximalSpeed()));
    }
    @Override
    public String toString() {
        return className + '\n'+
                super.toString() + '\n' +
                "\tAnnualMaintenanceCost=" + getAnnualMaintenanceCost() + '\n' +
                "\tWeaponArray=" + weapons.toString();

    }

}
