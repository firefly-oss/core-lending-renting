package com.firefly.core.lending.renting.interfaces.dtos.records.v1;

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
public class RentingReturnRecordDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long rentingReturnRecordId;

    @FilterableId
    private Long rentingAssetId;

    private LocalDate actualReturnDate;
    private String conditionReport;
    private BigDecimal damageCost;
    private Boolean isFinalized;
    private String note;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

