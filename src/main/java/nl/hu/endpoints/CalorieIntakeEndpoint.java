package nl.hu.endpoints;

import nl.hu.generated.GetBmiRequest;
import nl.hu.generated.GetBmiResponse;
import nl.hu.generated.GetCalorieIntakeRequest;
import nl.hu.generated.GetCalorieIntakeResponse;
import nl.hu.models.Person;
import nl.hu.repositories.CalorieIntakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CalorieIntakeEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private CalorieIntakeRepository calorieIntakeRepository;

    @Autowired
    public CalorieIntakeEndpoint(CalorieIntakeRepository calorieIntakeRepository) {
        this.calorieIntakeRepository = calorieIntakeRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCalorieIntakeRequest")
    @ResponsePayload
    public GetCalorieIntakeResponse getCalorieIntake(@RequestPayload GetCalorieIntakeRequest request) {
        GetCalorieIntakeResponse response = new GetCalorieIntakeResponse();
        Person person = new Person(
                request.getWeight(),
                request.getLength(),
                request.getAge(),
                request.getGender(),
                request.getActivityLevel()
        );

        response.setResponse(calorieIntakeRepository.calculateCalorieIntake(person));

        return response;
    }
}