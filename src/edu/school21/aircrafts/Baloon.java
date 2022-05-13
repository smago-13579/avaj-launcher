package edu.school21.aircrafts;

import edu.school21.towers.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

    }

    @Override
    public String toString() {
        return "Baloon#" + name + '(' + id + ')';
    }
}
