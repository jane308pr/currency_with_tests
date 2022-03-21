package com.example.curency.model;

public class CurrencyWithRate {
    public Currency currency;
    public Float rate;

    public CurrencyWithRate (Currency c, Float r){
        this.currency=c;
        this.rate=r;
    }
}
