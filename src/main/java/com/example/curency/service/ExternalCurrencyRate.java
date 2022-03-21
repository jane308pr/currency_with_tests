package com.example.curency.service;


import com.example.curency.model.CurrencyRate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public  class ExternalCurrencyRate {

    private static RestTemplate restTemplate = new RestTemplate();

    public float getRate(String currencyCode) {
        String path = "https://openexchangerates.org/api/latest.json?app_id=117d55feb99d40ef9bc3569fbceea89c";

        HttpEntity<HttpHeaders> entity = new HttpEntity<>( null);

        var response = restTemplate
                .exchange(path, HttpMethod.GET, entity, CurrencyRate.class)
                .getBody();

        return response.rates.get(currencyCode);
    }
}



