package com.saltyfish.domain.entity.form;

import com.saltyfish.domain.entity.base.BaseBean;
import com.saltyfish.domain.entity.form.category.ManageCategoryEntity;
import com.saltyfish.domain.entity.form.category.ProjectCategoryEntity;
import com.saltyfish.domain.entity.form.construct.ConstructEntity;
import com.saltyfish.domain.entity.form.human.ManagerEntity;
import com.saltyfish.domain.entity.form.human.PropertyOwnerEntity;
import com.saltyfish.domain.entity.form.project.mark.ProjectDetailMarkEntity;
import com.saltyfish.domain.entity.form.project.mark.ProjectMarkEntity;
import com.saltyfish.domain.entity.location.LocationEntity;
import com.saltyfish.domain.entity.unit.CountyEntity;
import com.saltyfish.domain.entity.unit.GroupEntity;
import com.saltyfish.domain.entity.unit.TownEntity;
import com.saltyfish.domain.entity.unit.VillageEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by weck on 16/8/29.
 * <p>
 * 水利设施
 */
@Entity
@Table(name = "water_conservation", schema = "", catalog = "exciting")
public class WaterConservationEntity extends BaseBean {
    private static final Long serialVersionUID = -1439134197984525370L;

    @NotEmpty
    private String code;            //编码
    @NotEmpty
    private String name;            //名称

    private String remark;              //备注

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "county_id", referencedColumnName = "id", nullable = false)
    private CountyEntity county;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "town_id", referencedColumnName = "id", nullable = false)
    private TownEntity town;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = true)
    private GroupEntity group;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "village_id", referencedColumnName = "id", nullable = false)
    private VillageEntity village;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private LocationEntity location;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "property_owner_id", referencedColumnName = "id")
    private PropertyOwnerEntity propertyOwner;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private ManagerEntity manager;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "construct_id", referencedColumnName = "id")
    private ConstructEntity construct;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "project_category_id", referencedColumnName = "id", nullable = false)
    private ProjectCategoryEntity projectCategory;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "manage_category_id", referencedColumnName = "id")
    private ManageCategoryEntity manageCategory;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "project_mark_id", referencedColumnName = "id", nullable = false)
    private ProjectMarkEntity projectMark;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "project_detail_mark_id", referencedColumnName = "id")
    private ProjectDetailMarkEntity projectDetailMark;

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public CountyEntity getCounty() {
        return county;
    }

    public void setCounty(CountyEntity county) {
        this.county = county;
    }

    public TownEntity getTown() {
        return town;
    }

    public void setTown(TownEntity town) {
        this.town = town;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    public VillageEntity getVillage() {
        return village;
    }

    public void setVillage(VillageEntity village) {
        this.village = village;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public PropertyOwnerEntity getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(PropertyOwnerEntity propertyOwner) {
        this.propertyOwner = propertyOwner;
    }

    public ManagerEntity getManager() {
        return manager;
    }

    public void setManager(ManagerEntity manager) {
        this.manager = manager;
    }

    public ConstructEntity getConstruct() {
        return construct;
    }

    public void setConstruct(ConstructEntity construct) {
        this.construct = construct;
    }

    public ProjectCategoryEntity getProjectCategory() {
        return projectCategory;
    }

    public void setProjectCategory(ProjectCategoryEntity projectCategory) {
        this.projectCategory = projectCategory;
    }

    public ManageCategoryEntity getManageCategory() {
        return manageCategory;
    }

    public void setManageCategory(ManageCategoryEntity manageCategory) {
        this.manageCategory = manageCategory;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
