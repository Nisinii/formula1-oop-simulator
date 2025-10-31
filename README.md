# Formula 1 Championship Manager

A comprehensive Formula 1 championship simulation application built in Java. This project features a full console-based management system for drivers and teams, as well as a dynamic GUI built from scratch with Java Swing for data visualization and race simulation.

## ✨ Key Features

The application is split into two main parts: a console-based management system and a Swing-based GUI.

### Console Management System

* **Create Driver:** Add a new driver and assign them to a unique constructor team.
* **Delete Driver:** Remove a driver and their associated team from the championship.
* **Change Driver:** Assign a new driver to an existing constructor team.
* **Display Statistics:** View detailed statistics for a selected driver.
* **Display F1 Table:** Show the main driver table, sorted in descending order by points. [cite_start]Ties are broken by the number of first-place wins.
* **Add a Race:** Manually enter the date and finishing positions for a completed race, which automatically updates all driver statistics and points.
* **Save Data:** Save the current state of the championship (drivers, teams, races) to a file.
* **Load Data:** Automatically load the previously saved data when the application starts.

### GUI Dashboard (Java Swing)

* **View Driver Table:** Displays all drivers and their statistics in a sortable table.
* **Sort by Points (Ascending):** Sorts the table to show drivers with the fewest points first.
* **Sort by 1st Place (Descending):** Sorts the table to show drivers with the most first-place wins.
* **Generate Random Race:** Adds a new race with completely random finishing positions for all drivers and updates the table.
* **Generate Probabilistic Race:**
    * Assigns random starting positions to all drivers.
    * Calculates the race winner based on a weighted probability (e.g., P1 has a 40% win chance, P2 has 30%, etc.).
    * Randomly assigns the remaining 2nd-10th place positions.
* **View All Races:** Displays a list of all completed races, sorted in ascending order by date.
* **Search Driver:** Provides a text box to search for a specific driver and displays all races they participated in, including their position and the date.

## 🛠️ Tech Stack

* **Core Language:** Java
* **GUI:** Java Swing (built manually without drag-and-drop tools)
* **Core Concepts:**
    * Object-Oriented Programming (OOP) 
    * Abstract Classes and Interfaces
    * Data Persistence (File I/O for saving/loading)
    * Data Structures & Sorting (Collections, Comparators)
    * Event-Driven Programming (Swing ActionListeners)
