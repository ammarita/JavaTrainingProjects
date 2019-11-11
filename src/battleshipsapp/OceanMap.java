package battleshipsapp;

import java.util.Scanner;

class OceanMap {
    private Scanner sc = new Scanner(System.in);
    private char[][] mapGrid = new char[10][10];

    private int playersShips = 5;
    private int computersShips = 5;

    private boolean playersTurn = true;
    private boolean playing = true;

    OceanMap() {
        System.out.println("***** Welcome to Battle Ship Game *****");
        System.out.println("\nRight now, the sea is empty.\n");
        printMap();
        placePlayersShip();
        placeComputersShips();
        System.out.println("Lets begin the Battle!");
        battleLoop();
    }

    private void printMap() {
        System.out.println("0123456789");
        for(int i = 0; i < mapGrid.length; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < mapGrid.length; j++) {
                if(mapGrid[i][j] == '1') {
                    System.out.print('@');
                } else if(mapGrid[i][j] == '2') {
                    System.out.print('\u0000');
                } else {
                    System.out.print(mapGrid[i][j]);
                    }
                }
            System.out.println("| " + i);
        }
        System.out.println("0123456789\n");
    }

    private void placePlayersShip() {
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

    private void placeComputersShips() {
        System.out.println(" Computer is placing out ships");
        int shipsDeployed = 1;
        while (shipsDeployed <= 5) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);

            if(mapGrid[x][y] == '\u0000') {
                mapGrid[x][y] = '2';
                System.out.println(shipsDeployed + ". ship deployed!");
                shipsDeployed++;
            }
        }
        System.out.println("All ships are in the places!\n");
        printMap();
    }

    private void playersMove() {
        System.out.println("Your Turn");

        while (playersTurn) {
            System.out.print("Enter X coordinate: ");
            int x = sc.nextInt();
            System.out.print("Enter Y coordinate: ");
            int y = sc.nextInt();

            if(x <= 9 && y <= 9 && mapGrid[x][y] != '-' && mapGrid[x][y] != 'X') {
                playersTurn = false;
            }

            if (x > 9 || y > 9) {
                System.out.println("You should shoot inside the sea. Try again!");
            } else if (mapGrid[x][y] == 'X' || mapGrid[x][y] == '-') {
                System.out.println("You already shot here. Try again!");
            } else if (mapGrid[x][y] == '2') {
                System.out.println("Boom! You sunk the enemy's ship!");
                mapGrid[x][y] = 'X';
                computersShips--;
            } else if (mapGrid[x][y] == '1') {
                System.out.println("Oh no, you sunk your own ship!");
                mapGrid[x][y] = 'X';
                playersShips--;
            } else {
                System.out.println("You missed");
                mapGrid[x][y] = '-';
            }
        }
    }

    private void computersMove() {
        System.out.println("Computer's Turn");
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        if(mapGrid[x][y] == '1') {
            System.out.println("Boom! Computer sunk your ship!");
            mapGrid[x][y] = 'X';
            playersShips--;
        } else if (mapGrid[x][y] == '2') {
            System.out.println("Computer sunk his own ship!");
            mapGrid[x][y] = 'X';
            computersShips--;
        } else {
            System.out.println("Computer missed");
            mapGrid[x][y] = '-';
        }
    }

    private void battleLoop() {
        while (playing) {
            playersMove();
            computersMove();
            printMap();
            System.out.println("You have " + playersShips + " left | Computer has " + computersShips + " ships left");
            System.out.println("-----------------------");
            playersTurn = true;

            if (playersShips <= 0 || computersShips <= 0) {
                playing = false;
            }
        }

        System.out.println("Game Over");
        if (computersShips <= 0) {
            System.out.println("You win the battle!");
        } else {
            System.out.println("You lost the battle!");
        }
    }
}
