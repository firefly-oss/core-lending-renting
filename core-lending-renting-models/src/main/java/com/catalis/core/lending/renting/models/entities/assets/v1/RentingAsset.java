package com.catalis.core.lending.renting.models.entities.assets.v1;

import com.catalis.core.lending.renting.interfaces.enums.assets.v1.AssetTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("renting_asset")
public class RentingAsset {

    @Id
    @Column("renting_asset_id")
    private Long rentingAssetId;

    @Column("renting_agreement_id")
    private Long rentingAgreementId;

    @Column("asset_type")
    private AssetTypeEnum assetType;

    @Column("asset_description")
    private String assetDescription;

    @Column("asset_serial_number")
    private String assetSerialNumber;

    @Column("asset_value")
    private BigDecimal assetValue;

    @Column("is_active")
    private Boolean isActive;

    @Column("note")
    private String note;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;
}