package br.com.bhut.test.bhut.service;

import br.com.bhut.test.bhut.entity.Car;
import br.com.bhut.test.bhut.http.ClientHttp;
import br.com.bhut.test.bhut.repository.CarRepository;
import br.com.bhut.test.bhut.utils.JsonParser;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ListCarsService {

    public JSONArray list() {
        ClientHttp clientHttp = new ClientHttp();
        String data = clientHttp.searchData("http://api-test.bhut.com.br:3000/api/cars");
        JsonParser parser = new JsonParser();
        JSONArray carsInJson = parser.parse(data);

        return carsInJson;
    }

}
