package com.firefly.core.lending.renting.web.controllers.schedule.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.lending.renting.core.services.schedule.v1.RentingBillingScheduleService;
import com.firefly.core.lending.renting.interfaces.dtos.schedule.v1.RentingBillingScheduleDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/renting-agreements/{rentingAgreementId}/billing-schedules")
@Tag(name = "RentingBillingSchedule", description = "Billing installment schedules for a renting agreement")
@RequiredArgsConstructor
public class RentingBillingScheduleController {

    private final RentingBillingScheduleService service;

    @GetMapping
    @Operation(summary = "List or search billing schedule entries for a renting agreement")
    public Mono<ResponseEntity<PaginationResponse<RentingBillingScheduleDTO>>> findAll(
            @PathVariable Long rentingAgreementId,
            @ModelAttribute FilterRequest<RentingBillingScheduleDTO> filterRequest) {

        return service.findAll(rentingAgreementId, filterRequest)
                .map(ResponseEntity::ok);
    }

    @PostMapping
    @Operation(summary = "Create a new billing schedule entry")
    public Mono<ResponseEntity<RentingBillingScheduleDTO>> create(
            @PathVariable Long rentingAgreementId,
            @RequestBody RentingBillingScheduleDTO dto) {

        return service.create(rentingAgreementId, dto)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/{rentingBillingScheduleId}")
    @Operation(summary = "Get a billing schedule entry by ID")
    public Mono<ResponseEntity<RentingBillingScheduleDTO>> getById(
            @PathVariable Long rentingAgreementId,
            @PathVariable Long rentingBillingScheduleId) {

        return service.getById(rentingAgreementId, rentingBillingScheduleId)
                .map(ResponseEntity::ok);
    }

    @PutMapping("/{rentingBillingScheduleId}")
    @Operation(summary = "Update a billing schedule entry")
    public Mono<ResponseEntity<RentingBillingScheduleDTO>> update(
            @PathVariable Long rentingAgreementId,
            @PathVariable Long rentingBillingScheduleId,
            @RequestBody RentingBillingScheduleDTO dto) {

        return service.update(rentingAgreementId, rentingBillingScheduleId, dto)
                .map(ResponseEntity::ok);
    }

    @DeleteMapping("/{rentingBillingScheduleId}")
    @Operation(summary = "Delete a billing schedule entry")
    public Mono<ResponseEntity<Void>> delete(
            @PathVariable Long rentingAgreementId,
            @PathVariable Long rentingBillingScheduleId) {

        return service.delete(rentingAgreementId, rentingBillingScheduleId)
                .thenReturn(ResponseEntity.noContent().build());
    }
}