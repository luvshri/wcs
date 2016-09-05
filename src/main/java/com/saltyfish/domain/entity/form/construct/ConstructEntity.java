package com.saltyfish.domain.entity.form.construct;

import com.saltyfish.domain.entity.base.BaseBean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by weck on 16/9/2.
 * <p>
 * 建设/维修
 */
@Entity
@Table(name = "construct", catalog = "exciting")
public class ConstructEntity extends BaseBean {
    private static final Long serialVersionUID = -8846250942868421370L;

    private String constructUnit;
    private Timestamp constructTime;

}
