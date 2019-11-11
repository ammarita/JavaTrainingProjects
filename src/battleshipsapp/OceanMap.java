package battleshipsapp;

public class OceanMap {
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
                System.out.print(mapGrid[i][j]);
            }
            System.out.println("| " + i);
        }
        System.out.println("123456789");
    }
}
