package animalkingdomapp;

import java.awt.*;

public class NinjaCat extends Critter {
    public NinjaCat() {
    }

    @Override
    public Action getMove(CritterInfo info) {
        if(info.frontThreat() || info.backThreat()) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL) {
            return Action.RIGHT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.LEFT;
        } else {
            return Action.HOP;
        }
    }

    @Override
    public Color getColor() {
        return Color.YELLOW;
    }

    @Override
    public String toString() {
        return "#";
    }
}
