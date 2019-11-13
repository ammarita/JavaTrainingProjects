package animalkingdomapp;

import java.awt.*;

public class Bear extends Critter {
    private boolean polar;
    private int moves = 0;

    public Bear() {
        this.polar = (Math.random() < 0.5);
    }

    //always infect if an enemy is in front, otherwise hop if possible, otherwise turn left.
    @Override
    public Action getMove(CritterInfo info) {
        if(info.getFront() == Neighbor.OTHER) {
            moves++;
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.EMPTY) {
            moves++;
            return Action.HOP;
        } else {
            moves++;
            return Action.LEFT;
        }
    }

    @Override
    public Color getColor() {
        if(polar) {
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    //Should alternate on each different move between a slash character (/) and a backslash character (\) starting with a slash.
    @Override
    public String toString() {
        if(moves % 2 == 0) {
            return "\\";
        } else {
            return "/";
        }
    }
}
