package com.saltyfish.framework.service;

import com.saltyfish.domain.entity.auth.UserEntity;
import com.saltyfish.domain.entity.other.NotificationEntity;
import com.saltyfish.domain.repository.auth.UserRepository;
import com.saltyfish.domain.repository.other.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by weck on 16/9/3.
 */
@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private UserService userService;

    /**
     * 判断用户修改公告的权限
     *
     * @param notificationId
     * @param userId
     * @return
     */
    public Boolean checkModifyNotificationAccess(Integer notificationId, Integer userId) {
        NotificationEntity notificationEntity = notificationRepository.findById(notificationId);
        UserEntity userEntity = userRepository.findById(userId);
        return !((notificationEntity.getCategory() == 1 && !userService.checkSuperAdmin(userId))
                || (notificationEntity.getCategory() == 2 &&
                !userEntity.getCounty().getId().equals(notificationEntity.getUser().getCounty().getId())));
    }
}
