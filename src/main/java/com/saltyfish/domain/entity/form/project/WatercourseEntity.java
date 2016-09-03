package com.saltyfish.domain.entity.form.project;

import com.saltyfish.domain.entity.base.SuperBean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 河道
 */
@Entity
@Table(name = "watercourse", schema = "", catalog = "exciting")
public class WatercourseEntity extends SuperBean {
    private static final Long serialVersionUID = 8745279287298234L;
    private BigDecimal length;                   //长度,km
    private Timestamp lastDredgingTime;     //上次疏浚时间
    private BigDecimal estuaryWidth;             //河口宽度 m
    private BigDecimal hediWidth;                    //河底宽度,m
    private BigDecimal leftWidth;                //左岸总宽,m
    private BigDecimal estuaryHeight;            //河口高程,m
    private BigDecimal hediHeight;               //河底高程,m
    private BigDecimal rightWidth;               //右岸总宽,m
    private String flowVillages;            //流经村组
    private String nature;                  //河道性质
    private String sectionImage;                   //断面图
    private String endpointLongitude;       //终点东经
    private String endpointLatitude;        //终点北纬,父类的经纬度默认起点的东经北纬
    private String startImage;          //照片头段
    private String middleImage;         //照片中段
    private String endImage;            //照片尾段

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }


    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public Timestamp getLastDredgingTime() {
        return lastDredgingTime;
    }

    public void setLastDredgingTime(Timestamp lastDredgingTime) {
        this.lastDredgingTime = lastDredgingTime;
    }

    public BigDecimal getEstuaryWidth() {
        return estuaryWidth;
    }

    public void setEstuaryWidth(BigDecimal estuaryWidth) {
        this.estuaryWidth = estuaryWidth;
    }

    public BigDecimal getHediWidth() {
        return hediWidth;
    }

    public void setHediWidth(BigDecimal hediWidth) {
        this.hediWidth = hediWidth;
    }

    public BigDecimal getLeftWidth() {
        return leftWidth;
    }

    public void setLeftWidth(BigDecimal leftWidth) {
        this.leftWidth = leftWidth;
    }

    public BigDecimal getEstuaryHeight() {
        return estuaryHeight;
    }

    public void setEstuaryHeight(BigDecimal estuaryHeight) {
        this.estuaryHeight = estuaryHeight;
    }

    public BigDecimal getHediHeight() {
        return hediHeight;
    }

    public void setHediHeight(BigDecimal hediHeight) {
        this.hediHeight = hediHeight;
    }

    public BigDecimal getRightWidth() {
        return rightWidth;
    }

    public void setRightWidth(BigDecimal rightWidth) {
        this.rightWidth = rightWidth;
    }

    public String getFlowVillages() {
        return flowVillages;
    }

    public void setFlowVillages(String flowVillages) {
        this.flowVillages = flowVillages;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getSectionImage() {
        return sectionImage;
    }

    public void setSectionImage(String sectionImage) {
        this.sectionImage = sectionImage;
    }

    public String getEndpointLongitude() {
        return endpointLongitude;
    }

    public void setEndpointLongitude(String endpointLongitude) {
        this.endpointLongitude = endpointLongitude;
    }

    public String getEndpointLatitude() {
        return endpointLatitude;
    }

    public void setEndpointLatitude(String endpointLatitude) {
        this.endpointLatitude = endpointLatitude;
    }

    public String getStartImage() {
        return startImage;
    }

    public void setStartImage(String startImage) {
        this.startImage = startImage;
    }

    public String getMiddleImage() {
        return middleImage;
    }

    public void setMiddleImage(String middleImage) {
        this.middleImage = middleImage;
    }

    public String getEndImage() {
        return endImage;
    }

    public void setEndImage(String endImage) {
        this.endImage = endImage;
    }
}
