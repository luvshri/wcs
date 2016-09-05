package com.saltyfish.domain.entity.form.project.device;

import com.saltyfish.domain.entity.base.SuperBean;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 水泵
 */
@Entity
@Table(name = "pump", catalog = "exciting")
public class PumpEntity extends SuperBean {
    private static final Long serialVersionUID = 975489279582824424L;
    @NotEmpty
    private Integer projectId;      //工程id
    @NotEmpty
    private String projectCode;
    private Integer count;      //数量
    private BigDecimal lift;     //铭牌扬程
    private BigDecimal flow;     //流量
    private Timestamp factoryTime;      //出厂时间
    private String model;

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public BigDecimal getLift() {
        return lift;
    }

    public void setLift(BigDecimal lift) {
        this.lift = lift;
    }

    public BigDecimal getFlow() {
        return flow;
    }

    public void setFlow(BigDecimal flow) {
        this.flow = flow;
    }

    public Timestamp getFactoryTime() {
        return factoryTime;
    }

    public void setFactoryTime(Timestamp factoryTime) {
        this.factoryTime = factoryTime;
    }
}
