package com.firefly.core.lending.renting.models.entities.event.v1;

import com.firefly.core.lending.renting.interfaces.enums.event.v1.EventTypeEnum;
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
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("renting_service_event")
public class RentingServiceEvent {

    @Id
    @Column("renting_service_event_id")
    private UUID rentingServiceEventId;

    @Column("renting_asset_id")
    private UUID rentingAssetId;

    @Column("event_date")
    private LocalDate eventDate;

    @Column("event_type")
    private EventTypeEnum eventType;

    @Column("cost")
    private BigDecimal cost;

    @Column("note")
    private String note;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;
}