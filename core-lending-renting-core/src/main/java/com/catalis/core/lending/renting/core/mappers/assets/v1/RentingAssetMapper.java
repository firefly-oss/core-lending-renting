package com.catalis.core.lending.renting.core.mappers.assets.v1;

import com.catalis.core.lending.renting.interfaces.dtos.assets.v1.RentingAssetDTO;
import com.catalis.core.lending.renting.models.entities.assets.v1.RentingAsset;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentingAssetMapper {
    RentingAssetDTO toDTO(RentingAsset entity);
    RentingAsset toEntity(RentingAssetDTO dto);
}
