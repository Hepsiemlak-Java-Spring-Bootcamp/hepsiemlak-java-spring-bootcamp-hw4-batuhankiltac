package com.emlakburada.emlakburada.service;

import com.emlakburada.emlakburada.core.DataResult;
import com.emlakburada.emlakburada.core.Result;
import com.emlakburada.emlakburada.dto.request.MessageRequest;
import com.emlakburada.emlakburada.model.Message;

import java.util.List;

public interface MessageService {
    DataResult<List<Message>> getAll();
    Result add(MessageRequest messageRequest);
    Result update(MessageRequest messageRequest);
    Result delete(MessageRequest messageRequest);
}