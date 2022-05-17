package edu.school21.aircrafts;

import edu.school21.Coordinates;
import edu.school21.WeatherTower;
import edu.school21.exceptions.IllegalWeatherException;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        int longitude, latitude, height;
        String weather = weatherTower.getWeather(coordinates);

        if ("SUN".equals(weather)) {
            longitude = this.coordinates.getLongitude();
            latitude = this.coordinates.getLatitude() + 10;
            height = this.coordinates.getHeight() + 2;
            this.coordinates = new Coordinates(longitude, latitude, height);
            System.out.println(this + ": Enjoy the good weather and speed uuupp!!!");
        } else if ("RAIN".equals(weather)) {
            longitude = this.coordinates.getLongitude();
            latitude = this.coordinates.getLatitude() + 5;
            height = this.coordinates.getHeight();
            this.coordinates = new Coordinates(longitude, latitude, height);
            System.out.println(this + ": It's raining. Better watch out for lightings.");
        } else if ("FOG".equals(weather)) {
            longitude = this.coordinates.getLongitude();
            latitude = this.coordinates.getLatitude() + 1;
            height = this.coordinates.getHeight();
            this.coordinates = new Coordinates(longitude, latitude, height);
            System.out.println(this + ": It's fog. I can't see the ground.");
        } else if ("SNOW".equals(weather)) {
            longitude = this.coordinates.getLongitude();
            latitude = this.coordinates.getLatitude();
            height = this.coordinates.getHeight() - 7;
            this.coordinates = new Coordinates(longitude, latitude, height);
            System.out.println(this + ": OMG! Winter is coming!");

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
        return "JetPlane#" + name + '(' + id + ')';
    }
}
