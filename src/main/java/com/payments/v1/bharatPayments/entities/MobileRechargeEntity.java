package com.payments.v1.bharatPayments.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "MOBILE_RECHARGE")
public class MobileRechargeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int amount;
    private String validity;
    private String benefit;
    private String category;
    private String verdict;
    private Date date;
    private String mobileNumber;
    private String operator;
    private String circle;
}
