package com.saltyfish.domain.entity.form.project.device;

import com.saltyfish.domain.entity.base.SuperBean;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by weck on 16/8/31.
 * <p>
 * 水轮机
 */

@Entity
@Table(name = "turbine", schema = "", catalog = "exciting")
public class TurbineEntity extends SuperBean {
    private static final Long serialVersionUID = -975132493522824424L;
    @NotEmpty
    private Integer projectId;          //工程id
    @NotEmpty
    private String projectCode;
    private String model;               //型号
    private String count;               //台数
    private Integer turns;              //转数
    private BigDecimal flow;                 //流量
    private Timestamp factoryTime;          //出厂时间

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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Integer getTurns() {
        return turns;
    }

    public void setTurns(Integer turns) {
        this.turns = turns;
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
