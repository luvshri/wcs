package com.saltyfish.domain.entity.form.category;

import com.saltyfish.domain.entity.base.BaseBean;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by weck on 16/9/2.
 * <p>
 * 工程种类实体
 */
@Entity
@Table(name = "project_category", catalog = "exciting")
public class ProjectCategoryEntity extends BaseBean {
    private static final Long serialVersionUID = 7974297428754231370L;

    private String name;

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
