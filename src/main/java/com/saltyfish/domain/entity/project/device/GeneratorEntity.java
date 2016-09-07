package com.saltyfish.domain.entity.project.device;

import com.saltyfish.domain.entity.base.SuperBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by weck on 16/8/31.
 * <p>
 * 发电机
 */
@Entity
@Table(name = "generator", catalog = "exciting")
public class GeneratorEntity extends SuperBean {

    private static final Long serialVersionUID = 489745829749432244L;

    @Column(nullable = false)
    private Integer projectId;          //工程id

    private String model;               //发电机型号

    private String power;                //单台功率乘以台数

    private String factoryDate;      //出厂年月

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getFactoryDate() {
        return factoryDate;
    }

    public void setFactoryDate(String factoryDate) {
        this.factoryDate = factoryDate;
    }
}
