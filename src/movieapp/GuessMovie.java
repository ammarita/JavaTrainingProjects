package movieapp;

import java.util.Scanner;

public class GuessMovie {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String guess = "";
        Game game = new Game();

        System.out.println("Guess The Movie Game");

        while(game.getWrongGuesses().size() < 10) {
            System.out.println("Guess the Movie: " + game.getHiddenMovieName());
            System.out.println("You have guessed (" + game.getWrongGuesses().size() + ") wrong letters: " + game.showWrongGuesses());
            System.out.print("Guess a letter: ");
            guess = input.next();
            game.checkGuess(guess);

            if(!game.isPlaying()) break;
        }

        if(game.getWrongGuesses().size() >= 10) {
            System.out.println("You lost!" +
                    "\nYou did not guessed \'" + game.getMovie() + "\' correctly.");
        }
    }//end main
}
