package com.saltyfish.domain.entity.project.projectdetail;

import com.saltyfish.domain.entity.base.BaseBean;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by weck on 16/8/30.
 * <p>
 * 投资
 */
@Entity
@Table(name = "investment", catalog = "exciting")
public class InvestmentEntity extends BaseBean {

    private static final Long serialVersionUID = 954892794278590424L;

    private String countryInvest; //国家投资

    private String provinceInvest;        //省级投资

    private String cityInvest;          //市级投资

    private String countyInvest;          //县级投资

    private String otherInvest;           //其他

    private Integer category;           //1 概算投资,2实际到位投资

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCountryInvest() {
        return countryInvest;
    }

    public void setCountryInvest(String countryInvest) {
        this.countryInvest = countryInvest;
    }

    public String getProvinceInvest() {
        return provinceInvest;
    }

    public void setProvinceInvest(String provinceInvest) {
        this.provinceInvest = provinceInvest;
    }

    public String getCityInvest() {
        return cityInvest;
    }

    public void setCityInvest(String cityInvest) {
        this.cityInvest = cityInvest;
    }

    public String getCountyInvest() {
        return countyInvest;
    }

    public void setCountyInvest(String countyInvest) {
        this.countyInvest = countyInvest;
    }

    public String getOtherInvest() {
        return otherInvest;
    }

    public void setOtherInvest(String otherInvest) {
        this.otherInvest = otherInvest;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

}
