package com.example.curency.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RateMainJson {
    @JsonProperty("disclaimer")
    private String disclaimer;

    @JsonProperty("license")
    private String license;

    @JsonProperty("timestamp")
    private Long timestamp;

    @JsonProperty("base")
    private String base;

    @JsonProperty("rates")
    private Rate rates;// Rate replaced by float
}
