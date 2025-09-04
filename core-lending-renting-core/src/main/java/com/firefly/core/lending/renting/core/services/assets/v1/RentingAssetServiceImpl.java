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


package com.firefly.core.lending.renting.core.services.assets.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.filters.FilterUtils;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.lending.renting.core.mappers.assets.v1.RentingAssetMapper;
import com.firefly.core.lending.renting.interfaces.dtos.assets.v1.RentingAssetDTO;
import com.firefly.core.lending.renting.models.entities.assets.v1.RentingAsset;
import com.firefly.core.lending.renting.models.repositories.assets.v1.RentingAssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@Transactional
public class RentingAssetServiceImpl implements RentingAssetService {

    @Autowired
    private RentingAssetRepository repository;

    @Autowired
    private RentingAssetMapper mapper;

    @Override
    public Mono<PaginationResponse<RentingAssetDTO>> findAll(UUID rentingAgreementId, FilterRequest<RentingAssetDTO> filterRequest) {
        filterRequest.getFilters().setRentingAgreementId(rentingAgreementId);
        return FilterUtils.createFilter(
                RentingAsset.class,
                mapper::toDTO
        ).filter(filterRequest);
    }

    @Override
    public Mono<RentingAssetDTO> create(UUID rentingAgreementId, RentingAssetDTO dto) {
        dto.setRentingAgreementId(rentingAgreementId);
        RentingAsset entity = mapper.toEntity(dto);
        entity.setRentingAssetId(null);
        return Mono.just(entity)
                .flatMap(repository::save)
                .map(mapper::toDTO);
    }

    @Override
    public Mono<RentingAssetDTO> getById(UUID rentingAgreementId, UUID rentingAssetId) {
        return repository.findById(rentingAssetId)
                .filter(asset -> rentingAgreementId.equals(asset.getRentingAgreementId()))
                .map(mapper::toDTO);
    }

    @Override
    public Mono<RentingAssetDTO> update(UUID rentingAgreementId, UUID rentingAssetId, RentingAssetDTO dto) {
        return repository.findById(rentingAssetId)
                .filter(asset -> rentingAgreementId.equals(asset.getRentingAgreementId()))
                .flatMap(existingAsset -> {
                    RentingAsset updatedEntity = mapper.toEntity(dto);
                    updatedEntity.setRentingAssetId(rentingAssetId);
                    updatedEntity.setRentingAgreementId(rentingAgreementId);
                    return repository.save(updatedEntity);
                })
                .map(mapper::toDTO);
    }

    @Override
    public Mono<Void> delete(UUID rentingAgreementId, UUID rentingAssetId) {
        return repository.findById(rentingAssetId)
                .filter(asset -> rentingAgreementId.equals(asset.getRentingAgreementId()))
                .flatMap(repository::delete);
    }
}
