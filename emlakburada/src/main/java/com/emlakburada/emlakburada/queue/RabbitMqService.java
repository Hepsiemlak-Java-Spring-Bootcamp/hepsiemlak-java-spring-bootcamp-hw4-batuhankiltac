package com.emlakburada.emlakburada.queue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
public class RabbitMqService implements QueueService {
    private final AmqpTemplate rabbitTemplate;
    private final Queue queue;

    @Autowired
    public RabbitMqService(AmqpTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    @Override
    public void sendMessage(String email) {
        rabbitTemplate.convertAndSend(String.valueOf(queue), email);
    }
}