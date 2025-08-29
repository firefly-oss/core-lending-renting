package com.firefly.core.lending.renting.core.services.schedule.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.filters.FilterUtils;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.lending.renting.core.mappers.schedule.v1.RentingBillingScheduleMapper;
import com.firefly.core.lending.renting.interfaces.dtos.schedule.v1.RentingBillingScheduleDTO;
import com.firefly.core.lending.renting.models.entities.schedule.v1.RentingBillingSchedule;
import com.firefly.core.lending.renting.models.repositories.schedule.v1.RentingBillingScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class RentingBillingScheduleServiceImpl implements RentingBillingScheduleService {

    @Autowired
    private RentingBillingScheduleRepository repository;

    @Autowired
    private RentingBillingScheduleMapper mapper;

    @Override
    public Mono<PaginationResponse<RentingBillingScheduleDTO>> findAll(Long rentingAgreementId, FilterRequest<RentingBillingScheduleDTO> filterRequest) {
        filterRequest.getFilters().setRentingAgreementId(rentingAgreementId);
        return FilterUtils.createFilter(
                RentingBillingSchedule.class,
                mapper::toDTO
        ).filter(filterRequest);
    }

    @Override
    public Mono<RentingBillingScheduleDTO> create(Long rentingAgreementId, RentingBillingScheduleDTO dto) {
        dto.setRentingAgreementId(rentingAgreementId);
        RentingBillingSchedule entity = mapper.toEntity(dto);
        return repository.save(entity)
                .map(mapper::toDTO);
    }

    @Override
    public Mono<RentingBillingScheduleDTO> getById(Long rentingAgreementId, Long rentingBillingScheduleId) {
        return repository.findById(rentingBillingScheduleId)
                .filter(entity -> entity.getRentingAgreementId().equals(rentingAgreementId))
                .map(mapper::toDTO);
    }

    @Override
    public Mono<RentingBillingScheduleDTO> update(Long rentingAgreementId, Long rentingBillingScheduleId, RentingBillingScheduleDTO dto) {
        return repository.findById(rentingBillingScheduleId)
                .filter(entity -> entity.getRentingAgreementId().equals(rentingAgreementId))
                .flatMap(existingEntity -> {
                    RentingBillingSchedule updatedEntity = mapper.toEntity(dto);
                    updatedEntity.setRentingBillingScheduleId(rentingBillingScheduleId);
                    updatedEntity.setRentingAgreementId(rentingAgreementId);
                    return repository.save(updatedEntity);
                })
                .map(mapper::toDTO);
    }

    @Override
    public Mono<Void> delete(Long rentingAgreementId, Long rentingBillingScheduleId) {
        return repository.findById(rentingBillingScheduleId)
                .filter(entity -> entity.getRentingAgreementId().equals(rentingAgreementId))
                .flatMap(repository::delete);
    }
}
