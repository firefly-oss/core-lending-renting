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

@Service
@Transactional
public class RentingAssetServiceImpl implements RentingAssetService {

    @Autowired
    private RentingAssetRepository repository;

    @Autowired
    private RentingAssetMapper mapper;

    @Override
    public Mono<PaginationResponse<RentingAssetDTO>> findAll(Long rentingAgreementId, FilterRequest<RentingAssetDTO> filterRequest) {
        filterRequest.getFilters().setRentingAgreementId(rentingAgreementId);
        return FilterUtils.createFilter(
                RentingAsset.class,
                mapper::toDTO
        ).filter(filterRequest);
    }

    @Override
    public Mono<RentingAssetDTO> create(Long rentingAgreementId, RentingAssetDTO dto) {
        dto.setRentingAgreementId(rentingAgreementId);
        RentingAsset entity = mapper.toEntity(dto);
        entity.setRentingAssetId(null);
        return Mono.just(entity)
                .flatMap(repository::save)
                .map(mapper::toDTO);
    }

    @Override
    public Mono<RentingAssetDTO> getById(Long rentingAgreementId, Long rentingAssetId) {
        return repository.findById(rentingAssetId)
                .filter(asset -> rentingAgreementId.equals(asset.getRentingAgreementId()))
                .map(mapper::toDTO);
    }

    @Override
    public Mono<RentingAssetDTO> update(Long rentingAgreementId, Long rentingAssetId, RentingAssetDTO dto) {
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
    public Mono<Void> delete(Long rentingAgreementId, Long rentingAssetId) {
        return repository.findById(rentingAssetId)
                .filter(asset -> rentingAgreementId.equals(asset.getRentingAgreementId()))
                .flatMap(repository::delete);
    }
}
