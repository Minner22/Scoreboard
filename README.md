# Scoreboard

## Project Description

Scoreboard is a simple Java library for managing the scoreboard of football matches. It allows you to add games, update scores, remove finished games, and generate summaries of the results sorted by total scores, with games added later being ranked higher in case of a tie.

## Features

1. **Start a game** – adds a new game with an initial score of 0-0.
2. **Finish a game** – removes a selected game from the scoreboard.
3. **Update score** – updates the score of an existing game.
4. **Summary** – returns a sorted list of games by total score (from highest to lowest), and in case of a tie, the game added later will be ranked higher.

## Assumptions and Notes

1. **Uniqueness of team names**: It is assumed that team names will be unique, allowing for easy identification of teams when updating scores. If this assumption is violated, a unique identifier for teams would be necessary.
2. **No data persistence**: The implementation does not store data in a database or files. All data is stored in memory, meaning that all data is lost when the program finishes executing.
3. **Tie-breaking**: If two games have the same total score, the game that was added later will appear higher in the ranking. This aligns with the requirements of the project.
4. **Error handling**: There is no additional validation for incorrect data (e.g., negative scores) as it is assumed that input data will always be correct.
5. **Java version**: The project was created with Java 21 in mind. If an older version of Java is used, the code might need to be adapted.

## Example

If the current data in the scoreboard is as follows:
1. Mexico - Canada: 0 – 5
2. Spain - Brazil: 10 – 2
3. Germany - France: 2 – 2
4. Uruguay - Italy: 6 – 6
5. Argentina - Australia: 3 - 1


The summary will return the results in the following order:

1. Uruguay 6 - Italy 6
2. Spain 10 - Brazil 2
3. Mexico 0 - Canada 5
4. Argentina 3 - Australia 1
5. Germany 2 - France 2

## Project Structure

The project consists of the following classes:

- **Scoreboard**: The main class responsible for managing the games and their scores.
- **Game**: Represents a single match between two teams, including their names and scores.
- **GameComparator**: A class that compares games based on the total score. In case of a tie, it returns `-1` to rank games added later higher.

## Requirements

- Java 21 or later
- Maven (for dependency management and project compilation)

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Minner22/Scoreboard
2. Navigate to the project directory:
   ```bash
   cd Scoreboard
3. Build the project using Maven:
   ```bash
   mvn clean install

## Usage
Example Code:
  ```java
  public class Main {
    public static void main(String[] args) {
        Scoreboard scoreboard = new Scoreboard();
        
        scoreboard.startGame("Mexico", "Canada");
        scoreboard.updateScore("Mexico", "Canada", 0, 5);
        scoreboard.startGame("Spain", "Brazil");
        scoreboard.updateScore("Spain", "Brazil", 10, 2);
        scoreboard.startGame("Germany", "France");
        scoreboard.updateScore("Germany", "France", 2, 2);
        
        List<Game> summary = scoreboard.getSummary();
        summary.forEach(System.out::println);
    }
  }
  ```
Output:
  ```
  Spain 10 - Brazil 2
Mexico 0 - Canada 5
Germany 2 - France 2
```

## Testing

The project follows the TDD (Test-Driven Development) approach. Unit tests cover:
  - Adding a game
  - Updating the score of a game
  - Removing a game from the scoreboard
  - Retrieving the summary and verifying the sorting order

Tests can be run using:
  ```bash
  mvn test
  ```

