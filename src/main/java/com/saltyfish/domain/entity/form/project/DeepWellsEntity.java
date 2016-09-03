package com.saltyfish.domain.entity.form.project;

import com.saltyfish.domain.entity.base.SuperBean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 深水井
 */
@Entity
@Table(name = "deep_wells", schema = "", catalog = "exciting")
public class DeepWellsEntity extends SuperBean {
    private static final Long serialVersionUID = -7391847456894534L;
    private BigDecimal irrigateArea;     //灌溉面积
    private String deepPump;        //深水泵
    private BigDecimal diameter;         //井口直径
    private BigDecimal depth;            //井深
    private String material;        //井管材质
    private String image;           //照片

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getIrrigateArea() {
        return irrigateArea;
    }

    public void setIrrigateArea(BigDecimal irrigateArea) {
        this.irrigateArea = irrigateArea;
    }

    public String getDeepPump() {
        return deepPump;
    }

    public void setDeepPump(String deepPump) {
        this.deepPump = deepPump;
    }

    public BigDecimal getDiameter() {
        return diameter;
    }

    public void setDiameter(BigDecimal diameter) {
        this.diameter = diameter;
    }

    public BigDecimal getDepth() {
        return depth;
    }

    public void setDepth(BigDecimal depth) {
        this.depth = depth;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
