package com.catalis.core.lending.renting.interfaces.dtos.schedule.v1;

 import com.catalis.core.utils.annotations.FilterableId;
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
public class RentingBillingScheduleDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long rentingBillingScheduleId;

    @FilterableId
    private Long rentingAgreementId;

    private Integer installmentNumber;
    private LocalDate dueDate;
    private BigDecimal rentAmount;
    private BigDecimal serviceFee;
    private BigDecimal totalDue;
    private Boolean isPaid;
    private LocalDate paidDate;
    private String note;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}