package com.example.oauth.service;

import com.example.oauth.api.SignUpRequest;
import com.example.oauth.api.User;
import com.example.oauth.domain.UserEntity;
import com.example.oauth.domain.UserRepository;
import com.example.oauth.service.mapping.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public User signUp(SignUpRequest signUpRequest) {

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(signUpRequest.getUsername());
        userEntity.setPassword(signUpRequest.getPassword());

        userEntity = userRepository.save(userEntity);

        return userMapper.toResource(userEntity);
    }
}
