package com.example.curency.service;

import com.example.curency.model.Currency;

import java.util.List;

public interface CurrencyService {

    void create(Currency currency);
    List<Currency> readAll();
    Currency read(int id);
    boolean update(Currency currency, int id);
    boolean delete(int id);


}
