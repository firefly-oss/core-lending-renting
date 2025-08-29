package com.firefly.core.lending.renting.core.mappers.event.v1;

import com.firefly.core.lending.renting.interfaces.dtos.event.v1.RentingServiceEventDTO;
import com.firefly.core.lending.renting.models.entities.event.v1.RentingServiceEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentingServiceEventMapper {
    RentingServiceEventDTO toDTO(RentingServiceEvent entity);
    RentingServiceEvent toEntity(RentingServiceEventDTO dto);
}
