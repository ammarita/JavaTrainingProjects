package mazerunnerapp;
/*
This is aprogram that navigates through a given maze.
The code for the Maze is already written, and provided in "Maze.java".
Students need to write the code that uses Maze and decides how to move through it.
 */

import java.util.Scanner;

public class MazeRunnerApp {
    Scanner sc = new Scanner(System.in);
    Maze maze = new Maze();

    public void intro() {
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        maze.printMap();
    }

    public String move() {
        String move = "";
        while(!move.equalsIgnoreCase("r") || !move.equalsIgnoreCase("l") || !move.equalsIgnoreCase("u") || !move.equalsIgnoreCase("d")) {
            System.out.print("Where would you like to move? (R, L, U, D) ");
            move = sc.next();
        }
        return move;
    }

    
}
