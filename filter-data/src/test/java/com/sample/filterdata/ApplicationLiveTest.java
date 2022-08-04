package com.sample.filterdata;

import com.sample.filterdata.config.SoapConfig;
import com.sample.filterdata.service.GetCountryResponse;
import com.sample.filterdata.service.SoapClient;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = SoapConfig.class, loader = AnnotationConfigContextLoader.class)
public class ApplicationLiveTest {


    @InjectMocks
    private SoapClient soapClient;

    @Test
    public void testResponse() {
        GetCountryResponse response = soapClient.findCountry("CHA231BLR");
        assertNotNull(response);
    }
}
