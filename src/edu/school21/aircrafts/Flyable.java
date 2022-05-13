package edu.school21.aircrafts;

import edu.school21.towers.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}
