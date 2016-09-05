package com.saltyfish.domain.entity.form.project;

import com.saltyfish.domain.entity.base.SuperBean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 桥梁
 */

@Entity
@Table(name = "bridge", catalog = "exciting")
public class BridgeEntity extends SuperBean {
    private static final Long serialVersionUID = -7874927950228503234L;
    private String watercourseLocation;     //所在河道
    private Integer crossCount;             //桥跨数
    private String beamStructure;           //梁板结构形式
    private String beamMaterial;             //梁板材质
    private BigDecimal loadStandard;                     //负载标准,T
    private BigDecimal crossLength;              //每跨长度,m
    private BigDecimal width;                    //桥面宽度,m
    private BigDecimal length;                   //桥面总长,m
    private String situation;               //完好情况
    private String image;                   //照片

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getWatercourseLocation() {
        return watercourseLocation;
    }

    public void setWatercourseLocation(String watercourseLocation) {
        this.watercourseLocation = watercourseLocation;
    }

    public Integer getCrossCount() {
        return crossCount;
    }

    public void setCrossCount(Integer crossCount) {
        this.crossCount = crossCount;
    }

    public String getBeamStructure() {
        return beamStructure;
    }

    public void setBeamStructure(String beamStructure) {
        this.beamStructure = beamStructure;
    }

    public String getBeamMaterial() {
        return beamMaterial;
    }

    public void setBeamMaterial(String beamMaterial) {
        this.beamMaterial = beamMaterial;
    }

    public BigDecimal getLoadStandard() {
        return loadStandard;
    }

    public void setLoadStandard(BigDecimal loadStandard) {
        this.loadStandard = loadStandard;
    }

    public BigDecimal getCrossLength() {
        return crossLength;
    }

    public void setCrossLength(BigDecimal crossLength) {
        this.crossLength = crossLength;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
