package com.cluster.global.repository;

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

    public String getGlobalResponse(String bankId){
       //Treat data as you like.

        return "Successfully received and processed global data!!";
    }
}
