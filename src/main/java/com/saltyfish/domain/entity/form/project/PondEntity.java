package com.saltyfish.domain.entity.form.project;

import com.saltyfish.domain.entity.base.SuperBean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 水塘
 */
@Entity
@Table(name = "pond", schema = "", catalog = "exciting")
public class PondEntity extends SuperBean {
    private static final Long serialVersionUID = -193848050958205434L;
    private String features;        //主要功能
    private Timestamp lastDredgingTime;     //上次疏浚时间
    private BigDecimal waterArea;        //水面积
    private BigDecimal waterCapacity;        //储水量
    private String image;           //照片

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public Timestamp getLastDredgingTime() {
        return lastDredgingTime;
    }

    public void setLastDredgingTime(Timestamp lastDredgingTime) {
        this.lastDredgingTime = lastDredgingTime;
    }

    public BigDecimal getWaterArea() {
        return waterArea;
    }

    public void setWaterArea(BigDecimal waterArea) {
        this.waterArea = waterArea;
    }

    public BigDecimal getWaterCapacity() {
        return waterCapacity;
    }

    public void setWaterCapacity(BigDecimal waterCapacity) {
        this.waterCapacity = waterCapacity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
