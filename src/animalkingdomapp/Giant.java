package animalkingdomapp;

import java.awt.*;

public class Giant extends Critter {
    private int moves = 0;

    public Giant() {
    }

    //always infect if an enemy is in front, otherwise hop if possible, otherwise turn right.
    @Override
    public Action getMove(CritterInfo info) {
        if(info.frontThreat()) {
            moves++;
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.EMPTY) {
            moves++;
            return Action.HOP;
        } else {
            moves++;
            return Action.RIGHT;
        }
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    //"fee" for 6 moves, then "fie" for 6 moves, then "foe" for 6 moves, then "fum" for 6 moves, then repeat.
    @Override
    public String toString() {
        updateMoves();
        if(moves < 6) {
            return "fee";
        } else {
            return "fie";
        }
    }

    private void updateMoves() {
        if(this.moves > 11) {
            this.moves = 0;
        }
    }
}
