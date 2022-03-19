package com.example.curency.service;

import com.example.curency.model.Currency;
import com.example.curency.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {



    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public void create(Currency client) {
        currencyRepository.save(client);
    }

    @Override
    public List<Currency>  readAll() {
        return currencyRepository.findAll();
    }


    @Override
    public Currency read(int id) {
        return currencyRepository.findById(id).get();

    }

    @Override
    public boolean update(Currency currency, int id) {
        if (currencyRepository.existsById(id)) {
            currency.setId(id);
            currencyRepository.save(currency);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (currencyRepository.existsById(id)) {
            currencyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}