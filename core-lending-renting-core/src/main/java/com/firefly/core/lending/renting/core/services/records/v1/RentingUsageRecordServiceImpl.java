package com.firefly.core.lending.renting.core.services.records.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.filters.FilterUtils;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.lending.renting.core.mappers.records.v1.RentingUsageRecordMapper;
import com.firefly.core.lending.renting.interfaces.dtos.records.v1.RentingUsageRecordDTO;
import com.firefly.core.lending.renting.models.entities.records.v1.RentingUsageRecord;
import com.firefly.core.lending.renting.models.repositories.records.v1.RentingUsageRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
public class RentingUsageRecordServiceImpl implements RentingUsageRecordService {

    @Autowired
    private RentingUsageRecordRepository repository;

    @Autowired
    private RentingUsageRecordMapper mapper;

    @Override
    public Mono<PaginationResponse<RentingUsageRecordDTO>> findAll(UUID rentingAgreementId, UUID rentingAssetId, FilterRequest<RentingUsageRecordDTO> filterRequest) {
        filterRequest.getFilters().setRentingAssetId(rentingAssetId);
        return FilterUtils.createFilter(
                RentingUsageRecord.class,
                mapper::toDTO
        ).filter(filterRequest);
    }

    @Override
    public Mono<RentingUsageRecordDTO> create(UUID rentingAgreementId, UUID rentingAssetId, RentingUsageRecordDTO dto) {
        RentingUsageRecord entity = mapper.toEntity(dto);
        entity.setRentingAssetId(rentingAssetId);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        return repository.save(entity)
                .map(mapper::toDTO);
    }

    @Override
    public Mono<RentingUsageRecordDTO> getById(UUID rentingAgreementId, UUID rentingAssetId, UUID rentingUsageRecordId) {
        return repository.findById(rentingUsageRecordId)
                .filter(record -> record.getRentingAssetId().equals(rentingAssetId))
                .map(mapper::toDTO);
    }

    @Override
    public Mono<RentingUsageRecordDTO> update(UUID rentingAgreementId, UUID rentingAssetId, UUID rentingUsageRecordId, RentingUsageRecordDTO dto) {
        return repository.findById(rentingUsageRecordId)
                .filter(record -> record.getRentingAssetId().equals(rentingAssetId))
                .flatMap(existingRecord -> {
                    RentingUsageRecord updatedEntity = mapper.toEntity(dto);
                    updatedEntity.setRentingUsageRecordId(existingRecord.getRentingUsageRecordId());
                    updatedEntity.setRentingAssetId(existingRecord.getRentingAssetId());
                    updatedEntity.setCreatedAt(existingRecord.getCreatedAt());
                    updatedEntity.setUpdatedAt(LocalDateTime.now());
                    return repository.save(updatedEntity);
                })
                .map(mapper::toDTO);
    }

    @Override
    public Mono<Void> delete(UUID rentingAgreementId, UUID rentingAssetId, UUID rentingUsageRecordId) {
        return repository.findById(rentingUsageRecordId)
                .filter(record -> record.getRentingAssetId().equals(rentingAssetId))
                .flatMap(repository::delete);
    }
}
