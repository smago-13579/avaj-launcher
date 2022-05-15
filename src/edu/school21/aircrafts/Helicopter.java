package edu.school21.aircrafts;

import edu.school21.Coordinates;
import edu.school21.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        int longitude, latitude, height;
        String weather = weatherTower.getWeather(coordinates);

        if ("SUN".equals(weather)) {
            longitude = this.coordinates.getLongitude() + 10;
            latitude = this.coordinates.getLatitude();
            height = this.coordinates.getHeight() + 2;
            this.coordinates = new Coordinates(longitude, latitude, height);
            System.out.println(this + ": The weather is nice. I see a village.");
        } else if ("RAIN".equals(weather)) {
            longitude = this.coordinates.getLongitude() + 5;
            latitude = this.coordinates.getLatitude();
            height = this.coordinates.getHeight();
            this.coordinates = new Coordinates(longitude, latitude, height);
            System.out.println(this + ": It's raining. The weather may change later.");
        } else if ("FOG".equals(weather)) {
            longitude = this.coordinates.getLongitude() + 1;
            latitude = this.coordinates.getLatitude();
            height = this.coordinates.getHeight();
            this.coordinates = new Coordinates(longitude, latitude, height);
            System.out.println(this + ": It's fog. I can't see the ground.");
        } else if ("SNOW".equals(weather)) {
            longitude = this.coordinates.getLongitude();
            latitude = this.coordinates.getLatitude();
            height = this.coordinates.getHeight() - 12;
            this.coordinates = new Coordinates(longitude, latitude, height);
            System.out.println(this + ": My rotor is going to freeze!");

            if (this.coordinates.getHeight() == 0) {
                System.out.println(this + " landing.");
                this.weatherTower.unregister(this);
            }
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

    @Override
    public String toString() {
        return "Helicopter#" + name + '(' + id + ')';
    }
}
