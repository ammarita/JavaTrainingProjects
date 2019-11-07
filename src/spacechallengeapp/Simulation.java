package spacechallengeapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Simulation {
//    private ArrayList<Item> items = new ArrayList<>();
//    private ArrayList<U1> U1Rockets = new ArrayList<>();
//    private ArrayList<U2> U2Rockets = new ArrayList<>();

    //method loads all items from a text file and returns an ArrayList of Items
    ArrayList<Item> loadItems(File file) {
        ArrayList<Item> items = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                String[] item = sc.nextLine().split("=");
                Item cargo = new Item(item[0], Integer.parseInt(item[1]));
                items.add(cargo);
            }
            System.out.println("Finished loading of cargo.");
        } catch (FileNotFoundException e) {
            System.out.println("Cargo file not found!");
            e.printStackTrace();
        }
        return items;
    }

    //method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
    //It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object
    // and filling that one until all items are loaded. The method then returns the ArrayList of those U1 rockets that are fully loaded.
    ArrayList<U1> loadU1(ArrayList<Item> items) {
        ArrayList<U1> U1Rockets = new ArrayList<>();
        U1 u1 = new U1();
        while (items.size() > 0) {
            Item item = items.get(0);
            if(u1.canCarry(item)) {
                u1.carry(item);
                items.remove(0);
            } else {
                U1Rockets.add(u1);
                u1 = new U1();
            }
            //System.out.println("Rocket loaded.");
        }
        System.out.println("Loaded " + U1Rockets.size() + " U1 rockets.");
        return U1Rockets;
    }

    //method takes the ArrayList of Items returned from loadItems and starts creating U2 rockets.
    ArrayList<U2> loadU2(ArrayList<Item> items) {
        ArrayList<U2> U2Rockets = new ArrayList<>();
        U2 u2 = new U2();
        while (items.size() > 0) {
            Item item = items.get(0);
            if(u2.canCarry(item)) {
                u2.carry(item);
                items.remove(0);
            } else {
                U2Rockets.add(u2);
                u2 = new U2();
            }
            //System.out.println("Rocket loaded.");
        }
        System.out.println("Loaded " + U2Rockets.size() + " U2 rockets.");
        return U2Rockets;
    }

    //method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList.
    // Every time a rocket explodes or crashes it should send that rocket again. All while keeping track of the total budget
    // required to send each rocket safely to Mars.
    // runSimulation then returns the total budget required to send all rockets (including the crashed ones).
    int runSimulation(ArrayList<Rocket> rockets) {
        int totalBudget = 0;
           for(int i = 0; i < rockets.size(); i++) {
               Rocket rocket = rockets.get(i);
               System.out.println("Launching rocket...");
               rocket.launch();

               while (!rocket.launch()) {
                   totalBudget += rocket.costs;
                   System.out.println("Launch failed! Launching again...");
                   rocket.launch();
               }

               System.out.println("Launching successful! Landing rocket...");
               rocket.land();

               while (!rocket.land()) {
                   totalBudget += rocket.costs;
                   System.out.println("Landing failed! Launching again...");
                   rocket.launch();
               }

               System.out.println("Landing successful! Preparing next rocket for launch...");
               totalBudget += rocket.costs;
           }
        System.out.println("All cargo sent to Mars.");
        return totalBudget;
    }
}
