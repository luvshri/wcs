package com.saltyfish.domain.entity.form.project;

import com.saltyfish.domain.entity.base.SuperBean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 泵站
 */
@Entity
@Table(name = "pump_station", catalog = "exciting")
public class PumpStationEntity extends SuperBean {
    private static final Long serialVersionUID = -798391408317894179L;
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
    //照片
    private String internalImage;       //泵房内照片
    private String externalImage;       //泵房外照片

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
