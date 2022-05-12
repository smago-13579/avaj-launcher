package edu.school21.app;

import edu.school21.aircrafts.Helicopter;
import edu.school21.aircrafts.Aircraft;

public class Simulator {
    public static void main(String[] args) {
        Aircraft aircraft = new Helicopter("H1", null);
        System.out.println(aircraft);
    }
}