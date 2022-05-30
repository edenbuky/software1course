package starfleet;

import java.util.*;

public class StarfleetManager {

    /**
     * Returns a list containing string representation of all fleet ships, sorted in descending order by
     * fire power, and then in descending order by commission year, and finally in ascending order by
     * name
     */
    //private static
    public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
        List<Spaceship> sortedFleet = new ArrayList<Spaceship>(fleet);
        Collections.sort(sortedFleet,new MySpaceshipComparator());
        List<String> output = new ArrayList<>();
        for ( Spaceship ship : sortedFleet){
            output.add(ship.toString());
        }
        return output;
    }

    /**
     * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
     */
    public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
        Iterator<Spaceship> it = fleet.iterator();
        Map<String,Integer> output = new TreeMap<>();
        while(it.hasNext()){
            Spaceship ship = it.next();
            String shipClass = ship.getClass().getSimpleName();
            if (output.containsKey(shipClass)){
                int val = output.get(shipClass) + 1;
                output.put(shipClass,val);
            }
            else {output.put(shipClass,1);}
        }
        return output;

    }


    /**
     * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
     */
    public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
        List<Spaceship> listFleet = new ArrayList<Spaceship>(fleet);
        int output = 0;
        for (Spaceship ship : listFleet){
            output += ship.getAnnualMaintenanceCost();
        }
        return output;

    }


    /**
     * Returns a set containing the names of all the fleet's weapons installed on any ship
     */
    public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
        Set<String> output = new HashSet<>();
        for (Spaceship ship : fleet){
            if (ship instanceof Fighter){
                List<Weapon> shipWeapons =((Fighter) ship).getWeapons();
                for (Weapon weapon : shipWeapons){
                    output.add(weapon.getName());
                }
            }
        }
        return output;

    }

    /*
     * Returns the total number of crew-members serving on board of the given fleet's ships.
     */
    public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
        int output = 0;
        for(Spaceship ship : fleet){
            output = ship.getCrewMembers().size();
        }
        return output;

    }

    /*
     * Returns the average age of all officers serving on board of the given fleet's ships.
     */
    public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
        float output= 0 , count = 0;
        for (Spaceship spaceship :fleet){
            Set<? extends CrewMember> team = spaceship.getCrewMembers();
            for (CrewMember member : team){
                if (member instanceof Officer){
                    output += member.getAge();
                    count++;
                }
            }
        }
        return output/count;
    }

    /*
     * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
     */

    public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
        Officer highestOfficer = null;
        Map<Officer,Spaceship> output = new HashMap<>();
        for (Spaceship spaceship :fleet) {
            Set<? extends CrewMember> team = spaceship.getCrewMembers();
            for (CrewMember member : team) {
                if (member instanceof Officer) {
                    if (highestOfficer == null || ((Officer) member).getRank().compareTo(highestOfficer.getRank()) > 0) {
                        highestOfficer = (Officer)member;
                    }
                }
            }
            if (highestOfficer != null){
                output.put(highestOfficer,spaceship);
            }
            highestOfficer = null;
        }
        return output;
    }

    /*
     * Returns a List of entries representing ranks and their occurrences.
     * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
     * The returned list is sorted ascendingly based on the number of occurrences.
     */
    public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
        Map<OfficerRank,Integer> officersRankMap = new HashMap<>();
        for (Spaceship spaceship :fleet) {
            Set<? extends CrewMember> team = spaceship.getCrewMembers();
            for (CrewMember member : team) {
                if (member instanceof Officer) {
                    OfficerRank rank = ((Officer) member).getRank();
                    if (officersRankMap.containsKey(rank)){
                        int val = officersRankMap.get(rank) + 1;
                        officersRankMap.put(rank,val);
                    }
                    else { officersRankMap.put(rank,1);}
                }
            }
        }
        List<Map.Entry<OfficerRank,Integer>> output = new ArrayList<>();
        for (Map.Entry<OfficerRank, Integer> entry : officersRankMap.entrySet()) {
            output.add(entry);
        }
        Collections.sort(output,Map.Entry.comparingByValue());
        return output;
    }

}
