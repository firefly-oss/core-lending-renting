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


package com.firefly.core.lending.renting.core.services.agreement.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.filters.FilterUtils;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.lending.renting.core.mappers.agreement.v1.RentingAgreementMapper;
import com.firefly.core.lending.renting.interfaces.dtos.agreement.v1.RentingAgreementDTO;
import com.firefly.core.lending.renting.models.entities.agreement.v1.RentingAgreement;
import com.firefly.core.lending.renting.models.repositories.agreement.v1.RentingAgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@Transactional
public class RentingAgreementServiceImpl implements RentingAgreementService {

    @Autowired
    private RentingAgreementRepository repository;

    @Autowired
    private RentingAgreementMapper mapper;

    @Override
    public Mono<PaginationResponse<RentingAgreementDTO>> findAll(FilterRequest<RentingAgreementDTO> filterRequest) {
        return FilterUtils.createFilter(
                RentingAgreement.class,
                mapper::toDTO
        ).filter(filterRequest);
    }

    @Override
    public Mono<RentingAgreementDTO> create(RentingAgreementDTO dto) {
        return Mono.just(dto)
                .map(mapper::toEntity)
                .flatMap(repository::save)
                .map(mapper::toDTO);
    }

    @Override
    public Mono<RentingAgreementDTO> getById(UUID rentingAgreementId) {
        return repository.findById(rentingAgreementId)
                .map(mapper::toDTO);
    }

    @Override
    public Mono<RentingAgreementDTO> update(UUID rentingAgreementId, RentingAgreementDTO dto) {
        return repository.findById(rentingAgreementId)
                .flatMap(existingAgreement -> {
                    RentingAgreement updatedEntity = mapper.toEntity(dto);
                    updatedEntity.setRentingAgreementId(existingAgreement.getRentingAgreementId());
                    return repository.save(updatedEntity);
                })
                .map(mapper::toDTO);
    }

    @Override
    public Mono<Void> delete(UUID rentingAgreementId) {
        return repository.findById(rentingAgreementId)
                .flatMap(repository::delete);
    }
}
