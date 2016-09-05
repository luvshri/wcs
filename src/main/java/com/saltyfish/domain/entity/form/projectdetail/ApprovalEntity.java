package com.saltyfish.domain.entity.form.projectdetail;

import com.saltyfish.domain.entity.base.BaseBean;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 批复
 */
@Entity
@Table(name = "approval", catalog = "exciting")
public class ApprovalEntity extends BaseBean {
    private static final Long serialVersionUID = -283479572243590424L;

    @NotEmpty
    private String approvalSymbol;      //批复文号
    @NotEmpty
    private Timestamp approvalTime;     //批复时间
    private String file;            //文件路径
    @NotEmpty
    private Integer grade;          //等级,1国家级,2省级,3市级,4县级
    @NotEmpty
    private String gradeName;       //等级名称,国家级,省级,市级,县级,与grade对应

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getApprovalSymbol() {
        return approvalSymbol;
    }

    public void setApprovalSymbol(String approvalSymbol) {
        this.approvalSymbol = approvalSymbol;
    }

    public Timestamp getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Timestamp approvalTime) {
        this.approvalTime = approvalTime;
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
