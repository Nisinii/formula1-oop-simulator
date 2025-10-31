// --- REFERENCES ---
// 01. https://stackoverflow.com/questions/29109678/java-print-in-bold
// 02. https://stackoverflow.com/questions/26576909/how-to-format-string-output-so-that-columns-are-evenly-centered/26577308
// 03. https://www.javatpoint.com/serialization-in-java
// 04. https://www.tutorialspoint.com/java/java_serialization.htm
// 05. https://www.w3schools.com/java/java_files_create.asp
// 06. 5COSC019W - OBJECT ORIENTED PROGRAMMING - Lecture 7: Exceptions
// 07. 5COSC019W - OBJECT ORIENTED PROGRAMMING - Lecture 6:  Graphical User Interfaces using Swing
// 08. https://www.tutorialspoint.com/how-to-change-jlabel-font-in-java
// 09. https://examples.javacodegeeks.com/desktop-java/swing/jtextfield/create-jtextfield-with-border/
// 10. https://www.java-examples.com/change-button-foreground-color-example
// 11. https://www.java-examples.com/change-button-background-color-example
// 12. https://www.geeksforgeeks.org/multidimensional-arrays-in-java/
// 13. https://www.javatpoint.com/java-jtable
// 14. https://www.javatpoint.com/how-to-generate-random-number-in-java
// 15. https://stackoverflow.com/questions/1090098/newline-in-jlabel
// 16. https://www.geeksforgeeks.org/java-awt-boxlayout-class/
// 17. https://www.javatpoint.com/java-jscrollpane
// 18. https://www.javatpoint.com/substring

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;


//Child class Formula1ChampionshipManager implements interface ChampionshipManager
public class Formula1ChampionshipManager implements  ChampionshipManager{

    //Array to store details of the drivers of F1 Championship
    Formula1Driver[] driver = new Formula1Driver[12]; //Maximum number of teams a F1 championship can have is 12

    int [] raceDate = new int[50]; //Creating array to store date of a race
    String[] raceMonth = new String[50]; //Creating array to store month of a race
    int[] raceYear = new int[50]; //Creating array to store year of a race
    String[] raceParticipants = new String[50]; //Creating array to store details of participants of a race


    //Initialization of values in the array Formula1Driver
    @Override
    public void InitialiseValues() {
        //Initialising the values of the array driver
        for (int x = 0; x < driver.length; x++) {
            driver[x] = new Formula1Driver("Not Found", "Not Found","Not Found", "Not Found",0, 0, 0, 0,0);
        }

        //Initialising the values of the arrays raceDate, raceMonth, raceYear, raceParticipants
        for(int y = 0; y < raceDate.length; y++){
            raceDate[y] = 0;
            raceMonth[y] = null;
            raceYear[y] = 0;
            raceParticipants[y] = null;
        }
    }

    //Method to add a driver along with his/her details into the Formula 1 Championship
    @Override
    public void AddDriver() {
        Scanner input = new Scanner(System.in);

        int x = 0;

        boolean full = false;

        for(int a = 0; a < driver.length; a++) {
            if (!driver[a].getFirstNameOfTheDriver().equals("Not Found")) {
                full = true;
            }
            else{
                full = false;
            }
        }

        if(full) { //In case 12 teams have already applied to F1 championship
            System.out.println("THE NUMBER OF DRIVERS IN THE FORMULA 1 HAS REACHED TO IT'S MAXIMUM...");
            System.out.println("PLEASE TRY AGAIN LATER...");
        }

        while(x < driver.length){
            if (driver[x].getFirstNameOfTheDriver().equals("Not Found")) {
                System.out.println("PLEASE ENTER THE FOLLOWING DETAILS OF THE PLAYER");

                System.out.print("First Name of the Driver: ");
                String driverFName = input.next();
                driverFName = driverFName.toUpperCase();

                System.out.print("Second Name of the Driver: ");
                String driverSName = input.next();
                driverSName = driverSName.toUpperCase();

                System.out.print("Team of the Driver (Please select a unique Team Name): ");
                String driverTeam = input.next();
                driverTeam = driverTeam.toUpperCase();

                System.out.print("Location of the Driver: ");
                String driverLocation = input.next();
                driverLocation = driverLocation.toUpperCase();

                boolean result = false; //To terminate the for loop from printing the if statements again and again

                for(int i = 0; i < driver.length; i++){
                    if (driver[i].getTheTeamOfTheDriver().equals(driverTeam) && driver[i].getFirstNameOfTheDriver().equals(driverFName)
                            && driver[i].getSecondNameOfTheDriver().equals(driverSName)){ //In case the driver and the team they add are already in the system
                        System.out.println("\nThe Driver and The Team Name you have selected is already in the system. Please select a different a Driver and a Team Name");
                        System.out.print("These are the Team Names Already Taken : ");
                        for (int y = 0; y < 12; y++) {
                            if (driver[y].getTheTeamOfTheDriver().equals("Not Found")){
                                System.out.print("");
                            }
                            else {
                                System.out.print(driver[y].getTheTeamOfTheDriver() + " ");
                            }
                        }
                        result = true;
                    }

                    else if (driver[i].getTheTeamOfTheDriver().equals(driverTeam) && (!driver[i].getFirstNameOfTheDriver().equals(driverFName)
                            || !driver[i].getSecondNameOfTheDriver().equals(driverSName))){ //In case the team they add is already in the system
                        System.out.println("\nThe Team Name you have selected is already taken. Please select a different Team Name");
                        System.out.print("These are the Team Names Already Taken : ");
                        for (int y = 0; y < 12; y++) {
                            if (driver[y].getTheTeamOfTheDriver().equals("Not Found")){
                                System.out.print("");
                            }
                            else {
                                System.out.print(driver[y].getTheTeamOfTheDriver() + " ");
                            }
                        }
                        result = true;
                    }

                    else if ((driver[i].getFirstNameOfTheDriver().equals(driverFName) && driver[i].getSecondNameOfTheDriver().equals(driverSName))
                            && !driver[i].getTheTeamOfTheDriver().equals(driverTeam)){ //In case the driver they add is already a part of another team
                        System.out.println("\nThe Driver you have entered is a part of another Team. Please select a different Driver");
                        result = true;
                    }

                }

                //Adding the details of a driver to the system
                if (!result) {
                    driver[x].setFirstNameOfTheDriver(driverFName);
                    driver[x].setSecondNameOfTheDriver(driverSName);
                    driver[x].setTheTeamOfTheDriver(driverTeam);
                    driver[x].setLocationOfTheDriver(driverLocation);
                    System.out.println("\nYour details have been added to the system.");
                    System.out.println("Statistics of the driver will be automatically 0 until further updated.");
                }

                break;
            }

            else{
                x++;
            }

        }


    }


    //Method to delete a driver and his other details from the system
    @Override
    public void DeleteDriver() {
        Scanner input = new Scanner(System.in);

        System.out.print("Please Enter The First Name Of The Driver You Want To Delete : ");
        String driverFName = input.next();
        driverFName = driverFName.toUpperCase();

        System.out.print("Please Enter The Second Name Of The Driver You Want To Delete : ");
        String driverSName = input.next();
        driverSName = driverSName.toUpperCase();

        System.out.print("Please Enter The Team (CAR MANUFACTURER) Of The Driver You Want To Delete : ");
        String driverTeam = input.next();
        driverTeam = driverTeam.toUpperCase();

        boolean result = false; //To terminate the for loop from implementing the if statements again and again

        for (int x = 0; x < driver.length; x++) {
            if (driver[x].getFirstNameOfTheDriver().equals(driverFName) && driver[x].getSecondNameOfTheDriver().equals(driverSName)
                    && driver[x].getTheTeamOfTheDriver().equals(driverTeam)) { //checking whether the details user entered is in the system

                System.out.println("\nThe Driver " + driver[x].getFirstNameOfTheDriver() + " " +
                        driver[x].getSecondNameOfTheDriver() + " and The Team " + driver[x].getTheTeamOfTheDriver() +
                        " Has Been Successfully Deleted From The System.");

                //assigning the variables to the default values
                driver[x].setFirstNameOfTheDriver("Not Found");
                driver[x].setSecondNameOfTheDriver("Not Found");
                driver[x].setTheTeamOfTheDriver("Not Found");
                driver[x].setLocationOfTheDriver("Not Found");
                driver[x].setNumberOfFirstPositions(0);
                driver[x].setNumberOfSecondPositions(0);
                driver[x].setNumberOfThirdPositions(0);
                driver[x].setNumberOfPointsADriverHas(0);
                driver[x].setNumberOfRacesParticipatedIn(0);

                result = true;

                Formula1Driver temp;

                //Sort the array so that the indexes without a driver in the middle of the array gets rearranged with indexes with a driver at the end of the array
                for (int i = 0; i < driver.length; i++) {
                    for (int j = i + 1; j < driver.length; j++) {
                        if ((driver[i].getFirstNameOfTheDriver().equals("Not Found")) && (!driver[j].getFirstNameOfTheDriver().equals("Not Found"))) {
                            temp = driver[i];
                            driver[i] = driver[j];
                            driver[j] = temp;
                        }

                    }
                }
            }

            else if ((!driver[x].getFirstNameOfTheDriver().equals(driverFName) || !driver[x].getSecondNameOfTheDriver().equals(driverSName))
                    && driver[x].getTheTeamOfTheDriver().equals(driverTeam)) { //In case the driver user wanted to delete is not in the system
                System.out.println("\nThe Name Of The Driver You Have Entered Is Not In The System.");
                System.out.println("Please Check The Spelling And Try Again. \nSorry For The Inconvenience!");

                result = true;
            }

            else if ((driver[x].getFirstNameOfTheDriver().equals(driverFName) && driver[x].getSecondNameOfTheDriver().equals(driverSName))
                    && !driver[x].getTheTeamOfTheDriver().equals(driverTeam)) { //In case the team of tje driver user entered is not in the system
                System.out.println("\nThe Team Of The Driver You Have Entered Is Not In The System.");
                System.out.println("Please Check The Spelling And Try Again. \nSorry For The Inconvenience!");

                result = true;
            }

        }

        //In case the driver and the team the user entered is not in the system
        if (!result) {
            System.out.println("\nThe Name And The Team Of The Driver You Have Entered Is Not In The System.");
            System.out.println("Please Check The Spelling And Try Again. \nSorry For The Inconvenience!");
        }
    }


    //Method to change the driver from an already existing team
    @Override
    public void ChangeDriverForConstructorTeam() {
        Scanner input = new Scanner(System.in);
        System.out.println("How Do You Want To Search? \n1 : Using Driver's Name \n2 : Using Team Name (CAR MANUFACTURER)");
        System.out.print("\nPlease Enter Your Choice : "); //Providing user two options to select the driver he wants to change
        String newDriver = input.next().toUpperCase();

        if (newDriver.equals("1") || newDriver.equals("YES")) { //In case user selects to search for the driver using the drivers name
            System.out.println("\n");
            System.out.print("Please Enter The First Name Of The Driver Who You Want To Change : ");
            String driverFName = input.next();
            driverFName = driverFName.toUpperCase();

            System.out.print("Please Enter The Second Name Of The Driver Who You Want To Change : ");
            String driverSName = input.next();
            driverSName = driverSName.toUpperCase();

            boolean result = false; //To terminate the for loop from printing the if statements again and again

            for (int i = 0; i < driver.length; i++) {
                if (driver[i].getFirstNameOfTheDriver().equals(driverFName) && driver[i].getSecondNameOfTheDriver().equals(driverSName)) {
                    System.out.println("\nYou Will Be Changing The Driver Of The Team " + driver[i].getTheTeamOfTheDriver());

                    System.out.println("\nDo You Wish To Continue? \n1 : Yes \n2 : No");
                    System.out.print("\nPlease Enter your choice: ");
                    String decision = input.next().toUpperCase();

                    if (decision.equals("1") || decision.equals("YES")) {
                        System.out.print("\nPlease Enter The First Name Of The New Driver: ");
                        String driverNewFName = input.next();
                        driverNewFName = driverNewFName.toUpperCase();
                        driver[i].setFirstNameOfTheDriver(driverNewFName);

                        System.out.print("Please Enter The Second Name Of The New Driver: ");
                        String driverNewSName = input.next();
                        driverNewSName = driverNewSName.toUpperCase();
                        driver[i].setSecondNameOfTheDriver(driverNewSName);

                        System.out.print("Please Enter The Location Of The New Driver: ");
                        String driverLocation = input.next();
                        driverLocation = driverLocation.toUpperCase();
                        driver[i].setLocationOfTheDriver(driverLocation);

                        System.out.println("\nStatistics of the driver will be automatically 0 until further updated.");
                        driver[i].setNumberOfFirstPositions(0);
                        driver[i].setNumberOfSecondPositions(0);
                        driver[i].setNumberOfThirdPositions(0);
                        driver[i].setNumberOfPointsADriverHas(0);
                        driver[i].setNumberOfRacesParticipatedIn(0);


                    } else if (decision.equals("2") || decision.equals("NO")) {
                        System.out.println("\nPlease Select A Different Option Or a Different Driver");
                    } else {
                        System.out.println("\nInvalid Input Received");
                    }

                    result = true;
                }
            }

            if (!result) {
                System.out.println("\nThere Is No Driver By The Name You Entered. Please Try Again.");
            }
        }

        else if (newDriver.equals("2") || newDriver.equals("NO")) { //In case user selects the option to search and delete the driver using the team name
            System.out.print("\nPlease Enter The Team of Which You want To Change The Driver Of : ");
            String driverTeam = input.next();
            driverTeam = driverTeam.toUpperCase();

            boolean result = false; //To terminate the for loop from printing the if statements again and again

            for(int i = 0; i < driver.length; i++) {
                if (driver[i].getTheTeamOfTheDriver().equals(driverTeam)) {
                    System.out.println("You Will Be Replacing The Driver " + driver[i].getFirstNameOfTheDriver() + " " + driver[i].getSecondNameOfTheDriver());

                    System.out.println("\nDo You Wish To Continue? \n1 : Yes \n2 : No");
                    System.out.print("\nPlease Enter your choice: ");
                    String decision = input.next().toUpperCase();

                    if (decision.equals("1") || decision.equals("YES")) {
                        System.out.print("\nPlease Enter The First Name Of The New Driver: ");
                        String driverNewFName = input.next();
                        driverNewFName = driverNewFName.toUpperCase();
                        driver[i].setFirstNameOfTheDriver(driverNewFName);

                        System.out.print("Please Enter The Second Name Of The New Driver: ");
                        String driverNewSName = input.next();
                        driverNewSName = driverNewSName.toUpperCase();
                        driver[i].setSecondNameOfTheDriver(driverNewSName);

                        System.out.print("Please Enter The Location Of The New Driver: ");
                        String driverLocation = input.next();
                        driverLocation = driverLocation.toUpperCase();
                        driver[i].setLocationOfTheDriver(driverLocation);

                        System.out.println("\nStatistics of the driver will be automatically 0 until further updated.");
                        driver[i].setNumberOfFirstPositions(0);
                        driver[i].setNumberOfSecondPositions(0);
                        driver[i].setNumberOfThirdPositions(0);
                        driver[i].setNumberOfPointsADriverHas(0);
                        driver[i].setNumberOfRacesParticipatedIn(0);

                    }
                    else if (decision.equals("2") || decision.equals("NO")) {
                        System.out.println("Please Select A Different Option Or a Different Driver");
                    } else {
                        System.out.println("Invalid Input Received");
                    }

                    result = true;

                }
            }

            if (!result) { //In case the team user entered is not in the system
                System.out.println("\nThe Team You Have Entered Is Not In The System. Please Try Again!");
            }
        }

        else { //In case user enters an invalid input
            System.out.println("Invalid Input Received");
        }

    }


    //Method to display the statistics of a driver
    @Override
    public void DisplayStatisticsOfExistingDriver() {
        Scanner input = new Scanner(System.in);

        System.out.print("Please Enter The First Name Of The Driver You Want To View The Statistics Of : ");
        String driverFName = input.next();
        driverFName = driverFName.toUpperCase();

        System.out.print("Please Enter The Second Name Of The Driver You Want To View The Statistics Of : ");
        String driverSName = input.next();
        driverSName = driverSName.toUpperCase();

        boolean result = false; //To terminate the for loop from printing the if statements again and again

        for (int x = 0; x < driver.length; x++) {
            if (driver[x].getFirstNameOfTheDriver().equals(driverFName) && driver[x].getSecondNameOfTheDriver().equals(driverSName)) {
                System.out.println("\nDETAILS OF THE DRIVER");
                System.out.println("   Name The Of The Driver : " + driver[x].getFirstNameOfTheDriver() + " " + driver[x].getSecondNameOfTheDriver());
                System.out.println("   Team The Of The Driver (CAR MANUFACTURER) : " + driver[x].getTheTeamOfTheDriver());
                System.out.println("   Location The Of The Driver : " + driver[x].getLocationOfTheDriver());
                System.out.println("STATISTICS OF THE DRIVER");
                System.out.println("   Number Of First Positions Achieved By The Driver : " + driver[x].getNumberOfFirstPositions());
                System.out.println("   Number Of Second Positions Achieved By The Driver : " + driver[x].getNumberOfSecondPositions());
                System.out.println("   Number Of Third Positions Achieved By The Driver : " + driver[x].getNumberOfThirdPositions());
                System.out.println("   Number Of Points Achieved By The Driver : " + driver[x].getNumberOfPointsADriverHas());
                System.out.println("   Number Of Races The Driver Has Participated In : " + driver[x].getNumberOfRacesParticipatedIn());

                result = true;
            }
        }

        if (!result){
            System.out.println("The Name Of The Driver You Have Entered Is Not In The System.");
            System.out.println("Please Try Again. Sorry For The Inconvenience Caused!");
        }
    }


    //Method to view the F1 drivers table
    @Override
    public void ViewDriversTable() {
        System.out.println("\n\n");
        System.out.printf("%123s","\033[0;1mFORMULA 1 2021 STANDINGS\n\033[0m");// ... 01 Reference used here to make text bold ...
        System.out.printf("%128s","\033[0;1mDETAILS AND STATISTIC OF THE DRIVERS\033[0m");// ... 01 Reference used here to make text bold ...

        //Arranging the Formula 1 Drivers Table according to descending order of the number of points
        Formula1Driver temp;

        for (int i = 0; i < driver.length; i++) {

            for (int j = i + 1; j < driver.length; j++) {

                if ((driver[i].getNumberOfPointsADriverHas()) < (driver[j].getNumberOfPointsADriverHas())) {
                    temp = driver[i];
                    driver[i] = driver[j];
                    driver[j] = temp;
                }

                else if (driver[i].getNumberOfPointsADriverHas().equals(driver[j].getNumberOfPointsADriverHas())){ //in case two drivers have same points
                    if ((driver[i].getNumberOfFirstPositions()) < (driver[j].getNumberOfFirstPositions())){ //The one with higher first positions is displayed first
                        temp = driver[i];
                        driver[i] = driver[j];
                        driver[j] = temp;
                    }
                }
            }
        }

        //Displaying of the Formula 1 Drivers Table
        System.out.println("\n...........................................................................................................................................................................................................................");
        System.out.println("\033[3;1mPOSITION\t\tNO. OF POINTS\t\tNAME OF THE PLAYER\t\t TEAM OF THE PLAYER\t\t" +
                "LOCATION OF THE PLAYER\t\tNO. OF 1ST POSITIONS\t\tNO. OF 2ND POSITIONS\t\tNO. OF 3RD POSITIONS\t\t" +
                "NO. OF RACES COMPLETED\033[0m"); // ... 01 Reference used here to make text bold ...
        System.out.println("...........................................................................................................................................................................................................................\n");

        //In case no information about drivers are added to the system
        if (driver[0].getFirstNameOfTheDriver().equals("Not Found")){
            System.out.printf( "%-15s %-19s %-24s %-22s %-36s %-27s %-27s %-27s %-27s" ,
                    "N/A", "N/A", "N/A", "N/A", "N/A","N/A","N/A", "N/A", "N/A"); // ... 02 Reference was used to get even space in between columns ...
            System.out.println("\n");
        }

        for(int x = 0; x < driver.length; x++){
            if(!driver[x].getFirstNameOfTheDriver().equals("Not Found")){
                System.out.printf( "%-21s %-13s %-24s %-22s %-36s %-27s %-27s %-27s %-27s" , x+1, driver[x].getNumberOfPointsADriverHas(),
                        driver[x].getFirstNameOfTheDriver() + " " + driver[x].getSecondNameOfTheDriver(),
                        driver[x].getTheTeamOfTheDriver(),
                        driver[x].getLocationOfTheDriver(),
                        driver[x].getNumberOfFirstPositions(),
                        driver[x].getNumberOfSecondPositions(),
                        driver[x].getNumberOfThirdPositions(),
                        driver[x].getNumberOfRacesParticipatedIn()); // ... 02 Reference was used to get even space in between columns ...
                System.out.println("\n");
            }
        }
        System.out.println("...........................................................................................................................................................................................................................\n\n");
    }


    //Method to add a race with its completed information
    @Override
    public void AddRaceWithItsDetails() {
        Scanner input = new Scanner(System.in);
        int empty = 0;

        System.out.print("Please Enter The Date When the Race Took Place : ");
        int date = input.nextInt();

        System.out.print("Please Enter The Month When the Race Took Place : ");
        String month = input.next();
        month = month.toUpperCase();

        for (int a = 0; a < raceMonth.length; a++) { //Checking which index is empty to store the race details
            if (raceMonth[a] == null) {
                empty = a;
                break;
            }
        }

        raceParticipants[empty] = ""; //

        boolean resultDate;


        raceYear[empty] = 2021;

        if (month.equals("JANUARY") || month.equals("MARCH") || month.equals("MAY") || month.equals("JULY")
                || month.equals("AUGUST") || month.equals("OCTOBER") || month.equals("DECEMBER")) {
            if (date > 1 && date <= 31) {
                raceDate[empty] = date;
                raceMonth[empty] = month;
                resultDate = true;

            } else {
                System.out.println("The date you have entered is incorrect. Please check again.");
                resultDate = false;
            }
        } else if (month.equals("APRIL") || month.equals("JUNE") || month.equals("SEPTEMBER") || month.equals("NOVEMBER")) {
            if (date > 1 && date <= 30) {
                raceDate[empty] = date;
                raceMonth[empty] = month;
                resultDate = true;
            } else {
                System.out.println("The date you have entered is incorrect. Please check again.");
                resultDate = false;
            }
        } else if (month.equals("FEBRUARY")) {
            if (date > 1 && date <= 28) {
                raceDate[empty] = date;
                raceMonth[empty] = month;
                resultDate = true;
            } else {
                System.out.println("The date you have entered is incorrect. Please check again.");
                resultDate = false;
            }
        }
        else{
            System.out.println("The month you have entered is incorrect. Please check again.");
            resultDate = false;
        }


        if(resultDate) {
            System.out.print("How Many Drivers Participated : ");
            int participants = input.nextInt();

            ArrayList<String> number = new ArrayList<>();

            for (int x = 0; x < participants; x++) {
                System.out.println("\n\n" + (x + 1) + " Driver");
                System.out.print("\tEnter First Name Of The Driver : ");
                String fName = input.next();
                fName = fName.toUpperCase();

                System.out.print("\tEnter Second Name Of The Driver : ");
                String sName = input.next();
                sName = sName.toUpperCase();

                System.out.print("\tEnter Team Of The Driver : ");
                String tName = input.next();
                tName = tName.toUpperCase();

                boolean result = false; //To terminate the for loop from printing the if statements again and again

                for (int i = 0; i < driver.length; i++) {

                    if (driver[i].getFirstNameOfTheDriver().equals(fName) && driver[i].getSecondNameOfTheDriver().equals(sName)
                            && driver[i].getTheTeamOfTheDriver().equals(tName)) { //Checking whether the driver exists in the system

                        if(!number.contains(fName + " " + sName + " " + tName)) { //To make sure the same driver doesnt get added to the race
                            number.add(fName + " " + sName + " " + tName);

                            driver[i].setNumberOfRacesParticipatedIn(driver[i].getNumberOfRacesParticipatedIn() + 1);

                            System.out.println("\tDid The Driver Complete The Race?\n \t\t1: Yes \n \t\t2: No");
                            System.out.print("\tPlease Enter Here: ");
                            String output = input.next().toUpperCase();

                            if (output.equals("1") || output.equals("YES")) {
                                System.out.print("\n\tWhat was the Drivers position: ");
                                int position = input.nextInt();

                                raceParticipants[empty]= raceParticipants[empty] + "    DRIVER " + (x+1) + " " + driver[i].getFirstNameOfTheDriver() + " " + driver[i].getSecondNameOfTheDriver() + " CAME IN " + position + " POSITION." +  "\n";

                                //Calculating the points of the driver according to the position
                                if (position == 1) {
                                    driver[i].setNumberOfPointsADriverHas(driver[i].getNumberOfPointsADriverHas() + 25);
                                    driver[i].setNumberOfFirstPositions(driver[i].getNumberOfFirstPositions() + 1);
                                    System.out.print("\t25 points have been added to the player!");
                                } else if (position == 2) {
                                    driver[i].setNumberOfPointsADriverHas(driver[i].getNumberOfPointsADriverHas() + 18);
                                    driver[i].setNumberOfSecondPositions(driver[i].getNumberOfSecondPositions() + 1);
                                    System.out.print("\t18 points have been added to the player!");
                                } else if (position == 3) {
                                    driver[i].setNumberOfPointsADriverHas(driver[i].getNumberOfPointsADriverHas() + 15);
                                    driver[i].setNumberOfThirdPositions(driver[i].getNumberOfThirdPositions() + 1);
                                    System.out.print("\t15 points have been added to the player!");
                                } else if (position == 4) {
                                    driver[i].setNumberOfPointsADriverHas(driver[i].getNumberOfPointsADriverHas() + 12);
                                    System.out.print("\t12 points have been added to the player!");
                                } else if (position == 5) {
                                    driver[i].setNumberOfPointsADriverHas(driver[i].getNumberOfPointsADriverHas() + 10);
                                    System.out.print("\t15 points have been added to the player!");
                                } else if (position == 6) {
                                    driver[i].setNumberOfPointsADriverHas(driver[i].getNumberOfPointsADriverHas() + 8);
                                    System.out.print("\t8 points have been added to the player!");
                                } else if (position == 7) {
                                    driver[i].setNumberOfPointsADriverHas(driver[i].getNumberOfPointsADriverHas() + 6);
                                    System.out.print("\t6 points have been added to the player!");
                                } else if (position == 8) {
                                    driver[i].setNumberOfPointsADriverHas(driver[i].getNumberOfPointsADriverHas() + 4);
                                    System.out.print("\t4 points have been added to the player!");
                                } else if (position == 9) {
                                    driver[i].setNumberOfPointsADriverHas(driver[i].getNumberOfPointsADriverHas() + 2);
                                    System.out.print("\t2 points have been added to the player!");
                                } else if (position == 10) {
                                    driver[i].setNumberOfPointsADriverHas(driver[i].getNumberOfPointsADriverHas() + 1);
                                    System.out.print("\t1 point have been added to the player!");
                                } else {
                                    System.out.println("\tThe Driver will not be awarded any points.");
                                }

                            } else if (output.equals("2") || output.equals("NO")) {
                                System.out.println("\tThe Driver is not eligible to be awarded any points.");
                                raceParticipants[empty]= raceParticipants[empty] + "    DRIVER " + (x+1) + " " + driver[i].getFirstNameOfTheDriver() + " " + driver[i].getSecondNameOfTheDriver() + " DNF." +  "\n";

                            } else {
                                System.out.println("\tInvalid input received");
                            }

                            result = true;
                        }

                        else{
                            System.out.println("\n\tThe Driver you have entered is already a participant in the race.");
                            System.out.println("\tPlease add a separate driver.");
                            x--;
                            result = true;
                        }

                    }

                }

                if (!result) {
                    System.out.println("\tThe Driver And The Team You Have Entered Is Not In The System.");
                    System.out.println("\tPlease Add The Correct Details Of The Driver Again.");
                    x--;
                }

            }

            System.out.println("\n\nThe Statistics Of The Drivers Are Automatically Updated Into The Formula 1 Drivers Table!");
        }
    }


    //Method to save newly updated information into a file program
    @Override
    public void SaveUpdatedInformationToFile() {
        try {
            File newObj = new File("Formula1_Drivers_Table.txt");

            if (newObj.createNewFile()) {
                System.out.println("\nFile created: " + newObj.getName());
                System.out.println("Absolute path: " + newObj.getAbsolutePath());
            } else {
                System.out.println("\nFile Existing: " + newObj.getName());
                System.out.println("Absolute path: " + newObj.getAbsolutePath());
            }

            //... 03 & 04 Reference used below to implement serialization...
            FileOutputStream fileOutputStream = new FileOutputStream("Formula1_Drivers_Table.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            //... 03 & 04 Reference used below to implement serialization...
            objectOutputStream.writeObject(driver);
            objectOutputStream.writeObject(raceDate);
            objectOutputStream.writeObject(raceMonth);
            objectOutputStream.writeObject(raceYear);
            objectOutputStream.writeObject(raceParticipants);
            objectOutputStream.close();
            System.out.println("\nAll The Information Has Been Updated Into File");
        }

        catch (IOException e) { // ... 06 Reference is used here ...
            System.out.println("An error occurred...\nPlease try again!");
            e.printStackTrace();
        }

        try {

            // ... 05 Reference is used below to create and write to file ...
            FileWriter writerPrint = new FileWriter("Formula1_Drivers_Table_Saved_Information.txt");
            PrintWriter printW = new PrintWriter(writerPrint);

            //Displaying of the Formula 1 Drivers Table
            printW.println("\n\n");

            // ... 01 Reference used below to make text bold ...
            printW.printf("%123s", "\033[0;1mFORMULA 1 2021 STANDINGS\n\033[0m");
            printW.printf("%128s", "\033[0;1mDETAILS AND STATISTIC OF THE DRIVERS\033[0m");
            printW.print("\n...........................................................................................................................................................................................................................");
            printW.printf("\n\033[3;1mPOSITION\t\tNO. OF POINTS\t\tNAME OF THE PLAYER\t\t TEAM OF THE PLAYER\t\t" +
                    "LOCATION OF THE PLAYER\t\tNO. OF 1ST POSITIONS\t\tNO. OF 2ND POSITIONS\t\tNO. OF 3RD POSITIONS\t\t" +
                    "NO. OF RACES COMPLETED\033[0m");

            printW.print("\n...........................................................................................................................................................................................................................\n");

            //In case no information about drivers are added to the system
            if (driver[0].getFirstNameOfTheDriver().equals("Not Found")) {
                printW.printf("%-15s %-19s %-24s %-22s %-36s %-27s %-27s %-27s %-27s",
                        "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A"); // ... 02 Reference was used to get even space in between columns ...
                printW.println("\n");
            }

            for (int x = 0; x < driver.length; x++) {
                if (!driver[x].getFirstNameOfTheDriver().equals("Not Found")) {
                    printW.printf("%-21s %-13s %-24s %-22s %-36s %-27s %-27s %-27s %-27s", x + 1, driver[x].getNumberOfRacesParticipatedIn(),
                            driver[x].getFirstNameOfTheDriver() + " " + driver[x].getSecondNameOfTheDriver(),
                            driver[x].getTheTeamOfTheDriver(),
                            driver[x].getLocationOfTheDriver(),
                            driver[x].getNumberOfFirstPositions(),
                            driver[x].getNumberOfSecondPositions(),
                            driver[x].getNumberOfThirdPositions(),
                            driver[x].getNumberOfRacesParticipatedIn()); // ... 02 Reference was used to get even space in between columns ...
                    printW.println("\n");

                }
            }
            printW.println("...........................................................................................................................................................................................................................\n\n");


            //Displaying details about the races
            if (raceDate[0] != 0 && (raceMonth[0] != null) && (raceYear[0] != 0) && (raceParticipants[0] != null)) {
                printW.print("\033[0;1mDETAILS ABOUT THE RACES\n\033[0m"); // ... 01 Reference used here to make text bold ...
                for (int i = 0; i < raceDate.length; i++) {
                    if (raceDate[i] != 0 && (raceMonth[i] != null) && (raceYear[i] != 0) && (raceParticipants[i] != null)) {
                        printW.print("Date Of The Race " + raceDate[i] + " " + raceMonth[i] + " " + raceYear[i] + "\n");
                        printW.print("Participants Of The Race \n" + raceParticipants[i] + "\n\n");
                    }
                }
            }

            writerPrint.close();
            printW.close();
        }

        catch (IOException e) { // ... 06 Reference is used here ...
            System.out.println("An error occurred...\nPlease try again!");
            e.printStackTrace();
        }

    }


    //Method to load the previously saved information from file program
    @Override
    public void LoadSavedInformationFromFile() {
        try {

            //... 03 & 04 Reference used below to implement deserialization...
            FileInputStream fileInputStream = new FileInputStream("Formula1_Drivers_Table.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            //... 03 & 04 Reference used below to implement deserialization...
            driver = (Formula1Driver[]) objectInputStream.readObject();
            raceDate = (int[]) objectInputStream.readObject();
            raceMonth = (String[]) objectInputStream.readObject();
            raceYear = (int[]) objectInputStream.readObject();
            raceParticipants = (String[]) objectInputStream.readObject();

            fileInputStream.close();

            System.out.println("\n\nAll The Previously Saved Information Has Recovered.");
            System.out.println("You Can Continue Your Operations Based On The Previously Saved Information Now.");
            System.out.println("--- Thank You! ---");

        }

        catch (FileNotFoundException e) { // ... 06 Reference is used here ...
            System.out.println("An Error Occurred.\nPlease check whether you have any previously saved file!");
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) { // ... 06 Reference is used here ...
            e.printStackTrace();
        }

        try {

            // ... 05 Reference is used below read from file ...
            File myObj = new File("Formula1_Drivers_Table_Saved_Information.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }

            myReader.close();

        }

        catch (FileNotFoundException e) { // ... 06 Reference is used here ...
            System.out.println("An Error Occurred.\nPlease check whether you have any previously saved file!");
            e.printStackTrace();
        }
    }


    //Method to load the previously saved information from file program at the beginning of the program (Created this methods so it wont print anything at the beginning)
    public void LoadFileAtStart(){

        try {
            File newObj = new File("Formula1_Drivers_Table.txt");

            if (newObj.createNewFile()) {
                //Initialising the values of the array driver
                for (int x = 0; x < driver.length; x++) {
                    driver[x] = new Formula1Driver("Not Found", "Not Found","Not Found", "Not Found",0, 0, 0, 0,0);
                }

                //Initialising the values of the arrays raceDate, raceMonth, raceYear, raceParticipants
                for(int y = 0; y < raceDate.length; y++){
                    raceDate[y] = 0;
                    raceMonth[y] = null;
                    raceYear[y] = 0;
                    raceParticipants[y] = null;
                }

                //... 03 & 04 Reference used below to implement serialization...
                FileOutputStream fileOutputStream = new FileOutputStream("Formula1_Drivers_Table.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                //... 03 & 04 Reference used below to implement serialization...
                objectOutputStream.writeObject(driver);
                objectOutputStream.writeObject(raceDate);
                objectOutputStream.writeObject(raceMonth);
                objectOutputStream.writeObject(raceYear);
                objectOutputStream.writeObject(raceParticipants);
                objectOutputStream.close();

            } else {
                //... 03 & 04 Reference used below to implement deserialization...
                FileInputStream fileInputStream = new FileInputStream("Formula1_Drivers_Table.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                //... 03 & 04 Reference used below to implement deserialization...
                driver = (Formula1Driver[]) objectInputStream.readObject();
                raceDate = (int[]) objectInputStream.readObject();
                raceMonth = (String[]) objectInputStream.readObject();
                raceYear = (int[]) objectInputStream.readObject();
                raceParticipants = (String[]) objectInputStream.readObject();

                fileInputStream.close();

            }

        } catch (IOException | ClassNotFoundException e) { // ... 06 Reference is used here ...
            e.printStackTrace();
        }
    }


    //Method to open the GUI
    public void Frame01() {
        // ... 07 Reference is used to below to create a JFrame and add JButtons, JLabels and JTextFields...
        JFrame fTitle = new JFrame("FORMULA 1 CHAMPIONSHIP 2021");

        //Creating the buttons
        JButton button01 = new JButton("DISPLAY");
        button01.setBounds(460, 84, 100, 32);

        JButton button02 = new JButton("DISPLAY");
        button02.setBounds(460, 169, 100, 32);

        JButton button03 = new JButton("DISPLAY");
        button03.setBounds(460, 254, 100, 32);

        JButton button04 = new JButton("GENERATE");
        button04.setBounds(460, 339, 100, 32);

        JButton button05 = new JButton("GENERATE");
        button05.setBounds(460, 424, 100, 32);

        JButton button06 = new JButton("DISPLAY");
        button06.setBounds(460, 509, 100, 32);

        JButton button07 = new JButton("SEARCH");
        button07.setBounds(240, 720, 100, 32);

        JButton button08 = new JButton("EXIT");
        button08.setBounds(520, 770, 100, 32);


        //Creating Labels
        JLabel labelTitle, label1, label1_1, label2, label2_2, label3, label3_3, label4, label4_4, label5, label5_5, label6, label6_6, label7, label7_1, label7_2;
        labelTitle = new JLabel("FORMULA 1 CHAMPIONSHIP 2021");
        labelTitle.setBounds(200, 25, 350, 20);

        label1 = new JLabel("DISPLAY FORMULA 1 TABLE IN DESCENDING ORDER.");
        label1.setBounds(70, 80, 400, 20);
        label1_1 = new JLabel("(According to Number of Points Driver Has)");
        label1_1.setBounds(70, 100, 350, 20);

        label2 = new JLabel("DISPLAY FORMULA 1 TABLE IN ASCENDING ORDER.");
        label2.setBounds(70, 165, 400, 20);
        label2_2 = new JLabel("(According to Number of Points Driver Has)");
        label2_2.setBounds(70, 185, 350, 20);

        label3 = new JLabel("DISPLAY FORMULA 1 TABLE IN DESCENDING ORDER.");
        label3.setBounds(70, 250, 400, 20);
        label3_3 = new JLabel("(According to Number of First Positions Driver Has)");
        label3_3.setBounds(70, 270, 350, 20);

        label4 = new JLabel("GENERATE A RANDOM RACE WITH EXISTING DRIVERS.");
        label4.setBounds(70, 335, 400, 20);
        label4_4 = new JLabel("(Automatically Updating The Formula1 Drivers Table)");
        label4_4.setBounds(70, 355, 350, 20);

        label5 = new JLabel("GENERATE A RANDOM RACE WITH EXISTING DRIVERS.");
        label5.setBounds(70, 420, 400, 20);
        label5_5 = new JLabel("(With Randomly Allocated Starting Positions For Drivers)");
        label5_5.setBounds(70, 440, 350, 20);

        label6 = new JLabel("DISPLAY ALL COMPLETED RACES.");
        label6.setBounds(70, 505, 400, 20);
        label6_6 = new JLabel("(In Ascending Order Of The Date Played)");
        label6_6.setBounds(70, 525, 350, 20);

        label7 = new JLabel("SEARCH FOR ALL THE RACES COMPLETED BY AN EXISTING DRIVER.");
        label7.setBounds(70, 590, 500, 20);
        label7_1 = new JLabel("Enter The Driver's First Name : ");
        label7_1.setBounds(70, 620, 350, 20);
        label7_2 = new JLabel("Enter The Driver's Second Name : ");
        label7_2.setBounds(70, 660, 350, 20);

        //Creating TextBoxes
        JTextField field01 = new JTextField(" First Name...", 20);
        field01.setBounds(310, 620, 180, 25);
        JTextField field02 = new JTextField(" Second Name...", 20);
        field02.setBounds(310, 660, 180, 25);

        //Customizing the labels
        // ... 08 Reference was used below to change the font of the labels ...
        Font fontTitle = new Font("Courgette", Font.PLAIN | Font.BOLD , 18);
        labelTitle.setFont(fontTitle);

        Font fontMenu = new Font("Verdana", Font.BOLD, 12);
        label1.setFont(fontMenu);
        label2.setFont(fontMenu);
        label3.setFont(fontMenu);
        label4.setFont(fontMenu);
        label5.setFont(fontMenu);
        label6.setFont(fontMenu);
        label7.setFont(fontMenu);

        Font fontDetails = new Font("Verdana", Font.ITALIC, 12);
        label1_1.setFont(fontDetails);
        label2_2.setFont(fontDetails);
        label3_3.setFont(fontDetails);
        label4_4.setFont(fontDetails);
        label5_5.setFont(fontDetails);
        label6_6.setFont(fontDetails);

        Font fontTextBox = new Font("Verdana", Font.ITALIC, 12);
        label7_1.setFont(fontTextBox);
        label7_2.setFont(fontTextBox);

        //Customizing the text boxes
        Font fontText = new Font("Verdana", Font.PLAIN, 12); // ... 08 Reference was used here to change the font of the labels ...
        field01.setFont(fontText);
        field01.setBorder(BorderFactory.createLineBorder(Color.black)); // ... 09 Reference was used here to put a border around the text box ...
        field02.setFont(fontText);
        field02.setBorder(BorderFactory.createLineBorder(Color.black)); // ... 09 Reference was used here to put a border around the text box ...

        //Customizing the buttons
        // ... 10 & 10 References are used below to change the background color and foreground color...
        Color buttonBackground01 = new Color(12, 107, 104);
        Color buttonForeground01 = new Color(255, 255, 255);
        Color buttonBackground02 = new Color(4, 224, 217);
        Color buttonForeground02 = new Color(0, 0, 0);
        Color buttonBackground03 = new Color(162, 189, 189);

        button01.setBackground(buttonBackground01);
        button01.setForeground(buttonForeground01);
        button01.setBorder(BorderFactory.createLineBorder(Color.black));
        button02.setBackground(buttonBackground02);
        button02.setForeground(buttonForeground02);
        button02.setBorder(BorderFactory.createLineBorder(Color.black));
        button03.setBackground(buttonBackground01);
        button03.setForeground(buttonForeground01);
        button03.setBorder(BorderFactory.createLineBorder(Color.black));
        button04.setBackground(buttonBackground02);
        button04.setForeground(buttonForeground02);
        button04.setBorder(BorderFactory.createLineBorder(Color.black));
        button05.setBackground(buttonBackground01);
        button05.setForeground(buttonForeground01);
        button05.setBorder(BorderFactory.createLineBorder(Color.black));
        button06.setBackground(buttonBackground02);
        button06.setForeground(buttonForeground02);
        button06.setBorder(BorderFactory.createLineBorder(Color.black));
        button07.setBackground(buttonBackground01);
        button07.setForeground(buttonForeground01);
        button07.setBorder(BorderFactory.createLineBorder(Color.black));
        button08.setBackground(buttonBackground03);
        button08.setForeground(buttonForeground02);
        button08.setBorder(BorderFactory.createLineBorder(Color.black,3)); // ... 09 Reference was used here to put a border around the button and increase the thickness of the line ...



        //Add the buttons, labels and text boxes into the frame
        fTitle.add(labelTitle);
        fTitle.add(label1);
        fTitle.add(label1_1);
        fTitle.add(button01);
        fTitle.add(label2);
        fTitle.add(label2_2);
        fTitle.add(button02);
        fTitle.add(label3);
        fTitle.add(label3_3);
        fTitle.add(button03);
        fTitle.add(label4);
        fTitle.add(label4_4);
        fTitle.add(button04);
        fTitle.add(label5);
        fTitle.add(label5_5);
        fTitle.add(button05);
        fTitle.add(label6);
        fTitle.add(label6_6);
        fTitle.add(button06);
        fTitle.add(label7);
        fTitle.add(label7_1);
        fTitle.add(label7_2);
        fTitle.add(field01);
        fTitle.add(field02);
        fTitle.add(button07);
        fTitle.add(button08);


        fTitle.setSize(660, 860); // Setting the size of the frame
        fTitle.setLayout(null);// Using no layout managers
        fTitle.setVisible(true);// Making the frame visible
        fTitle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // The frame will close and the program will stop running when the close button is clicked ...


        // Button to display the Formula 1 drivers table in descending order
        button01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //Arranging the Formula 1 Drivers Table according to descending order of the number of points
                Formula1Driver[] order = driver.clone();
                Formula1Driver temp;

                for (int i = 0; i < order.length; i++) {

                    for (int j = i + 1; j < order.length; j++) {

                        if ((order[i].getNumberOfPointsADriverHas()) < (order[j].getNumberOfPointsADriverHas())) {
                            temp = order[i];
                            order[i] = order[j];
                            order[j] = temp;
                        }
                    }
                }

                //Displaying of the Formula 1 Drivers Table in the frame

                int numberOfDrivers = 0;

                for(int z = 0; z < order.length; z++){
                    if (!order[z].getFirstNameOfTheDriver().equals("Not Found")){
                        numberOfDrivers++;
                    }
                }

                // ... 12 Reference was used below to create a 2D array ...
                String[][] row = new String[numberOfDrivers][8];

                for (int a = 0; a < order.length; a++){
                    if (!order[a].getFirstNameOfTheDriver().equals("Not Found")) {
                        String numberOfPoints = String.valueOf(order[a].getNumberOfPointsADriverHas());
                        row[a][0] = numberOfPoints;

                        row[a][1] = order[a].getFirstNameOfTheDriver() + " " + order[a].getSecondNameOfTheDriver();
                        row[a][2] = order[a].getTheTeamOfTheDriver();
                        row[a][3] = order[a].getLocationOfTheDriver();

                        String firstPositions = String.valueOf(order[a].getNumberOfFirstPositions());
                        row[a][4] = firstPositions;

                        String secondPositions = String.valueOf(order[a].getNumberOfSecondPositions());
                        row[a][5] = secondPositions;

                        String thirdPositions = String.valueOf(order[a].getNumberOfThirdPositions());
                        row[a][6] = thirdPositions;

                        String numberOfRaces = String.valueOf(order[a].getNumberOfRacesParticipatedIn());
                        row[a][7] = numberOfRaces;
                    }
                }

                String[] column ={"Number Of Points","Name Of The Driver","Team Of The Driver", "Location Of The Driver",
                        "Number Of First Positions", "Number Of Second Positions", "Number Of Third Positions", "Number Of Races"};


                JFrame frame01 =new JFrame("Formula 1 Table In Descending Order Of The Number Of Points");

                //Creating previous and exit buttons
                JButton previous = new JButton("PREVIOUS");
                previous.setBounds(80, 300, 100, 32);

                JButton exit = new JButton("EXIT");
                exit.setBounds(1300, 300, 100, 32);

                //Customizing the previous and exit buttons
                previous.setBackground(buttonBackground01);
                exit.setBackground(buttonBackground01);
                previous.setForeground(buttonForeground01);
                exit.setForeground(buttonForeground01);

                if(numberOfDrivers ==0){ // If the number of drivers are zero, no table will be displayed
                    JLabel label01 = new JLabel("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    label01.setBounds(80, 50, 1400, 20);

                    JLabel label02 = new JLabel("----------------------------------------------------------------------------------------------------------------------------  THERE ARE NO DRIVERS IN ORDER TO CREATE A TABLE  ----------------------------------------------------------------------------------------------------------------------------");
                    label02.setBounds(80, 70, 1400, 20);

                    JLabel label03 = new JLabel("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    label03.setBounds(80, 90, 1400, 20);

                    JLabel label = new JLabel("");
                    label.setBounds(100, 120, 1000, 20);

                    frame01.add(previous);
                    frame01.add(exit);

                    frame01.add(label01);
                    frame01.add(label02);
                    frame01.add(label03);
                    frame01.add(label);

                }

                else {
                    // ... 13 Reference is used below to create a JTable ...
                    JTable descendingTable = new JTable(row, column);
                    descendingTable.setEnabled(false);

                    JScrollPane scrollPane = new JScrollPane(descendingTable);

                    frame01.add(previous);
                    frame01.add(exit);
                    frame01.add(scrollPane);
                }


                frame01.setSize(1500,400);
                frame01.setVisible(true);
                fTitle.setVisible(false);


                //Button to exit the frame
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frame01.dispose();
                        fTitle.dispose();
                    }

                });

                //Button to go the previous menu frame
                previous.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frame01.dispose();
                        fTitle.setVisible(true);
                    }

                });
            }

        });


        // Button to display Formula 1 table in ascending order
        button02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //Arranging the Formula 1 Drivers Table according to descending order of the number of points
                Formula1Driver[] order = driver.clone();
                Formula1Driver temp;

                for (int i = 0; i < order.length; i++) {

                    for (int j = i + 1; j < order.length; j++) {

                        if ((order[j].getNumberOfPointsADriverHas()) < (order[i].getNumberOfPointsADriverHas())) {
                            temp = order[j];
                            order[j] = order[i];
                            order[i] = temp;
                        }

                    }
                }

                //Displaying of the Formula 1 Drivers Table in the frame

                int numberOfDrivers = 0;

                for(int z = 0; z < order.length; z++){
                    if (!order[z].getFirstNameOfTheDriver().equals("Not Found")){
                        numberOfDrivers++;
                    }
                }

                // ... 12 Reference was used below to create a 2D array ...
                String[][] row = new String[numberOfDrivers][8];

                int index = 0;

                for (int a = 0; a < order.length; a++){
                    if (!order[a].getFirstNameOfTheDriver().equals("Not Found")) {

                        String numberOfPoints = String.valueOf(order[a].getNumberOfPointsADriverHas());
                        row[index][0] = numberOfPoints;

                        row[index][1] = order[a].getFirstNameOfTheDriver() + " " + order[a].getSecondNameOfTheDriver();
                        row[index][2] = order[a].getTheTeamOfTheDriver();
                        row[index][3] = order[a].getLocationOfTheDriver();

                        String firstPositions = String.valueOf(order[a].getNumberOfFirstPositions());
                        row[index][4] = firstPositions;

                        String secondPositions = String.valueOf(order[a].getNumberOfSecondPositions());
                        row[index][5] = secondPositions;

                        String thirdPositions = String.valueOf(order[a].getNumberOfThirdPositions());
                        row[index][6] = thirdPositions;

                        String numberOfRaces = String.valueOf(order[a].getNumberOfRacesParticipatedIn());
                        row[index][7] = numberOfRaces;
                        index++;
                    }
                }

                String[] column ={"Number Of Points","Name Of The Driver","Team Of The Driver", "Location Of The Driver",
                        "Number Of First Positions", "Number Of Second Positions", "Number Of Third Positions", "Number Of Races"};

                JFrame frame01 =new JFrame("Formula 1 Table In Ascending Order Of The Number Of Points");

                // Creating previous and exit buttons
                JButton previous = new JButton("PREVIOUS");
                previous.setBounds(80, 300, 100, 32);

                JButton exit = new JButton("EXIT");
                exit.setBounds(1300, 300, 100, 32);

                // Customizing the previous and exit buttons
                previous.setBackground(buttonBackground01);
                exit.setBackground(buttonBackground01);
                previous.setForeground(buttonForeground01);
                exit.setForeground(buttonForeground01);

                if(numberOfDrivers ==0){ // If number of drivers are zero, no table will be displayed
                    JLabel label01 = new JLabel("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    label01.setBounds(80, 50, 1400, 20);

                    JLabel label02 = new JLabel("----------------------------------------------------------------------------------------------------------------------------  THERE ARE NO DRIVERS IN ORDER TO CREATE A TABLE  ----------------------------------------------------------------------------------------------------------------------------");
                    label02.setBounds(80, 70, 1400, 20);

                    JLabel label03 = new JLabel("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    label03.setBounds(80, 90, 1400, 20);

                    JLabel label = new JLabel("");
                    label.setBounds(100, 120, 1000, 20);

                    frame01.add(previous);
                    frame01.add(exit);

                    frame01.add(previous);
                    frame01.add(exit);
                    frame01.add(label01);
                    frame01.add(label02);
                    frame01.add(label03);
                    frame01.add(label);

                }

                else {
                    // ... 13 Reference is used below to create a JTable ...
                    JTable ascendingTable = new JTable(row, column);
                    ascendingTable.setEnabled(false);

                    JScrollPane scrollPane = new JScrollPane(ascendingTable);

                    frame01.add(previous);
                    frame01.add(exit);
                    frame01.add(scrollPane);
                }

                frame01.setSize(1500,400);
                frame01.setVisible(true);
                fTitle.setVisible(false);

                //Button to exit the frame
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frame01.dispose();
                        fTitle.dispose();
                    }

                });

                //Button to go back to the previous menu frame
                previous.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frame01.dispose();
                        fTitle.setVisible(true);
                    }

                });


            }

        });


        //Button to display Formula 1 table in descending order according to the number of first positions
        button03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //Arranging the Formula 1 Drivers Table according to descending order of the number of points
                Formula1Driver[] order = driver.clone();
                Formula1Driver temp;

                for (int i = 0; i < order.length; i++) {

                    for (int j = i + 1; j < order.length; j++) {

                        if ((order[i].getNumberOfFirstPositions()) < (order[j].getNumberOfFirstPositions())) {
                            temp = order[i];
                            order[i] = order[j];
                            order[j] = temp;
                        }
                    }
                }

                //Displaying of the Formula 1 Drivers Table in the frame

                int numberOfDrivers = 0;

                for(int z = 0; z < order.length; z++){
                    if (!order[z].getFirstNameOfTheDriver().equals("Not Found")){
                        numberOfDrivers++;
                    }
                }

                // ... 12 Reference was used below to create a 2D array ...
                String[][] row = new String[numberOfDrivers][8];

                for (int a = 0; a < order.length; a++){
                    if (!order[a].getFirstNameOfTheDriver().equals("Not Found")) {
                        String numberOfPoints = String.valueOf(order[a].getNumberOfPointsADriverHas());
                        row[a][0] = numberOfPoints;

                        row[a][1] = order[a].getFirstNameOfTheDriver() + " " + order[a].getSecondNameOfTheDriver();
                        row[a][2] = order[a].getTheTeamOfTheDriver();
                        row[a][3] = order[a].getLocationOfTheDriver();

                        String firstPositions = String.valueOf(order[a].getNumberOfFirstPositions());
                        row[a][4] = firstPositions;

                        String secondPositions = String.valueOf(order[a].getNumberOfSecondPositions());
                        row[a][5] = secondPositions;

                        String thirdPositions = String.valueOf(order[a].getNumberOfThirdPositions());
                        row[a][6] = thirdPositions;

                        String numberOfRaces = String.valueOf(order[a].getNumberOfRacesParticipatedIn());
                        row[a][7] = numberOfRaces;
                    }
                }

                String[] column ={"Number Of Points","Name Of The Driver","Team Of The Driver", "Location Of The Driver",
                        "Number Of First Positions", "Number Of Second Positions", "Number Of Third Positions", "Number Of Races"};


                JFrame frame01 =new JFrame("Formula 1 Table In Descending Order Of The First Positions Achieved");

                //Creating previous and exit buttons
                JButton previous = new JButton("PREVIOUS");
                previous.setBounds(80, 300, 100, 32);

                JButton exit = new JButton("EXIT");
                exit.setBounds(1300, 300, 100, 32);

                //Customizing the previous and exit buttons
                previous.setBackground(buttonBackground01);
                exit.setBackground(buttonBackground01);
                previous.setForeground(buttonForeground01);
                exit.setForeground(buttonForeground01);

                if(numberOfDrivers ==0){ //In case the number of drivers are zero, no table will be displayed
                    JLabel label01 = new JLabel("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    label01.setBounds(80, 50, 1400, 20);

                    JLabel label02 = new JLabel("----------------------------------------------------------------------------------------------------------------------------  THERE ARE NO DRIVERS IN ORDER TO CREATE A TABLE  ----------------------------------------------------------------------------------------------------------------------------");
                    label02.setBounds(80, 70, 1400, 20);

                    JLabel label03 = new JLabel("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    label03.setBounds(80, 90, 1400, 20);

                    JLabel label = new JLabel("");
                    label.setBounds(100, 120, 1000, 20);

                    frame01.add(previous);
                    frame01.add(exit);

                    frame01.add(label01);
                    frame01.add(label02);
                    frame01.add(label03);
                    frame01.add(label);
                }

                else {
                    // ... 13 Reference was used below to create the table ...
                    JTable descendingTable = new JTable(row, column);
                    descendingTable.setEnabled(false);

                    JScrollPane scrollPane = new JScrollPane(descendingTable);

                    frame01.add(previous);
                    frame01.add(exit);
                    frame01.add(scrollPane);
                }

                frame01.setSize(1500,400);
                frame01.setVisible(true);
                fTitle.setVisible(false);

                //Button to exit the frame
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frame01.dispose();
                    }

                });

                //Button to go back to the previous menu frame
                previous.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frame01.dispose();
                        fTitle.setVisible(true);
                    }

                });


            }

        });


        // Button to generate a random race
        button04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int numberOfDrivers = 0;

                for(int x = 0; x < driver.length; x++){
                    if(!driver[x].getFirstNameOfTheDriver().equals("Not Found")){
                        numberOfDrivers ++;
                    }
                }

                int empty = 0;

                for (int a = 0; a < raceMonth.length; a++) { //Checking which index is empty to store the race details
                    if (raceMonth[a] == null) {
                        empty = a;
                        break;
                    }
                }

                raceParticipants[empty] = "";

                if(numberOfDrivers !=0) {
                    raceYear[empty] = 2021;

                    // ... 14 Reference is used below to generate a random month and date ...

                    int month = 1 + (int) (Math.random() * (12 - 1) + 1);

                    if (month == 1) {
                        String monthName = "JANUARY";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (31 - 1) + 1);
                        raceDate[empty] = date;

                    } else if (month == 2) {
                        String monthName = "FEBRUARY";
                        raceMonth[empty] = monthName;

                        int date = 1 +  (int) (Math.random() * (28 - 1) + 1);
                        raceDate[empty] = date;

                    } else if (month == 3) {
                        String monthName = "MARCH";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (31 - 1) + 1);
                        raceDate[empty] = date;
                    } else if (month == 4) {
                        String monthName = "APRIL";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (30 - 1) + 1);
                        raceDate[empty] = date;

                    } else if (month == 5) {
                        String monthName = "MAY";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (31 - 1) + 1);
                        raceDate[empty] = date;

                    } else if (month == 6) {
                        String monthName = "JUNE";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (30 - 1) + 1);
                        raceDate[empty] = date;

                    } else if (month == 7) {
                        String monthName = "JULY";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (31 - 1) + 1);
                        raceDate[empty] = date;

                    } else if (month == 8) {
                        String monthName = "AUGUST";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (31 - 1) + 1);
                        raceDate[empty] = date;

                    } else if (month == 9) {
                        String monthName = "SEPTEMBER";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (30 - 1) + 1);
                        raceDate[empty] = date;

                    } else if (month == 10) {
                        String monthName = "OCTOBER";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (31 - 1) + 1);
                        raceDate[empty] = date;

                    } else if (month == 11) {
                        String monthName = "NOVEMBER";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (30 - 1) + 1);
                        raceDate[empty] = date;
                    } else if (month == 12) {
                        String monthName = "DECEMBER";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (31 - 1) + 1);
                        raceDate[empty] = date;
                    }
                }


                ArrayList<Integer> numbers = new ArrayList<>();
                ArrayList<Integer> positionNumbers = new ArrayList<>();

                int max = numberOfDrivers;
                int min = 0;
                for(int z = 0; z < numberOfDrivers; z++){
                    int index = (int)(Math.random()*((max - min)) + min); // Generating a random index to get a driver
                    int position = (int)(Math.random()*((max - min)) + 1);// Generating a random position for a driver

                    if (!numbers.contains(index) && !positionNumbers.contains(position)) {
                        numbers.add(index);
                        positionNumbers.add(position);

                        raceParticipants[empty]= raceParticipants[empty] + "    DRIVER " + (z+1) + " " + driver[index].getFirstNameOfTheDriver() + " " + driver[index].getSecondNameOfTheDriver() + " CAME IN " + position + " POSITION." +  "\n";
                        driver[index].setNumberOfRacesParticipatedIn(driver[index].getNumberOfRacesParticipatedIn() + 1);

                        // Calculating the number of points for each driver
                        if (position == 1) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 25);
                            driver[index].setNumberOfFirstPositions(driver[index].getNumberOfFirstPositions() + 1);
                        }
                        else if (position == 2) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 18);
                            driver[index].setNumberOfSecondPositions(driver[index].getNumberOfSecondPositions() + 1);
                        }
                        else if (position == 3) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 15);
                            driver[index].setNumberOfThirdPositions(driver[index].getNumberOfThirdPositions() + 1);
                        }
                        else if (position == 4) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 12);
                        }
                        else if (position == 5) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 10);
                        }
                        else if (position == 6) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 8);
                        }
                        else if (position == 7) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 6);
                        }
                        else if (position == 8) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 4);
                        }
                        else if (position == 9) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 2);
                        }
                        else if (position == 10) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 1);
                        }

                    }
                    else{
                        z--;
                    }


                }

                //Displaying of formula 1 table and the generated race details

                // ... 12 Reference was used below to create a 2D array ...
                String[][] row = new String[numberOfDrivers][8];

                for (int a = 0; a < driver.length; a++){
                    if (!driver[a].getFirstNameOfTheDriver().equals("Not Found")) {
                        String numberOfPoints = String.valueOf(driver[a].getNumberOfPointsADriverHas());
                        row[a][0] = numberOfPoints;

                        row[a][1] = driver[a].getFirstNameOfTheDriver() + " " + driver[a].getSecondNameOfTheDriver();
                        row[a][2] = driver[a].getTheTeamOfTheDriver();
                        row[a][3] = driver[a].getLocationOfTheDriver();

                        String firstPositions = String.valueOf(driver[a].getNumberOfFirstPositions());
                        row[a][4] = firstPositions;

                        String secondPositions = String.valueOf(driver[a].getNumberOfSecondPositions());
                        row[a][5] = secondPositions;

                        String thirdPositions = String.valueOf(driver[a].getNumberOfThirdPositions());
                        row[a][6] = thirdPositions;

                        String numberOfRaces = String.valueOf(driver[a].getNumberOfRacesParticipatedIn());
                        row[a][7] = numberOfRaces;
                    }
                }


                String[] column ={"Number Of Points","Name Of The Driver","Team Of The Driver", "Location Of The Driver",
                        "Number Of First Positions", "Number Of Second Positions", "Number Of Third Positions", "Number Of Races"};

                JFrame frame01 = new JFrame("Generating A Random Race");
                JLabel label01, label02, label03, label04, label05, label06;

                JTable Table = new JTable(row, column);

                JScrollPane scrollPane = new JScrollPane(Table);


                label01 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                label01.setBounds(30, 300, 1000, 20);
                label01.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 13));

                label02 = new JLabel("DETAILS OF THE RACE");
                label02.setBounds(30, 320, 1000, 20);
                label02.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 13));

                label03 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                label03.setBounds(30, 340, 1000, 20);
                label03.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 13));

                label04 = new JLabel("DATE OF THE RACE " + raceDate[empty] + " " + raceMonth[empty] + " " + raceYear[empty]);
                label04.setBounds(60, 360, 1000, 20);
                label04.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 12));

                label05 = new JLabel("PARTICIPANTS OF THE RACE");
                label05.setBounds(60, 380, 1000, 20);
                label05.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 12));

                label06 = new JLabel(raceParticipants[empty]);
                label06.setBounds(90, 400, 1000, 200);
                label06.setText("<html>" + raceParticipants[empty].replaceAll("\n", "<br/>") + "</html>"); // ... 15 Reference is used here ...
                label06.setFont(new Font("Verdana", Font.PLAIN, 12));
                label06.setVerticalAlignment(JLabel.TOP);

                JButton previous = new JButton("PREVIOUS");
                previous.setBounds(80, 700, 100, 32);

                JButton exit = new JButton("EXIT");
                exit.setBounds(1300, 700, 100, 32);


                previous.setBackground(buttonBackground01);
                exit.setBackground(buttonBackground01);
                previous.setForeground(buttonForeground01);
                exit.setForeground(buttonForeground01);

                frame01.add(label01);
                frame01.add(label02);
                frame01.add(label03);
                frame01.add(label04);
                frame01.add(label05);
                frame01.add(label06);
                frame01.add(previous);
                frame01.add(exit);
                frame01.add(scrollPane);

                frame01.setSize(1500,800);
                frame01.setVisible(true);
                fTitle.setVisible(false);

                // Button to exit the program
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frame01.dispose();
                    }

                });

                // Button to go to the previous menu frame
                previous.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frame01.dispose();
                        fTitle.setVisible(true);
                    }

                });

            }

        });


        //Generate a random a race with a starting position
        button05.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int numberOfDrivers = 0;

                for (int x = 0; x < driver.length; x++) {
                    if (!driver[x].getFirstNameOfTheDriver().equals("Not Found")) {
                        numberOfDrivers++;
                    }
                }

                int empty = 0;

                for (int a = 0; a < raceMonth.length; a++) { //Checking which index is empty to store the race details
                    if (raceMonth[a] == null) {
                        empty = a;
                        break;
                    }
                }

                raceParticipants[empty] = "";

                if (numberOfDrivers != 0) {
                    raceYear[empty] = 2021;

                    // ... 14 Reference is used below to generate a random month and date ...

                    int month = 1 + (int) (Math.random() * (12 - 1) + 1);

                    if (month == 1) {
                        String monthName = "JANUARY";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (31 - 1) + 1);
                        raceDate[empty] = date;

                    } else if (month == 2) {
                        String monthName = "FEBRUARY";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (28 - 1) + 1);
                        raceDate[empty] = date;

                    } else if (month == 3) {
                        String monthName = "MARCH";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (31 - 1) + 1);
                        raceDate[empty] = date;
                    } else if (month == 4) {
                        String monthName = "APRIL";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (30 - 1) + 1);
                        raceDate[empty] = date;

                    } else if (month == 5) {
                        String monthName = "MAY";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (31 - 1) + 1);
                        raceDate[empty] = date;

                    } else if (month == 6) {
                        String monthName = "JUNE";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (30 - 1) + 1);
                        raceDate[empty] = date;

                    } else if (month == 7) {
                        String monthName = "JULY";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (31 - 1) + 1);
                        raceDate[empty] = date;

                    } else if (month == 8) {
                        String monthName = "AUGUST";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (31 - 1) + 1);
                        raceDate[empty] = date;

                    } else if (month == 9) {
                        String monthName = "SEPTEMBER";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (30 - 1) + 1);
                        raceDate[empty] = date;

                    } else if (month == 10) {
                        String monthName = "OCTOBER";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (31 - 1) + 1);
                        raceDate[empty] = date;

                    } else if (month == 11) {
                        String monthName = "NOVEMBER";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (30 - 1) + 1);
                        raceDate[empty] = date;
                    } else if (month == 12) {
                        String monthName = "DECEMBER";
                        raceMonth[empty] = monthName;

                        int date = 1 + (int) (Math.random() * (31 - 1) + 1);
                        raceDate[empty] = date;
                    }
                }

                int max = numberOfDrivers;
                int min = 1;
                int position;
                int maxIndex = numberOfDrivers - 1;
                int minIndex = 0;

                ArrayList<Integer> positionNumbers = new ArrayList<>();
                ArrayList<Integer> startingPositionNumbers = new ArrayList<>();
                ArrayList<Integer> numbers = new ArrayList<>();
                ArrayList<Integer> nextPositionNumbers = new ArrayList<>();


                for (int x = 0; x < numberOfDrivers;x++) {
                    int startingPosition = (int) (Math.random() * (max - min + 1 ) + min); //Generating a random starting position
                    int random = 1 + (int) (Math.random() * (100 - 1) + 1); //Generating a random number from 1 - 100 to get the winning probability
                    boolean positionResult = false;

                    //Creating an algorithm to get the winning probability of each starting position
                    if (startingPosition == 1) {
                        if (random <= 40) {
                            positionNumbers.add(1);
                            positionResult = true;
                        }
                        else if (x == (numberOfDrivers - 1)){
                            if (!positionNumbers.contains(1)) {
                                positionNumbers.add(1);
                                positionResult = true;
                            }
                        }
                    }

                    if ((startingPosition == 2)){
                        if (random <= 30) {
                            if (!positionNumbers.contains(1)) {
                                positionNumbers.add(1);
                                positionResult = true;
                            }
                        }
                        else if (x == (numberOfDrivers - 1)){
                            if (!positionNumbers.contains(1)) {
                                positionNumbers.add(1);
                                positionResult = true;
                            }
                        }
                    }

                    if ((startingPosition == 3) || (startingPosition == 4)){
                        if (random <= 10) {
                            if (!positionNumbers.contains(1)) {
                                positionNumbers.add(1);
                                positionResult = true;
                            }
                        }
                        else if (x == (numberOfDrivers - 1)){
                            if (!positionNumbers.contains(1)) {
                                positionNumbers.add(1);
                                positionResult = true;
                            }
                        }
                    }

                    if ((startingPosition == 5) || (startingPosition == 6) || (startingPosition == 7) || (startingPosition == 8) || (startingPosition == 9)){
                        if (random <= 2) {
                            if (!positionNumbers.contains(1)) {
                                positionNumbers.add(1);
                                positionResult = true;
                            }
                        }
                        else if (x == (numberOfDrivers - 1)){
                            if (!positionNumbers.contains(1)) {
                                positionNumbers.add(1);
                                positionResult = true;
                            }
                        }
                    }

                    int index = (int) (Math.random() * (maxIndex - minIndex + 1 ) + minIndex); // Generating a random index to get a driver
                    if (positionResult) {
                        position = 1;
                    } else {
                        position = (int) (Math.random() * ( (maxIndex+1) - (minIndex+2) + 1 ) + (minIndex+2)); // Generating a random position for each driver
                    }

                    if(!numbers.contains(index) && !nextPositionNumbers.contains(position) && !startingPositionNumbers.contains(startingPosition)){
                        numbers.add(index);
                        startingPositionNumbers.add(startingPosition);
                        nextPositionNumbers.add(position);
                        raceParticipants[empty] = raceParticipants[empty] + "    DRIVER " + (x + 1) + " " + driver[index].getFirstNameOfTheDriver() + " " + driver[index].getSecondNameOfTheDriver() + " IN STARTING POSITION " + startingPosition + " CAME IN " + position + " POSITION." + "\n";
                        driver[index].setNumberOfRacesParticipatedIn(driver[index].getNumberOfRacesParticipatedIn() + 1);

                        //Calculating the number of points to be added for each driver
                        if (position == 1) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 25);
                            driver[index].setNumberOfFirstPositions(driver[index].getNumberOfFirstPositions() + 1);
                        } else if (position == 2) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 18);
                            driver[index].setNumberOfSecondPositions(driver[index].getNumberOfSecondPositions() + 1);
                        } else if (position == 3) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 15);
                            driver[index].setNumberOfThirdPositions(driver[index].getNumberOfThirdPositions() + 1);
                        } else if (position == 4) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 12);
                        } else if (position == 5) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 10);
                        } else if (position == 6) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 8);
                        } else if (position == 7) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 6);
                        } else if (position == 8) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 4);
                        } else if (position == 9) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 2);
                        } else if (position == 10) {
                            driver[index].setNumberOfPointsADriverHas(driver[index].getNumberOfPointsADriverHas() + 1);
                        }

                    }
                    else{
                        x--;
                    }

                }

                //Displaying of the formula 1 table and the generated race details

                // ... 12 Reference was used below to create a 2D array ...
                String[][] row = new String[numberOfDrivers][8];

                for (int a = 0; a < driver.length; a++){
                    if (!driver[a].getFirstNameOfTheDriver().equals("Not Found")) {
                        String numberOfPoints = String.valueOf(driver[a].getNumberOfPointsADriverHas());
                        row[a][0] = numberOfPoints;

                        row[a][1] = driver[a].getFirstNameOfTheDriver() + " " + driver[a].getSecondNameOfTheDriver();
                        row[a][2] = driver[a].getTheTeamOfTheDriver();
                        row[a][3] = driver[a].getLocationOfTheDriver();

                        String firstPositions = String.valueOf(driver[a].getNumberOfFirstPositions());
                        row[a][4] = firstPositions;

                        String secondPositions = String.valueOf(driver[a].getNumberOfSecondPositions());
                        row[a][5] = secondPositions;

                        String thirdPositions = String.valueOf(driver[a].getNumberOfThirdPositions());
                        row[a][6] = thirdPositions;

                        String numberOfRaces = String.valueOf(driver[a].getNumberOfRacesParticipatedIn());
                        row[a][7] = numberOfRaces;
                    }
                }

                String[] column ={"Number Of Points","Name Of The Driver","Team Of The Driver", "Location Of The Driver",
                        "Number Of First Positions", "Number Of Second Positions", "Number Of Third Positions", "Number Of Races"};

                JFrame frame01 = new JFrame("Generating A Random Race");
                JLabel label01, label02, label03, label04, label05, label06;

                JTable descendingTable = new JTable(row, column);

                descendingTable.setLocation(100, 100);
                descendingTable.setBounds(100, 100, 1500, 400);

                JScrollPane scrollPane = new JScrollPane(descendingTable);


                label01 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                label01.setBounds(30, 300, 1000, 20);
                label01.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 13));

                label02 = new JLabel("DETAILS OF THE RACE");
                label02.setBounds(30, 320, 1000, 20);
                label02.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 13));

                label03 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                label03.setBounds(30, 340, 1000, 20);
                label03.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 13));

                label04 = new JLabel("DATE OF THE RACE " + raceDate[empty] + " " + raceMonth[empty] + " " + raceYear[empty]);
                label04.setBounds(60, 360, 1000, 20);
                label04.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 12));

                label05 = new JLabel("PARTICIPANTS OF THE RACE");
                label05.setBounds(60, 380, 1000, 20);
                label05.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 12));

                label06 = new JLabel(raceParticipants[empty]);
                label06.setBounds(90, 400, 1000, 1000);
                label06.setText("<html>" + raceParticipants[empty].replaceAll("\n", "<br/>") + "</html>"); // ... 15 Reference is used here ...
                label06.setFont(new Font("Verdana", Font.PLAIN, 12));
                label06.setVerticalAlignment(JLabel.TOP);

                JButton previous = new JButton("PREVIOUS");
                previous.setBounds(80, 700, 100, 32);

                JButton exit = new JButton("EXIT");
                exit.setBounds(1300, 700, 100, 32);


                previous.setBackground(buttonBackground01);
                exit.setBackground(buttonBackground01);
                previous.setForeground(buttonForeground01);
                exit.setForeground(buttonForeground01);

                frame01.add(label01);
                frame01.add(label02);
                frame01.add(label03);
                frame01.add(label04);
                frame01.add(label05);
                frame01.add(label06);
                frame01.add(previous);
                frame01.add(exit);
                frame01.add(scrollPane);

                frame01.setSize(1500,800);
                frame01.setVisible(true);
                fTitle.setVisible(false);

                // Button to exit the program
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frame01.dispose();
                    }

                });

                // Button to go to the previous menu frame
                previous.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frame01.dispose();
                        fTitle.setVisible(true);
                    }

                });

            }
        });


        // Display all completed races
        button06.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Integer[] raceMonthNumber = new Integer[50];

                Arrays.fill(raceMonthNumber, 100);

                for (int x = 0; x < raceMonth.length; x++){
                    if (raceMonth[x] == null){
                        raceMonthNumber[x] = 100;
                    }
                    else if(raceMonth[x].equals("JANUARY")){
                        raceMonthNumber[x] = 1;
                    }
                    else if (raceMonth[x].equals("FEBRUARY")){
                        raceMonthNumber[x] = 2;
                    }
                    else if (raceMonth[x].equals("MARCH")){
                        raceMonthNumber[x] = 3;
                    }
                    else if (raceMonth[x].equals("APRIL")){
                        raceMonthNumber[x] = 4;
                    }
                    else if (raceMonth[x].equals("MAY")){
                        raceMonthNumber[x] = 5;
                    }
                    else if (raceMonth[x].equals("JUNE")){
                        raceMonthNumber[x] = 6;
                    }
                    else if (raceMonth[x].equals("JULY")){
                        raceMonthNumber[x] = 7;
                    }
                    else if (raceMonth[x].equals("AUGUST")){
                        raceMonthNumber[x] = 8;
                    }
                    else if (raceMonth[x].equals("SEPTEMBER")){
                        raceMonthNumber[x] = 9;
                    }
                    else if (raceMonth[x].equals("OCTOBER")){
                        raceMonthNumber[x] = 10;
                    }
                    else if (raceMonth[x].equals("NOVEMBER")){
                        raceMonthNumber[x] = 11;
                    }
                    else if (raceMonth[x].equals("DECEMBER")){
                        raceMonthNumber[x] = 12;
                    }
                    else{
                        raceMonthNumber[x] = 100;
                    }
                }

                String  temp01;
                int temp02;
                int temp03;
                String temp04;
                int temp05;

                for (int i = 0; i < raceMonth.length; i++) {

                    for (int j = i + 1; j < raceMonth.length; j++) {

                        if ((raceMonthNumber[i]) > (raceMonthNumber[j])) {
                            temp01 = raceMonth[i];
                            raceMonth[i] = raceMonth[j];
                            raceMonth[j] = temp01;

                            temp02 = raceMonthNumber[i];
                            raceMonthNumber[i] = raceMonthNumber[j];
                            raceMonthNumber[j] = temp02;

                            temp03 = raceDate[i];
                            raceDate[i] = raceDate[j];
                            raceDate[j] = temp03;

                            temp04 = raceParticipants[i];
                            raceParticipants[i] = raceParticipants[j];
                            raceParticipants[j] = temp04;

                            temp05 = raceYear[i];
                            raceYear[i] = raceYear[j];
                            raceYear[j] = temp05;

                        }

                        else if (raceMonthNumber[i].equals(raceMonthNumber[j])) {
                            if((raceDate[i]) > (raceDate[j])) {
                                temp03 = raceDate[i];
                                raceDate[i] = raceDate[j];
                                raceDate[j] = temp03;

                                temp04 = raceParticipants[i];
                                raceParticipants[i] = raceParticipants[j];
                                raceParticipants[j] = temp04;

                            }
                        }
                    }

                }

                JFrame frame01 =new JFrame("Displaying All Races In Ascending Order");

                JLabel label01, label02, label03, label04, label05, label06, label07, label;

                JButton previous = new JButton("PREVIOUS");
                previous.setBorder(new EmptyBorder(new Insets(5, 15, 5, 15)));
                previous.setBounds(50, 50, 100, 32);

                JLabel space = new JLabel("");
                space.setBorder(new EmptyBorder(new Insets(5, 10, 5, 10)));

                JButton exit = new JButton("EXIT");
                exit.setBorder(new EmptyBorder(new Insets(5, 20, 5, 20)));
                exit.setBounds(1100, 50, 100, 32);

                previous.setBackground(buttonBackground01);
                exit.setBackground(buttonBackground01);
                previous.setForeground(buttonForeground01);
                exit.setForeground(buttonForeground01);

                JPanel container = new JPanel();

                // ... 07 & 16 Reference is used below to create a box layout ...
                BoxLayout boxlayout = new BoxLayout(container, BoxLayout.Y_AXIS);
                container.setLayout(boxlayout);

                container.setBorder(new EmptyBorder(new Insets(60, 30, 50, 30)));

                JPanel containerButtons = new JPanel();

                // ... 07 & 16 Reference is used below to create a box layout ...
                BoxLayout boxlayoutButtons = new BoxLayout(containerButtons, BoxLayout.X_AXIS);
                containerButtons.setLayout(boxlayoutButtons);

                containerButtons.add(previous);
                containerButtons.add(space);
                containerButtons.add(exit);

                if(raceMonth[0] == null && raceDate[0] == 0 && raceParticipants[0] == null && raceYear[0] == 0){ // In case there are no races in the system
                    label01 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    label01.setBounds(50, 120, 1000, 20);

                    label02 = new JLabel("THERE ARE NO RACES ADDED OR GENERATED IN THE SYSTEM");
                    label02.setBounds(50, 140, 1000, 20);

                    label03 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    label03.setBounds(50, 160, 1000, 20);

                    label = new JLabel("");
                    label.setBounds(50, 180, 1000, 20);

                    frame01.add(previous);
                    frame01.add(exit);
                    frame01.add(label01);
                    frame01.add(label02);
                    frame01.add(label03);
                    frame01.add(label);
                }

                else {
                    container.add(containerButtons);

                    label01 = new JLabel("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    label01.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 13));
                    label01.setBorder(new EmptyBorder(new Insets(50, 0, 0, 0)));

                    label02 = new JLabel("DETAILS ABOUT THE RACES");
                    label02.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 13));

                    label03 = new JLabel("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    label03.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 13));

                    container.add(label01);
                    container.add(label02);
                    container.add(label03);

                    for (int n = 0; n < raceDate.length; n++) {
                        if ((raceDate[n] != 0) && (!raceMonth[n].equals("Not Found")) && (raceYear[n] != 0) && (!raceParticipants[n].equals(""))) {
                            label04 = new JLabel("DATE OF THE RACE " + raceDate[n] + " " + raceMonth[n] + " " + raceYear[n]);
                            label04.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 13));
                            label04.setBorder(new EmptyBorder(new Insets(5, 30, 0, 0)));

                            label05 = new JLabel("PARTICIPANTS OF THE RACE");
                            label05.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 13));
                            label05.setBorder(new EmptyBorder(new Insets(5, 30, 0, 0)));

                            label06 = new JLabel(raceParticipants[n]);
                            label06.setFont(new Font("Verdana", Font.PLAIN, 12));
                            label06.setText("<html>" + raceParticipants[n].replaceAll("\n", "<br/>") + "</html>"); // ... 15 Reference is used here ...
                            label06.setBorder(new EmptyBorder(new Insets(5, 60, 0, 0)));

                            label07 = new JLabel("------------------------------------------------------------------------------------------------------------------------------------------------");
                            label07.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 13));
                            label07.setBorder(new EmptyBorder(new Insets(5, 30, 0, 0)));

                            container.add(label04);
                            container.add(label05);
                            container.add(label06);
                            container.add(label07);

                        }
                    }


                    // ... 17 Reference used below to create a scrollPane
                    JScrollPane scrollableArea = new JScrollPane(container);

                    scrollableArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    scrollableArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                    frame01.add(scrollableArea);


                }

                frame01.setSize(1300,800);
                frame01.setVisible(true);
                fTitle.setVisible(false);


                // Button to exit the program
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frame01.dispose();
                    }

                });

                // Button to go the previous menu frame
                previous.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frame01.dispose();
                        fTitle.setVisible(true);
                    }

                });
            }
        });


        // To display all races completed by a specific driver
        button07.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String fName = field01.getText();
                fName = fName.toUpperCase();
                String sName = field02.getText();
                sName = sName.toUpperCase();

                boolean result = true;

                for(int x = 0; x < driver.length;x++){
                    if(driver[x].getFirstNameOfTheDriver().equals(fName) && driver[x].getSecondNameOfTheDriver().equals(sName)){
                        result = true;
                        break;
                    }
                    else{
                        result = false;
                    }
                }

                JFrame frame01 =new JFrame("Displaying All Races Participated By A Driver");
                JLabel label01, label02, label03, label;

                JButton previous = new JButton("PREVIOUS");
                previous.setBounds(50, 50, 100, 32);
                previous.setBorder(new EmptyBorder(new Insets(5, 15, 5, 15)));

                JLabel space = new JLabel("");
                space.setBorder(new EmptyBorder(new Insets(5, 10, 5, 10)));

                JButton exit = new JButton("EXIT");
                exit.setBounds(800, 50, 100, 32);
                exit.setBorder(new EmptyBorder(new Insets(5, 20, 5, 20)));

                previous.setBackground(buttonBackground01);
                exit.setBackground(buttonBackground01);
                previous.setForeground(buttonForeground01);
                exit.setForeground(buttonForeground01);

                JPanel container = new JPanel();

                // ... 07 & 16 Reference used below to create a box layout
                BoxLayout boxlayout = new BoxLayout(container, BoxLayout.Y_AXIS);
                container.setLayout(boxlayout);

                container.setBorder(new EmptyBorder(new Insets(60, 30, 50, 30)));

                JPanel containerButtons = new JPanel();

                // ... 07 & 16 Reference is used below to create a box layout ...
                BoxLayout boxlayoutButtons = new BoxLayout(containerButtons, BoxLayout.X_AXIS);
                containerButtons.setLayout(boxlayoutButtons);

                containerButtons.add(previous);
                containerButtons.add(space);
                containerButtons.add(exit);

                if(!result){ // In case there are no drivers

                    label01 = new JLabel("-------------------------------------------------------------------------------------------------------------");
                    label01.setBounds(50, 120, 1000, 20);

                    label02 = new JLabel("THERE IS NO DRIVER BY THE NAME  " + fName + " " + sName + " IN THE SYSTEM.");
                    label02.setBounds(50, 140, 1000, 20);

                    label03 = new JLabel("-------------------------------------------------------------------------------------------------------------");
                    label03.setBounds(50, 160, 1000, 20);

                    label = new JLabel("");
                    label.setBounds(50, 180, 1000, 20);

                    frame01.add(previous);
                    frame01.add(exit);

                    frame01.add(label01);
                    frame01.add(label02);
                    frame01.add(label03);
                    frame01.add(label);


                }

                if(result){

                    container.add(containerButtons);

                    JLabel label04, label05, label06;

                    label01 = new JLabel("-------------------------------------------------------------------------------------------------------------");
                    label01.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 13));
                    label01.setBorder(new EmptyBorder(new Insets(50, 0, 0, 0)));

                    label02 = new JLabel("DETAILS OF THE RACES OF THE DRIVER " + fName + " " + sName);
                    label02.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 13));

                    label03 = new JLabel("-------------------------------------------------------------------------------------------------------------");
                    label03.setFont(new Font("Verdana", Font.PLAIN | Font.BOLD, 13));

                    container.add(label01);
                    container.add(label02);
                    container.add(label03);

                    for(int y=0; y < raceParticipants.length; y++){
                        if(raceParticipants[y] != null) {
                            if (raceParticipants[y].contains(fName) && raceParticipants[y].contains(sName)) {
                                int number = raceParticipants[y].indexOf((fName));
                                number = number - 2;
                                String position = raceParticipants[y].substring(number, (number + 1)); // ... 18 Reference used here to get the index value of the position...

                                label04 = new JLabel("Date of the Race : " + raceDate[y] + " " + raceMonth[y] + " " + raceYear[y] + ".");
                                label04.setFont(new Font("Verdana", Font.PLAIN, 13));
                                label04.setBorder(new EmptyBorder(new Insets(5, 30, 0, 0)));

                                label05 = new JLabel("Position Of The Driver In The Above Race is " + position + " Position.");
                                label05.setFont(new Font("Verdana", Font.PLAIN, 13));
                                label05.setBorder(new EmptyBorder(new Insets(5, 30, 0, 0)));

                                label06 = new JLabel("--------------------------------------------------------------------------------------------------------");
                                label06.setFont(new Font("Verdana", Font.PLAIN, 13));
                                label06.setBorder(new EmptyBorder(new Insets(5, 30, 0, 0)));

                                container.add(label04);
                                container.add(label05);
                                container.add(label06);
                            }
                        }
                    }

                    // ... 17 Reference is used below to create a scrollPane
                    JScrollPane scrollableArea = new JScrollPane(container);

                    scrollableArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    scrollableArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                    frame01.add(scrollableArea);

                }

                field01.setText(" First Name ...");
                field02.setText(" Second Name ...");

                frame01.setSize(1000,800);
                frame01.setVisible(true);
                fTitle.setVisible(false);

                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frame01.dispose();
                        fTitle.dispose();
                    }

                });

                previous.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frame01.dispose();
                        fTitle.setVisible(true);
                    }

                });
            }
        });

        button08.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fTitle.setVisible(false);
            }
        });
    }
}

