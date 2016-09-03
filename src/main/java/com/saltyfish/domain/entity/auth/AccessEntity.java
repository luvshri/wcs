package com.saltyfish.domain.entity.auth;

import com.saltyfish.domain.entity.base.BaseBean;
import com.saltyfish.domain.entity.unit.CountyEntity;
import com.saltyfish.domain.entity.unit.TownEntity;

import javax.persistence.*;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 权限
 */
@Entity
@Table(name = "access", schema = "", catalog = "exciting")
public class AccessEntity extends BaseBean {
    private static final Long serialVersionUID = 99989431798730424L;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "county_id", referencedColumnName = "id")
    private CountyEntity county;
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    private TownEntity town;

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

}
