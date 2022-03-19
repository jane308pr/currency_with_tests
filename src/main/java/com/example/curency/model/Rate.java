package com.example.curency.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.stereotype.Component;


@Component
public class Rate {

    @JsonProperty("symbols")
    private String symbol;
}
