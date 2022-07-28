package br.com.bhut.test.bhut.entity.factory;

import br.com.bhut.test.bhut.entity.Log;

import java.time.LocalDateTime;

public class LogBuilder {

    private final Log log;


    public LogBuilder(final Log log) {
        this.log = log;
    }

    public static LogBuilder builder() {
        return new LogBuilder(new Log());
    }

    public LogBuilder id(String id) {
        this.log.setId(id);
        return this;
    }

    public LogBuilder carId(String carId) {
        this.log.setCar_id(carId);
        return this;
    }


    public LogBuilder dataHora(LocalDateTime dataHora) {
        this.log.setData_hora(dataHora);
        return this;
    }

    public Log build() {
        return this.log;
    }

}
