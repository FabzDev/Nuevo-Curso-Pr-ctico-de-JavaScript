package com.fabzdev.exercism.remoteControlWithInterface;

public class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    private int victories;
    private int distance = 0;
    @Override
    public void drive() {
            distance += 10;
    }
    @Override
    public int getDistanceTravelled() {
        return distance;
    }
    public int getNumberOfVictories() {
        return victories;
    }
    public void setNumberOfVictories(int numberOfVictories) {
        this.victories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar otherProdCar) {
        return otherProdCar.getNumberOfVictories() - this.victories;
    }
}
