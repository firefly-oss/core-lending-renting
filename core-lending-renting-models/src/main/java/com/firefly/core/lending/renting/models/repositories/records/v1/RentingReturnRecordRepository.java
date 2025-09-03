package com.firefly.core.lending.renting.models.repositories.records.v1;

import com.firefly.core.lending.renting.models.entities.records.v1.RentingReturnRecord;
import com.firefly.core.lending.renting.models.repositories.BaseRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface RentingReturnRecordRepository extends BaseRepository<RentingReturnRecord, UUID> {
    Mono<RentingReturnRecord> findByRentingAssetId(UUID rentingAssetId);
    Mono<Void> deleteByRentingAssetId(UUID rentingAssetId);
}
