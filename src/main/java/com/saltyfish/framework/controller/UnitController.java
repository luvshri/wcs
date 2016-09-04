package com.saltyfish.framework.controller;

import com.saltyfish.common.bean.Response;
import com.saltyfish.framework.service.ResponseService;
import com.saltyfish.framework.service.UnitService;
import com.saltyfish.framework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weck on 16/9/4.
 */
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @Autowired
    private UserService userService;

    @Autowired
    private ResponseService responseService;

    /**
     * 获取权限范围内的乡镇
     * @param userId 用户id
     * @param token 登录token
     * @return
     */
    @RequestMapping("/getAccessedTowns")
    public Response getAccessedTowns(@RequestParam("userId") Integer userId,
                                    @RequestParam("token") String token){
        Response response = new Response();
        try {
            if (!userService.checkLogin(userId,token)){
                return responseService.notLogin(response);
            }
            else {
                Map<String,Object> data = new HashMap<>();
                data.put("county",unitService.getCountyByUserId(userId));
                data.put("towns",unitService.getAccessedTowns(userId));
                response.setData(data);
                response.setCode(HttpStatus.OK.value());
                return response;
            }
        }catch (Exception e){
            return responseService.serverError(response);
        }
    }
}
