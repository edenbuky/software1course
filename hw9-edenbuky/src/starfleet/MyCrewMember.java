package starfleet;

import java.util.Objects;

public abstract class MyCrewMember implements CrewMember {

    private String name;
    private int age;
    private int yearsInService;

    public MyCrewMember(int age, int yearsInService, String name){
        this.name = name;
        this.age = age;
        this.yearsInService = yearsInService;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getYearsInService() {
        return yearsInService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyCrewMember)) return false;
        MyCrewMember that = (MyCrewMember) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "MyCrewMember\n" +
                "\tname='" + name + '\n' +
                "\tage=" + age + '\n' +
                "\tyearsInService=" + yearsInService;
    }
}