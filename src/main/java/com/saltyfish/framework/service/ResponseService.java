package com.saltyfish.framework.service;

import com.saltyfish.common.bean.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weck on 16/9/3.
 * <p>
 * 返回service
 */
@Service
public class ResponseService {

    /**
     * 未登录返回
     *
     * @param response 返回对象
     * @return response
     */
    public Response notLogin(Response response) {
        response.setCode(HttpStatus.UNAUTHORIZED.value());
        Map<String, Object> msg = new HashMap<>();
        msg.put("details", "请登录");
        response.setError(msg);
        return response;
    }

    /**
     * 服务器错误
     *
     * @param response 返回对象
     * @return response
     */
    public Response serverError(Response response) {
        Map<String, Object> msg = new HashMap<>();
        msg.put("details", "服务器错误");
        response.setError(msg);
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return response;
    }

    /**
     * 没有权限
     *
     * @param response 返回对象
     * @return response
     */
    public Response noAccess(Response response) {
        response.setCode(HttpStatus.FORBIDDEN.value());
        Map<String, Object> msg = new HashMap<>();
        msg.put("details", "对不起,您没有权限");
        response.setError(msg);
        return response;
    }

    /**
     * 用户名不存在
     *
     * @param response 返回对象
     * @return response
     */
    public Response notFound(Response response) {
        response.setCode(HttpStatus.NOT_FOUND.value());
        Map<String, Object> msg = new HashMap<>();
        msg.put("details", "用户名不存在");
        response.setError(msg);
        return response;
    }

    /**
     * 密码不正确
     *
     * @param response 返回对象
     * @return response
     */
    public Response inCorrectPassword(Response response) {
        response.setCode(HttpStatus.NOT_ACCEPTABLE.value());
        Map<String, Object> msg = new HashMap<>();
        msg.put("details", "密码不正确");
        response.setError(msg);
        return response;
    }

    /**
     * 成功
     *
     * @param response 返回对象
     * @return response
     */
    public Response success(Response response) {
        response.setCode(HttpStatus.OK.value());
        Map<String, Object> msg = new HashMap<>();
        msg.put("details", "成功");
        response.setData(msg);
        return response;
    }


    /**
     * 错误路径
     *
     * @param response 返回对象
     * @return response
     */
    public Response errorPath(Response response) {
        response.setCode(HttpStatus.NOT_FOUND.value());
        Map<String, Object> msg = new HashMap<>();
        msg.put("details", "请求url错误");
        response.setError(msg);
        return response;
    }
}
