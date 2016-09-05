package com.saltyfish.domain.entity.form.project.division;

import com.saltyfish.domain.entity.base.SuperBean;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by weck on 16/8/31.
 * <p>
 * 沟渠
 */
@Entity
@Table(name = "canal", catalog = "exciting")
public class CanalEntity extends SuperBean {
    private static final Long serialVersionUID = -5847937472510125424L;
    @NotEmpty
    private Integer projectId;      //工程id
    @NotEmpty
    private String projectCode;     //工程编码
    private String model;           //类别
    private BigDecimal length;               //长度
    private BigDecimal sectionSize;              //断面尺寸
    private BigDecimal seepageCanalLength;       //其中防渗渠长度(KM)
    private BigDecimal liningSectionSize;        //衬砌断面尺寸
    private String liningMaterial;       //衬砌材质

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
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

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getSectionSize() {
        return sectionSize;
    }

    public void setSectionSize(BigDecimal sectionSize) {
        this.sectionSize = sectionSize;
    }

    public BigDecimal getSeepageCanalLength() {
        return seepageCanalLength;
    }

    public void setSeepageCanalLength(BigDecimal seepageCanalLength) {
        this.seepageCanalLength = seepageCanalLength;
    }

    public BigDecimal getLiningSectionSize() {
        return liningSectionSize;
    }

    public void setLiningSectionSize(BigDecimal liningSectionSize) {
        this.liningSectionSize = liningSectionSize;
    }

    public String getLiningMaterial() {
        return liningMaterial;
    }

    public void setLiningMaterial(String liningMaterial) {
        this.liningMaterial = liningMaterial;
    }
}
