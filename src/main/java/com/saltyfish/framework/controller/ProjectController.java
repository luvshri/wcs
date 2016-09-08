package com.saltyfish.framework.controller;

import com.saltyfish.common.bean.Response;
import com.saltyfish.domain.entity.project.WaterConservationEntity;
import com.saltyfish.domain.entity.project.conservation.AqueductEntity;
import com.saltyfish.domain.entity.project.mark.ProjectMarkEntity;
import com.saltyfish.framework.service.AuthService;
import com.saltyfish.framework.service.FileService;
import com.saltyfish.framework.service.ProjectService;
import com.saltyfish.framework.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

/**
 * Created by weck on 16/9/4.
 * 工程操作请求
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private FileService fileService;

    @Autowired
    private AuthService authService;

    @Autowired
    private ResponseService responseService;

    /**
     * @param userId                   用户id
     * @param token                    登录token
     * @param category                 工程种类
     * @param townId                   乡镇id
     * @param villageId                村庄id
     * @param groupId                  组id
     * @param code                     工程编码
     * @param name                     工程名字
     * @param remark                   备注
     * @param manageModel              管理模式
     * @param situation                完好情况
     * @param constructTime            修建/改造时间
     * @param constructUnit            修建/改造单位
     * @param propertyOwner            产权人
     * @param manager                  管理人
     * @param crossWatercourseLocation 所跨河道
     * @param crossCount               跨数
     * @param sectionSize              断面尺寸
     * @param structureAndMaterial     结构和材质
     * @param image                    照片
     * @param crossLength              每跨长
     * @param length                   总长
     * @param width                    宽度
     * @param watercourseLocation      说在河道
     * @param loadStandard             负载标准
     * @param headOrPumpStation        渠首或者取水泵站
     * @param buildingMatchRate        建筑物配套率
     * @param goodConditionRate        渠道及建筑物完好率
     * @param SeepageCanalLength       总计其中防渗渠长度
     * @param LiningSectionSize        总计衬砌断面尺寸
     * @param sumLength                总计长度
     * @param planeSketch              平面草图
     * @param culvertModel             涵洞类型
     * @param holeModel                洞省类型
     * @param doorMaterial             洞口闸门材质
     * @param holeMaterial             洞身材质
     * @param hoistModel               洞口启闭机类型
     * @param isRegistered             是否登记注册
     * @param features                 特性
     * @param isAccountability         是否建立三级责任制
     * @param feeResources             主要运行经费来源
     * @param maintainPersonFee        聘用管护人员工资
     * @param isCertificated           是否持证上岗
     * @param development              生产开发
     * @param manageRageLine           管理范围线
     * @param pondDamManageLine        塘坝管理范围线
     * @param protectGround            护坝地
     * @param twoLinesBuilding         理论二线内建筑物
     * @param specifiedManage          规范化管理
     * @param irrigateArea             灌溉面积
     * @param deepPump                 深水泵
     * @param diameter                 直径
     * @param depth                    深度
     * @param material                 材质
     * @param intakeWay                取水方式
     * @param waterResource            水源
     * @param sumDiameter              总直径
     * @param waterCapacity            储水量
     * @param size                     尺寸
     * @param modelAndMaterial         型号和材质
     * @param paddyFieldArea           水田面积
     * @param drainageArea             排涝面积
     * @param irrigateFee              灌溉收费
     * @param drainageFee              排涝收费
     * @param annualFee                年收费
     * @param machineArea              机房面积
     * @param affiliation              隶属关系
     * @param sumElectricCapacity      总装机容量
     * @param averageCapacity          平均容量
     * @param internalImage            内部照片
     * @param externalImage            外部照片
     * @param problem                  存在的问题
     * @param lastDredgingTime         上次疏浚时间
     * @param waterArea                水面积
     * @param model                    型号
     * @param holeCount                单孔数
     * @param door                     闸门
     * @param hoistTonnage             启闭机吨位
     * @param holeHeight               单孔高
     * @param holeWidth                单孔宽
     * @param doorHeight               闸门高
     * @param doorWidth                闸门宽
     * @param buildingSituation        建筑完好情况
     * @param doorSituation            闸门完好情况
     * @param hoistSituation           启闭机完好情况
     * @param estuaryWidth             河口宽
     * @param estuaryHeight            河口高
     * @param hediWidth                河底宽
     * @param hediHeight               河底高
     * @param leftWidth                左岸宽
     * @param rightWidth               右岸宽
     * @param flowVillages             流经村庄
     * @param nature                   性质
     * @param sectionImage             断面图
     * @param longitude                经度
     * @param latitude                 纬度
     * @param endpointLongitude        终点经度
     * @param endpointLatitude         终点纬度
     * @param startImage               起点照片
     * @param middleImage              中部照片
     * @param endImage                 尾部照片
     * @param provideAmount            日供水量
     * @param waterModel               水源类型
     * @param haveCleaner              有无净化设施
     * @param isRegularCheck           是否定期检测
     * @param dayProvideAmount         日供水量
     * @param provideVillageCount      供水村庄数量
     * @param providePopulation        供水人口
     * @param haveProtectArea          是否建立水源保护区
     * @param generatorModel1          发电机类型
     * @param generatorPower1          发电机单台功率*台数
     * @param generatorFactoryDate1    发电机出厂日期
     * @param turbineModel1            水轮机类型
     * @param turbineCount1            水轮机台数
     * @param turbineTurnsOrFlow1      水轮机转数/流量
     * @param turbineFactoryDate1      水轮机出厂日期
     * @param transformerModel1        变压器类型
     * @param transformerCapacity1     变压器单机容量*台数
     * @param pumpCount1               水泵台数
     * @param pumpLiftOrFlow1          水泵扬程/流量
     * @param pumpFactoryDate1         水泵出厂日期
     * @param pumpModel1               水泵类型
     * @param electricMotorModel1      电动机类型
     * @param electricPower1           电动机单台功率*台数
     * @param electricFactoryDate1     电动机出厂日期
     * @param pipeModel1               管道类型
     * @param pipeLength1              管道长
     * @param pipeDiameter1            管道直径
     * @param pipeMaterial1            管道材质
     * @param canalModel1              沟渠类型
     * @param canalLength1             沟渠长度
     * @param canalSection1            沟渠断面
     * @param canalSeepageLength1      沟渠防渗渠长度
     * @param canalLiningSectionSize1  沟渠砌断面尺寸
     * @param canalLiningMaterial1     沟渠衬砌材质
     * @return 操作结果
     */
    @RequestMapping("/addConservation")
    public Response addConservation(@RequestParam("userId") Integer userId,
                                    @RequestParam("token") String token,
                                    @RequestParam("category") String category,
                                    @RequestParam("townId") Integer townId,
                                    @RequestParam("villageId") Integer villageId,
                                    @RequestParam(value = "groupId", required = false) Integer groupId,
                                    @RequestParam("code") String code,
                                    @RequestParam("name") String name,
                                    @RequestParam(value = "remark", required = false, defaultValue = "") String remark,
                                    @RequestParam(value = "manageModel", required = false, defaultValue = "自管") String manageModel,
                                    @RequestParam(value = "situation", required = false, defaultValue = "完好") String situation,
                                    @RequestParam(value = "constructTime", required = false, defaultValue = "") String constructTime,
                                    @RequestParam(value = "constructUnit", required = false, defaultValue = "") String constructUnit,
                                    @RequestParam(value = "propertyOwner", required = false, defaultValue = "") String propertyOwner,
                                    @RequestParam(value = "manager", required = false, defaultValue = "") String manager,
                                    @RequestParam(value = "crossWatercourseLocation", required = false, defaultValue = "") String crossWatercourseLocation,
                                    @RequestParam(value = "crossCount", required = false, defaultValue = "") String crossCount,
                                    @RequestParam(value = "sectionSize", required = false, defaultValue = "") String sectionSize,
                                    @RequestParam(value = "structureAndMaterial", required = false, defaultValue = "") String structureAndMaterial,
                                    @RequestParam(value = "image", required = false, defaultValue = "") MultipartFile image,
                                    @RequestParam(value = "crossLength", required = false, defaultValue = "") String crossLength,
                                    @RequestParam(value = "length", required = false, defaultValue = "") String length,
                                    @RequestParam(value = "width", required = false, defaultValue = "") String width,
                                    @RequestParam(value = "watercourseLocation", required = false, defaultValue = "") String watercourseLocation,
                                    @RequestParam(value = "loadStandard", required = false, defaultValue = "") String loadStandard,
                                    @RequestParam(value = "headOrPumpStation", required = false, defaultValue = "") String headOrPumpStation,
                                    @RequestParam(value = "buildingMatchRate", required = false, defaultValue = "") String buildingMatchRate,
                                    @RequestParam(value = "goodConditionRate", required = false, defaultValue = "") String goodConditionRate,
                                    @RequestParam(value = "SeepageCanalLength", required = false, defaultValue = "") String SeepageCanalLength,
                                    @RequestParam(value = "LiningSectionSize", required = false, defaultValue = "") String LiningSectionSize,
                                    @RequestParam(value = "sumLength", required = false, defaultValue = "") String sumLength,
                                    @RequestParam(value = "planeSketch", required = false, defaultValue = "") MultipartFile planeSketch,
                                    @RequestParam(value = "culvertModel", required = false, defaultValue = "") String culvertModel,
                                    @RequestParam(value = "holeModel", required = false, defaultValue = "") String holeModel,
                                    @RequestParam(value = "doorMaterial", required = false, defaultValue = "") String doorMaterial,
                                    @RequestParam(value = "holeMaterial", required = false, defaultValue = "") String holeMaterial,
                                    @RequestParam(value = "hoistModel", required = false, defaultValue = "") String hoistModel,
                                    @RequestParam(value = "isRegistered", required = false, defaultValue = "") String isRegistered,
                                    @RequestParam(value = "features", required = false, defaultValue = "") String features,
                                    @RequestParam(value = "isAccountability", required = false, defaultValue = "") String isAccountability,
                                    @RequestParam(value = "feeResources", required = false, defaultValue = "") String feeResources,
                                    @RequestParam(value = "maintainPersonFee", required = false, defaultValue = "") String maintainPersonFee,
                                    @RequestParam(value = "isCertificated", required = false, defaultValue = "") String isCertificated,
                                    @RequestParam(value = "development", required = false, defaultValue = "") String development,
                                    @RequestParam(value = "manageRageLine", required = false, defaultValue = "") String manageRageLine,
                                    @RequestParam(value = "pondDamManageLine", required = false, defaultValue = "") String pondDamManageLine,
                                    @RequestParam(value = "protectGround", required = false, defaultValue = "") String protectGround,
                                    @RequestParam(value = "twoLinesBuilding", required = false, defaultValue = "") String twoLinesBuilding,
                                    @RequestParam(value = "specifiedManage", required = false, defaultValue = "") String specifiedManage,
                                    @RequestParam(value = "irrigateArea", required = false, defaultValue = "") String irrigateArea,
                                    @RequestParam(value = "deepPump", required = false, defaultValue = "") String deepPump,
                                    @RequestParam(value = "diameter", required = false, defaultValue = "") String diameter,
                                    @RequestParam(value = "depth", required = false, defaultValue = "") String depth,
                                    @RequestParam(value = "material", required = false, defaultValue = "") String material,
                                    @RequestParam(value = "intakeWay", required = false, defaultValue = "") String intakeWay,
                                    @RequestParam(value = "waterResource", required = false, defaultValue = "") String waterResource,
                                    @RequestParam(value = "sumDiameter", required = false, defaultValue = "") String sumDiameter,
                                    @RequestParam(value = "waterCapacity", required = false, defaultValue = "") String waterCapacity,
                                    @RequestParam(value = "size", required = false, defaultValue = "") String size,
                                    @RequestParam(value = "modelAndMaterial", required = false, defaultValue = "") String modelAndMaterial,
                                    @RequestParam(value = "paddyFieldArea", required = false, defaultValue = "") String paddyFieldArea,
                                    @RequestParam(value = "drainageArea", required = false, defaultValue = "") String drainageArea,
                                    @RequestParam(value = "irrigateFee", required = false, defaultValue = "") String irrigateFee,
                                    @RequestParam(value = "drainageFee", required = false, defaultValue = "") String drainageFee,
                                    @RequestParam(value = "annualFee", required = false, defaultValue = "") String annualFee,
                                    @RequestParam(value = "machineArea", required = false, defaultValue = "") String machineArea,
                                    @RequestParam(value = "affiliation", required = false, defaultValue = "") String affiliation,
                                    @RequestParam(value = "sumElectricCapacity", required = false, defaultValue = "") String sumElectricCapacity,
                                    @RequestParam(value = "averageCapacity", required = false, defaultValue = "") String averageCapacity,
                                    @RequestParam(value = "internalImage", required = false, defaultValue = "") String internalImage,
                                    @RequestParam(value = "externalImage", required = false, defaultValue = "") String externalImage,
                                    @RequestParam(value = "problem", required = false, defaultValue = "") String problem,
                                    @RequestParam(value = "lastDredgingTime", required = false, defaultValue = "") String lastDredgingTime,
                                    @RequestParam(value = "waterArea", required = false, defaultValue = "") String waterArea,
                                    @RequestParam(value = "model", required = false, defaultValue = "") String model,
                                    @RequestParam(value = "holeCount", required = false, defaultValue = "") String holeCount,
                                    @RequestParam(value = "door", required = false, defaultValue = "") String door,
                                    @RequestParam(value = "hoistTonnage", required = false, defaultValue = "") String hoistTonnage,
                                    @RequestParam(value = "holeHeight", required = false, defaultValue = "") String holeHeight,
                                    @RequestParam(value = "holeWidth", required = false, defaultValue = "") String holeWidth,
                                    @RequestParam(value = "doorHeight", required = false, defaultValue = "") String doorHeight,
                                    @RequestParam(value = "doorWidth", required = false, defaultValue = "") String doorWidth,
                                    @RequestParam(value = "buildingSituation", required = false, defaultValue = "完好") String buildingSituation,
                                    @RequestParam(value = "doorSituation", required = false, defaultValue = "") String doorSituation,
                                    @RequestParam(value = "hoistSituation", required = false, defaultValue = "") String hoistSituation,
                                    @RequestParam(value = "estuaryWidth", required = false, defaultValue = "") String estuaryWidth,
                                    @RequestParam(value = "estuaryHeight", required = false, defaultValue = "") String estuaryHeight,
                                    @RequestParam(value = "hediWidth", required = false, defaultValue = "") String hediWidth,
                                    @RequestParam(value = "hediHeight", required = false, defaultValue = "") String hediHeight,
                                    @RequestParam(value = "leftWidth", required = false, defaultValue = "") String leftWidth,
                                    @RequestParam(value = "rightWidth", required = false, defaultValue = "") String rightWidth,
                                    @RequestParam(value = "flowVillages", required = false, defaultValue = "") String flowVillages,
                                    @RequestParam(value = "nature", required = false, defaultValue = "") String nature,
                                    @RequestParam(value = "sectionImage", required = false, defaultValue = "") MultipartFile sectionImage,
                                    @RequestParam(value = "longitude", required = false, defaultValue = "") BigDecimal longitude,
                                    @RequestParam(value = "latitude", required = false, defaultValue = "") BigDecimal latitude,
                                    @RequestParam(value = "endpointLongitude", required = false, defaultValue = "") BigDecimal endpointLongitude,
                                    @RequestParam(value = "endpointLatitude", required = false, defaultValue = "") BigDecimal endpointLatitude,
                                    @RequestParam(value = "startImage", required = false, defaultValue = "") MultipartFile startImage,
                                    @RequestParam(value = "middleImage", required = false, defaultValue = "") MultipartFile middleImage,
                                    @RequestParam(value = "endImage", required = false, defaultValue = "") MultipartFile endImage,
                                    @RequestParam(value = "provideAmount", required = false, defaultValue = "") String provideAmount,
                                    @RequestParam(value = "waterModel", required = false, defaultValue = "") String waterModel,
                                    @RequestParam(value = "haveCleaner", required = false, defaultValue = "") String haveCleaner,
                                    @RequestParam(value = "isRegularCheck", required = false, defaultValue = "") String isRegularCheck,
                                    @RequestParam(value = "dayProvideAmount", required = false, defaultValue = "") String dayProvideAmount,
                                    @RequestParam(value = "provideVillageCount", required = false, defaultValue = "") String provideVillageCount,
                                    @RequestParam(value = "providePopulation", required = false, defaultValue = "") String providePopulation,
                                    @RequestParam(value = "haveProtectArea", required = false, defaultValue = "") String haveProtectArea,
                                    @RequestParam(value = "mainFunction", required = false, defaultValue = "") String mainFunction,
                                    //发电机
                                    @RequestParam(value = "generatorModel1", required = false, defaultValue = "") String generatorModel1,
                                    @RequestParam(value = "generatorPower1", required = false, defaultValue = "") String generatorPower1,
                                    @RequestParam(value = "generatorFactoryDate1", required = false, defaultValue = "") String generatorFactoryDate1,
                                    @RequestParam(value = "generatorModel2", required = false, defaultValue = "") String generatorModel2,
                                    @RequestParam(value = "generatorPower2", required = false, defaultValue = "") String generatorPower2,
                                    @RequestParam(value = "generatorFactoryDate2", required = false, defaultValue = "") String generatorFactoryDate2,
                                    @RequestParam(value = "generatorModel3", required = false, defaultValue = "") String generatorModel3,
                                    @RequestParam(value = "generatorPower3", required = false, defaultValue = "") String generatorPower3,
                                    @RequestParam(value = "generatorFactoryDate3", required = false, defaultValue = "") String generatorFactoryDate3,
                                    //水轮机
                                    @RequestParam(value = "turbineModel1", required = false, defaultValue = "") String turbineModel1,
                                    @RequestParam(value = "turbineCount1", required = false, defaultValue = "") String turbineCount1,
                                    @RequestParam(value = "turbineTurnsOrFlow1", required = false, defaultValue = "") String turbineTurnsOrFlow1,
                                    @RequestParam(value = "turbineFactoryDate1", required = false, defaultValue = "") String turbineFactoryDate1,
                                    @RequestParam(value = "turbineModel2", required = false, defaultValue = "") String turbineModel2,
                                    @RequestParam(value = "turbineCount2", required = false, defaultValue = "") String turbineCount2,
                                    @RequestParam(value = "turbineTurnsOrFlow2", required = false, defaultValue = "") String turbineTurnsOrFlow2,
                                    @RequestParam(value = "turbineFactoryDate2", required = false, defaultValue = "") String turbineFactoryDate2,
                                    @RequestParam(value = "turbineModel3", required = false, defaultValue = "") String turbineModel3,
                                    @RequestParam(value = "turbineCount3", required = false, defaultValue = "") String turbineCount3,
                                    @RequestParam(value = "turbineTurnsOrFlow3", required = false, defaultValue = "") String turbineTurnsOrFlow3,
                                    @RequestParam(value = "turbineFactoryDate3", required = false, defaultValue = "") String turbineFactoryDate3,
                                    //变压器
                                    @RequestParam(value = "transformerModel1", required = false, defaultValue = "") String transformerModel1,
                                    @RequestParam(value = "transformerCapacity1", required = false, defaultValue = "") String transformerCapacity1,
                                    @RequestParam(value = "transformerModel2", required = false, defaultValue = "") String transformerModel2,
                                    @RequestParam(value = "transformerCapacity2", required = false, defaultValue = "") String transformerCapacity2,
                                    @RequestParam(value = "transformerModel3", required = false, defaultValue = "") String transformerModel3,
                                    @RequestParam(value = "transformerCapacity3", required = false, defaultValue = "") String transformerCapacity3,
                                    //水泵
                                    @RequestParam(value = "pumpCount1", required = false, defaultValue = "") String pumpCount1,
                                    @RequestParam(value = "pumpLiftOrFlow1", required = false, defaultValue = "") String pumpLiftOrFlow1,
                                    @RequestParam(value = "pumpFactoryDate1", required = false, defaultValue = "") String pumpFactoryDate1,
                                    @RequestParam(value = "pumpModel1", required = false, defaultValue = "") String pumpModel1,
                                    @RequestParam(value = "pumpCount2", required = false, defaultValue = "") String pumpCount2,
                                    @RequestParam(value = "pumpLiftOrFlow2", required = false, defaultValue = "") String pumpLiftOrFlow2,
                                    @RequestParam(value = "pumpFactoryDate2", required = false, defaultValue = "") String pumpFactoryDate2,
                                    @RequestParam(value = "pumpModel2", required = false, defaultValue = "") String pumpModel2,
                                    @RequestParam(value = "pumpCount3", required = false, defaultValue = "") String pumpCount3,
                                    @RequestParam(value = "pumpLiftOrFlow3", required = false, defaultValue = "") String pumpLiftOrFlow3,
                                    @RequestParam(value = "pumpFactoryDate3", required = false, defaultValue = "") String pumpFactoryDate3,
                                    @RequestParam(value = "pumpModel3", required = false, defaultValue = "") String pumpModel3,
                                    //电动机
                                    @RequestParam(value = "electricMotorModel1", required = false, defaultValue = "") String electricMotorModel1,
                                    @RequestParam(value = "electricPower1", required = false, defaultValue = "") String electricPower1,
                                    @RequestParam(value = "electricFactoryDate1", required = false, defaultValue = "") String electricFactoryDate1,
                                    @RequestParam(value = "electricMotorModel2", required = false, defaultValue = "") String electricMotorModel2,
                                    @RequestParam(value = "electricPower2", required = false, defaultValue = "") String electricPower2,
                                    @RequestParam(value = "electricFactoryDate2", required = false, defaultValue = "") String electricFactoryDate2,
                                    @RequestParam(value = "electricMotorModel3", required = false, defaultValue = "") String electricMotorModel3,
                                    @RequestParam(value = "electricPower3", required = false, defaultValue = "") String electricPower3,
                                    @RequestParam(value = "electricFactoryDate3", required = false, defaultValue = "") String electricFactoryDate3,
                                    //管滴灌的支管
                                    @RequestParam(value = "pipeModel1", required = false, defaultValue = "主管1") String pipeModel1,
                                    @RequestParam(value = "pipeLength1", required = false, defaultValue = "") String pipeLength1,
                                    @RequestParam(value = "pipeDiameter1", required = false, defaultValue = "") String pipeDiameter1,
                                    @RequestParam(value = "pipeMaterial1", required = false, defaultValue = "") String pipeMaterial1,
                                    @RequestParam(value = "pipeModel2", required = false, defaultValue = "主管2") String pipeModel2,
                                    @RequestParam(value = "pipeLength2", required = false, defaultValue = "") String pipeLength2,
                                    @RequestParam(value = "pipeDiameter2", required = false, defaultValue = "") String pipeDiameter2,
                                    @RequestParam(value = "pipeMaterial2", required = false, defaultValue = "") String pipeMaterial2,
                                    @RequestParam(value = "pipeModel3", required = false, defaultValue = "支管1") String pipeModel3,
                                    @RequestParam(value = "pipeLength3", required = false, defaultValue = "") String pipeLength3,
                                    @RequestParam(value = "pipeDiameter3", required = false, defaultValue = "") String pipeDiameter3,
                                    @RequestParam(value = "pipeMaterial3", required = false, defaultValue = "") String pipeMaterial3,
                                    @RequestParam(value = "pipeModel4", required = false, defaultValue = "支管2") String pipeModel4,
                                    @RequestParam(value = "pipeLength4", required = false, defaultValue = "") String pipeLength4,
                                    @RequestParam(value = "pipeDiameter4", required = false, defaultValue = "") String pipeDiameter4,
                                    @RequestParam(value = "pipeMaterial4", required = false, defaultValue = "") String pipeMaterial4,
                                    @RequestParam(value = "pipeModel5", required = false, defaultValue = "毛管1") String pipeModel5,
                                    @RequestParam(value = "pipeLength5", required = false, defaultValue = "") String pipeLength5,
                                    @RequestParam(value = "pipeDiameter5", required = false, defaultValue = "") String pipeDiameter5,
                                    @RequestParam(value = "pipeMaterial5", required = false, defaultValue = "") String pipeMaterial5,
                                    @RequestParam(value = "pipeModel6", required = false, defaultValue = "毛管2") String pipeModel6,
                                    @RequestParam(value = "pipeLength6", required = false, defaultValue = "") String pipeLength6,
                                    @RequestParam(value = "pipeDiameter6", required = false, defaultValue = "") String pipeDiameter6,
                                    @RequestParam(value = "pipeMaterial6", required = false, defaultValue = "") String pipeMaterial6,
                                    //渠道的小渠
                                    @RequestParam(value = "canalModel1", required = false, defaultValue = "干渠1") String canalModel1,
                                    @RequestParam(value = "canalLength1", required = false, defaultValue = "") String canalLength1,
                                    @RequestParam(value = "canalSection1", required = false, defaultValue = "") String canalSection1,
                                    @RequestParam(value = "canalSeepageLength1", required = false, defaultValue = "") String canalSeepageLength1,
                                    @RequestParam(value = "canalLiningSectionSize1", required = false, defaultValue = "") String canalLiningSectionSize1,
                                    @RequestParam(value = "canalLiningMaterial1", required = false, defaultValue = "") String canalLiningMaterial1,
                                    @RequestParam(value = "canalModel2", required = false, defaultValue = "干渠2") String canalModel2,
                                    @RequestParam(value = "canalLength2", required = false, defaultValue = "") String canalLength2,
                                    @RequestParam(value = "canalSection2", required = false, defaultValue = "") String canalSection2,
                                    @RequestParam(value = "canalSeepageLength2", required = false, defaultValue = "") String canalSeepageLength2,
                                    @RequestParam(value = "canalLiningSectionSize2", required = false, defaultValue = "") String canalLiningSectionSize2,
                                    @RequestParam(value = "canalLiningMaterial2", required = false, defaultValue = "") String canalLiningMaterial2,
                                    @RequestParam(value = "canalModel3", required = false, defaultValue = "支渠1") String canalModel3,
                                    @RequestParam(value = "canalLength3", required = false, defaultValue = "") String canalLength3,
                                    @RequestParam(value = "canalSection3", required = false, defaultValue = "") String canalSection3,
                                    @RequestParam(value = "canalSeepageLength3", required = false, defaultValue = "") String canalSeepageLength3,
                                    @RequestParam(value = "canalLiningSectionSize3", required = false, defaultValue = "") String canalLiningSectionSize3,
                                    @RequestParam(value = "canalLiningMaterial3", required = false, defaultValue = "") String canalLiningMaterial3,
                                    @RequestParam(value = "canalModel4", required = false, defaultValue = "支渠2") String canalModel4,
                                    @RequestParam(value = "canalLength4", required = false, defaultValue = "") String canalLength4,
                                    @RequestParam(value = "canalSection4", required = false, defaultValue = "") String canalSection4,
                                    @RequestParam(value = "canalSeepageLength4", required = false, defaultValue = "") String canalSeepageLength4,
                                    @RequestParam(value = "canalLiningSectionSize4", required = false, defaultValue = "") String canalLiningSectionSize4,
                                    @RequestParam(value = "canalLiningMaterial4", required = false, defaultValue = "") String canalLiningMaterial4,
                                    @RequestParam(value = "canalModel5", required = false, defaultValue = "斗渠1") String canalModel5,
                                    @RequestParam(value = "canalLength5", required = false, defaultValue = "") String canalLength5,
                                    @RequestParam(value = "canalSection5", required = false, defaultValue = "") String canalSection5,
                                    @RequestParam(value = "canalSeepageLength5", required = false, defaultValue = "") String canalSeepageLength5,
                                    @RequestParam(value = "canalLiningSectionSize5", required = false, defaultValue = "") String canalLiningSectionSize5,
                                    @RequestParam(value = "canalLiningMaterial5", required = false, defaultValue = "") String canalLiningMaterial5,
                                    @RequestParam(value = "canalModel6", required = false, defaultValue = "斗渠2") String canalModel6,
                                    @RequestParam(value = "canalLength6", required = false, defaultValue = "") String canalLength6,
                                    @RequestParam(value = "canalSection6", required = false, defaultValue = "") String canalSection6,
                                    @RequestParam(value = "canalSeepageLength6", required = false, defaultValue = "") String canalSeepageLength6,
                                    @RequestParam(value = "canalLiningSectionSize6", required = false, defaultValue = "") String canalLiningSectionSize6,
                                    @RequestParam(value = "canalLiningMaterial6", required = false, defaultValue = "") String canalLiningMaterial6,
                                    @RequestParam(value = "canalModel7", required = false, defaultValue = "农渠1") String canalModel7,
                                    @RequestParam(value = "canalLength7", required = false, defaultValue = "") String canalLength7,
                                    @RequestParam(value = "canalSection7", required = false, defaultValue = "") String canalSection7,
                                    @RequestParam(value = "canalSeepageLength7", required = false, defaultValue = "") String canalSeepageLength7,
                                    @RequestParam(value = "canalLiningSectionSize7", required = false, defaultValue = "") String canalLiningSectionSize7,
                                    @RequestParam(value = "canalLiningMaterial7", required = false, defaultValue = "") String canalLiningMaterial7,
                                    @RequestParam(value = "canalModel8", required = false, defaultValue = "农渠2") String canalModel8,
                                    @RequestParam(value = "canalLength8", required = false, defaultValue = "") String canalLength8,
                                    @RequestParam(value = "canalSection8", required = false, defaultValue = "") String canalSection8,
                                    @RequestParam(value = "canalSeepageLength8", required = false, defaultValue = "") String canalSeepageLength8,
                                    @RequestParam(value = "canalLiningSectionSize8", required = false, defaultValue = "") String canalLiningSectionSize8,
                                    @RequestParam(value = "canalLiningMaterial8", required = false, defaultValue = "") String canalLiningMaterial8,
                                    @RequestParam("timeStamp") Long timeStamp) {
        Response response = new Response();
        try {
            if (!authService.checkLogin(userId, token)) {
                return responseService.notLogin(response);
            } else if (authService.checkGuest(userId) || !authService.checkUserTownAccess(userId, townId)
                    || !authService.unitContainingCheck(townId, villageId, groupId)) {
                return responseService.noAccess(response);
            }
            WaterConservationEntity waterConservationEntity = new WaterConservationEntity();
            projectService.setCommonProperty(waterConservationEntity, userId, category, remark, name, code, manageModel, townId, villageId,
                    groupId, situation, constructTime, constructUnit, propertyOwner, manager, longitude, latitude, timeStamp);
            ProjectMarkEntity projectMark = new ProjectMarkEntity();
            switch (category) {
                case "渡槽":
                    String imagePath = "";
                    AqueductEntity aqueduct = new AqueductEntity();
                    if (image != null) {
                        imagePath = fileService.saveFile(image);
                    }
                    projectService.saveAqueduct(aqueduct, crossWatercourseLocation, crossCount, sectionSize, structureAndMaterial, crossLength, imagePath);
                    projectMark.setAqueduct(aqueduct);
                    break;
                case "桥梁":
                    //TODO 13中类型的各一种情况
                    break;
                default:
                    break;
            }
            waterConservationEntity.setProjectMark(projectMark);
            return responseService.success(response);
        } catch (Exception e) {
            return responseService.serverError(response);
        }
    }
}
