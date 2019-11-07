package spacechallengeapp;

import java.io.File;
import java.util.ArrayList;

public class SpaceChallengeApp {
    public static void main(String[] args) {
        //TODO: Create a Simulation object
        //TODO: Load Items for Phase-1 and Phase-2
        //TODO: Load a fleet of U1 rockets for Phase-1 and then for Phase-2
        //TODO: Run the simulation using the fleet of U1 rockets and display the total budget required.
        //TODO: Repeat the same for U2 rockets and display the total budget for that.

        File phase1 = new File("./src/spacechallengeapp/phase-1.txt");
        File phase2 = new File("./src/spacechallengeapp/phase-2.txt");

        Simulation simulation = new Simulation();

        ArrayList cargo1 = simulation.loadItems(phase1);
        ArrayList cargo2 = simulation.loadItems(phase2);

        ArrayList U1Rockets1 = simulation.loadU1(cargo1);
        ArrayList U1Rockets2 = simulation.loadU1(cargo2);

        int totalBudget1 = simulation.runSimulation(U1Rockets1);
        int totalBudget2 = simulation.runSimulation(U1Rockets2);

        System.out.println("Simulation for U1 Rockets: Total Budget for Mars Mission Phase 1 is $" + totalBudget1 + " Million" +
                "\nTotal Budget for Mars Mission Phase 2 is $" + totalBudget2 + " Million");

        ArrayList cargoU21 = simulation.loadItems(phase1);
        ArrayList cargoU22 = simulation.loadItems(phase2);

        ArrayList U2Rockets1 = simulation.loadU2(cargoU21);
        ArrayList U2Rockets2 = simulation.loadU2(cargoU22);

        int totalBudgetU21 = simulation.runSimulation(U2Rockets1);
        int totalBudgetU22 = simulation.runSimulation(U2Rockets2);

        System.out.println("Simulation for U2 Rockets: Total Budget for Mars Mission Phase 1 is $" + totalBudgetU21 + " Million" +
                "\nTotal Budget for Mars Mission Phase 2 is $" + totalBudgetU22 + " Million");
    }//end main
}
