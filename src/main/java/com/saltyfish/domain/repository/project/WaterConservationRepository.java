package com.saltyfish.domain.repository.project;

import com.saltyfish.domain.entity.project.WaterConservationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by weck on 16/9/8.
 */
@Repository
public interface WaterConservationRepository extends JpaRepository<WaterConservationEntity, Integer> {
    Page<WaterConservationEntity> findByCategoryAndTownIdIn(@Param("category") String category,
                                                            @Param("town_id") List<Integer> townIds,
                                                            Pageable pageable);

    Page<WaterConservationEntity> findByCategoryAndTownId(@Param("category") String category,
                                                          @Param("town_id") Integer townId,
                                                          Pageable pageable);

    Page<WaterConservationEntity> findByCategoryAndVillageId(@Param("category") String category,
                                                             @Param("village_id") Integer villageId,
                                                             Pageable pageable);

    Page<WaterConservationEntity> findByCategoryAndGroupId(@Param("category") String category,
                                                           @Param("group_id") Integer groupId,
                                                           Pageable pageable);

    Page<WaterConservationEntity> findByManageModelAndCategoryAndTownIdIn(@Param("manage_model") String manageModel,
                                                                          @Param("category") String category,
                                                                          @Param("town_id") List<Integer> townIds,
                                                                          Pageable pageable);

    Page<WaterConservationEntity> findByManageModelAndCategoryAndTownId(@Param("manage_model") String manageModel,
                                                                        @Param("category") String category,
                                                                        @Param("town_id") Integer townId,
                                                                        Pageable pageable);

    Page<WaterConservationEntity> findByManageModelAndCategoryAndVillageId(@Param("manage_model") String manageModel,
                                                                           @Param("category") String category,
                                                                           @Param("village_id") Integer villageId,
                                                                           Pageable pageable);

    Page<WaterConservationEntity> findByManageModelAndCategoryAndGroupId(@Param("manage_model") String manageModel,
                                                                         @Param("category") String category,
                                                                         @Param("group_id") Integer groupId,
                                                                         Pageable pageable);

    Page<WaterConservationEntity> findBySituationAndCategoryAndTownIdIn(@Param("situation") String situation,
                                                                        @Param("category") String category,
                                                                        @Param("town_id") List<Integer> townIds,
                                                                        Pageable pageable);

    Page<WaterConservationEntity> findBySituationAndCategoryAndTownId(@Param("situation") String situation,
                                                                      @Param("category") String category,
                                                                      @Param("town_id") Integer townId,
                                                                      Pageable pageable);

    Page<WaterConservationEntity> findBySituationAndCategoryAndVillageId(@Param("situation") String situation,
                                                                         @Param("category") String category,
                                                                         @Param("village_id") Integer villageId,
                                                                         Pageable pageable);

    Page<WaterConservationEntity> findBySituationAndCategoryAndGroupId(@Param("situation") String situation,
                                                                       @Param("category") String category,
                                                                       @Param("group_id") Integer groupId,
                                                                       Pageable pageable);

    Page<WaterConservationEntity> findByManageModelAndSituationAndCategoryAndTownIdIn(@Param("manage_model") String manageModel,
                                                                                      @Param("situation") String situation,
                                                                                      @Param("category") String category,
                                                                                      @Param("town_id") List<Integer> townIds,
                                                                                      Pageable pageable);

    Page<WaterConservationEntity> findByManageModelAndSituationAndCategoryAndTownId(@Param("manage_model") String manageModel,
                                                                                    @Param("situation") String situation,
                                                                                    @Param("category") String category,
                                                                                    @Param("town_id") Integer townId,
                                                                                    Pageable pageable);

    Page<WaterConservationEntity> findByManageModelAndSituationAndCategoryAndVillageId(@Param("manage_model") String manageModel,
                                                                                       @Param("situation") String situation,
                                                                                       @Param("category") String category,
                                                                                       @Param("village_id") Integer villageId,
                                                                                       Pageable pageable);

    Page<WaterConservationEntity> findByManageModelAndSituationAndCategoryAndGroupId(@Param("manage_model") String manageModel,
                                                                                     @Param("situation") String situation,
                                                                                     @Param("category") String category,
                                                                                     @Param("group_id") Integer groupId,
                                                                                     Pageable pageable);

    Page<WaterConservationEntity> findByCategoryAndTownIdInAndUpdateTimeBetween(@Param("category") String category,
                                                                                @Param("town_id") List<Integer> townIds,
                                                                                @Param("update_time") Timestamp startTime,
                                                                                @Param("update_time") Timestamp endTime,
                                                                                Pageable pageable);

    Page<WaterConservationEntity> findByCategoryAndTownIdInAndCodeLike(@Param("category") String category,
                                                                       @Param("town_id") List<Integer> townIds,
                                                                       @Param("code") String code,
                                                                       Pageable pageable);

    Page<WaterConservationEntity> findByCategoryAndTownIdInAndNameLike(@Param("category") String category,
                                                                       @Param("town_id") List<Integer> townIds,
                                                                       @Param("name") String name,
                                                                       Pageable pageable);

    Page<WaterConservationEntity> findByTownIdIn(@Param("town_id") List<Integer> townIds,
                                                 Pageable pageable);
}
