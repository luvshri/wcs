package com.saltyfish.domain.repository.auth;

import com.saltyfish.domain.entity.auth.AccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by weck on 16/8/31.
 */
@Repository
public interface AccessRepository extends JpaRepository<AccessEntity, Integer> {
}
