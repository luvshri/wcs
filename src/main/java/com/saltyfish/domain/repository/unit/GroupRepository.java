package com.saltyfish.domain.repository.unit;

import com.saltyfish.domain.entity.unit.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by weck on 16/8/31.
 */
@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Integer> {
}
