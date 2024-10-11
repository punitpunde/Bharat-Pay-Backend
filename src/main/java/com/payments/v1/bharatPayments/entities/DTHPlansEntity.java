package com.payments.v1.bharatPayments.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "DTH_PLANS")
public class DTHPlansEntity {
    @Id
    public String planId;
    public String planName;
    public int amount;
    public int validityDays;
    public int channels;
    public String operator;
}
