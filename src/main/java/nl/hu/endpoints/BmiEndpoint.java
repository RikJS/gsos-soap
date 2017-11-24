package nl.hu.endpoints;

import nl.hu.generated.GetBmiRequest;
import nl.hu.generated.GetBmiResponse;
import nl.hu.models.Person;
import nl.hu.repositories.BmiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BmiEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private BmiRepository bmiRepository;

    @Autowired
    public BmiEndpoint(BmiRepository bmiRepository) {
        this.bmiRepository = bmiRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBmiRequest")
    @ResponsePayload
    public GetBmiResponse getBmi(@RequestPayload GetBmiRequest request) {
        GetBmiResponse response = new GetBmiResponse();
        Person person = new Person(request.getWeight(), request.getLength());

        response.setResponse(bmiRepository.calculateBmi(person));

        return response;
    }
}