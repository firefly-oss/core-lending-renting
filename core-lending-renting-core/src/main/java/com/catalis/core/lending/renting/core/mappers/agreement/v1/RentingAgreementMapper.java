package com.catalis.core.lending.renting.core.mappers.agreement.v1;

import com.catalis.core.lending.renting.interfaces.dtos.agreement.v1.RentingAgreementDTO;
import com.catalis.core.lending.renting.models.entities.agreement.v1.RentingAgreement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentingAgreementMapper {
    RentingAgreementDTO toDTO(RentingAgreement entity);
    RentingAgreement toEntity(RentingAgreementDTO dto);
}