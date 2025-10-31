//Interface ChampionshipManager which contains abstract methods.
public interface ChampionshipManager {
    void InitialiseValues();
    void AddDriver();
    void DeleteDriver();
    void ChangeDriverForConstructorTeam();
    void DisplayStatisticsOfExistingDriver();
    void ViewDriversTable();
    void AddRaceWithItsDetails();
    void SaveUpdatedInformationToFile();
    void LoadSavedInformationFromFile();
    void LoadFileAtStart();
}