package br.com.bhut.test.bhut.connection;

import br.com.bhut.test.bhut.constants.RabbitMQConstants;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConnection {

    private static final String EXCHANGE_NAME = "amq.direct";
    private AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    private Queue queue(String queueName) {
        return new Queue(queueName, true, false, false);
    }

    private DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    private Binding relation(Queue queue, DirectExchange exchange) {
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE, exchange.getName(), queue.getName(), null);
    }

    @PostConstruct
    private void add() {
        Queue carQueue = this.queue(RabbitMQConstants.CAR_QUEUE);

        DirectExchange exchange = this.directExchange();

        Binding carRelation = this.relation(carQueue, exchange);

        // Create the queues
        this.amqpAdmin.declareQueue(carQueue);

        // Create exchange
        this.amqpAdmin.declareExchange(exchange);

        // Create relation
        this.amqpAdmin.declareBinding(carRelation);
    }

}
