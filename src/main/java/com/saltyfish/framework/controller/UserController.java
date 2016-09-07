package com.saltyfish.framework.controller;

import com.saltyfish.common.bean.Response;
import com.saltyfish.domain.entity.auth.UserEntity;
import com.saltyfish.framework.service.ProjectService;
import com.saltyfish.framework.service.ResponseService;
import com.saltyfish.framework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weck on 16/9/2.
 * <p>
 * 用户操作请求
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ResponseService responseService;

    @Autowired
    private UserService userService;


    /**
     * 登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping("/login")
    public Response login(@RequestParam("userName") String userName,
                          @RequestParam("password") String password) {
        Response rp = new Response();

        try {
            UserEntity userEntity = userService.findByName(userName);
            if (userEntity != null) {
                if (userService.verifyPassword(userEntity, password)) {
                    userService.setToken(userEntity);
                    rp.setCode(HttpStatus.OK.value());
                    Map<String, Object> msg = new HashMap<>();
                    msg.put("user", userEntity);
                    rp.setData(msg);
                    return rp;
                } else {
                    responseService.inCorrectPassword(rp);
                    return rp;
                }
            } else {
                responseService.notFound(rp);
                return rp;
            }
        } catch (Exception e) {
            responseService.serverError(rp);
            return rp;
        }
    }
}
