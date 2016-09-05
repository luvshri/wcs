package com.saltyfish.domain.repository.project;

import com.saltyfish.domain.entity.form.category.ProjectCategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by weck on 16/9/2.
 * <p>
 * 工程种类仓库
 */
@Repository
public interface ProjectCategoryRepository extends CrudRepository<ProjectCategoryEntity, Integer> {

}
