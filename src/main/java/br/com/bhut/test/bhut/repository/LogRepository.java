package br.com.bhut.test.bhut.repository;

import br.com.bhut.test.bhut.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, String> {
}
