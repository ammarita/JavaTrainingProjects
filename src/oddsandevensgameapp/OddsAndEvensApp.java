package oddsandevensgameapp;
/*
For this project you are going to program a game called "Odds and Evens".
The game is similar to rock paper scissors. It is played between two players,
in your version it will be you versus the computer. Each player will choose either "odds" or "evens",
since you’re playing the computer you will get first pick. Once you have chosen your side,
you each choose a number of fingers to play- 0 to 5.
The winner is determined by whether the sum of your fingers is odd or even (depending on what you chose).
 */

import java.util.Random;
import java.util.Scanner;

public class OddsAndEvensApp {
    static Scanner sc = new Scanner(System.in);
    private static String name;
    private static int user;
    private static int computer;

    public static void main(String[] args) {
        startGame();
        playGame();
        isOddOrEven();
        chooseWinner();
    }

    private static void startGame() {
        System.out.println("Let's play a game called \"Odds and Evens\"");
        System.out.print("What is your name? ");
        name = sc. nextLine();
        System.out.print("Hi " + name + "! Which do you choose? (O)dds or (E)vens: ");
        String choice = sc.nextLine();
        acceptChoice(choice);
        System.out.println("-----------------------------------\n");
    }

    private static void acceptChoice(String choice) {
        if(choice.equalsIgnoreCase("o")) {
            System.out.println(name + " has picked odds! The computer will be evens.");
        } else if (choice.equalsIgnoreCase("e")) {
            System.out.println(name + " has picked evens! The computer will be odds.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

    private static void playGame() {
        System.out.print("How many \"fingers\" do you put out? ");
        user = sc.nextInt();

        //computer randomly puts out "fingers"
        Random rand = new Random();
        computer = rand.nextInt(6);
        System.out.println("The computer plays " + computer + " \"fingers\".");
        System.out.println("-----------------------------------\n");
    }

    private static boolean isOdds() {
        return (user + computer) % 2 == 0;
    }

    private static void isOddOrEven() {
        System.out.println(user + " + " + computer + " = " + (user + computer));

        if(isOdds()) {
            System.out.println((user + computer) + " is ...odd!");
        } else {
            System.out.println((user + computer) + " is ...even!");
        }
    }

    private static void chooseWinner() {
        if(isOdds()) {
            if(user % 2 == 0) {
                System.out.println("The computer wins!");
            } else {
                System.out.println("You win!");
            }
        } else {
            if(user % 2 == 0) {
                System.out.println("You win!");
            } else {
                System.out.println("The computer wins!");
            }
        }
        System.out.println("-----------------------------------\n");
    }
}
