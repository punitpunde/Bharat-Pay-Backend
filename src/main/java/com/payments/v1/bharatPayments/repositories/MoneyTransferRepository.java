package com.payments.v1.bharatPayments.repositories;

import com.payments.v1.bharatPayments.entities.MoneyTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyTransferRepository extends JpaRepository<MoneyTransactionEntity, Long> {
//    @Query("SELECT m FROM MoneyTransferEntity m")
//    List<MoneyTransferEntity> getAll();

}
