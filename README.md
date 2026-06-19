# README
This file is to help aid in the direction, planning, and understanding of the project goal.
This file will not be included in the final production.

# Checkers Game (Java)

A Java implementation of the classic Checkers game, featuring both Human vs. Human and Human vs. AI gameplay modes.

# Authors

* Joseph Romano - [JCodeTech](https://github.com/JCodeTech)
* Alexander Egan - [GITHUB USERNAME HERE]
* Pavel Parada - [GITHUB USERNAME HERE]

# Project Overview

This project is a Java-based implementation of Checkers.

# Dependencies
* Project is utilizing openjdk-26 (JDK 26 equivalent)
* To work on this project and ensuring compatibility, utilize primarily JDK 26 
* You may use equivalent versions of the JDK.
* Communicate with other collaborators about which development kit you are using to prevent compatibility issues. 

# Core Game Logic (Pseudocode)

The following pseudocode outlines the primary execution flow of the game:

# 1. Initialization
* Initialize the `Board` with pieces in their starting positions.
* Set up the `Window` to render the graphical interface.
* Load the `Menu` to allow players to select a game mode (Human vs. Human or Human vs. AI etc.).

# 2. Game Loop
While the game is active:
1.  * Identify Current Player: Determine if it is the turn of the Human or AI player.
2.  * Input:
        * If Human: Wait for user input (selecting a starting square and a destination square).
        * If AI: Let the AI determine the next move.
3.  * Move Validation:
        * Utilize the `Move` object for checker moves.
        * Use `GameRules` to list all available spaces to move to by checking the objects around the current selection(e.g., within bounds, correct direction).
4.  * State Update:
        * If Move is Valid:
           * Update the `Board` with the piece's new position.
           * Check for captures: If a piece was jumped, remove the captured `Checker` from the board.
           * Check for promotions: If a piece reaches the opposite end, promote it to a King.
           * Refresh the `Window` to reflect the updated state.
    * If Move is Invalid:
        * Trigger a `GameException` or notify the user of an illegal move.
5.  * Win/Loss Condition Check:
        * If a player has no remaining pieces: Declare Winner.
        * If a player has no legal moves left: Declare Loss/Draw.
6.  * Switch Turn: Proceed to the next player's turn.
        * The `Controller` should keep track of who's turn it is and determine when it's the next players turn.

# Key Components

* `Board`: Manages the 8x8 grid and piece positions.
* `Checker`: Represents individual pieces with color and position attributes.
* `GameRules`: Contains the logic for movement, captures, and victory conditions.
* `AI`: Implements decision-making algorithms for the computer opponent.
* `Window`: The graphical user interface (GUI) component for rendering the game.

# Documentation
* The following documentations are provided:

1. [Project Plan](docs/Project%20Plan%20Group%202.docx)
2. [Prject Desgin](https://umuc365-my.sharepoint.com/:w:/g/personal/aegan5_student_umgc_edu/IQCuFd91cb-LQbvmqr_lN_k2AUE18jf4C8Lm0Ocm2mhyIjs?e=529nh5) Due ***June 26th 2026***
3. [Phase I Source]() TO BE IMPLEMENTED - ***June 24th 2026***
4. [Test Plan]() TO BE IMPLEMENTED - Due ***July 8th 2026***
5. [Phase II Source]() TO BE IMPLEMENTED - Due ***July 15th 2026***
6. [User Guide]() TO BE IMPLEMENTED - Due ***July 22nd 2026***
7. [Final Document]() TO BE IMPLEMENTED - Due ***August 4th 2026***