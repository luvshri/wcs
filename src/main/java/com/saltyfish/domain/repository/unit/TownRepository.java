package com.saltyfish.domain.repository.unit;

import com.saltyfish.domain.entity.unit.TownEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by weck on 16/8/31.
 */
@Repository
public interface TownRepository extends JpaRepository<TownEntity, Integer> {
}
