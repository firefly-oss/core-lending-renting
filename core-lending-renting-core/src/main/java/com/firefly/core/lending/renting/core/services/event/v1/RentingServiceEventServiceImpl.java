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


package com.firefly.core.lending.renting.core.services.event.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.filters.FilterUtils;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.lending.renting.core.mappers.event.v1.RentingServiceEventMapper;
import com.firefly.core.lending.renting.interfaces.dtos.event.v1.RentingServiceEventDTO;
import com.firefly.core.lending.renting.models.entities.event.v1.RentingServiceEvent;
import com.firefly.core.lending.renting.models.repositories.event.v1.RentingServiceEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@Transactional
public class RentingServiceEventServiceImpl implements RentingServiceEventService {

    @Autowired
    private RentingServiceEventRepository repository;

    @Autowired
    private RentingServiceEventMapper mapper;

    @Override
    public Mono<PaginationResponse<RentingServiceEventDTO>> findAll(UUID rentingAgreementId, UUID rentingAssetId, FilterRequest<RentingServiceEventDTO> filterRequest) {
        filterRequest.getFilters().setRentingAssetId(rentingAssetId);
        return FilterUtils.createFilter(
                RentingServiceEvent.class,
                mapper::toDTO
        ).filter(filterRequest);
    }

    @Override
    public Mono<RentingServiceEventDTO> create(UUID rentingAgreementId, UUID rentingAssetId, RentingServiceEventDTO dto) {
        RentingServiceEvent entity = mapper.toEntity(dto);
        entity.setRentingAssetId(rentingAssetId);
        return repository.save(entity)
                .map(mapper::toDTO);
    }

    @Override
    public Mono<RentingServiceEventDTO> getById(UUID rentingAgreementId, UUID rentingAssetId, UUID rentingServiceEventId) {
        return repository.findById(rentingServiceEventId)
                .filter(event -> event.getRentingAssetId().equals(rentingAssetId))
                .map(mapper::toDTO);
    }

    @Override
    public Mono<RentingServiceEventDTO> update(UUID rentingAgreementId, UUID rentingAssetId, UUID rentingServiceEventId, RentingServiceEventDTO dto) {
        return repository.findById(rentingServiceEventId)
                .filter(event -> event.getRentingAssetId().equals(rentingAssetId))
                .flatMap(existingEvent -> {
                    RentingServiceEvent updatedEvent = mapper.toEntity(dto);
                    updatedEvent.setRentingServiceEventId(rentingServiceEventId);
                    updatedEvent.setRentingAssetId(rentingAssetId);
                    return repository.save(updatedEvent);
                })
                .map(mapper::toDTO);
    }

    @Override
    public Mono<Void> delete(UUID rentingAgreementId, UUID rentingAssetId, UUID rentingServiceEventId) {
        return repository.findById(rentingServiceEventId)
                .filter(event -> event.getRentingAssetId().equals(rentingAssetId))
                .flatMap(repository::delete);
    }
}