package com.jpmc.datafilter.client;

import com.jpmc.datafilter.config.SoapConfig;
import com.local.article.GetCountryRequest;
import com.local.article.GetCountryResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

//    private CountryRepository countryRepository;

//    @Autowired
//    public CountryEndpoint(CountryRepository countryRepository) {
//        this.countryRepository = countryRepository;
//    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
//        response.setCountry(countryRepository.getIndiaResponse(request.getBankId()));
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SoapConfig.class);
        CountryClient countryClient = annotationConfigApplicationContext.getBean(CountryClient.class);
        response.setCountry(countryClient.getCountry(request.getBankId()).getCountry());

        return response;
    }
}
