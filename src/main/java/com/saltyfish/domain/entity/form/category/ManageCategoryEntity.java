package com.saltyfish.domain.entity.form.category;

import com.saltyfish.domain.entity.base.BaseBean;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by weck on 16/9/2.
 * <p>
 * 管理模式
 */
@Entity
@Table(name = "manage_category", schema = "", catalog = "exciting")
public class ManageCategoryEntity extends BaseBean {
    private static final Long serialVersionUID = -984397387292521470L;

    private String name;

}
