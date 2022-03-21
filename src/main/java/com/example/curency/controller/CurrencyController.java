package com.example.curency.controller;

import com.example.curency.model.Currency;

import com.example.curency.model.CurrencyWithRate;
import com.example.curency.service.CurrencyService;
import com.example.curency.service.ExternalCurrencyRate;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;
    private final ExternalCurrencyRate externalRates;

    @PostMapping(value = "/currency")
    public ResponseEntity<?> create(@RequestBody Currency currency) {
        currencyService.create(currency);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/currency")
    public ResponseEntity<List<Currency>> read() {
        List<Currency> currencyList = currencyService.readAll();

        return currencyList != null &&  !currencyList.isEmpty()
                ? new ResponseEntity<>(currencyList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/currency/{id}")
    public ResponseEntity<CurrencyWithRate> read(@PathVariable(name = "id") int id) {
        Currency currencyEntity = currencyService.read(id);
        Float rate = externalRates.getRate(currencyEntity.getCode());
        CurrencyWithRate data= new CurrencyWithRate(currencyEntity, rate);

        return currencyEntity != null
                ? new ResponseEntity<>(data, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/currency/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Currency currency) {
        boolean updated = currencyService.update(currency, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        boolean deleted = currencyService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}