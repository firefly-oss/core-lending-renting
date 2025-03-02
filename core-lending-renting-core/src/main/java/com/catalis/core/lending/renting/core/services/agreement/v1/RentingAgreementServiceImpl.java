package com.catalis.core.lending.renting.core.services.agreement.v1;

import com.catalis.common.core.filters.FilterRequest;
import com.catalis.common.core.filters.FilterUtils;
import com.catalis.common.core.queries.PaginationResponse;
import com.catalis.core.lending.renting.core.mappers.agreement.v1.RentingAgreementMapper;
import com.catalis.core.lending.renting.interfaces.dtos.agreement.v1.RentingAgreementDTO;
import com.catalis.core.lending.renting.models.entities.agreement.v1.RentingAgreement;
import com.catalis.core.lending.renting.models.repositories.agreement.v1.RentingAgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

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
    public Mono<RentingAgreementDTO> getById(Long rentingAgreementId) {
        return repository.findById(rentingAgreementId)
                .map(mapper::toDTO);
    }

    @Override
    public Mono<RentingAgreementDTO> update(Long rentingAgreementId, RentingAgreementDTO dto) {
        return repository.findById(rentingAgreementId)
                .flatMap(existingAgreement -> {
                    RentingAgreement updatedEntity = mapper.toEntity(dto);
                    updatedEntity.setRentingAgreementId(existingAgreement.getRentingAgreementId());
                    return repository.save(updatedEntity);
                })
                .map(mapper::toDTO);
    }

    @Override
    public Mono<Void> delete(Long rentingAgreementId) {
        return repository.findById(rentingAgreementId)
                .flatMap(repository::delete);
    }
}
