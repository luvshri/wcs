package com.saltyfish.domain.entity.form.project.mark;

import com.saltyfish.domain.entity.base.SuperBean;
import com.saltyfish.domain.entity.form.project.*;

import javax.persistence.*;

/**
 * Created by weck on 16/9/2.
 */
@Entity
@Table(name = "project_mark", schema = "", catalog = "exciting")
public class ProjectMarkEntity extends SuperBean {
    private static final Long serialVersionUID = -3094094589759825424L;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "aqueduct_id", referencedColumnName = "id")
    private AqueductEntity aqueduct;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bridge_id", referencedColumnName = "id")
    private BridgeEntity bridge;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "channel_id", referencedColumnName = "id")
    private ChannelEntity channel;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "culvert_id", referencedColumnName = "id")
    private CulvertEntity culvert;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dam_id", referencedColumnName = "id")
    private DamEntity dam;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "deep_wells_id", referencedColumnName = "id")
    private DeepWellsEntity deepWells;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "drip_irrigation_pipe_id", referencedColumnName = "id")
    private DripIrrigationPipeEntity dripIrrigationPipe;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "great_wells_id", referencedColumnName = "id")
    private GreatWellsEntity greatWells;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "hydropower_id", referencedColumnName = "id")
    private HydropowerEntity hydropower;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pond_id", referencedColumnName = "id")
    private PondEntity pond;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pump_station_id", referencedColumnName = "id")
    private PumpStationEntity pumpStation;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sluice_id", referencedColumnName = "id")
    private SluiceEntity sluice;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "watercourse_id", referencedColumnName = "id")
    private WatercourseEntity watercourse;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "water_works_id", referencedColumnName = "id")
    private WaterWorksEntity waterWorks;


}
