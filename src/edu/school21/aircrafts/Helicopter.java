package edu.school21.aircrafts;

public class Helicopter extends Aircraft {

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public String toString() {
        return "Helicopter#" + name + '(' + id + ')';
    }
}
