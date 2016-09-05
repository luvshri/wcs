package com.saltyfish.domain.entity.form.project;

import com.saltyfish.domain.entity.base.SuperBean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 水电站
 */
@Entity
@Table(name = "hydropower", catalog = "exciting")
public class HydropowerEntity extends SuperBean {
    private static final Long serialVersionUID = -4945280285272950802L;
    //受益面积
    private BigDecimal irrigateArea;     //灌溉面积
    private BigDecimal paddyFieldArea;   //其中水田面积
    private BigDecimal drainageArea;     //排涝面积
    //机电灌溉收费情况
    private String irrigateFee;     //灌溉收费标准
    private String drainageFee;     //排涝收费标准
    private String annualIncome;    //年收入
    private String nature;          //泵站的性质
    private BigDecimal machineArea;      //机房面积,m2
    private BigDecimal totalInstalledCapacity;   //总装机容量,KW
    private BigDecimal riverElevation;   //引河河底高程,m
    private BigDecimal poolHeight;       //进水池底板顶高程,m

    private String affiliation;         //隶属关系
    private BigDecimal sumElectricCapacity;      //总发电装机容量（KW）
    private BigDecimal averageCapacity;          //近5年平均年发电量(万kWh)
    //照片
    private String internalImage;       //发电站内照片
    private String externalImage;       //发电站外照片

    private String runningSituation;        //运行情况
    private String description;         //存在的问题


    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getIrrigateArea() {
        return irrigateArea;
    }

    public void setIrrigateArea(BigDecimal irrigateArea) {
        this.irrigateArea = irrigateArea;
    }

    public BigDecimal getPaddyFieldArea() {
        return paddyFieldArea;
    }

    public void setPaddyFieldArea(BigDecimal paddyFieldArea) {
        this.paddyFieldArea = paddyFieldArea;
    }

    public BigDecimal getDrainageArea() {
        return drainageArea;
    }

    public void setDrainageArea(BigDecimal drainageArea) {
        this.drainageArea = drainageArea;
    }

    public String getIrrigateFee() {
        return irrigateFee;
    }

    public void setIrrigateFee(String irrigateFee) {
        this.irrigateFee = irrigateFee;
    }

    public String getDrainageFee() {
        return drainageFee;
    }

    public void setDrainageFee(String drainageFee) {
        this.drainageFee = drainageFee;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public BigDecimal getMachineArea() {
        return machineArea;
    }

    public void setMachineArea(BigDecimal machineArea) {
        this.machineArea = machineArea;
    }

    public BigDecimal getTotalInstalledCapacity() {
        return totalInstalledCapacity;
    }

    public void setTotalInstalledCapacity(BigDecimal totalInstalledCapacity) {
        this.totalInstalledCapacity = totalInstalledCapacity;
    }

    public BigDecimal getRiverElevation() {
        return riverElevation;
    }

    public void setRiverElevation(BigDecimal riverElevation) {
        this.riverElevation = riverElevation;
    }

    public BigDecimal getPoolHeight() {
        return poolHeight;
    }

    public void setPoolHeight(BigDecimal poolHeight) {
        this.poolHeight = poolHeight;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public BigDecimal getSumElectricCapacity() {
        return sumElectricCapacity;
    }

    public void setSumElectricCapacity(BigDecimal sumElectricCapacity) {
        this.sumElectricCapacity = sumElectricCapacity;
    }

    public BigDecimal getAverageCapacity() {
        return averageCapacity;
    }

    public void setAverageCapacity(BigDecimal averageCapacity) {
        this.averageCapacity = averageCapacity;
    }

    public String getInternalImage() {
        return internalImage;
    }

    public void setInternalImage(String internalImage) {
        this.internalImage = internalImage;
    }

    public String getExternalImage() {
        return externalImage;
    }

    public void setExternalImage(String externalImage) {
        this.externalImage = externalImage;
    }

    public String getRunningSituation() {
        return runningSituation;
    }

    public void setRunningSituation(String runningSituation) {
        this.runningSituation = runningSituation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
