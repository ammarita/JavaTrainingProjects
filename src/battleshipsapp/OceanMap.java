package battleshipsapp;

import java.util.Scanner;

public class OceanMap {
    Scanner sc = new Scanner(System.in);
    char[][] mapGrid = new char[10][10];

    public OceanMap() {
        System.out.println("***** Welcome to Battle Ship Game *****");
        System.out.println("\nRight now, the sea is empty.\n");
        printMap();
    }

    private void printMap() {
        System.out.println("123456789");
        for(int i = 0; i < mapGrid.length; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < mapGrid[j].length - 1; j++) {
                if(mapGrid[i][j] == '1') {
                    System.out.print('@');
                } else {
                    System.out.print(mapGrid[i][j]);
                }
            }
            System.out.println("| " + i);
        }
        System.out.println("123456789");
    }

    public void placePlayersShip() {
        System.out.println("You have 5 ships to place in the sea. Please choose the location!");
        int shipsDeployed = 1;
        while(shipsDeployed <= 5) {
            System.out.print("Enter X coordinate for your " + shipsDeployed + " ship: ");
            int x = sc.nextInt();
            System.out.print("Enter Y coordinate for your " + shipsDeployed + " ship: ");
            int y = sc.nextInt();

            if(x > 9 || y > 9) {
                System.out.println("You should place your ships inside the sea. Try again!");
            } else if(mapGrid[x][y] == '\u0000') {
                mapGrid[x][y] = '1';
                shipsDeployed++;
            } else {
                System.out.println("This place is not empty. Try again!");
            }
        }
        System.out.println("Your ships are sailing in the sea!\n");
        printMap();
    }
}
