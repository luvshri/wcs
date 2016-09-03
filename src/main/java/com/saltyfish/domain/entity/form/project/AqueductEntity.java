package com.saltyfish.domain.entity.form.project;

import com.saltyfish.domain.entity.base.SuperBean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 渡槽
 */
@Entity
@Table(name = "aqueduct", schema = "", catalog = "exciting")
public class AqueductEntity extends SuperBean {
    private static final Long serialVersionUID = -3094094589759825424L;
    private String crossWatercourseLocation;        //所跨河道
    private Integer crossCount;             //跨数
    private BigDecimal sectionSize;              //断面尺寸
    private String structureAndMaterial;         //槽身结构和材质
    private BigDecimal crossLength;              //每跨长
    private String image;               //照片

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCrossWatercourseLocation() {
        return crossWatercourseLocation;
    }

    public void setCrossWatercourseLocation(String crossWatercourseLocation) {
        this.crossWatercourseLocation = crossWatercourseLocation;
    }

    public Integer getCrossCount() {
        return crossCount;
    }

    public void setCrossCount(Integer crossCount) {
        this.crossCount = crossCount;
    }

    public BigDecimal getSectionSize() {
        return sectionSize;
    }

    public void setSectionSize(BigDecimal sectionSize) {
        this.sectionSize = sectionSize;
    }

    public String getStructureAndMaterial() {
        return structureAndMaterial;
    }

    public void setStructureAndMaterial(String structureAndMaterial) {
        this.structureAndMaterial = structureAndMaterial;
    }

    public BigDecimal getCrossLength() {
        return crossLength;
    }

    public void setCrossLength(BigDecimal crossLength) {
        this.crossLength = crossLength;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
