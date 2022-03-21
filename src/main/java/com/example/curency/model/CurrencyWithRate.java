package com.example.curency.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CurrencyWithRate {
    public Currency currency;
    public Float rate;
}
