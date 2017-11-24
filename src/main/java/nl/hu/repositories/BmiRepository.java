package nl.hu.repositories;

import nl.hu.models.Person;
import org.springframework.stereotype.Component;

@Component
public class BmiRepository {

    public double calculateBmi(Person person) {
        double lengthInMeters = person.getLength()/100;
        lengthInMeters = person.getWeight() / (lengthInMeters*lengthInMeters);
        return round(lengthInMeters, 1);
    }

    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}