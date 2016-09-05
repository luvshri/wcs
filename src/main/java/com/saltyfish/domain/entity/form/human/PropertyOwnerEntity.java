package com.saltyfish.domain.entity.form.human;

import com.saltyfish.domain.entity.base.BaseBean;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by weck on 16/9/2.
 * <p>
 * 产权人
 */
@Entity
@Table(name = "property_owner", catalog = "exciting")
public class PropertyOwnerEntity extends BaseBean {

    private static final Long serialVersionUID = 1254285092473892370L;
    private String owner;
    private String contacts;
    private String phone;

}
