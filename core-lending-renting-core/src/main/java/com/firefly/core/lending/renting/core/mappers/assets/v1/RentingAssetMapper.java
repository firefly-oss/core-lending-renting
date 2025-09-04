/*
 * Copyright 2025 Firefly Software Solutions Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.firefly.core.lending.renting.core.mappers.assets.v1;

import com.firefly.core.lending.renting.interfaces.dtos.assets.v1.RentingAssetDTO;
import com.firefly.core.lending.renting.models.entities.assets.v1.RentingAsset;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentingAssetMapper {
    RentingAssetDTO toDTO(RentingAsset entity);
    RentingAsset toEntity(RentingAssetDTO dto);
}
