package movieapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Game {
    File file = new File("C:\\Users\\marit\\IdeaProjects\\JavaTrainingProjects\\src\\movieapp\\movies.txt");
    List<String> movieList = new ArrayList<>();
    Set<String> wrongGuesses = new LinkedHashSet<>();
    String movie = "";
    String hiddenMovieName = "";
    boolean isPlaying = true;

    public Game() {
        createMovieList();
        randomMovie();
    }

    //Creating movie list from file
    private void createMovieList() {
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                movieList.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Movie file not found!");
            e.printStackTrace();
        }
    }

    //Randomly pick a movie from list
    private String randomMovie() {
        int randomPick = (int) (Math.random() * (movieList.size() -1));
        movie = movieList.get(randomPick);
        return movie;
    }

    //Replace movie name with -
    public String hideMovie() {
        hiddenMovieName = movie.replaceAll(".", "-");
        return hiddenMovieName;
    }

    //Show wrong guesses
    public String  showWrongGuesses() {
        String wrongGuess = "";
        for(String guess : wrongGuesses) {
            wrongGuess += guess + " ";
        }
        return wrongGuess;
    }

    //Checking if movie contains guessed letter
    public void checkGuess(String guess) {
        if (guess.length() > 1) {
            System.out.println("Please enter one letter at the time!");
        } else if (wrongGuesses.contains(guess)) {
            System.out.println("You already have guessed " + guess + "." +
                    "\nTry again!");
        } else if (!movie.contains(guess)) {
            wrongGuesses.add(guess);
        } else if (movie.contains(guess)) {
            replaceLetters(guess);
        }

        if (hiddenMovieName.equals(movie)) {
            System.out.println("Congratulations, you won!" +
                    "\nYou guessed movie " + movie + " correctly.");
            isPlaying = false;
        }
    }
    //Replacing correct guessed letters
    private void replaceLetters(String letter) {
        int index = movie.indexOf(letter);
        char replaceLetter = letter.charAt(0);
        List<Integer> replacementIndex = new ArrayList<>();
        while(index >= 0) {
            System.out.println(index);
            replacementIndex.add(index);
            System.out.println(replacementIndex);
            index = movie.indexOf(letter, index + letter.length());
        }

        for (int i = 0; i < replacementIndex.size(); i++) {
            int replace = replacementIndex.get(i);
            System.out.println(replace);
            System.out.println(hiddenMovieName.charAt(replace));
            StringBuilder hiddenMovie = new StringBuilder(hiddenMovieName);
            hiddenMovie.setCharAt(replace, replaceLetter);
            hiddenMovieName = String.valueOf(hiddenMovie);
        }
        System.out.println(hiddenMovieName);
    }

}
