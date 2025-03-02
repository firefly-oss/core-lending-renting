package com.catalis.core.lending.renting.models.entities.schedule.v1;

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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("renting_billing_schedule")
public class RentingBillingSchedule {

    @Id
    @Column("renting_billing_schedule_id")
    private Long rentingBillingScheduleId;

    @Column("renting_agreement_id")
    private Long rentingAgreementId;

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