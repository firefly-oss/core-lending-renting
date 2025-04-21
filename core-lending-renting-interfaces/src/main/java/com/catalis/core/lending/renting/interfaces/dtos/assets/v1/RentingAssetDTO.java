package com.catalis.core.lending.renting.interfaces.dtos.assets.v1;

import com.catalis.core.lending.renting.interfaces.enums.assets.v1.AssetTypeEnum;
import com.catalis.core.utils.annotations.FilterableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentingAssetDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long rentingAssetId;

    @FilterableId
    private Long rentingAgreementId;

    private AssetTypeEnum assetType;
    private String assetDescription;
    private String assetSerialNumber;
    private BigDecimal assetValue;
    private Boolean isActive;
    private String note;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}