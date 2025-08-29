package com.firefly.core.lending.renting.models.entities.records.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("renting_usage_record")
public class RentingUsageRecord {

    @Id
    @Column("renting_usage_record_id")
    private Long rentingUsageRecordId;

    @Column("renting_asset_id")
    private Long rentingAssetId;

    @Column("usage_date")
    private LocalDate usageDate;

    @Column("mileage")
    private Integer mileage;  // or hours if relevant

    @Column("usage_detail")
    private String usageDetail;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;
}