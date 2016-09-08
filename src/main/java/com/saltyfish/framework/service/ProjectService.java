package com.saltyfish.framework.service;

import com.saltyfish.domain.entity.location.LocationEntity;
import com.saltyfish.domain.entity.project.WaterConservationEntity;
import com.saltyfish.domain.entity.project.conservation.AqueductEntity;
import com.saltyfish.domain.repository.LocationRepository;
import com.saltyfish.domain.repository.auth.UserRepository;
import com.saltyfish.domain.repository.project.AqueductRepository;
import com.saltyfish.domain.repository.unit.GroupRepository;
import com.saltyfish.domain.repository.unit.TownRepository;
import com.saltyfish.domain.repository.unit.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by weck on 16/9/3.
 * <p>
 * 工程操作
 */
@Service
public class ProjectService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TownRepository townRepository;

    @Autowired
    private VillageRepository villageRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private AqueductRepository aqueductRepository;

    /**
     * 保存共有属性
     */
    public void setCommonProperty(WaterConservationEntity wc, Integer userId, String category, String remark,
                                  String name, String code, String manageModel, Integer townId, Integer villageId,
                                  Integer groupId, String situation, String constructTime, String constructUnit,
                                  String propertyOwner, String manager, BigDecimal longitude, BigDecimal latitude,
                                  Long timeStamp) {
        Timestamp time = new Timestamp(timeStamp);
        wc.setCounty(userRepository.findById(userId).getCounty());
        wc.setCategory(category);
        wc.setRemark(remark);
        wc.setName(name);
        wc.setCode(code);
        wc.setManageModel(manageModel);
        wc.setTown(townRepository.findById(townId));
        wc.setVillage(villageRepository.findById(villageId));
        wc.setGroup(groupRepository.findById(groupId));
        wc.setSituation(situation);
        wc.setConstructTIme(constructTime);
        wc.setConstructUnit(constructUnit);
        wc.setPropertyOwner(propertyOwner);
        wc.setManager(manager);
        wc.setIsDelete(0);
        LocationEntity location = new LocationEntity();
        location.setLongitude(longitude);
        location.setLatitude(latitude);
        location.setIsDelete(0);
        location.setCreateTime(time);
        location.setUpdateTime(time);
        locationRepository.save(location);
        wc.setLocation(location);
    }

    /**
     * 保存渡槽属性
     */
    public void saveAqueduct(AqueductEntity aqueduct, String crossWatercourseLocation, String crossCount, String sectionSize, String structureAndMaterial, String crossLength, String imagePath) {
        aqueduct.setCrossCount(crossCount);
        aqueduct.setCrossLength(crossLength);
        aqueduct.setCrossWatercourseLocation(crossWatercourseLocation);
        aqueduct.setImage(imagePath);
        aqueduct.setSectionSize(sectionSize);
        aqueduct.setStructureAndMaterial(structureAndMaterial);
        aqueductRepository.save(aqueduct);
    }
}
