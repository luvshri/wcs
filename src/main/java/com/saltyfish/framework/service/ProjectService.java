package com.saltyfish.framework.service;

import com.saltyfish.domain.entity.form.category.ProjectCategoryEntity;
import com.saltyfish.domain.repository.project.ProjectCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by weck on 16/9/3.
 * <p>
 * 工程操作
 */
@Service
public class ProjectService {
    @Autowired
    private ProjectCategoryRepository projectCategoryRepository;

    /**
     * 查找所有工程种类
     *
     * @return 工程种类list
     */
    public List<ProjectCategoryEntity> findAll() {
        return (List<ProjectCategoryEntity>) projectCategoryRepository.findAll();
    }
}
