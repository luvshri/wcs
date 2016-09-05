package com.saltyfish.domain.entity.form.project;

import com.saltyfish.domain.entity.base.SuperBean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 塘坝
 */

@Entity
@Table(name = "dam", catalog = "exciting")
public class DamEntity extends SuperBean {
    private static final Long serialVersionUID = -2342987549323245464L;
    private Integer isRegistered;       //是否注册等级
    private BigDecimal length;               //坝长
    private BigDecimal height;               //坝高
    private BigDecimal capacity;             //库容
    private BigDecimal crestElevation;               //堰顶高程
    private String features;                    //主要功能
    private Integer accountabilityIsBuild;         //是否建立三级责任制
    private Integer haveFunding;                //是否有运行经费来源
    private Integer haveMaintainPerson;         //是否聘用管护人员
    private Integer haveCertificate;            //是否持证上岗
    private String maintainSituation;           //工程维修养护情况
    private Integer haveDevelopment;            //是否有生产开发
    private Integer developExplanation;         //若有生产开发,说明
    private Integer damRageQualified;           //大坝管理范围线是否达标
    private String damExplanation;              //大坝管理范围线未达标说明
    private Integer pondDamRageQulified;            //塘坝管理范围线是否达标
    private String pondDamExplanation;          //塘坝管理范围线未达标说明
    private Integer sealManage;                 //大坝保护范围是否封闭管理
    private Integer retainingDam;               //是否有护坝地
    private BigDecimal retainingLength;              //护坝地长
    private BigDecimal retainingWidth;               //护坝地宽
    private Integer haveBuildings;              //是否有理论二线内建筑物
    private BigDecimal housesArea;                   //二线内民房面积
    private BigDecimal factoryBuildingArea;          //二线内厂房面积
    private BigDecimal villageRoadArea;              //二线内村道面积
    private BigDecimal otherArea;                    //其他面积
    private Integer manageQualified;            //是否规范化管理
    private String manageSituation;             //现状管理情况描述
    private String image;                       //图片

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(Integer isRegistered) {
        this.isRegistered = isRegistered;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getCapacity() {
        return capacity;
    }

    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }

    public BigDecimal getCrestElevation() {
        return crestElevation;
    }

    public void setCrestElevation(BigDecimal crestElevation) {
        this.crestElevation = crestElevation;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public Integer getAccountabilityIsBuild() {
        return accountabilityIsBuild;
    }

    public void setAccountabilityIsBuild(Integer accountabilityIsBuild) {
        this.accountabilityIsBuild = accountabilityIsBuild;
    }

    public Integer getHaveFunding() {
        return haveFunding;
    }

    public void setHaveFunding(Integer haveFunding) {
        this.haveFunding = haveFunding;
    }

    public Integer getHaveMaintainPerson() {
        return haveMaintainPerson;
    }

    public void setHaveMaintainPerson(Integer haveMaintainPerson) {
        this.haveMaintainPerson = haveMaintainPerson;
    }

    public Integer getHaveCertificate() {
        return haveCertificate;
    }

    public void setHaveCertificate(Integer haveCertificate) {
        this.haveCertificate = haveCertificate;
    }

    public String getMaintainSituation() {
        return maintainSituation;
    }

    public void setMaintainSituation(String maintainSituation) {
        this.maintainSituation = maintainSituation;
    }

    public Integer getHaveDevelopment() {
        return haveDevelopment;
    }

    public void setHaveDevelopment(Integer haveDevelopment) {
        this.haveDevelopment = haveDevelopment;
    }

    public Integer getDevelopExplanation() {
        return developExplanation;
    }

    public void setDevelopExplanation(Integer developExplanation) {
        this.developExplanation = developExplanation;
    }

    public Integer getDamRageQualified() {
        return damRageQualified;
    }

    public void setDamRageQualified(Integer damRageQualified) {
        this.damRageQualified = damRageQualified;
    }

    public String getDamExplanation() {
        return damExplanation;
    }

    public void setDamExplanation(String damExplanation) {
        this.damExplanation = damExplanation;
    }

    public Integer getPondDamRageQulified() {
        return pondDamRageQulified;
    }

    public void setPondDamRageQulified(Integer pondDamRageQulified) {
        this.pondDamRageQulified = pondDamRageQulified;
    }

    public String getPondDamExplanation() {
        return pondDamExplanation;
    }

    public void setPondDamExplanation(String pondDamExplanation) {
        this.pondDamExplanation = pondDamExplanation;
    }

    public Integer getSealManage() {
        return sealManage;
    }

    public void setSealManage(Integer sealManage) {
        this.sealManage = sealManage;
    }

    public Integer getRetainingDam() {
        return retainingDam;
    }

    public void setRetainingDam(Integer retainingDam) {
        this.retainingDam = retainingDam;
    }

    public BigDecimal getRetainingLength() {
        return retainingLength;
    }

    public void setRetainingLength(BigDecimal retainingLength) {
        this.retainingLength = retainingLength;
    }

    public BigDecimal getRetainingWidth() {
        return retainingWidth;
    }

    public void setRetainingWidth(BigDecimal retainingWidth) {
        this.retainingWidth = retainingWidth;
    }

    public Integer getHaveBuildings() {
        return haveBuildings;
    }

    public void setHaveBuildings(Integer haveBuildings) {
        this.haveBuildings = haveBuildings;
    }

    public BigDecimal getHousesArea() {
        return housesArea;
    }

    public void setHousesArea(BigDecimal housesArea) {
        this.housesArea = housesArea;
    }

    public BigDecimal getFactoryBuildingArea() {
        return factoryBuildingArea;
    }

    public void setFactoryBuildingArea(BigDecimal factoryBuildingArea) {
        this.factoryBuildingArea = factoryBuildingArea;
    }

    public BigDecimal getVillageRoadArea() {
        return villageRoadArea;
    }

    public void setVillageRoadArea(BigDecimal villageRoadArea) {
        this.villageRoadArea = villageRoadArea;
    }

    public BigDecimal getOtherArea() {
        return otherArea;
    }

    public void setOtherArea(BigDecimal otherArea) {
        this.otherArea = otherArea;
    }

    public Integer getManageQualified() {
        return manageQualified;
    }

    public void setManageQualified(Integer manageQualified) {
        this.manageQualified = manageQualified;
    }

    public String getManageSituation() {
        return manageSituation;
    }

    public void setManageSituation(String manageSituation) {
        this.manageSituation = manageSituation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
