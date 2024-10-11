package com.payments.v1.bharatPayments.repositories;

import com.payments.v1.bharatPayments.entities.DTHPlansEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DTHPlansRepository extends JpaRepository<DTHPlansEntity, String> {
}
