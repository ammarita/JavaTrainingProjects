package animalkingdomapp;

import java.awt.*;

public class WhiteTiger extends Critter {
    private boolean hasInfected = false;

    public WhiteTiger() {
    }

    //Same as a Tiger
    @Override
    public Action getMove(CritterInfo info) {
        if(info.frontThreat()) {
            this.hasInfected = true;
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }

    @Override
    public Color getColor() {
        return Color.WHITE;
    }

    //"tgr" if it hasn’t infected another Critter yet, “TGR” if it has infected.
    @Override
    public String toString() {
        if(this.hasInfected) {
            return "TGR";
        } else {
            return "tgr";
        }
    }
}
