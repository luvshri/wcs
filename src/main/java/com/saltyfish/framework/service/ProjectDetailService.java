package com.saltyfish.framework.service;

import com.saltyfish.domain.entity.project.ProjectDetailEntity;
import com.saltyfish.domain.entity.project.projectdetail.ApprovalEntity;
import com.saltyfish.domain.entity.project.projectdetail.CheckEntity;
import com.saltyfish.domain.entity.project.projectdetail.InvestmentEntity;
import com.saltyfish.domain.repository.project.ProjectDetailRepository;
import com.saltyfish.domain.repository.project.projectDetail.ApprovalRepository;
import com.saltyfish.domain.repository.project.projectDetail.CheckRepository;
import com.saltyfish.domain.repository.project.projectDetail.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by weck on 16/9/19.
 */
@Service
public class ProjectDetailService {

    @Autowired
    private ProjectDetailRepository projectDetailRepository;

    @Autowired
    private ApprovalRepository approvalRepository;

    @Autowired
    private CheckRepository checkRepository;

    @Autowired
    private InvestmentRepository investmentRepository;

    public Integer saveCommonItems(String projectName, String constructTime, String constructUnit, String sumEstimateInvestment, String sumFactInvestment, String others, Long timeStamp) {
        ProjectDetailEntity projectDetail = new ProjectDetailEntity();
        Timestamp time = new Timestamp(timeStamp);
        projectDetail.setProjectName(projectName);
        projectDetail.setConstructUnit(constructUnit);
        projectDetail.setConstructTime(constructTime);
        projectDetail.setSumEstimateInvestment(sumEstimateInvestment);
        projectDetail.setSumFactInvestment(sumFactInvestment);
        projectDetail.setOthers(others);
        projectDetail.setIsDelete(0);
        projectDetail.setUpdateTime(time);
        projectDetail.setCreateTime(time);
        projectDetailRepository.save(projectDetail);
        return projectDetail.getId();
    }

    public void saveApproval(Integer projectDetailId, String filePath, String grade, String symbol, String approvalTime, Long timeStamp) {
        ProjectDetailEntity projectDetail = projectDetailRepository.findById(projectDetailId);
        ApprovalEntity approval = new ApprovalEntity();
        Timestamp time = new Timestamp(timeStamp);
        approval.setCreateTime(time);
        approval.setUpdateTime(time);
        approval.setIsDelete(0);
        approval.setFile(filePath);
        approval.setGrade(grade);
        approval.setSymbol(symbol);
        approval.setTime(approvalTime);
        approvalRepository.save(approval);
        List<ApprovalEntity> approvals = projectDetail.getApprovals();
        approvals.add(approval);
        projectDetail.setApprovals(approvals);
        projectDetail.setUpdateTime(time);
        projectDetailRepository.save(projectDetail);
    }

    public void saveCheck(Integer projectDetailId, String filePath, String grade, String checkTime, Long timeStamp) {
        ProjectDetailEntity projectDetail = projectDetailRepository.findById(projectDetailId);
        CheckEntity check = new CheckEntity();
        Timestamp time = new Timestamp(timeStamp);
        check.setUpdateTime(time);
        check.setCreateTime(time);
        check.setGrade(grade);
        check.setIsDelete(0);
        check.setFile(filePath);
        check.setTime(checkTime);
        checkRepository.save(check);
        List<CheckEntity> checks = projectDetail.getChecks();
        checks.add(check);
        projectDetail.setChecks(checks);
        projectDetail.setUpdateTime(time);
        projectDetailRepository.save(projectDetail);
    }

    public void saveInvestment(Integer projectDetailId, String invest, String investResource, String category, Long timeStamp) {
        ProjectDetailEntity projectDetail = projectDetailRepository.findById(projectDetailId);
        InvestmentEntity investment = new InvestmentEntity();
        Timestamp time = new Timestamp(timeStamp);
        investment.setUpdateTime(time);
        investment.setIsDelete(0);
        investment.setCreateTime(time);
        investment.setCategory(category);
        investment.setInvest(invest);
        investment.setInvestResource(investResource);
        investmentRepository.save(investment);
        List<InvestmentEntity> investments = projectDetail.getInvestments();
        investments.add(investment);
        projectDetail.setInvestments(investments);
        projectDetail.setUpdateTime(time);
        projectDetailRepository.save(projectDetail);
    }
}
