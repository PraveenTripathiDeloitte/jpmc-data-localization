package com.sample.filterdata.repository;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Component
public class CountryRepository {

    private static final Map<String, List<String>> countries = new HashMap<>();

    @PostConstruct
    public void initData(){

    }

    public String findCountry(String bankId){
        String regex = "[A-Z0-9]+CHE|DEL|BOM|BLR";
        if (Pattern.compile(regex).matcher(bankId).find())
            return "India data!!!";
        return "Global data!!!";
    }
}
