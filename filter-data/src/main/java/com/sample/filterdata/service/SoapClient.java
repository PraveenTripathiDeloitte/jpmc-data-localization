package com.sample.filterdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.regex.Pattern;

@Service
public class SoapClient extends WebServiceGatewaySupport {

    @Autowired
    private Jaxb2Marshaller jaxb2Marshaller;

    private WebServiceTemplate webServiceTemplate;

    public GetCountryResponse findCountry(String bankId) {

        String regex = "[A-Z0-9]+CHE|DEL|BOM|BLR";

        GetCountryResponse response = new GetCountryResponse();

        GetCountryRequest request = new GetCountryRequest();
        request.setBankId(bankId);

        webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
        if (Pattern.compile(regex).matcher(bankId).find()) {
            response = (GetCountryResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:8090/ws", request);
        } else {
            response = (GetCountryResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:8089/ws", request);
        }
        return response;
    }
}
