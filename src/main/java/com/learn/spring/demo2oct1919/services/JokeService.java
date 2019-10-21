package com.learn.spring.demo2oct1919.services;

import com.learn.spring.demo2oct1919.json.JokeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {


    private static final String base = "http://api.icndb.com/jokes/random?";

    /*
    1) Spring autowires a single constructor
    2) Autowires the Resttemplate builder which is a single to create a resttemplate.
    3) Spring can autowire only when its a @service or if its a bean ..
    getforentity returns header
    getforobject returns the bojet oly

    *
    * */

    private RestTemplate restTemplate;
    @Autowired
    public JokeService(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public String getJoke(String first, String last) {
        String url = String.format("%sfirstName=%s&lastName=%s", base, first, last);
        JokeResponse response = restTemplate.getForObject(url, JokeResponse.class);
        return response.getValue().getJoke();
    }
}
