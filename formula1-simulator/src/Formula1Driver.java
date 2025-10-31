//Child class Formula1Driver which extends Abstract class Driver.
//Includes the statistics of a Formula1 Driver.
public class Formula1Driver extends Driver {
    private Integer numberOfFirstPositions;
    private Integer numberOfSecondPositions;
    private Integer numberOfThirdPositions;
    private Integer numberOfPointsADriverHas;
    private Integer numberOfRacesParticipatedIn;

    //Parameterized constructor for the class Formula1Driver
    public Formula1Driver(String firstNameOfTheDriver, String secondNameOfTheDriver, String locationOfTheDriver, String theTeamOfTheDriver, int firstPlace, int secondPlace, int thirdPlace, int points, int races) {
        super(firstNameOfTheDriver, secondNameOfTheDriver, locationOfTheDriver, theTeamOfTheDriver);
        numberOfFirstPositions = firstPlace;
        numberOfSecondPositions = secondPlace;
        numberOfThirdPositions = thirdPlace;
        numberOfPointsADriverHas = points;
        numberOfRacesParticipatedIn = races;
    }


    //Getters for the private variables
    public Integer getNumberOfFirstPositions() {
        return numberOfFirstPositions;
    }

    public Integer getNumberOfSecondPositions() {
        return numberOfSecondPositions;
    }

    public Integer getNumberOfThirdPositions() {
        return numberOfThirdPositions;
    }

    public Integer getNumberOfPointsADriverHas() {
        return numberOfPointsADriverHas;
    }

    public Integer getNumberOfRacesParticipatedIn() {
        return numberOfRacesParticipatedIn;
    }


    //Setters for the private variables
    public void setNumberOfFirstPositions(Integer numberOfFirstPositions) {
        this.numberOfFirstPositions = numberOfFirstPositions;
    }

    public void setNumberOfSecondPositions(Integer numberOfSecondPositions) {
        this.numberOfSecondPositions = numberOfSecondPositions;
    }

    public void setNumberOfThirdPositions(Integer numberOfThirdPositions) {
        this.numberOfThirdPositions = numberOfThirdPositions;
    }

    public void setNumberOfPointsADriverHas(Integer numberOfPointsADriverHas) {
        this.numberOfPointsADriverHas = numberOfPointsADriverHas;
    }

    public void setNumberOfRacesParticipatedIn(Integer numberOfRacesParticipatedIn) {
        this.numberOfRacesParticipatedIn = numberOfRacesParticipatedIn;
    }
}