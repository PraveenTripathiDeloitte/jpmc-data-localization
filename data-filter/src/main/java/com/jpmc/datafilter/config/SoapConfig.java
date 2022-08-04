package com.jpmc.datafilter.config;

import com.jpmc.datafilter.client.CountryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class SoapConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setPackagesToScan("com/jpmc/datafilter");
        marshaller.setContextPath("com.local.article");
        return marshaller;
    }

    @Bean
    public CountryClient countryClient1(Jaxb2Marshaller jaxb2Marshaller) {
        CountryClient countryClient = new CountryClient();
//        countryClient.setDefaultUri("http://localhost:8089/ws");
        countryClient.setMarshaller(jaxb2Marshaller);
        countryClient.setUnmarshaller(jaxb2Marshaller);
        return countryClient;
    }
}
