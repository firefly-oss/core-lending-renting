package com.firefly.core.lending.renting.core.mappers.schedule.v1;

import com.firefly.core.lending.renting.interfaces.dtos.schedule.v1.RentingBillingScheduleDTO;
import com.firefly.core.lending.renting.models.entities.schedule.v1.RentingBillingSchedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentingBillingScheduleMapper {
    RentingBillingScheduleDTO toDTO(RentingBillingSchedule entity);
    RentingBillingSchedule toEntity(RentingBillingScheduleDTO dto);
}
