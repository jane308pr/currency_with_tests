package com.example.curency.service;
import com.example.curency.model.RateMainJson;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(url= "https://openexchangerates.org/api")
public class RateService {
    @GetMapping("/latest.json")
    public RateMainJson getRates(@RequestParam String app_id, String symbols) {
        return null;
        //RateMainJson rates = getRates.rates ();

    }





}
