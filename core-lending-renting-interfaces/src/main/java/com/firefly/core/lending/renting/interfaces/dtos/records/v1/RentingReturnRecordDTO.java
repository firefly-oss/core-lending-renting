package com.firefly.core.lending.renting.interfaces.dtos.records.v1;

import com.firefly.annotations.ValidAmount;
import com.firefly.annotations.ValidDate;
import com.firefly.core.utils.annotations.FilterableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
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
public class RentingReturnRecordDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID rentingReturnRecordId;

    @NotNull(message = "Renting asset ID is required")
    @FilterableId
    private UUID rentingAssetId;

    @NotNull(message = "Actual return date is required")
    @ValidDate(message = "Actual return date must be a valid date")
    private LocalDate actualReturnDate;

    @NotBlank(message = "Condition report is required")
    @Size(max = 2000, message = "Condition report cannot exceed 2000 characters")
    private String conditionReport;

    @PositiveOrZero(message = "Damage cost must be zero or positive")
    @ValidAmount(message = "Damage cost must be a valid amount")
    private BigDecimal damageCost;

    private Boolean isFinalized;

    @Size(max = 1000, message = "Note cannot exceed 1000 characters")
    private String note;

    @PastOrPresent(message = "Created date cannot be in the future")
    private LocalDateTime createdAt;

    @PastOrPresent(message = "Updated date cannot be in the future")
    private LocalDateTime updatedAt;
}

