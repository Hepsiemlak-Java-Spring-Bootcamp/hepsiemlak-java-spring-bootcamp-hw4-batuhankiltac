package com.emlakburada.emlakburada.service;

import com.emlakburada.emlakburada.core.DataResult;
import com.emlakburada.emlakburada.core.Result;
import com.emlakburada.emlakburada.core.SuccessDataResult;
import com.emlakburada.emlakburada.core.SuccessResult;
import com.emlakburada.emlakburada.dto.request.UserRequest;
import com.emlakburada.emlakburada.model.User;
import com.emlakburada.emlakburada.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>("Listed all users.", userRepository.findAll());
    }

    @Override
    public Result add(UserRequest userRequest) {
        UserBaseService userBaseService = new UserBaseService();
        User user = userBaseService.convertToUserEntity(userRequest);
        userRepository.save(user);
        return new SuccessResult("User has been added to Database.");
    }

    @Override
    public Result update(UserRequest userRequest) {
        User user = new User();
        user.setId(userRequest.getId());
        user.setUserType(userRequest.getUserType());
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setBio(userRequest.getBio());
        userRepository.save(user);
        return new SuccessResult("User has been updated.");
    }

    @Override
    public Result delete(UserRequest userRequest) {
        User user = new User();
        user.setId(userRequest.getId());
        userRepository.delete(user);
        return new SuccessResult("User has been deleted.");
    }
}