package com.example.curency.controller;

import com.example.curency.model.Currency;

import com.example.curency.service.CurrencyService;
import com.example.curency.service.LastestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CurrencyController {

    private final CurrencyService currencyService;
    private final LastestResponse lastestResponse;

    @Autowired
    public CurrencyController(CurrencyService currencyService, LastestResponse lastestResponse) {
        this.currencyService = currencyService;
        this.lastestResponse = lastestResponse;
    }
    /*створення нового клієта
@PostMapping(value = "/clients") — здесь мы обозначаем, что данный метод обрабатывает POST запросы на адрес /clients
Метод возвращает ResponseEntity<?>. ResponseEntity — специальный класс для возврата ответов.
Метод принимает параметр @RequestBody Client client, значение этого параметра подставляется из тела запроса.   @RequestBody.
Внутри тела метода мы вызываем метод create у ранее созданного сервиса и передаем ему принятого в параметрах контроллера клиента.
     */

    @PostMapping(value = "/currency")
    public ResponseEntity<?> create(@RequestBody Currency currency) {
        currencyService.create(currency);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    /*Далее реализуем операцию Read:для начала реализуем операцию получения списка всех имеющихся клиентов:
     */
    @GetMapping(value = "/currency")
    public ResponseEntity<List<Currency>> read() {
        final List<Currency> currencyList = currencyService.readAll();

        return currencyList != null &&  !currencyList.isEmpty()
                ? new ResponseEntity<>(currencyList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /*Далее реализуем возможность получать клиента по  id:
     */
    @GetMapping(value = "/currency/{id}")
    public ResponseEntity<Currency> read(@PathVariable(name = "id") int id) {
        final Currency currency = currencyService.read(id);
        final String rates = lastestResponse.rates;


        return currency != null
                ? new ResponseEntity< >(currency, rates, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/currency/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Currency currency) {
        final boolean updated = currencyService.update(currency, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = currencyService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}