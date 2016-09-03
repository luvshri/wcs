package com.saltyfish.domain.entity.form.human;

import com.saltyfish.domain.entity.base.BaseBean;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by weck on 16/9/2.
 * <p>
 * 管理人
 */
@Entity
@Table(name = "manager", schema = "", catalog = "exciting")
public class ManagerEntity extends BaseBean {
    private static final Long serialVersionUID = -5937964902850421370L;
    private String manager;
    private String contacts;
    private String phone;
}
