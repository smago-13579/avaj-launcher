package edu.school21.app;

import edu.school21.aircrafts.Flyable;
import edu.school21.factory.AircraftFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Simulator {
    private static List<Flyable> aircrafts = new ArrayList<>();
    private static AircraftFactory factory = new AircraftFactory();
    private static int times;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("There must be one scenario argument.");
            System.exit(-1);
        }

        try {
            List<String> lines = Files.readAllLines(Paths.get(args[0]));
            times = Integer.parseInt(lines.remove(0).trim());

            lines.forEach(s -> {
                List<String> params = Arrays.stream(s.trim().split("\\s+")).collect(Collectors.toList());
                checkParameters(params);
                Flyable flyable = factory.newAircraft(params.get(0), params.get(1), Integer.parseInt(params.get(2)),
                        Integer.parseInt(params.get(3)), Integer.parseInt(params.get(4)));
                aircrafts.add(flyable);
            });

            aircrafts.forEach(System.out::println);
        } catch (IOException | NumberFormatException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }

    private static void checkParameters(List<String> params) {
        if (params.size() != 5) {
            System.err.println("ERROR: Incorrect scenario. Must be 5 parameters for each aircraft.");
            System.exit(-1);
        }

        if (Integer.parseInt(params.get(2)) < 0 || Integer.parseInt(params.get(3)) < 0
                || Integer.parseInt(params.get(4)) < 0) {
            System.err.println("ERROR: Parameter can't be less than zero.");
            System.exit(-1);
        }
    }


}