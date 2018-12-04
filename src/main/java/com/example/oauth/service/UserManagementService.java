package com.example.oauth.service;

import com.example.oauth.api.SignUpRequest;
import com.example.oauth.api.User;
import com.example.oauth.config.ServiceConfiguration;
import com.example.oauth.domain.UserEntity;
import com.example.oauth.domain.UserRepository;
import com.example.oauth.service.mapping.UserMapper;
import com.example.oauth.service.util.PasswordValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserManagementService {

    public static final String ADMINISTRATION_CREDENTIAL_NOT_SET_PLEASE_CHECK_YOUR_SETTINGS = "Administration password not set. Please check your settings";


    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordValidator passwordValidator;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ServiceConfiguration serviceConfiguration;

    @Autowired
    PasswordEncoder passwordEncoder;


    @EventListener(ApplicationReadyEvent.class)
    public void handleAdminPasswordRegistration(){

        ServiceConfiguration.Admin adminProps = serviceConfiguration.getAdmin();

        if (adminProps != null && passwordValidator.isValid(adminProps.getPassword())) {
            changeAdminPassword(adminProps.getPassword());
        } else {
            log.error(ADMINISTRATION_CREDENTIAL_NOT_SET_PLEASE_CHECK_YOUR_SETTINGS);
            throw new RuntimeException(ADMINISTRATION_CREDENTIAL_NOT_SET_PLEASE_CHECK_YOUR_SETTINGS);
        }

    }

    @Transactional
    protected void changeAdminPassword(String password) {
        UserEntity userEntity = userRepository.findByUsername("admin");
        userEntity.setPassword(passwordEncoder.encode(password));

        userRepository.save(userEntity);
    }

    @Transactional
    public User signUp(SignUpRequest signUpRequest) {

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(signUpRequest.getUsername());
        userEntity.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        userEntity = userRepository.save(userEntity);

        return userMapper.toResource(userEntity);
    }
}
