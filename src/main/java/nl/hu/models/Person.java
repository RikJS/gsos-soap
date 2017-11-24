package nl.hu.models;

import nl.hu.generated.ActivityLevel;
import nl.hu.generated.Gender;

/**
 * Created by rikde on 21/11/2017.
 */
public class Person {
    private double weight;
    private double length;
    private double age;
    private Gender gender;
    private ActivityLevel activityLevel;

    public Person(double weight, double length) {
        this.length = length;
        this.weight = weight;
    }

    public Person(double weight, double length, double age, Gender gender, ActivityLevel activityLevel) {
        this.length = length;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
        this.activityLevel = activityLevel;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }
}
