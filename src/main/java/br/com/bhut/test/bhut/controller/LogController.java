package br.com.bhut.test.bhut.controller;

import br.com.bhut.test.bhut.entity.Log;
import br.com.bhut.test.bhut.service.ListLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private ListLogsService service;

    @GetMapping
    public List<Log> list() {
        List<Log> logs = service.list();

        return logs;
    }

}
