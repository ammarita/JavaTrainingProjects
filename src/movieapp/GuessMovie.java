package movieapp;

import java.util.Scanner;

public class GuessMovie {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String guess = "";
        Game game = new Game();

        System.out.println("Guess The Movie");
        System.out.println(game.movie);
        System.out.println(game.hideMovie());

        while(game.wrongGuesses.size() < 10) {
            System.out.println("Guess the Movie: " + game.hideMovie());
            System.out.println("You have guessed (" + game.wrongGuesses.size() + ") wrong letters: " + game.wrongGuesses);
            System.out.print("Guess a letter: ");
            guess = input.next();
            game.checkGuess(guess);
        }

        if(game.wrongGuesses.size() >= 10) {
            System.out.println("You lost!" +
                    "\nYou did not guessed '" + game.movie + "' correctly.");
        }

    }//end main
}
