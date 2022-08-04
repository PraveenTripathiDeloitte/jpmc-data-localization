package com.sample.filterdata.controller;


//import com.sample.filterdata.repository.CountryRepository;
import com.sample.filterdata.service.GetCountryRequest;
import com.sample.filterdata.service.GetCountryResponse;
import com.sample.filterdata.service.SoapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

//    private CountryRepository countryRepository;

    @Autowired
    private SoapClient soapClient;

//    @Autowired
//    public CountryEndpoint(CountryRepository countryRepository) {
//        this.countryRepository = countryRepository;
//    }


//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(soapClient.findCountry(request.getBankId()).getCountry());
        return response;
    }
}
