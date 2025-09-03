package com.firefly.core.lending.renting.interfaces.dtos.schedule.v1;

import com.firefly.annotations.ValidAmount;
import com.firefly.annotations.ValidDate;
import com.firefly.core.utils.annotations.FilterableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
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
public class RentingBillingScheduleDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID rentingBillingScheduleId;

    @NotNull(message = "Renting agreement ID is required")
    @FilterableId
    private UUID rentingAgreementId;

    @NotNull(message = "Installment number is required")
    @Min(value = 1, message = "Installment number must be at least 1")
    private Integer installmentNumber;

    @NotNull(message = "Due date is required")
    @ValidDate(message = "Due date must be a valid date")
    private LocalDate dueDate;

    @NotNull(message = "Rent amount is required")
    @Positive(message = "Rent amount must be positive")
    @ValidAmount(message = "Rent amount must be a valid amount")
    private BigDecimal rentAmount;

    @Positive(message = "Service fee must be positive")
    @ValidAmount(message = "Service fee must be a valid amount")
    private BigDecimal serviceFee;

    @NotNull(message = "Total due is required")
    @Positive(message = "Total due must be positive")
    @ValidAmount(message = "Total due must be a valid amount")
    private BigDecimal totalDue;

    private Boolean isPaid;

    @ValidDate(message = "Paid date must be a valid date")
    private LocalDate paidDate;

    @Size(max = 1000, message = "Note cannot exceed 1000 characters")
    private String note;

    @PastOrPresent(message = "Created date cannot be in the future")
    private LocalDateTime createdAt;

    @PastOrPresent(message = "Updated date cannot be in the future")
    private LocalDateTime updatedAt;
}