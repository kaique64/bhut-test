package br.com.bhut.test.bhut.controller;

import br.com.bhut.test.bhut.service.ListCarsService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/listCars")
public class ListCarsController {

    @Autowired
    private ListCarsService service;

    @GetMapping
    public ResponseEntity<Object> listCars() {
        JSONArray cars = service.list();

        return new ResponseEntity<>(cars.toList(), HttpStatus.OK);
    }

}
