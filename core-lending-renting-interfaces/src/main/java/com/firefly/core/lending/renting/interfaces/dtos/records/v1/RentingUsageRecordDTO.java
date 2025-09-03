package com.firefly.core.lending.renting.interfaces.dtos.records.v1;

import com.firefly.annotations.ValidDate;
import com.firefly.core.utils.annotations.FilterableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentingUsageRecordDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID rentingUsageRecordId;

    @NotNull(message = "Renting asset ID is required")
    @FilterableId
    private UUID rentingAssetId;

    @NotNull(message = "Usage date is required")
    @ValidDate(message = "Usage date must be a valid date")
    private LocalDate usageDate;

    @Min(value = 0, message = "Mileage must be zero or positive")
    private Integer mileage;    // or usage hours

    @Size(max = 1000, message = "Usage detail cannot exceed 1000 characters")
    private String usageDetail;

    @PastOrPresent(message = "Created date cannot be in the future")
    private LocalDateTime createdAt;

    @PastOrPresent(message = "Updated date cannot be in the future")
    private LocalDateTime updatedAt;
}