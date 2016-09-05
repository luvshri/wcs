package com.saltyfish.domain.entity.form.projectdetail;

import com.saltyfish.domain.entity.base.BaseBean;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 验收
 */
@Entity
@Table(name = "check", catalog = "exciting")
public class CheckEntity extends BaseBean {
    private static final Long serialVersionUID = 1238048502978590424L;
    @NotEmpty
    private Timestamp checkTime;
    private String file;
    @NotEmpty
    private Integer grade;          //等级,1国家级,2省级,3市级,4县级
    @NotEmpty
    private String gradeName;       //等级名称,国家级,省级,市级,县级,与grade对应

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Timestamp getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}
