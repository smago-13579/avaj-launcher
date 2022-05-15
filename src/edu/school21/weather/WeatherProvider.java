package edu.school21.weather;

import edu.school21.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {

    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int value = coordinates.getHeight() + coordinates.getLatitude() * 2 + coordinates.getLongitude() * 3;

        return weather[value % 4];
    }
}
