package com.example.curency.controller;

import com.example.curency.model.Currency;

import com.example.curency.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CurrencyController {

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }
    /*створення нового клієта
@PostMapping(value = "/clients") — здесь мы обозначаем, что данный метод обрабатывает POST запросы на адрес /clients

Метод возвращает ResponseEntity<?>. ResponseEntity — специальный класс для возврата ответов. С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код.

Метод принимает параметр @RequestBody Client client, значение этого параметра подставляется из тела запроса. Об этом говорит аннотация  @RequestBody.

Внутри тела метода мы вызываем метод create у ранее созданного сервиса и передаем ему принятого в параметрах контроллера клиента.

После чего возвращаем статус 201 Created, создав новый объект ResponseEntity и передав в него нужное значение енума HttpStatus.

     */

    @PostMapping(value = "/currency")
    public ResponseEntity<?> create(@RequestBody Currency currency) {
        currencyService.create(currency);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    /*Далее реализуем операцию Read:

Для начала реализуем операцию получения списка всех имеющихся клиентов:

     */
    @GetMapping(value = "/currency")
    public ResponseEntity<List<Currency>> read() {
        final List<Currency> currencyList = currencyService.readAll();

        return currencyList != null &&  !currencyList.isEmpty()
                ? new ResponseEntity<>(currencyList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /*Далее реализуем возможность получать клиента по его id:
    Из нового, у нас тут появилась переменная пути. Переменная, которая определена в URI. value = "/clients/{id}". Мы указали ее в фигурных скобках. А в параметрах метода принимаем её в качестве int переменной, с помощью аннотации @PathVariable(name = "id").

Данный метод будет принимать запросы на uri вида /clients/{id}, где вместо {id} может быть любое численное значение. Данное значение, впоследствии, передается переменной int id — параметру метода.

В теле мы получаем объект Client с помощью нашего сервиса и принятого id. И далее, по аналогии со списком, возвращаем либо статус 200 OK и сам объект Client, либо просто статус 404 Not Found, если клиента с таким id не оказалось в системе.

     */
    @GetMapping(value = "/currency/{id}")
    public ResponseEntity<Currency> read(@PathVariable(name = "id") int id) {
        final Currency currency = currencyService.read(id);


        return currency != null
                ? new ResponseEntity<>(currency,  HttpStatus.OK)
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