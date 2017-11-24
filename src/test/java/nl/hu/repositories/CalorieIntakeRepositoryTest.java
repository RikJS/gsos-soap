package nl.hu.repositories;

import nl.hu.generated.ActivityLevel;
import nl.hu.generated.Gender;
import nl.hu.models.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by rikde on 24/11/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CalorieIntakeRepositoryTest {
    private Person person;

    @Autowired
    private CalorieIntakeRepository calorieIntakeRepository;

    @Before
    public void setup() {
        person = new Person(67, 170, 20, Gender.MALE, ActivityLevel.ACTIVE);
    }

    @Test
    public void calculateCalorieIntakeTest() {
        int calorieIntakeExpected = 2384;
        int calorieIntakeResult = calorieIntakeRepository.calculateCalorieIntake(person);

        assertEquals(calorieIntakeExpected, calorieIntakeResult);
    }
}
