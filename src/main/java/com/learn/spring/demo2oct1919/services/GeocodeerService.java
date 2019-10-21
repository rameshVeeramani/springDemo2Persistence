package com.learn.spring.demo2oct1919.services;

import com.learn.spring.demo2oct1919.json.Response;
import com.learn.spring.demo2oct1919.json.Site;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class GeocodeerService {

    private static final String Base = "https://maps.googleapis.com/maps/api/geocode/json";
    private static final String KEY = "AIzaSyAHPJ7so6ZBpYPK84H5JRyLCPqRtpwkEO8";
    private RestTemplate template;

    public GeocodeerService(RestTemplateBuilder builder){
        template= builder.setConnectTimeout(Duration.ofSeconds(2)).build();
    }

    private String encodeString(String s) {
        String encode = URLEncoder.encode(s);
        return encode;

    }

    public Site getlatlng(String...address) {
        String encodedAddress = Arrays.stream(address)
                .map(s -> encodeString(s))
                .collect(Collectors.joining(","));
        String url = String.format("%s?address=%s&key=%s", Base, encodedAddress, KEY);
        System.out.println(url);
        Response response =   template.getForObject(url, Response.class);

        System.out.println(response.getResults().length);
        Site site = new Site("",response.getlocation().getLat(),response.getlocation().getLan());
        return  site;
    }
}
