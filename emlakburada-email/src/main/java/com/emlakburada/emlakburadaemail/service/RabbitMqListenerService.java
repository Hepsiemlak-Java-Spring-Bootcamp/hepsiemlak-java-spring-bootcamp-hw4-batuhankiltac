package com.emlakburada.emlakburadaemail.service;

import com.emlakburada.emlakburadaemail.dto.EmailMessage;
import com.emlakburada.emlakburadaemail.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqListenerService {
    private final EmailService emailService;

    @Autowired
    public RabbitMqListenerService(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${emlakburada.rabbitmq.queue}")
    public void receiveMessage(String message) {
        EmailMessage emailMessage = new EmailMessage(message);
        Email email = new Email();
        email.setEmail(message.split(",")[0]);
        email.setId(Integer.parseInt(message.split(",")[1]));
        log.info(message);
        emailService.send(emailMessage.getEmail().split(",")[0]);
    }
}