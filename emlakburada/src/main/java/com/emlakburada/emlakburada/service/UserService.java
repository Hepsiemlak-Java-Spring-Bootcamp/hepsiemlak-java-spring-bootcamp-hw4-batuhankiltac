package com.emlakburada.emlakburada.service;

import com.emlakburada.emlakburada.core.DataResult;
import com.emlakburada.emlakburada.core.Result;
import com.emlakburada.emlakburada.dto.request.UserRequest;
import com.emlakburada.emlakburada.model.User;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();
    Result add(UserRequest userRequest);
    Result update(UserRequest userRequest);
    Result delete(UserRequest userRequest);
}