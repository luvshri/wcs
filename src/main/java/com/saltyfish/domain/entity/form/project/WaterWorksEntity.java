package com.saltyfish.domain.entity.form.project;

import com.saltyfish.domain.entity.base.SuperBean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 水厂
 */
@Entity
@Table(name = "waterworks", catalog = "exciting")
public class WaterWorksEntity extends SuperBean {
    private static final Long serialVersionUID = 129845788980745834L;
    private BigDecimal provideAmount;        //供水能力
    private String waterModel;          //水源类型
    private Integer haveCleaner;        //有无净化设施
    private Integer isRegularCheck;     //水质是否定期检测
    private BigDecimal dayProvideAmount;     //现状日供水量
    private Integer provideVillageCount;    //现状供水村数
    private Integer providePopulation;      //现状用水人口
    private Integer haveProtectArea;        //是否建立水源保护区
    private String image;

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getProvideAmount() {
        return provideAmount;
    }

    public void setProvideAmount(BigDecimal provideAmount) {
        this.provideAmount = provideAmount;
    }

    public String getWaterModel() {
        return waterModel;
    }

    public void setWaterModel(String waterModel) {
        this.waterModel = waterModel;
    }

    public Integer getHaveCleaner() {
        return haveCleaner;
    }

    public void setHaveCleaner(Integer haveCleaner) {
        this.haveCleaner = haveCleaner;
    }

    public Integer getIsRegularCheck() {
        return isRegularCheck;
    }

    public void setIsRegularCheck(Integer isRegularCheck) {
        this.isRegularCheck = isRegularCheck;
    }

    public BigDecimal getDayProvideAmount() {
        return dayProvideAmount;
    }

    public void setDayProvideAmount(BigDecimal dayProvideAmount) {
        this.dayProvideAmount = dayProvideAmount;
    }

    public Integer getProvideVillageCount() {
        return provideVillageCount;
    }

    public void setProvideVillageCount(Integer provideVillageCount) {
        this.provideVillageCount = provideVillageCount;
    }

    public Integer getProvidePopulation() {
        return providePopulation;
    }

    public void setProvidePopulation(Integer providePopulation) {
        this.providePopulation = providePopulation;
    }

    public Integer getHaveProtectArea() {
        return haveProtectArea;
    }

    public void setHaveProtectArea(Integer haveProtectArea) {
        this.haveProtectArea = haveProtectArea;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
