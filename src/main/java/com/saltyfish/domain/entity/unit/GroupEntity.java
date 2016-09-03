package com.saltyfish.domain.entity.unit;

import com.saltyfish.domain.entity.base.Unit;
import com.saltyfish.domain.entity.location.LocationEntity;

import javax.persistence.*;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 组
 */
@Entity
@Table(name = "group", schema = "", catalog = "exciting")
public class GroupEntity extends Unit {
    private static final Long serialVersionUID = -6128309824038223424L;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private LocationEntity location;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "village_id", referencedColumnName = "id", nullable = false)
    private VillageEntity village;
}
