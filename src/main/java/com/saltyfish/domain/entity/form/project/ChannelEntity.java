package com.saltyfish.domain.entity.form.project;

import com.saltyfish.domain.entity.base.SuperBean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 渠道
 */

@Entity
@Table(name = "channel", schema = "", catalog = "exciting")
public class ChannelEntity extends SuperBean {
    private static final Long serialVersionUID = -7954280582502454234L;

    private String pumpStation;             //取水泵站
    private BigDecimal buildingMatchRate;         //建筑物配套率(%)
    private BigDecimal sumLength;                //渠道总长(KM)
    private BigDecimal goodConditionRate;        //渠道及建筑完好率(%)
    private String image;                   //照片
    private BigDecimal sumSectionSize;           //总计断面尺寸
    private BigDecimal sumSeepageCanalLength;        //总计其中防渗渠长度(KM)
    private BigDecimal sumLiningSectionSize;         //总计衬砌断面尺寸


    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPumpStation() {
        return pumpStation;
    }

    public void setPumpStation(String pumpStation) {
        this.pumpStation = pumpStation;
    }

    public BigDecimal getBuildingMatchRate() {
        return buildingMatchRate;
    }

    public void setBuildingMatchRate(BigDecimal buildingMatchRate) {
        this.buildingMatchRate = buildingMatchRate;
    }

    public BigDecimal getSumLength() {
        return sumLength;
    }

    public void setSumLength(BigDecimal sumLength) {
        this.sumLength = sumLength;
    }

    public BigDecimal getGoodConditionRate() {
        return goodConditionRate;
    }

    public void setGoodConditionRate(BigDecimal goodConditionRate) {
        this.goodConditionRate = goodConditionRate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getSumSectionSize() {
        return sumSectionSize;
    }

    public void setSumSectionSize(BigDecimal sumSectionSize) {
        this.sumSectionSize = sumSectionSize;
    }

    public BigDecimal getSumSeepageCanalLength() {
        return sumSeepageCanalLength;
    }

    public void setSumSeepageCanalLength(BigDecimal sumSeepageCanalLength) {
        this.sumSeepageCanalLength = sumSeepageCanalLength;
    }

    public BigDecimal getSumLiningSectionSize() {
        return sumLiningSectionSize;
    }

    public void setSumLiningSectionSize(BigDecimal sumLiningSectionSize) {
        this.sumLiningSectionSize = sumLiningSectionSize;
    }
}
