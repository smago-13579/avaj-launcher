package edu.school21;

import edu.school21.aircrafts.Flyable;

import java.util.ArrayList;
import java.util.stream.Stream;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
        System.out.println("Tower says: " + flyable + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        System.out.println("Tower says: " + flyable + " unregistered from weather tower.");
    }

    protected void conditionsChanged() {
        Stream.of(observers.toArray()).forEach(o -> ((Flyable) o).updateConditions());
    }
}
