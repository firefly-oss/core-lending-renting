package com.catalis.core.lending.renting.models.entities.agreement.v1;

import com.catalis.core.lending.renting.interfaces.enums.agreement.v1.AgreementStatusEnum;
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
@Table("renting_agreement")
public class RentingAgreement {

    @Id
    @Column("renting_agreement_id")
    private Long rentingAgreementId;

    @Column("contract_id")
    private Long contractId;

    @Column("customer_id")
    private Long customerId;

    @Column("agreement_status")
    private AgreementStatusEnum agreementStatus;

    @Column("start_date")
    private LocalDate startDate;

    @Column("end_date")
    private LocalDate endDate;

    @Column("monthly_rent")
    private BigDecimal monthlyRent;

    @Column("services_included")
    private Boolean servicesIncluded;

    @Column("insurance_fee")
    private BigDecimal insuranceFee;

    @Column("remarks")
    private String remarks;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;
}