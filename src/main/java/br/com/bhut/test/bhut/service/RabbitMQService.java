package br.com.bhut.test.bhut.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    @Autowired
    private RabbitTemplate template;

    public void sendMessage(String queueName, Object message) {
        this.template.convertAndSend(queueName, message);
    }

}
