package com.firefly.core.lending.renting.interfaces.dtos.agreement.v1;

import com.firefly.core.lending.renting.interfaces.enums.agreement.v1.AgreementStatusEnum;
import com.firefly.core.utils.annotations.FilterableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentingAgreementDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long rentingAgreementId;

    @FilterableId
    private Long contractId;

    @FilterableId
    private Long customerId;

    private AgreementStatusEnum agreementStatus;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal monthlyRent;
    private Boolean servicesIncluded;
    private BigDecimal insuranceFee;
    private String remarks;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}