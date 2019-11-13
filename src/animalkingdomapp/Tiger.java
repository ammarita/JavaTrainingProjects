package animalkingdomapp;

import java.awt.*;

public class Tiger extends Critter {
    private int moves = 0;
    public Tiger() {
    }

    //always infect if an enemy is in front, otherwise if a wall is in front or to the right,
    // then turn left, otherwise if a fellow Tiger is in front, then turn right, otherwise hop.
    @Override
    public Action getMove(CritterInfo info) {
        if(info.frontThreat()) {
            moves++;
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            moves++;
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            moves++;
            return Action.RIGHT;
        } else {
            moves++;
            return Action.HOP;
        }
    }

    //Randomly picks one of three colors (Color.RED, Color.GREEN, Color.BLUE) and uses that color for three moves,
    // then randomly picks one of those colors again for the next three moves,
    // then randomly picks another one of those colors for the next three moves, and so on.
    @Override
    public Color getColor() {
        updateMove();
        int random = 1;
        if(moves == 0) {
            random = (int) (Math.random() * ((3 - 1) + 1)) + 1;
        }

        if(random == 1) {
            return Color.RED;
        } else if (random == 2) {
            return Color.BLUE;
        } else {
            return Color.GREEN;
        }

    }

    @Override
    public String toString() {
        return "TGR";
    }
    
    private void updateMove() {
        if(moves > 2) {
            moves = 0;
        }
    }
}
