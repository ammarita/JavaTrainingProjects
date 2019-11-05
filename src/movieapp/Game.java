package movieapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    File file = new File("C:\\Users\\marita.lasmane\\Downloads\\JavaTrainingProjects\\src\\movieapp\\movies.txt");
    List<String> movieList = new ArrayList<>();
    List<String> wrongGuesses = new ArrayList<>();
    String movie = "";

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
        return movie.replaceAll(".", "-");
    }

    //Show wrong guesses
    public String  showWrongGuesses() {
        String wrongGuess = "";
        for(String guess : wrongGuesses) {
            wrongGuess = guess + " ";
        }
        return wrongGuess;
    }
}
