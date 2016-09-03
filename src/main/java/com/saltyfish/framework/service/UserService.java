package com.saltyfish.framework.service;

import com.saltyfish.common.utils.PasswordEncode;
import com.saltyfish.common.utils.UUIDGenerator;
import com.saltyfish.domain.entity.auth.UserEntity;
import com.saltyfish.domain.repository.auth.RoleRepository;
import com.saltyfish.domain.repository.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by weck on 16/9/2.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    /**
     * 根据id找用户实体
     *
     * @param id 用户id
     * @return UserEntity
     */
    public UserEntity findById(Integer id) {
        return userRepository.findById(id);
    }

    /**
     * 根据id检测用户是否超级管理员
     *
     * @param id
     * @return
     */
    public Boolean checkSuperAdmin(Integer id) {
        return userRepository.findById(id).getRoles().contains(roleRepository.findByName("superAdmin"));
    }

    /**
     * 判断用户是否登录
     *
     * @param id    用户id
     * @param token 登录token
     * @return
     */
    public Boolean checkLogin(Integer id, String token) {
        return token.equals(userRepository.findById(id).getToken());
    }


    /**
     * 登录设置token
     *
     * @param userEntity
     */
    public void setToken(UserEntity userEntity) {
        userEntity.setToken(UUIDGenerator.getUUID());
        userEntity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        userRepository.save(userEntity);
    }

    /**
     * 检测密码
     *
     * @param userEntity
     * @param password
     * @return
     */
    public Boolean verifyPassword(UserEntity userEntity, String password) {
        return PasswordEncode.verify(userEntity.getPassword(), password, userEntity.getSalt());
    }

    /**
     * 根据用户名查找用户
     *
     * @param userName
     * @return
     */
    public UserEntity findByName(String userName) {
        return userRepository.findByName(userName);
    }
}
