package battleshipsapp;

import java.util.Scanner;

public class BattleShipsApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playing = true;
        while (playing) {
            OceanMap oceanMap = new OceanMap();

            System.out.println("Do you want to play again? (y/n)");
            String answer = sc.next().toLowerCase();

            if (answer.equals("n")) {
                playing = false;
            }
        }
    }//end main
}
