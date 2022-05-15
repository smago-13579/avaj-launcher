package edu.school21;

import edu.school21.aircrafts.Flyable;

import java.util.ArrayList;

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
        observers.forEach(Flyable::updateConditions);
    }
}
