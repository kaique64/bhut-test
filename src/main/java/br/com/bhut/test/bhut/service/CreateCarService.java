package br.com.bhut.test.bhut.service;

import br.com.bhut.test.bhut.dto.CarDto;
import br.com.bhut.test.bhut.entity.Log;
import br.com.bhut.test.bhut.http.ClientHttp;
import br.com.bhut.test.bhut.repository.LogRepository;
import br.com.bhut.test.bhut.utils.JsonParser;
import br.com.bhut.test.bhut.vo.CarVO;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.time.LocalDate;

@Service
public class CreateCarService {

    @Autowired
    private LogRepository logRepository;
    private JSONObject body;

    public CarVO create(CarDto dto) throws IOException, InterruptedException {
        ClientHttp clientHttp = new ClientHttp();
        JSONObject body = new JSONObject();
        JsonParser parser = new JsonParser();

        body.put("title", dto.getTitle());
        body.put("brand", dto.getBrand());
        body.put("price", dto.getPrice());
        body.put("age", dto.getAge());

        HttpResponse<String> response = clientHttp.post("http://api-test.bhut.com.br:3000/api/cars", body);
        JSONObject car = parser.parseObject(response.body());

        CarVO carVO = new CarVO(
                car.getString("_id"),
                car.getString("title"),
                car.getString("brand"),
                car.getString("price"),
                car.getInt("age"));

        // Save log
        Log log = new Log();
        log.setCar_id(car.get("_id").toString());
        log.setData_hora(LocalDate.now());

        logRepository.save(log);

        return carVO;
    }

}
