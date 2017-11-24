package nl.hu.repositories;

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
public class BmiRepositoryTest {
    private Person person;

    @Autowired
    private BmiRepository bmiRepository;

    @Before
    public void setup() {
        person = new Person(67, 170);
    }

    @Test
    public void calculateBmiTest() {
        double bmiExpected = 23.2;
        double bmiResult = bmiRepository.calculateBmi(person);

        assertEquals(bmiExpected, bmiResult, 1e-8);
    }
}
