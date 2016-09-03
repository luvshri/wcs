package com.saltyfish.domain.entity.unit;

import com.saltyfish.domain.entity.base.Unit;
import com.saltyfish.domain.entity.location.LocationEntity;

import javax.persistence.*;

/**
 * Created by weck on 16/8/29.
 * <p>
 * 村
 */
@Entity
@Table(name = "village", schema = "", catalog = "exciting")
public class VillageEntity extends Unit {
    private static final Long serialVersionUID = -1283787394589098432L;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "town_id", referencedColumnName = "id", nullable = false)
    private TownEntity town;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private LocationEntity location;

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }
}
