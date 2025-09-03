package com.firefly.core.lending.renting.interfaces.dtos.agreement.v1;

import com.firefly.annotations.ValidAmount;
import com.firefly.annotations.ValidDate;
import com.firefly.core.lending.renting.interfaces.enums.agreement.v1.AgreementStatusEnum;
import com.firefly.core.utils.annotations.FilterableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentingAgreementDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID rentingAgreementId;

    @NotNull(message = "Contract ID is required")
    @FilterableId
    private UUID contractId;

    @NotNull(message = "Customer ID is required")
    @FilterableId
    private UUID customerId;

    @NotNull(message = "Agreement status is required")
    private AgreementStatusEnum agreementStatus;

    @NotNull(message = "Start date is required")
    @ValidDate(message = "Start date must be a valid date")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    @ValidDate(message = "End date must be a valid date")
    private LocalDate endDate;

    @NotNull(message = "Monthly rent is required")
    @Positive(message = "Monthly rent must be positive")
    @ValidAmount(message = "Monthly rent must be a valid amount")
    private BigDecimal monthlyRent;

    private Boolean servicesIncluded;

    @Positive(message = "Insurance fee must be positive")
    @ValidAmount(message = "Insurance fee must be a valid amount")
    private BigDecimal insuranceFee;

    @Size(max = 1000, message = "Remarks cannot exceed 1000 characters")
    private String remarks;

    @PastOrPresent(message = "Created date cannot be in the future")
    private LocalDateTime createdAt;

    @PastOrPresent(message = "Updated date cannot be in the future")
    private LocalDateTime updatedAt;
}