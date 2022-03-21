package com.example.curency.model;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;

@Builder
@Data
public class CurrencyRate {
    public String disclaimer;
    public String license;
    public Long timestamp;
    public String base;
    public HashMap<String, Float> rates;
}

