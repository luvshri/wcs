package com.saltyfish.domain.entity.form.project;

import com.saltyfish.domain.entity.base.SuperBean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 大口井
 */
@Entity
@Table(name = "great_wells", catalog = "exciting")
public class GreatWellsEntity extends SuperBean {
    private static final Long serialVersionUID = -905482052785724952L;
    private BigDecimal irrigateArea;     //灌溉面积
    private BigDecimal waterCapacity;        //储水量
    private BigDecimal size;             //井口尺寸
    private BigDecimal depth;            //井深
    private BigDecimal material;         //井壁材质
    private String image;           //照片


    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getWaterCapacity() {
        return waterCapacity;
    }

    public void setWaterCapacity(BigDecimal waterCapacity) {
        this.waterCapacity = waterCapacity;
    }

    public BigDecimal getIrrigateArea() {
        return irrigateArea;
    }

    public void setIrrigateArea(BigDecimal irrigateArea) {
        this.irrigateArea = irrigateArea;
    }

    public BigDecimal getWatedrCapacity() {
        return waterCapacity;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public BigDecimal getDepth() {
        return depth;
    }

    public void setDepth(BigDecimal depth) {
        this.depth = depth;
    }

    public BigDecimal getMaterial() {
        return material;
    }

    public void setMaterial(BigDecimal material) {
        this.material = material;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
