package com.catalis.core.lending.renting.models.repositories.records.v1;

import com.catalis.core.lending.renting.models.entities.records.v1.RentingReturnRecord;
import com.catalis.core.lending.renting.models.repositories.BaseRepository;
import reactor.core.publisher.Mono;

public interface RentingReturnRecordRepository extends BaseRepository<RentingReturnRecord, Long> {
    Mono<RentingReturnRecord> findByRentingAssetId(Long rentingAssetId);
    Mono<Void> deleteByRentingAssetId(Long rentingAssetId);
}
