package com.saltyfish.framework.service;

import com.saltyfish.domain.entity.auth.UserEntity;
import com.saltyfish.domain.entity.location.LocationEntity;
import com.saltyfish.domain.entity.unit.CountyEntity;
import com.saltyfish.domain.entity.unit.GroupEntity;
import com.saltyfish.domain.entity.unit.TownEntity;
import com.saltyfish.domain.entity.unit.VillageEntity;
import com.saltyfish.domain.repository.LocationRepository;
import com.saltyfish.domain.repository.auth.UserRepository;
import com.saltyfish.domain.repository.unit.CountyRepository;
import com.saltyfish.domain.repository.unit.GroupRepository;
import com.saltyfish.domain.repository.unit.TownRepository;
import com.saltyfish.domain.repository.unit.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
    @Autowired
    private CountyRepository countyRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private VillageRepository villageRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserService userService;

    /**
     * 根据用户id获取当前县信息
     *
     * @param userId 用户id
     * @return
     */
    public CountyEntity getCountyByUserId(Integer userId) {
        return userRepository.findById(userId).getCounty();
    }

    /**
     * 根据用户id获取权限范围内的乡镇信息
     *
     * @param userId 用户id
     * @return
     */
    public List<TownEntity> getAccessedTowns(Integer userId) {
        UserEntity user = userRepository.findById(userId);
        if (userService.checkAdmin(userId)) {
            return townRepository.findByCountyId(user.getCounty().getId());
        }
        return user.getTowns();
    }

    /**
     * 新增县
     *
     * @param countyName 县名
     * @param longitude  经度
     * @param latitude   纬度
     * @param timeStamp  时间戳
     */
    public void addCounty(String countyName, BigDecimal longitude, BigDecimal latitude, Long timeStamp) {
        Timestamp time = new Timestamp(timeStamp);
        LocationEntity location = new LocationEntity();
        location.setCreateTime(time);
        location.setUpdateTime(time);
        location.setIsDelete(0);
        location.setLongitude(longitude);
        location.setLatitude(latitude);
        locationRepository.save(location);
        CountyEntity county = new CountyEntity();
        county.setCreateTime(time);
        county.setIsDelete(0);
        county.setUpdateTime(time);
        county.setIsActive(1);
        county.setName(countyName);
        county.setLocation(location);
        countyRepository.save(county);
    }

    /**
     * 修改县
     *
     * @param countyId   当前修改县id
     * @param countyName 县名
     * @param longitude  经度
     * @param latitude   纬度
     * @param timeStamp  时间戳
     */
    public void updateCounty(Integer countyId, String countyName, BigDecimal longitude, BigDecimal latitude, Long timeStamp) {
        Timestamp time = new Timestamp(timeStamp);
        CountyEntity county = countyRepository.findById(countyId);
        if (!county.getLocation().getLatitude().equals(latitude) || !county.getLocation().getLongitude().equals(longitude)) {
            locationRepository.delete(county.getLocation());
            LocationEntity location = new LocationEntity();
            location.setCreateTime(time);
            location.setUpdateTime(time);
            location.setIsDelete(0);
            location.setLongitude(longitude);
            location.setLatitude(latitude);
            locationRepository.save(location);
            county.setLocation(location);
        }
        county.setUpdateTime(time);
        county.setName(countyName);
        countyRepository.save(county);
    }

    /**
     * 获取县的列表
     *
     * @return
     */
    public List<CountyEntity> getCounties() {
        return countyRepository.findByIsDelete(0);
    }

    /**
     * 根据乡镇获取村list
     *
     * @param townId 乡镇id
     * @return
     */
    public List<VillageEntity> getVillagesByTown(Integer townId) {
        return villageRepository.findByTownId(townId);
    }

    /**
     * 根据id获取村庄
     *
     * @param villageId 村庄id
     * @return
     */
    public VillageEntity getVillageById(Integer villageId) {
        return villageRepository.findById(villageId);
    }

    /**
     * 根据村庄获取组list
     *
     * @param villageId 村庄id
     * @return
     */
    public List<GroupEntity> getGroupsByVillage(Integer villageId) {
        return groupRepository.findByVillageId(villageId);
    }

    /**
     * 添加乡镇
     *
     * @param userId    用户id
     * @param townName  乡镇名称
     * @param timeStamp 时间戳
     */
    public void addTown(Integer userId, String townName, Long timeStamp) {
        TownEntity town = new TownEntity();
        Timestamp time = new Timestamp(timeStamp);
        town.setName(townName);
        town.setCreateTime(time);
        town.setUpdateTime(time);
        town.setIsActive(1);
        town.setIsDelete(0);
        town.setCounty(userRepository.findById(userId).getCounty());
        townRepository.save(town);
    }
}
