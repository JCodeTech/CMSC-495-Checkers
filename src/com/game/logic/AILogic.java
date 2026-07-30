package com.game.logic;

// To approach the AI logic, we need to create methods that replicate how we think when deciding which checker to move.
// We can simplify it to run a for loop that checks every black checker to see if it has a free space to move to and move it to that space if it is available.
// We also need to consider capture moves.
// Example, AI selects a black checker, the method then looks for valid move spaces, at the same time if a move is invalid due to another checker is present in the space it would
// move to it will check the color of that checker and if that checker is red it will then check the next space that would capture that checker to see if its available to move to.

public class AILogic {



}