package com.firefly.core.lending.renting.interfaces.dtos.records.v1;

import com.firefly.core.utils.annotations.FilterableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentingUsageRecordDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long rentingUsageRecordId;

    @FilterableId
    private Long rentingAssetId;

    private LocalDate usageDate;
    private Integer mileage;    // or usage hours
    private String usageDetail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}