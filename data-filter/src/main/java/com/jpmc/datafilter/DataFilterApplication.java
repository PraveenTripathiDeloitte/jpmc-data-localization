package com.jpmc.datafilter;

import com.jpmc.datafilter.client.CountryClient;
//import com.jpmc.datafilter.config.SoapClientConfig;
import com.jpmc.datafilter.config.SoapConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DataFilterApplication {

	public static void main(String[] args) {

		SpringApplication.run(DataFilterApplication.class, args);
//		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SoapConfig.class);
//		CountryClient countryClient = annotationConfigApplicationContext.getBean(CountryClient.class);
//		System.out.println(countryClient.getCountry("CHA231BLR").getCountry());
	}

}
