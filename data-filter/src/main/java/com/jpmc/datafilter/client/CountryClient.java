package com.jpmc.datafilter.client;

import com.local.article.GetCountryRequest;
import com.local.article.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.regex.Pattern;

public class CountryClient extends WebServiceGatewaySupport {

//    @Autowired
//    private Jaxb2Marshaller jaxb2Marshaller;

//    private WebServiceTemplate webServiceTemplate;

    public GetCountryResponse getCountry(String bankId) {
        String regex = "[A-Z0-9]+CHE|DEL|BOM|BLR";
        GetCountryRequest getCountryRequest = new GetCountryRequest();
        getCountryRequest.setBankId(bankId);
//        webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
        if (Pattern.compile(regex).matcher(bankId).find()) {
            return (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8090/ws", getCountryRequest);
        } else {
            return (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8089/ws", getCountryRequest);
        }

//        return (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(getCountryRequest);
    }
}
