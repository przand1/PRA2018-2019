package quartz.scheduler;

public class Human implements Comparable<Human> {

    private long pesel;
    private String city;
    private String firstName;
    private String surName;

    public long getPesel() {
        return pesel;
    }

    public String getCity() {
        return city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Human(long pesel, String city, String firstName, String surName) {
        this.pesel = pesel;
        this.city = city;
        this.firstName = firstName;
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "Human{" +
                "pesel=" + pesel +
                ", city='" + city + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Human other) {
        return this.getCity().compareTo(other.getCity());
    }



}
