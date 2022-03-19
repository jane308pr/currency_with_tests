package com.example.curency.controller;

import com.example.curency.model.Currency;
import com.example.curency.model.Rate;
import com.example.curency.model.RateMainJson;
import com.example.curency.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RateController {
    private static final String APP_ID = "1ce73ad6a57744ba8514dd76d877b297";

    @Autowired
    private Rate symbol;

    @Autowired
    private RateService rateService;



    @GetMapping("latest.json")
    RateMainJson getRates(@RequestParam String app_id, String symbol) {
        RateMainJson rates = rateService.getRates(APP_ID, symbol);
        return rates;
    }
}