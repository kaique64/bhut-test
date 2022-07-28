package br.com.bhut.test.bhut.service;

import br.com.bhut.test.bhut.dto.CarDto;
import br.com.bhut.test.bhut.entity.Log;
import br.com.bhut.test.bhut.entity.factory.LogBuilder;
import br.com.bhut.test.bhut.http.ClientHttp;
import br.com.bhut.test.bhut.repository.LogRepository;
import br.com.bhut.test.bhut.utils.JsonParser;
import br.com.bhut.test.bhut.vo.CarVO;
import br.com.bhut.test.bhut.vo.factory.CarVOBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

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

        CarVO carVO = CarVOBuilder.builder()
                .id(car.getString("_id"))
                .title(car.getString("title"))
                .brand(car.getString("brand"))
                .price(car.getString("price"))
                .age(car.getInt("age"))
                .build();

        // Save log
        Log log = LogBuilder.builder()
                .carId(car.get("_id").toString())
                .dataHora(LocalDateTime.now())
                .build();

        logRepository.save(log);

        return carVO;
    }

}
