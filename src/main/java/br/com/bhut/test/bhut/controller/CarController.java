package br.com.bhut.test.bhut.controller;

import br.com.bhut.test.bhut.constants.RabbitMQConstants;
import br.com.bhut.test.bhut.dto.CarDto;
import br.com.bhut.test.bhut.service.CreateCarService;
import br.com.bhut.test.bhut.service.ListCarsService;
import br.com.bhut.test.bhut.service.RabbitMQService;
import br.com.bhut.test.bhut.vo.CarVO;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private ListCarsService listCarsService;

    @Autowired
    private CreateCarService createCarService;

    @Autowired
    private RabbitMQService rabbitMQService;

    @GetMapping("/listCars")
    public ResponseEntity<Object> list() {
        JSONArray cars = listCarsService.list();

        return new ResponseEntity<>(cars.toList(), HttpStatus.OK);
    }

    @PostMapping("/createCar")
    public ResponseEntity<CarVO> create(@RequestBody @Valid CarDto dto) throws IOException, InterruptedException {
        CarVO car = createCarService.create(dto);

        // Send message to queue
        rabbitMQService.sendMessage(RabbitMQConstants.CAR_QUEUE, dto);

        URI uri = URI.create("api-test.bhut.com.br:3000/api/cars/" + car.get_id());

        return ResponseEntity.created(uri).body(car);
    }
}
