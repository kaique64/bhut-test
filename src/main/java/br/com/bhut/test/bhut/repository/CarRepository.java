package br.com.bhut.test.bhut.repository;

import br.com.bhut.test.bhut.entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, String> {
}
