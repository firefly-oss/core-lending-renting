package com.firefly.core.lending.renting.core.mappers.records.v1;

import com.firefly.core.lending.renting.interfaces.dtos.records.v1.RentingReturnRecordDTO;
import com.firefly.core.lending.renting.models.entities.records.v1.RentingReturnRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentingReturnRecordMapper {
    RentingReturnRecordDTO toDTO(RentingReturnRecord entity);
    RentingReturnRecord toEntity(RentingReturnRecordDTO dto);
}
