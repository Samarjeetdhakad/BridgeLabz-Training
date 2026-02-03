package com.streamapi.iotsensor;

import java.util.Arrays;
import java.util.List;

public class SensorApp {
    public static void main(String[] args) {
        List<Double> sensorReadings = Arrays.asList(22.5,35.8, 18.2, 42.0, 29.4 );
        double threshold = 30.0;
        sensorReadings.stream()
                      .filter(reading -> reading > threshold) // above threshold
                      .forEach(reading ->
                          System.out.println("High Reading: " + reading)
                      );
    }
}