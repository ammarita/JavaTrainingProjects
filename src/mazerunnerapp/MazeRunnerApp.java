package mazerunnerapp;
/*
This is a program that navigates through a given maze.
The code for the Maze is already written, and provided in "Maze.java".
Students need to write the code that uses Maze and decides how to move through it.
 */

import java.util.Scanner;

public class MazeRunnerApp {
    private static Scanner sc = new Scanner(System.in);
    private static Maze maze = new Maze();
    private static String move;

    public static void main(String[] args) {
        intro();
        play();
    }

    private static void intro() {
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        maze.printMap();
    }

    private static String move() {
        while(!move.equalsIgnoreCase("r") || !move.equalsIgnoreCase("l") || !move.equalsIgnoreCase("u") || !move.equalsIgnoreCase("d")) {
            System.out.print("Where would you like to move? (R, L, U, D) ");
            move = sc.next();
        }
        return move;
    }

    private static void checkMove(String move) {
        switch (move.toUpperCase()) {
            case "R":
                if(maze.canIMoveRight()) {
                    maze.moveRight();
                } else {
                    System.out.println("Sorry, you've hit a wall");
                }
                break;
            case "L":
                if(maze.canIMoveLeft()) {
                    maze.moveLeft();
                } else {
                    System.out.println("Sorry, you've hit a wall");
                }
                break;
            case "U":
                if(maze.canIMoveUp()) {
                    maze.moveUp();
                } else {
                    System.out.println("Sorry, you've hit a wall");
                }
                break;
            case "D":
                if(maze.canIMoveDown()) {
                    maze.moveDown();
                } else {
                    System.out.println("Sorry, you've hit a wall");
                }
                break;
        }
        maze.printMap();
    }

    private static void play() {
        while (!maze.didIWin()) {
            move();
            checkMove(move);
        }
    }

}
