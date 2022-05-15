package edu.school21.aircrafts;

import edu.school21.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}
