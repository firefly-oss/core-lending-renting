package com.catalis.core.lending.renting.core.mappers.records.v1;

import com.catalis.core.lending.renting.interfaces.dtos.records.v1.RentingUsageRecordDTO;
import com.catalis.core.lending.renting.models.entities.records.v1.RentingUsageRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentingUsageRecordMapper {
    RentingUsageRecordDTO toDTO(RentingUsageRecord entity);
    RentingUsageRecord toEntity(RentingUsageRecordDTO dto);
}