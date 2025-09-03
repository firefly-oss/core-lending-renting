package com.firefly.core.lending.renting.interfaces.dtos.assets.v1;

import com.firefly.annotations.ValidAmount;
import com.firefly.core.utils.annotations.FilterableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentingAssetDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID rentingAssetId;

    @NotNull(message = "Renting agreement ID is required")
    @FilterableId
    private UUID rentingAgreementId;

    @NotNull(message = "Asset type ID is required")
    @FilterableId
    private UUID assetTypeId;

    @NotBlank(message = "Asset description is required")
    @Size(max = 500, message = "Asset description cannot exceed 500 characters")
    private String assetDescription;

    @NotBlank(message = "Asset serial number is required")
    @Size(max = 100, message = "Asset serial number cannot exceed 100 characters")
    private String assetSerialNumber;

    @NotNull(message = "Asset value is required")
    @Positive(message = "Asset value must be positive")
    @ValidAmount(message = "Asset value must be a valid amount")
    private BigDecimal assetValue;

    private Boolean isActive;

    @Size(max = 1000, message = "Note cannot exceed 1000 characters")
    private String note;

    @PastOrPresent(message = "Created date cannot be in the future")
    private LocalDateTime createdAt;

    @PastOrPresent(message = "Updated date cannot be in the future")
    private LocalDateTime updatedAt;
}