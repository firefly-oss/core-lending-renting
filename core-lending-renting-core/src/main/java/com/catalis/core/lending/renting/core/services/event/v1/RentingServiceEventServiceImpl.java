package com.catalis.core.lending.renting.core.services.event.v1;

import com.catalis.common.core.filters.FilterRequest;
import com.catalis.common.core.filters.FilterUtils;
import com.catalis.common.core.queries.PaginationResponse;
import com.catalis.core.lending.renting.core.mappers.event.v1.RentingServiceEventMapper;
import com.catalis.core.lending.renting.interfaces.dtos.event.v1.RentingServiceEventDTO;
import com.catalis.core.lending.renting.models.entities.event.v1.RentingServiceEvent;
import com.catalis.core.lending.renting.models.repositories.event.v1.RentingServiceEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class RentingServiceEventServiceImpl implements RentingServiceEventService {

    @Autowired
    private RentingServiceEventRepository repository;

    @Autowired
    private RentingServiceEventMapper mapper;

    @Override
    public Mono<PaginationResponse<RentingServiceEventDTO>> findAll(Long rentingAgreementId, Long rentingAssetId, FilterRequest<RentingServiceEventDTO> filterRequest) {
        filterRequest.getFilters().setRentingAssetId(rentingAssetId);
        return FilterUtils.createFilter(
                RentingServiceEvent.class,
                mapper::toDTO
        ).filter(filterRequest);
    }

    @Override
    public Mono<RentingServiceEventDTO> create(Long rentingAgreementId, Long rentingAssetId, RentingServiceEventDTO dto) {
        RentingServiceEvent entity = mapper.toEntity(dto);
        entity.setRentingAssetId(rentingAssetId);
        return repository.save(entity)
                .map(mapper::toDTO);
    }

    @Override
    public Mono<RentingServiceEventDTO> getById(Long rentingAgreementId, Long rentingAssetId, Long rentingServiceEventId) {
        return repository.findById(rentingServiceEventId)
                .filter(event -> event.getRentingAssetId().equals(rentingAssetId))
                .map(mapper::toDTO);
    }

    @Override
    public Mono<RentingServiceEventDTO> update(Long rentingAgreementId, Long rentingAssetId, Long rentingServiceEventId, RentingServiceEventDTO dto) {
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
    public Mono<Void> delete(Long rentingAgreementId, Long rentingAssetId, Long rentingServiceEventId) {
        return repository.findById(rentingServiceEventId)
                .filter(event -> event.getRentingAssetId().equals(rentingAssetId))
                .flatMap(repository::delete);
    }
}