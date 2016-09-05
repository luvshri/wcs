package com.saltyfish.framework.controller;

import com.saltyfish.common.bean.Response;
import com.saltyfish.domain.entity.other.NotificationEntity;
import com.saltyfish.framework.service.AuthService;
import com.saltyfish.framework.service.NotificationService;
import com.saltyfish.framework.service.ResponseService;
import com.saltyfish.framework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weck on 16/9/2.
 */
@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private UserService userService;
    @Autowired
    private ResponseService responseService;
    @Autowired
    private AuthService authService;

    /**
     * 添加新公告
     *
     * @param userId    用户id
     * @param token     登录token
     * @param title     标题
     * @param content   内容
     * @param timeStamp 时间戳
     * @param category  种类
     * @return
     */
    @RequestMapping("/addNotification")
    public Response addNotification(@RequestParam("userId") Integer userId,
                                    @RequestParam("token") String token,
                                    @RequestParam("title") String title,
                                    @RequestParam("content") String content,
                                    @RequestParam("timeStamp") Long timeStamp,
                                    @RequestParam(value = "category", required = false, defaultValue = "2") Integer category) {
        Response response = new Response();
        try {
            if (!userService.checkLogin(userId, token)) {
                return responseService.notLogin(response);
            } else if (category == 1 && !userService.checkSuperAdmin(userId)) {
                return responseService.noAccess(response);
            } else {
                notificationService.addNotification(title, content, timeStamp, userId, category);
                return responseService.success(response);
            }
        } catch (Exception e) {
            return responseService.serverError(response);
        }
    }

    /**
     * 更新公告
     *
     * @param userId         用户id
     * @param token          登录token
     * @param notificationId 公告id
     * @param title          标题
     * @param content        内容
     * @param timeStamp      时间戳
     * @return
     */
    @RequestMapping("/updateNotification")
    public Response updateNotification(@RequestParam("userId") Integer userId,
                                       @RequestParam("token") String token,
                                       @RequestParam("notificationId") Integer notificationId,
                                       @RequestParam("title") String title,
                                       @RequestParam("content") String content,
                                       @RequestParam("timeStamp") Long timeStamp) {
        Response response = new Response();
        try {
            if (!userService.checkLogin(userId, token)) {
                return responseService.notLogin(response);
            } else if (!authService.checkModifyNotificationAccess(notificationId, userId)) {
                return responseService.noAccess(response);
            } else {
                notificationService.updateNotification(notificationId, content, timeStamp, title, userId);
                return responseService.success(response);
            }
        } catch (Exception e) {
            return responseService.serverError(response);
        }
    }

    /**
     * 删除公告,isDelete设为1
     *
     * @param userId         用户id
     * @param token          登录token
     * @param notificationId 公告id
     * @param timeStamp      时间戳
     * @return
     */
    @RequestMapping("/deleteNotification")
    public Response deleteNotification(@RequestParam("userId") Integer userId,
                                       @RequestParam("token") String token,
                                       @RequestParam("notificationId") Integer notificationId,
                                       @RequestParam("timeStamp") Long timeStamp) {
        Response response = new Response();
        try {
            if (!userService.checkLogin(userId, token)) {
                return responseService.notLogin(response);
            } else if (!authService.checkModifyNotificationAccess(notificationId, userId)) {
                return responseService.noAccess(response);
            } else {
                notificationService.deleteNotification(notificationId, userId, timeStamp);
                return responseService.success(response);

            }
        } catch (Exception e) {
            return responseService.serverError(response);
        }
    }


    /**
     * 查看首页的公告
     *
     * @param page 页码
     * @param size 每页条数
     * @return response
     */
    @RequestMapping("/indexNotifications")
    public Response getIndexNotifications(@RequestParam("page") Integer page,
                                          @RequestParam("size") Integer size) {
        Response response = new Response();
        try {
            Page<NotificationEntity> notifications = notificationService.getIndexNotifications(page, size);
            response.setCode(HttpStatus.OK.value());
            Map<String, Object> msg = new HashMap<>();
            msg.put("notifications", notifications);
            response.setData(msg);
            return response;
        } catch (Exception e) {
            return responseService.serverError(response);
        }
    }

    /**
     * 查看县内公告
     *
     * @param page   页码
     * @param size   每页条数
     * @param userId 用户id
     * @param token  登录token
     * @return response
     */
    @RequestMapping("/countyNotifications")
    public Response getCountyNotifications(@RequestParam("page") Integer page,
                                           @RequestParam("size") Integer size,
                                           @RequestParam(value = "userId", required = false) Integer userId,
                                           @RequestParam(value = "token", required = false, defaultValue = "") String token) {
        Response response = new Response();
        Sort sort = new Sort(Sort.Direction.DESC, "updateTime");
        Pageable pageable = new PageRequest(page - 1, size, sort);
        try {
            /*如果用户未登录*/
            if (!userService.checkLogin(userId, token)) {
                return responseService.notLogin(response);
            } else {
                Page<NotificationEntity> notifications = notificationService.getCountyNotifications(page, size, userId, token);
                response.setCode(HttpStatus.OK.value());
                Map<String, Object> msg = new HashMap<>();
                msg.put("notifications", notifications);
                response.setData(msg);
                return response;
            }
        } catch (Exception e) {
            return responseService.serverError(response);
        }
    }

}
