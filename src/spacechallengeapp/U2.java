package spacechallengeapp;

public class U2 extends Rocket {

    public U2() {
        this.costs = 120;
        this.weight = 18000;
        this.maxWeight = 29000;
        this.launchExplosionFactor = 4;
        this.landingCrashFactor = 8;
    }

    @Override
    public boolean launch() {
        double random = Math.random();
        double launchExplosionChance = (this.launchExplosionFactor * 100) * (this.weight / this.maxWeight);
        if(launchExplosionChance >= random) {
            return false;
        }
        return super.launch();
    }

    @Override
    public boolean land() {
        double random = Math.random();
        double launchExplosionChance = (this.landingCrashFactor * 100) * (this.weight / this.maxWeight);
        if(launchExplosionChance >= random) {
            return false;
        }
        return super.launch();
    }
}