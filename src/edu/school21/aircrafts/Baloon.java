package edu.school21.aircrafts;

import edu.school21.Coordinates;
import edu.school21.WeatherTower;
import edu.school21.exceptions.IllegalWeatherException;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        int longitude, latitude, height;
        String weather = weatherTower.getWeather(coordinates);

        if ("SUN".equals(weather)) {
            longitude = this.coordinates.getLongitude() + 2;
            latitude = this.coordinates.getLatitude();
            height = this.coordinates.getHeight() + 4;
            this.coordinates = new Coordinates(longitude, latitude, height);
            System.out.println(this + ": Let's enjoy the good weather and take some pics.");
        } else if ("RAIN".equals(weather)) {
            longitude = this.coordinates.getLongitude();
            latitude = this.coordinates.getLatitude();
            height = this.coordinates.getHeight() - 5;
            this.coordinates = new Coordinates(longitude, latitude, height);
            System.out.println(this + ": Damn you rain! You messed up my baloon.");

            if (this.coordinates.getHeight() == 0) {
                System.out.println(this + " landing.");
                this.weatherTower.unregister(this);
            }
        } else if ("FOG".equals(weather)) {
            longitude = this.coordinates.getLongitude();
            latitude = this.coordinates.getLatitude();
            height = this.coordinates.getHeight() - 3;
            this.coordinates = new Coordinates(longitude, latitude, height);
            System.out.println(this + ": It's fog. I can't see the ground.");

            if (this.coordinates.getHeight() == 0) {
                System.out.println(this + " landing.");
                this.weatherTower.unregister(this);
            }
        } else if ("SNOW".equals(weather)) {
            longitude = this.coordinates.getLongitude();
            latitude = this.coordinates.getLatitude();
            height = this.coordinates.getHeight() - 15;
            this.coordinates = new Coordinates(longitude, latitude, height);
            System.out.println(this + ": It's snowing. We're gonna crash.");

            if (this.coordinates.getHeight() == 0) {
                System.out.println(this + " landing.");
                this.weatherTower.unregister(this);
            }
        } else {
            throw new IllegalWeatherException();
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

    @Override
    public String toString() {
        return "Baloon#" + name + '(' + id + ')';
    }
}
