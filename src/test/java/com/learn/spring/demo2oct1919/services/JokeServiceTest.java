package com.learn.spring.demo2oct1919.services;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JokeServiceTest {

    private Logger logger = LoggerFactory.getLogger(JokeService.class);

    @Autowired
    private JokeService service;


    @Test
    public void getJoke(){
        String joke = service.getJoke("Ramesh","Veeramani");
        logger.info(joke);
        assertTrue(joke.contains("Ramesh") || joke.contains("Veeramani"));
    }


}