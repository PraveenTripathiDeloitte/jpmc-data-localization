package com.jpmc.datafilter.client;

import com.local.article.GetCountryRequest;
import com.local.article.GetCountryResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.regex.Pattern;

public class CountryClient extends WebServiceGatewaySupport {


    public GetCountryResponse getCountry(String bankId) {
        String regex = "[A-Z0-9]+CHE|DEL|BOM|BLR";
        GetCountryRequest getCountryRequest = new GetCountryRequest();
        getCountryRequest.setBankId(bankId);
        if (Pattern.compile(regex).matcher(bankId).find()) {
            //for local
//            return (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8090/ws", getCountryRequest);
            //for deployed
            return (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive("http://ec2-3-91-149-67.compute-1.amazonaws.com:8090/ws", getCountryRequest);
        } else {
            //for local
//            return (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8089/ws", getCountryRequest);
            //for deployed
            return (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive("http://ec2-54-165-252-134.compute-1.amazonaws.com:8089/ws", getCountryRequest);
        }

    }
}
