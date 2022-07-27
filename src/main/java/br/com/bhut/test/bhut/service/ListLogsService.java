package br.com.bhut.test.bhut.service;

import br.com.bhut.test.bhut.entity.Log;
import br.com.bhut.test.bhut.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListLogsService {

    @Autowired
    private LogRepository logRepository;

    public List<Log> list() {
        List<Log> logs = logRepository.findAll();

        return logs;
    }

}
