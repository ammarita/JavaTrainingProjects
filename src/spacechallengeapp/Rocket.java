package spacechallengeapp;

public class Rocket implements SpaceShip {
    int costs;
    int weight;
    int maxWeight;
    double launchExplosionFactor;
    double landingCrashFactor;

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if(this.weight + item.getWeight() <= this.maxWeight) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void carry(Item item) {
        this.weight += item.getWeight();
    }
}