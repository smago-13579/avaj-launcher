package edu.school21.exceptions;

public class IllegalWeatherException extends RuntimeException {
    public IllegalWeatherException() {
        super("ERROR: Weather is not defined.");
    }
}
