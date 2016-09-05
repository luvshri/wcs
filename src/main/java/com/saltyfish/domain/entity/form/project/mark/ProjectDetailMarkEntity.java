package com.saltyfish.domain.entity.form.project.mark;

import com.saltyfish.domain.entity.base.SuperBean;
import com.saltyfish.domain.entity.form.projectdetail.ApprovalEntity;
import com.saltyfish.domain.entity.form.projectdetail.CheckEntity;
import com.saltyfish.domain.entity.form.projectdetail.InvestmentEntity;

import javax.persistence.*;

/**
 * Created by weck on 16/9/2.
 */
@Entity
@Table(name = "project_detail_mark", catalog = "exciting")
public class ProjectDetailMarkEntity extends SuperBean {
    private static final Long serialVersionUID = 3092347950254928024L;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "approval_id", referencedColumnName = "id")
    private ApprovalEntity approval;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "check_id", referencedColumnName = "id")
    private CheckEntity check;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "investment_id", referencedColumnName = "id")
    private InvestmentEntity investment;

}
