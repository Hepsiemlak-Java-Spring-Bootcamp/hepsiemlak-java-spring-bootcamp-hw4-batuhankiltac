package com.emlakburada.emlakburada.service;

import com.emlakburada.emlakburada.core.DataResult;
import com.emlakburada.emlakburada.core.Result;
import com.emlakburada.emlakburada.core.SuccessDataResult;
import com.emlakburada.emlakburada.core.SuccessResult;
import com.emlakburada.emlakburada.dto.request.MessageRequest;
import com.emlakburada.emlakburada.model.Message;
import com.emlakburada.emlakburada.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public DataResult<List<Message>> getAll() {
        return new SuccessDataResult<>("Listed all messages.", messageRepository.findAll());
    }

    @Override
    public Result add(MessageRequest messageRequest) {
        MessageBaseService messageBaseService = new MessageBaseService();
        Message message = messageBaseService.convertToMessageEntity(messageRequest);
        messageRepository.save(message);
        return new SuccessResult("Message has been added to Database.");
    }

    @Override
    public Result update(MessageRequest messageRequest) {
        Message message = new Message();
        message.setId(messageRequest.getId());
        message.setTitle(messageRequest.getTitle());
        message.setDescription(messageRequest.getDescription());
        //message.setSender(messageRequest.getSender());
        //message.setReceiver(messageRequest.getReceiver());
        messageRepository.save(message);
        return new SuccessResult("Message has been updated.");
    }

    @Override
    public Result delete(MessageRequest messageRequest) {
        Message message = new Message();
        message.setId(messageRequest.getId());
        messageRepository.delete(message);
        return new SuccessResult("Message has been deleted.");
    }
}