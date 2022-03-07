package com.emlakburada.emlakburada.controller;

import com.emlakburada.emlakburada.dto.request.MessageRequest;
import com.emlakburada.emlakburada.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(value = "/messages")
    public ResponseEntity<?> addMessage(@RequestBody MessageRequest messageRequest) {
        return ResponseEntity.ok(messageService.add(messageRequest));
    }

    @GetMapping(value = "/messages")
    public ResponseEntity<?> getAllMessages() {
        return ResponseEntity.ok(messageService.getAll());
    }

    @PutMapping(value = "/messages")
    public ResponseEntity<?> updateMessage(@RequestBody MessageRequest messageRequest) {
        return ResponseEntity.ok(messageService.update(messageRequest));
    }

    @DeleteMapping(value = "/messages")
    public ResponseEntity<?> deleteMessage(@RequestBody MessageRequest messageRequest) {
        return ResponseEntity.ok(messageService.delete(messageRequest));
    }
}