package edu.school21;

import edu.school21.aircrafts.Flyable;
import edu.school21.exceptions.IllegalParameterException;
import edu.school21.exceptions.IllegalScenarioException;
import edu.school21.factory.AircraftFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Simulator {
//    private static List<Flyable> aircrafts = new ArrayList<>();
    private static AircraftFactory factory = new AircraftFactory();
    private static WeatherTower weatherTower = new WeatherTower();
    private static int times;

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new IllegalScenarioException("There must be one scenario argument.");
            }
            List<String> lines = Files.readAllLines(Paths.get(args[0]));
            times = Integer.parseInt(lines.remove(0).trim());

            lines.forEach(s -> {
                List<String> params = Arrays.stream(s.trim().split("\\s+")).collect(Collectors.toList());
                checkParameters(params);
                Flyable flyable = factory.newAircraft(params.get(0), params.get(1), Integer.parseInt(params.get(2)),
                        Integer.parseInt(params.get(3)), Integer.parseInt(params.get(4)));
                flyable.registerTower(weatherTower);
            });

            while (times-- > 0) {
                weatherTower.changeWeather();
            }
        } catch (IOException | RuntimeException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    private static void checkParameters(List<String> params) {
        if (params.size() != 5) {
            throw new IllegalScenarioException("ERROR: Incorrect scenario. Must be 5 parameters for each aircraft.");
        }

        if (Integer.parseInt(params.get(2)) < 0 || Integer.parseInt(params.get(3)) < 0
                || Integer.parseInt(params.get(4)) < 0) {
            throw new IllegalParameterException("ERROR: Parameter can't be less than zero.");
        }

        if (Integer.parseInt(params.get(4)) > 100) {
            throw new IllegalParameterException("ERROR: Height can't be more than 100.");
        }
    }


}