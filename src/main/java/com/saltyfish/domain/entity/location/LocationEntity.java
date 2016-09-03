package com.saltyfish.domain.entity.location;

import com.saltyfish.domain.entity.base.BaseBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by weck on 16/9/1.
 * <p>
 * 经纬度
 */
@Entity
@Table(name = "location", schema = "", catalog = "exciting")
public class LocationEntity extends BaseBean {
    private static final Long serialVersionUID = -2389744690840525370L;
    @Column(nullable = false)
    private BigDecimal longitude;
    @Column(nullable = false)
    private BigDecimal latitude;

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
}
