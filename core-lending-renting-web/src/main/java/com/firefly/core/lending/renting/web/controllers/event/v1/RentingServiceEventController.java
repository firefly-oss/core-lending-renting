package com.firefly.core.lending.renting.web.controllers.event.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.lending.renting.core.services.event.v1.RentingServiceEventService;
import com.firefly.core.lending.renting.interfaces.dtos.event.v1.RentingServiceEventDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/renting-agreements/{rentingAgreementId}/assets/{rentingAssetId}/service-events")
@Tag(name = "RentingServiceEvent", description = "Maintenance/repair service events for a rented asset")
@RequiredArgsConstructor
public class RentingServiceEventController {

    private final RentingServiceEventService service;

    @GetMapping
    @Operation(summary = "List or search service events for an asset")
    public Mono<ResponseEntity<PaginationResponse<RentingServiceEventDTO>>> findAll(
            @PathVariable Long rentingAgreementId,
            @PathVariable Long rentingAssetId,
            @ModelAttribute FilterRequest<RentingServiceEventDTO> filterRequest) {

        return service.findAll(rentingAgreementId, rentingAssetId, filterRequest)
                .map(ResponseEntity::ok);
    }

    @PostMapping
    @Operation(summary = "Create a new service event record")
    public Mono<ResponseEntity<RentingServiceEventDTO>> create(
            @PathVariable Long rentingAgreementId,
            @PathVariable Long rentingAssetId,
            @RequestBody RentingServiceEventDTO dto) {

        return service.create(rentingAgreementId, rentingAssetId, dto)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/{rentingServiceEventId}")
    @Operation(summary = "Get a service event by ID")
    public Mono<ResponseEntity<RentingServiceEventDTO>> getById(
            @PathVariable Long rentingAgreementId,
            @PathVariable Long rentingAssetId,
            @PathVariable Long rentingServiceEventId) {

        return service.getById(rentingAgreementId, rentingAssetId, rentingServiceEventId)
                .map(ResponseEntity::ok);
    }

    @PutMapping("/{rentingServiceEventId}")
    @Operation(summary = "Update a service event record")
    public Mono<ResponseEntity<RentingServiceEventDTO>> update(
            @PathVariable Long rentingAgreementId,
            @PathVariable Long rentingAssetId,
            @PathVariable Long rentingServiceEventId,
            @RequestBody RentingServiceEventDTO dto) {

        return service.update(rentingAgreementId, rentingAssetId, rentingServiceEventId, dto)
                .map(ResponseEntity::ok);
    }

    @DeleteMapping("/{rentingServiceEventId}")
    @Operation(summary = "Delete a service event record")
    public Mono<ResponseEntity<Void>> delete(
            @PathVariable Long rentingAgreementId,
            @PathVariable Long rentingAssetId,
            @PathVariable Long rentingServiceEventId) {

        return service.delete(rentingAgreementId, rentingAssetId, rentingServiceEventId)
                .thenReturn(ResponseEntity.noContent().build());
    }
}