package edu.school21.factory;

import edu.school21.Coordinates;
import edu.school21.aircrafts.*;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type.equalsIgnoreCase("Baloon")) {
            return new Baloon(name, coordinates);
        }

        if (type.equalsIgnoreCase("JetPlane")) {
            return new JetPlane(name, coordinates);
        }

        if (type.equalsIgnoreCase("Helicopter")) {
            return new Helicopter(name, coordinates);
        }

        System.err.println("ERROR: Aircraft type not defined!!!");
        return null;
    }
}
