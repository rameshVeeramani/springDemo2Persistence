package com.learn.spring.demo2oct1919.services;


import com.learn.spring.demo2oct1919.json.Site;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GeocoderServiceTest {


    private Logger logger = LoggerFactory.getLogger(GeocoderServiceTest.class);
    @Autowired
    public GeocodeerService gs;

    @Test
    public void getLatLangWithoutStreet()
    {
        Site site = gs.getlatlng("Boston", "MA");
        System.out.println(site.getLatitute());
        System.out.println(site.getLongitute());
        assertAll(
                () -> assertEquals(site.getLatitute(),323)
        );
    }

    public void getLatLngWithStreet(){

    }

}
