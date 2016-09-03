package com.saltyfish.domain.entity.form.project;

import com.saltyfish.domain.entity.base.SuperBean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 管滴灌
 */
@Entity
@Table(name = "drip_irrigation_pipe", schema = "", catalog = "exciting")
public class DripIrrigationPipeEntity extends SuperBean {
    private static final Long serialVersionUID = -59475892792024924L;
    private BigDecimal irrigateArea;     //灌溉面积
    private String intakeWay;       //取水方式
    private String waterResource;       //水源
    private BigDecimal sumLength;            //管道总长
    private BigDecimal sumDiameter;          //管道总直径
    private String iamge;               //照片
    private String sketch;          //平面草图

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getIrrigateArea() {
        return irrigateArea;
    }

    public void setIrrigateArea(BigDecimal irrigateArea) {
        this.irrigateArea = irrigateArea;
    }

    public String getIntakeWay() {
        return intakeWay;
    }

    public void setIntakeWay(String intakeWay) {
        this.intakeWay = intakeWay;
    }

    public String getWaterResource() {
        return waterResource;
    }

    public void setWaterResource(String waterResource) {
        this.waterResource = waterResource;
    }

    public BigDecimal getSumLength() {
        return sumLength;
    }

    public void setSumLength(BigDecimal sumLength) {
        this.sumLength = sumLength;
    }

    public BigDecimal getSumDiameter() {
        return sumDiameter;
    }

    public void setSumDiameter(BigDecimal sumDiameter) {
        this.sumDiameter = sumDiameter;
    }

    public String getIamge() {
        return iamge;
    }

    public void setIamge(String iamge) {
        this.iamge = iamge;
    }

    public String getSketch() {
        return sketch;
    }

    public void setSketch(String sketch) {
        this.sketch = sketch;
    }
}
