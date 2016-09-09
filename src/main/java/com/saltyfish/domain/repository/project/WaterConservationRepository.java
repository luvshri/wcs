package com.saltyfish.domain.repository.project;

import com.saltyfish.domain.entity.project.WaterConservationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by weck on 16/9/8.
 */
@Repository
public interface WaterConservationRepository extends JpaRepository<WaterConservationEntity, Integer> {
    Page<WaterConservationEntity> findByCategoryAndTownIdIn(@Param("category") String category,
                                                            @Param("townId") List<Integer> townIds,
                                                            Pageable pageable);
}
