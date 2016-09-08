package com.saltyfish.framework.service;

import com.saltyfish.domain.entity.location.LocationEntity;
import com.saltyfish.domain.entity.project.WaterConservationEntity;
import com.saltyfish.domain.entity.project.conservation.AqueductEntity;
import com.saltyfish.domain.entity.project.conservation.BridgeEntity;
import com.saltyfish.domain.entity.project.conservation.ChannelEntity;
import com.saltyfish.domain.entity.project.division.CanalEntity;
import com.saltyfish.domain.repository.LocationRepository;
import com.saltyfish.domain.repository.auth.UserRepository;
import com.saltyfish.domain.repository.project.AqueductRepository;
import com.saltyfish.domain.repository.project.BridgeRepository;
import com.saltyfish.domain.repository.project.ChannelRepository;
import com.saltyfish.domain.repository.project.division.CanalRepository;
import com.saltyfish.domain.repository.unit.GroupRepository;
import com.saltyfish.domain.repository.unit.TownRepository;
import com.saltyfish.domain.repository.unit.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private BridgeRepository bridgeRepository;

    @Autowired
    private CanalRepository canalRepository;

    @Autowired
    private ChannelRepository channelRepository;

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
    public void saveAqueduct(AqueductEntity aqueduct, String crossWatercourseLocation, String crossCount,
                             String sectionSize, String structureAndMaterial, String crossLength, String imagePath) {
        aqueduct.setCrossCount(crossCount);
        aqueduct.setCrossLength(crossLength);
        aqueduct.setCrossWatercourseLocation(crossWatercourseLocation);
        aqueduct.setImage(imagePath);
        aqueduct.setSectionSize(sectionSize);
        aqueduct.setStructureAndMaterial(structureAndMaterial);
        aqueductRepository.save(aqueduct);
    }

    public void saveBridge(BridgeEntity bridgeEntity, String watercourseLocation, String crossCount,
                           String structureAndMaterial, String loadStandard, String crossLength, String width,
                           String length, String imagePath) {
        bridgeEntity.setStructureAndMaterial(structureAndMaterial);
        bridgeEntity.setCrossLength(crossLength);
        bridgeEntity.setImage(imagePath);
        bridgeEntity.setCrossCount(crossCount);
        bridgeEntity.setWatercourseLocation(watercourseLocation);
        bridgeEntity.setLoadStandard(loadStandard);
        bridgeEntity.setLength(length);
        bridgeEntity.setWidth(width);
        bridgeRepository.save(bridgeEntity);
    }

    public void saveChannel(ChannelEntity channel, String headOrPumpStation, String buildingMatchRate, String length,
                            String goodConditionRate, String imagePath, String sectionSize, String seepageCanalLength,
                            String liningSectionSize, String sumLength, String planeSketchPath, String canalLength1,
                            String canalLength2, String canalLength3, String canalLength4, String canalLength5,
                            String canalLength6, String canalLength7, String canalLength8, String canalLiningMaterial1,
                            String canalLiningMaterial2, String canalLiningMaterial3, String canalLiningMaterial4,
                            String canalLiningMaterial5, String canalLiningMaterial6, String canalLiningMaterial7,
                            String canalLiningMaterial8, String canalLiningSectionSize1, String canalLiningSectionSize2,
                            String canalLiningSectionSize3, String canalLiningSectionSize4, String canalLiningSectionSize5,
                            String canalLiningSectionSize6, String canalLiningSectionSize7, String canalLiningSectionSize8,
                            String canalModel1, String canalModel2, String canalModel3, String canalModel4,
                            String canalModel5, String canalModel6, String canalModel7, String canalModel8,
                            String canalSectionSize1, String canalSectionSize2, String canalSectionSize3,
                            String canalSectionSize4, String canalSectionSize5, String canalSectionSize6,
                            String canalSectionSize7, String canalSectionSize8, String canalSeepageLength1,
                            String canalSeepageLength2, String canalSeepageLength3, String canalSeepageLength4,
                            String canalSeepageLength5, String canalSeepageLength6, String canalSeepageLength7,
                            String canalSeepageLength8) {
        channel.setHeadOrPumpStation(headOrPumpStation);
        channel.setBuildingMatchRate(buildingMatchRate);
        channel.setLength(length);
        channel.setGoodConditionRate(goodConditionRate);
        channel.setSumLength(sumLength);
        channel.setImage(imagePath);
        channel.setSectionSize(sectionSize);
        channel.setSeepageCanalLength(seepageCanalLength);
        channel.setLiningSectionSize(liningSectionSize);
        channel.setPlaneSketch(planeSketchPath);
        CanalEntity canal1 = new CanalEntity();
        CanalEntity canal2 = new CanalEntity();
        CanalEntity canal3 = new CanalEntity();
        CanalEntity canal4 = new CanalEntity();
        CanalEntity canal5 = new CanalEntity();
        CanalEntity canal6 = new CanalEntity();
        CanalEntity canal7 = new CanalEntity();
        CanalEntity canal8 = new CanalEntity();
        canal1.setModel(canalModel1);
        canal1.setLiningSectionSize(canalLiningSectionSize1);
        canal1.setSeepageCanalLength(canalSeepageLength1);
        canal1.setLiningMaterial(canalLiningMaterial1);
        canal1.setLength(canalLength1);
        canal1.setSectionSize(canalSectionSize1);
        canalRepository.save(canal1);
        canal2.setLength(canalLength2);
        canal2.setLiningMaterial(canalLiningMaterial2);
        canal2.setSeepageCanalLength(canalSeepageLength2);
        canal2.setModel(canalModel2);
        canal2.setSectionSize(canalSectionSize2);
        canal2.setLiningSectionSize(canalLiningSectionSize2);
        canalRepository.save(canal2);
        canal3.setLength(canalLength3);
        canal3.setLiningMaterial(canalLiningMaterial3);
        canal3.setSeepageCanalLength(canalSeepageLength3);
        canal3.setModel(canalModel3);
        canal3.setSectionSize(canalSectionSize3);
        canal3.setLiningSectionSize(canalLiningSectionSize3);
        canalRepository.save(canal3);
        canal4.setLength(canalLength4);
        canal4.setLiningMaterial(canalLiningMaterial4);
        canal4.setSeepageCanalLength(canalSeepageLength4);
        canal4.setModel(canalModel4);
        canal4.setSectionSize(canalSectionSize4);
        canal4.setLiningSectionSize(canalLiningSectionSize4);
        canalRepository.save(canal4);
        canal5.setLength(canalLength5);
        canal5.setLiningMaterial(canalLiningMaterial5);
        canal5.setSeepageCanalLength(canalSeepageLength5);
        canal5.setModel(canalModel5);
        canal5.setSectionSize(canalSectionSize5);
        canal5.setLiningSectionSize(canalLiningSectionSize5);
        canalRepository.save(canal5);
        canal6.setLength(canalLength6);
        canal6.setLiningMaterial(canalLiningMaterial6);
        canal6.setSeepageCanalLength(canalSeepageLength6);
        canal6.setModel(canalModel6);
        canal6.setSectionSize(canalSectionSize6);
        canal6.setLiningSectionSize(canalLiningSectionSize6);
        canalRepository.save(canal6);
        canal7.setLength(canalLength7);
        canal7.setLiningMaterial(canalLiningMaterial7);
        canal7.setSeepageCanalLength(canalSeepageLength7);
        canal7.setModel(canalModel7);
        canal7.setSectionSize(canalSectionSize7);
        canal7.setLiningSectionSize(canalLiningSectionSize7);
        canalRepository.save(canal7);
        canal8.setLength(canalLength8);
        canal8.setLiningMaterial(canalLiningMaterial8);
        canal8.setSeepageCanalLength(canalSeepageLength8);
        canal8.setModel(canalModel8);
        canal8.setSectionSize(canalSectionSize8);
        canal8.setLiningSectionSize(canalLiningSectionSize8);
        canalRepository.save(canal8);
        List<CanalEntity> canals = new ArrayList<>();
        canals.add(canal1);
        canals.add(canal2);
        canals.add(canal3);
        canals.add(canal4);
        canals.add(canal5);
        canals.add(canal6);
        canals.add(canal7);
        canals.add(canal8);
        channel.setCanals(canals);
        channelRepository.save(channel);
    }
}
