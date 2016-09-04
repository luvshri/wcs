package com.saltyfish.framework.service;

import com.saltyfish.domain.entity.auth.UserEntity;
import com.saltyfish.domain.entity.unit.CountyEntity;
import com.saltyfish.domain.entity.unit.TownEntity;
import com.saltyfish.domain.repository.auth.UserRepository;
import com.saltyfish.domain.repository.unit.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by weck on 16/9/4.
 */
@Service
public class UnitService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TownRepository townRepository;

    public CountyEntity getCountyByUserId(Integer userId){
        return userRepository.findById(userId).getCounty();
    }

    public List<TownEntity> getAccessedTowns(Integer userId) {
        UserEntity user = userRepository.findById(userId);
        return user.getTowns() == null ? townRepository.findByCountyId(user.getCounty().getId()) : user.getTowns();
    }
}
