package com.saltyfish.framework.controller;

import com.saltyfish.common.utils.UUIDGenerator;
import com.saltyfish.domain.entity.auth.UserEntity;
import com.saltyfish.domain.repository.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by weck on 16/9/2.
 */
@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/test")
    public UserEntity test() {
        UserEntity userEntity = userRepository.findById(1);
        userEntity.setToken(UUIDGenerator.getUUID());
        userRepository.save(userEntity);
        return userEntity;
    }
}
