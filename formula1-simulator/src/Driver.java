// --- REFERENCES ---
// 01. https://www.javatpoint.com/serialization-in-java
// 02. https://www.tutorialspoint.com/java/java_serialization.htm

import java.io.Serializable;

//Abstract class Driver which includes the details (Name, Location and Team) of the driver.
public abstract class Driver implements Serializable { //... 01 & 02 Reference used here...
    private String firstNameOfTheDriver;
    private String secondNameOfTheDriver;
    private String locationOfTheDriver;
    private String theTeamOfTheDriver;


    //Parameterized constructor for the Driver class
     Driver(String firstNameOfTheDriver, String secondNameOfTheDriver, String locationOfTheDriver, String theTeamOfTheDriver) {
        this.firstNameOfTheDriver = firstNameOfTheDriver;
        this.secondNameOfTheDriver = secondNameOfTheDriver;
        this.locationOfTheDriver = locationOfTheDriver;
        this.theTeamOfTheDriver = theTeamOfTheDriver;
    }

    //Getters for the private variables
    public String getFirstNameOfTheDriver() {
        return firstNameOfTheDriver;
    }

    public String getSecondNameOfTheDriver() {
        return secondNameOfTheDriver;
    }

    public String getTheTeamOfTheDriver() {
        return theTeamOfTheDriver;
    }

    public String getLocationOfTheDriver() {
        return locationOfTheDriver;
    }

    //Setters for the private variables
    public void setFirstNameOfTheDriver(String firstNameOfTheDriver) {
        this.firstNameOfTheDriver = firstNameOfTheDriver;
    }

    public void setSecondNameOfTheDriver(String secondNameOfTheDriver) {
        this.secondNameOfTheDriver = secondNameOfTheDriver;
    }

    public void setTheTeamOfTheDriver(String theTeamOfTheDriver) {
        this.theTeamOfTheDriver = theTeamOfTheDriver;
    }

    public void setLocationOfTheDriver(String locationOfTheDriver) {
        this.locationOfTheDriver = locationOfTheDriver;
    }
}