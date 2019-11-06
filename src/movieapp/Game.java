package movieapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Game {
    private File file = new File("./src/movieapp/movies.txt");
    private List<String> movieList = new ArrayList<>();
    private Set<String> wrongGuesses = new LinkedHashSet<>();
    private String movie = "";
    private String hiddenMovieName = "";
    private boolean isPlaying = true;

    Game() {
        createMovieList();
        randomMovie();
        hideMovie();
    }

    Set<String> getWrongGuesses() {
        return wrongGuesses;
    }

    String getMovie() {
        return movie;
    }

    String getHiddenMovieName() {
        return hiddenMovieName;
    }

    boolean isPlaying() {
        return isPlaying;
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
    private void randomMovie() {
        int randomPick = (int) (Math.random() * (movieList.size() -1));
        movie = movieList.get(randomPick);
    }

    //Replace movie name with -
    private void hideMovie() {
        hiddenMovieName = movie.replaceAll("[a-zA-Z0-9]", "-");
    }

    //Show wrong guesses
    String  showWrongGuesses() {
        String wrongGuess = "";
        for(String guess : wrongGuesses) {
            wrongGuess += guess + " ";
        }
        return wrongGuess;
    }

    //Checking if movie contains guessed letter
    void checkGuess(String guess) {
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
            replacementIndex.add(index);
            index = movie.indexOf(letter, index + letter.length());
        }

        for (int replace : replacementIndex) {
            StringBuilder hiddenMovie = new StringBuilder(hiddenMovieName);
            hiddenMovie.setCharAt(replace, replaceLetter);
            hiddenMovieName = String.valueOf(hiddenMovie);
        }
        System.out.println(hiddenMovieName);
    }
}
