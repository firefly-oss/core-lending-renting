package com.catalis.core.lending.renting.models.entities.records.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("renting_return_record")
public class RentingReturnRecord {

    @Id
    @Column("renting_return_record_id")
    private Long rentingReturnRecordId;

    @Column("renting_asset_id")
    private Long rentingAssetId;

    @Column("actual_return_date")
    private LocalDate actualReturnDate;

    @Column("condition_report")
    private String conditionReport;

    @Column("damage_cost")
    private BigDecimal damageCost;

    @Column("is_finalized")
    private Boolean isFinalized;

    @Column("note")
    private String note;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;
}