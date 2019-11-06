package spacechallengeapp;

public class U1 extends Rocket {

    public U1() {
        this.costs = 100;
        this.weight = 10000;
        this.maxWeight = 18000;
        this.launchExplosionFactor = 5;
        this.landingCrashFactor = 1;
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
