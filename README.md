# Tic Tac Toe Game

## Overview

This is a simple Tic Tac Toe game implemented in Java using the Swing framework for the graphical user interface. Players can take turns to mark their symbols ('X' or 'O') on a 3x3 grid, and the game checks for a winner or a draw after each move.

## Features

- Play against another player in a two-player mode.
- Automatic detection of win conditions (three in a row either horizontally, vertically, or diagonally).
- Ability to declare a draw if the board is full without a winner.
- Reset button to restart the game.

## Requirements

- Java Development Kit (JDK) version 8 or higher.
- An IDE or text editor to compile and run the Java code.

## Installation

1. Ensure you have the JDK installed on your system.
2. Clone this repository or download the `tictactoe.java` file to your local machine.
3. Open the `tictactoe.java` file in your favorite IDE or text editor.

## Compiling and Running the Game

To compile and run the Tic Tac Toe game:

1. Open a terminal (command prompt).
2. Navigate to the directory where your `tictactoe.java` file is located.
3. Compile the Java file using the following command:

   ```bash
   javac tictactoe.java
   ```

4. Run the compiled Java program:

   ```bash
   java TicTacToe
   ```

## How to Play

1. When the game starts, the first player ('X') is indicated as the current player.
2. Click any empty cell in the 3x3 grid to place your symbol.
3. The game alternates between players after each move.
4. The game announces the winner as soon as a player aligns three of their symbols, or it declares a draw if all cells are filled with no winner.
5. To restart the game, click the "Reset" button.

## Code Structure

- **Enum `Player`**: Represents the two players, `X` and `O`.
- **Class `TicTacToe`**: Contains the main game logic, GUI creation, event handling, and game management.
  - **Fields**: `frame`, `currentPlayerField`, `buttons`, `resetButton`, `cellState`, `moveCount`, `currentPlayer`.
  - **Methods**:
    - `actionPerformed(ActionEvent e)`: Handles button clicks and manages game state.
    - `updateButton(int row, int col)`: Updates the button display after a player's move.
    - `checkWinCondition()`: Checks for win or draw conditions.
    - `declareWinner(int player)`: Declares the winner and disables further moves.
    - `resetGame()`: Resets the game to the initial state.

## Acknowledgements

This implementation uses Java Swing for the graphical interface. The game logic is based on the classic rules of Tic Tac Toe.

Feel free to contribute by putting forth an issue, or forking the repository and submitting a pull request!

Enjoy playing Tic Tac Toe!
