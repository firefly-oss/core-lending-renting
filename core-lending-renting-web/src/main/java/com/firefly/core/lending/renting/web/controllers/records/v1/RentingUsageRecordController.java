package com.firefly.core.lending.renting.web.controllers.records.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.lending.renting.core.services.records.v1.RentingUsageRecordService;
import com.firefly.core.lending.renting.interfaces.dtos.records.v1.RentingUsageRecordDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/renting-agreements/{rentingAgreementId}/assets/{rentingAssetId}/usage-records")
@Tag(name = "RentingUsageRecord", description = "Usage logs (mileage/hours) for a rented asset")
@RequiredArgsConstructor
public class RentingUsageRecordController {

    private final RentingUsageRecordService service;

    @GetMapping
    @Operation(summary = "List or search usage records for a given asset")
    public Mono<ResponseEntity<PaginationResponse<RentingUsageRecordDTO>>> findAll(
            @PathVariable UUID rentingAgreementId,
            @PathVariable UUID rentingAssetId,
            @ModelAttribute FilterRequest<RentingUsageRecordDTO> filterRequest) {

        return service.findAll(rentingAgreementId, rentingAssetId, filterRequest)
                .map(ResponseEntity::ok);
    }

    @PostMapping
    @Operation(summary = "Create a new usage record")
    public Mono<ResponseEntity<RentingUsageRecordDTO>> create(
            @PathVariable UUID rentingAgreementId,
            @PathVariable UUID rentingAssetId,
            @RequestBody RentingUsageRecordDTO dto) {

        return service.create(rentingAgreementId, rentingAssetId, dto)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/{rentingUsageRecordId}")
    @Operation(summary = "Get a usage record by ID")
    public Mono<ResponseEntity<RentingUsageRecordDTO>> getById(
            @PathVariable UUID rentingAgreementId,
            @PathVariable UUID rentingAssetId,
            @PathVariable UUID rentingUsageRecordId) {

        return service.getById(rentingAgreementId, rentingAssetId, rentingUsageRecordId)
                .map(ResponseEntity::ok);
    }

    @PutMapping("/{rentingUsageRecordId}")
    @Operation(summary = "Update a usage record")
    public Mono<ResponseEntity<RentingUsageRecordDTO>> update(
            @PathVariable UUID rentingAgreementId,
            @PathVariable UUID rentingAssetId,
            @PathVariable UUID rentingUsageRecordId,
            @RequestBody RentingUsageRecordDTO dto) {

        return service.update(rentingAgreementId, rentingAssetId, rentingUsageRecordId, dto)
                .map(ResponseEntity::ok);
    }

    @DeleteMapping("/{rentingUsageRecordId}")
    @Operation(summary = "Delete a usage record")
    public Mono<ResponseEntity<Void>> delete(
            @PathVariable UUID rentingAgreementId,
            @PathVariable UUID rentingAssetId,
            @PathVariable UUID rentingUsageRecordId) {

        return service.delete(rentingAgreementId, rentingAssetId, rentingUsageRecordId)
                .thenReturn(ResponseEntity.noContent().build());
    }
}
