package com.saltyfish.domain.entity.unit;

import com.saltyfish.domain.entity.base.Unit;
import com.saltyfish.domain.entity.location.LocationEntity;

import javax.persistence.*;

/**
 * Created by weck on 16/8/29.
 * <p>
 * 镇
 */
@Entity
@Table(name = "town", schema = "", catalog = "exciting")
public class TownEntity extends Unit {
    private static final Long serialVersionUID = -8390098490395830424L;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "county_id", referencedColumnName = "id", nullable = false)
    private CountyEntity county;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private LocationEntity location;

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public CountyEntity getCounty() {
        return county;
    }

    public void setCounty(CountyEntity county) {
        this.county = county;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }
}
