/*
 * Copyright 2025 Firefly Software Solutions Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.firefly.core.lending.renting.models.entities.schedule.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("renting_billing_schedule")
public class RentingBillingSchedule {

    @Id
    @Column("renting_billing_schedule_id")
    private UUID rentingBillingScheduleId;

    @Column("renting_agreement_id")
    private UUID rentingAgreementId;

    @Column("installment_number")
    private Integer installmentNumber;

    @Column("due_date")
    private LocalDate dueDate;

    @Column("rent_amount")
    private BigDecimal rentAmount;

    @Column("service_fee")
    private BigDecimal serviceFee;

    @Column("total_due")
    private BigDecimal totalDue;

    @Column("is_paid")
    private Boolean isPaid;

    @Column("paid_date")
    private LocalDate paidDate;

    @Column("note")
    private String note;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;
}