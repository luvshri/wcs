package com.saltyfish.domain.entity.form.project.human;

import com.saltyfish.domain.entity.base.SuperBean;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by weck on 16/8/31.
 * <p>
 * 聘用的管护人员
 */

@Entity
@Table(name = "transformer", schema = "", catalog = "exciting")
public class MaintainPersonEntity extends SuperBean {
    private static final Long serialVersionUID = -984759890284597424L;
    @NotEmpty
    private Integer projectId;      //工程id
    private Integer count;              //数量
    private BigDecimal annualPay;            //工资每年多少
    private Integer years;      //协议年限

    public static Long getSerialVersionUID() {
        return serialVersionUID;
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

    public BigDecimal getAnnualPay() {
        return annualPay;
    }

    public void setAnnualPay(BigDecimal annualPay) {
        this.annualPay = annualPay;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }
}
