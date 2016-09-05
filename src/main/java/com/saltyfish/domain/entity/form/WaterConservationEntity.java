package com.saltyfish.domain.entity.form;

import com.saltyfish.domain.entity.base.BaseBean;
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

import javax.persistence.*;

/**
 * Created by weck on 16/8/29.
 * <p>
 * 水利设施
 */
@Entity
@Table(name = "water_conservation", catalog = "exciting")
public class WaterConservationEntity extends BaseBean {
    private static final Long serialVersionUID = -1439134197984525370L;

    @Column(nullable = false)
    private String code;            //编码
    @Column(nullable = false)
    private String name;            //名称

    private String remark;              //备注

    private String manageModel;     //管理模式

    /*县*/
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "county_id", referencedColumnName = "id", nullable = false)
    private CountyEntity county;

    /*乡镇*/
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "town_id", referencedColumnName = "id", nullable = false)
    private TownEntity town;

    /*组*/
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private GroupEntity group;

    /*村*/
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "village_id", referencedColumnName = "id", nullable = false)
    private VillageEntity village;

    /*经纬度*/
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private LocationEntity location;

    /*产权*/
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "property_owner_id", referencedColumnName = "id")
    private PropertyOwnerEntity propertyOwner;

    /*管理*/
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private ManagerEntity manager;

    /*建设维修*/
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "construct_id", referencedColumnName = "id")
    private ConstructEntity construct;

    /*种类*/
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "project_category_id", referencedColumnName = "id", nullable = false)
    private ProjectCategoryEntity projectCategory;

    /*工程标记*/
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "project_mark_id", referencedColumnName = "id", nullable = false)
    private ProjectMarkEntity projectMark;

    /*工程明细标记*/
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "project_detail_mark_id", referencedColumnName = "id")
    private ProjectDetailMarkEntity projectDetailMark;

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getManageModel() {
        return manageModel;
    }

    public void setManageModel(String manageModel) {
        this.manageModel = manageModel;
    }

    public ProjectMarkEntity getProjectMark() {
        return projectMark;
    }

    public void setProjectMark(ProjectMarkEntity projectMark) {
        this.projectMark = projectMark;
    }

    public ProjectDetailMarkEntity getProjectDetailMark() {
        return projectDetailMark;
    }

    public void setProjectDetailMark(ProjectDetailMarkEntity projectDetailMark) {
        this.projectDetailMark = projectDetailMark;
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
