package com.firefly.core.lending.renting.core.services.records.v1;

import com.firefly.core.lending.renting.core.mappers.records.v1.RentingReturnRecordMapper;
import com.firefly.core.lending.renting.interfaces.dtos.records.v1.RentingReturnRecordDTO;
import com.firefly.core.lending.renting.models.repositories.records.v1.RentingReturnRecordRepository;
import com.firefly.core.lending.renting.models.entities.records.v1.RentingReturnRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@Transactional
public class RentingReturnRecordServiceImpl implements RentingReturnRecordService {

    @Autowired
    private RentingReturnRecordRepository repository;

    @Autowired
    private RentingReturnRecordMapper mapper;

    @Override
    public Mono<RentingReturnRecordDTO> getByAsset(UUID rentingAgreementId, UUID rentingAssetId) {
        return repository.findByRentingAssetId(rentingAssetId)
                .map(mapper::toDTO);
    }

    @Override
    public Mono<RentingReturnRecordDTO> create(UUID rentingAgreementId, UUID rentingAssetId, RentingReturnRecordDTO dto) {
        RentingReturnRecord entity = mapper.toEntity(dto);
        entity.setRentingAssetId(rentingAssetId);
        return repository.save(entity)
                .map(mapper::toDTO);
    }

    @Override
    public Mono<RentingReturnRecordDTO> update(UUID rentingAgreementId, UUID rentingAssetId, RentingReturnRecordDTO dto) {
        return repository.findByRentingAssetId(rentingAssetId)
                .flatMap(existing -> {
                    RentingReturnRecord updatedEntity = mapper.toEntity(dto);
                    updatedEntity.setRentingReturnRecordId(existing.getRentingReturnRecordId());
                    return repository.save(updatedEntity);
                })
                .map(mapper::toDTO);
    }

    @Override
    public Mono<Void> delete(UUID rentingAgreementId, UUID rentingAssetId) {
        return repository.deleteByRentingAssetId(rentingAssetId);
    }
}