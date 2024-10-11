package com.payments.v1.bharatPayments.repositories;

import com.payments.v1.bharatPayments.entities.MobileRechargePlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RechargePlansRepository extends JpaRepository<MobileRechargePlanEntity, Long> {
//    @Query("SELECT r FROM MobileRechargePlanEntity r WHERE r.operator = :operator AND r.circle = :circle")
//    List<MobileRechargePlanEntity> getRechargePlansByOperatorAndCircle(@Param("operator") String operator, @Param("circle") String circle);
////      Optional<List<MobileRechargePlanEntity>>findAll();
}
