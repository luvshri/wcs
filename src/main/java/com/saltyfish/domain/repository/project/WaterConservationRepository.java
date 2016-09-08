package com.saltyfish.domain.repository.project;

import com.saltyfish.domain.entity.project.WaterConservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by weck on 16/9/8.
 */
@Repository
public interface WaterConservationRepository extends JpaRepository<WaterConservationEntity, Integer> {
}
