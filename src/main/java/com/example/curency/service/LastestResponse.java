package com.example.curency.service;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Component
public  class LastestResponse {
    public String disclaimer;
    public String license;
    public Long timestamp;
    public String base;
    public String rates;

    static RestTemplate restTemplate = new RestTemplate();

@ResponseBody
    public String rates() {
        String path = "https://openexchangerates.org/api/latest.json?app_id=117d55feb99d40ef9bc3569fbceea89c";

        HttpEntity<HttpHeaders> entity = new HttpEntity<>( null);

        var response  = restTemplate
                .exchange(path, HttpMethod.GET, entity, LastestResponse.class)
                .getBody();

        return response.base;
    }
}



