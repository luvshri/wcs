package com.saltyfish.domain.entity.form.project.device;

import com.saltyfish.domain.entity.base.SuperBean;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 变压器
 */
@Entity
@Table(name = "transformer", schema = "", catalog = "exciting")
public class TransformerEntity extends SuperBean {
    private static final Long serialVersionUID = 7842794270759825424L;
    @NotEmpty
    private Integer projectId;      //工程id
    @NotEmpty
    private String projectCode;
    private String model;           //型号
    private Integer count;          //数量
    private BigDecimal capacity;         //单机容量,KVA

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getCapacity() {
        return capacity;
    }

    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }
}
