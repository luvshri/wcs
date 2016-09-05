package com.saltyfish.domain.entity.form.project.division;

import com.saltyfish.domain.entity.base.SuperBean;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by weck on 16/8/31.
 * <p>
 * 管滴灌管道
 */

@Entity
@Table(name = "pipe", catalog = "exciting")
public class PipeEntity extends SuperBean {
    private static final Long serialVersionUID = -2874592742389725424L;
    private String model;       //管道类型
    private BigDecimal length;           //长度
    @NotEmpty
    private Integer projectId;          //工程id
    @NotEmpty
    private String projectCode;     //工程编码
    private BigDecimal diameter;         //直径
    private String material;            //材质

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public BigDecimal getDiameter() {
        return diameter;
    }

    public void setDiameter(BigDecimal diameter) {
        this.diameter = diameter;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
