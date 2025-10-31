import java.util.Scanner;

public class Main {
    public static boolean Formula1DriverMenu;

    public static void main(String[] args) {
        Formula1ChampionshipManager driverObj = new Formula1ChampionshipManager();
        Scanner input = new Scanner(System.in);

        boolean loop;

        //Procedure to initialize values to the array Formula1Driver
        driverObj.InitialiseValues();

        //Procedure to load previously saved Information to the array Formula1Driver
        driverObj.LoadFileAtStart();

        //Display formula 1 details
        System.out.println("\n");
        System.out.println("\033[0;1mCHAMPIONSHIP OF THE FORMULA 1 2021\033[0m");
        System.out.println("\033[0;1mPRIZE WON BY THE F1 CHAMPION IS $66 million (£48 million)\033[0m");
        System.out.println("\033[0;1mPRIZE WON BY THE F1 PARTICIPANTS IS $15 million (£11 million)\033[0m");

        Formula1DriverMenu = true;

        //Creating the menu
        while (Formula1DriverMenu) {
            System.out.println("\nPLEASE SELECT ONE OF THE FOLLOWING OPTIONS FROM THE MENU...");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.println("[1] : Add A New Driver To Compete In The Formula 1 Championship.");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.println("[2] : Delete A Driver From The Formula 1 Championship Along With His/Her Team (Car Manufacturer).");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.println("[3] : Change The Driver's Name (Including Other Details) For An Existing Constructor Team (Car Manufacturer).");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.println("[4] : Display The Statistics Of A Selected Existing Formula 1 Driver.");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.println("[5] : Display The Formula 1 Drivers Table (Which Include All The Details And Statistics Of A Driver).");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.println("[6] : Add The Final Results Of A Race.");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.println("[7] : Save The Newly Updated Information Into File Program.");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.println("[8] : Load The Previously Saved Information From File Program");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.println("[9] : Start Graphical User Interface (GUI) Menu Based On Java Swing");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.println("[10] : Newly Start The Program Discontinuing From The Saved Information.");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.println("[11] : Exit The Program");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.println("THANK YOU!");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.print("\nPLEASE ENTER YOUR SELECTED CHOICE FROM THE MENU (EITHER 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 OR 11): ");

            String SelectedOption = input.next();
            SelectedOption = SelectedOption.toUpperCase();
            System.out.println("-------------------------------------------------------------------------------------------------------------");

            switch (SelectedOption) {

                case "1":
                    //Procedure to add a new driver to the formula 1 championship
                    driverObj.AddDriver();
                    loop = true;
                    break;

                case "2":
                    //Procedure to delete a driver along with his/her team details
                    driverObj.DeleteDriver();
                    loop = true;
                    break;

                case "3":
                    //Procedure to change the drivers name and other details for an existing constructor team
                    driverObj.ChangeDriverForConstructorTeam();
                    loop = true;
                    break;

                case "4":
                    //Procedure to display statistics of an existing driver
                    driverObj.DisplayStatisticsOfExistingDriver();
                    loop = true;
                    break;

                case "5":
                    //Procedure to display the formula 1 drivers table
                    driverObj.ViewDriversTable();
                    loop = true;
                    break;

                case "6":
                    //Procedure to add final results of a race
                    driverObj.AddRaceWithItsDetails();
                    loop = true;
                    break;

                case "7":
                    //Procedure to save newly updated information into a file program
                    driverObj.SaveUpdatedInformationToFile();
                    loop = true;
                    break;

                case "8":
                    //Procedure to load the previously saved information from file program
                    driverObj.LoadSavedInformationFromFile();
                    loop = true;
                    break;

                case "9":
                    //Procedure to load the previously saved information from file program
                    driverObj.Frame01();
                    loop = true;
                    break;

                case "10":
                    //Procedure to load the previously saved information from file program
                    driverObj.InitialiseValues();
                    System.out.println("\n-------------------------------------------------------------------------------------------------------------");
                    System.out.println("The System Has Been Newly Initialised Values\nThe Program Will Continue Without Considering The Existing Data");
                    System.out.println("-------------------------------------------------------------------------------------------------------------");

                    loop = true;
                    break;

                case "11":
                    //Procedure to load the previously saved information from file program
                    System.out.println("\n-------------------------------------------------------------------------------------------------------------");
                    System.out.println("Thank You for Choosing Our System!");
                    System.out.println("-------------------------------------------------------------------------------------------------------------");
                    loop = false;
                    break;

                default:
                    System.out.println("Invalid Selection");
                    loop = true;
                    break;
            }

            if (loop) {
                System.out.println("\n-------------------------------------------------------------------------------------------------------------");
                System.out.println("Would you like to Select another Option\n1 : Yes\n2 : No");
                System.out.println("-------------------------------------------------------------------------------------------------------------");
                System.out.print("\nPlease Enter Your Choice: ");
                String output = input.next().toUpperCase();

                if (output.equals("1") || output.equals("YES")) {
                    System.out.println("\n-------------------------------------------------------------------------------------------------------------\n");
                    Formula1DriverMenu = true;
                } else if (output.equals("2") || output.equals("NO")) {
                    Formula1DriverMenu = false;
                    System.out.println("\n-------------------------------------------------------------------------------------------------------------");
                    System.out.println("Thank You for Choosing Our System!");
                    System.out.println("-------------------------------------------------------------------------------------------------------------");
                }
                else{
                    System.out.println("\n--- Invalid Selection ---");
                }
            } else {
                Formula1DriverMenu = false;

            }
        }
    }

}
