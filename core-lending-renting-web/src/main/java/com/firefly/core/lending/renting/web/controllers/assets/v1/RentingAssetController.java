package com.firefly.core.lending.renting.web.controllers.assets.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.lending.renting.core.services.assets.v1.RentingAssetService;
import com.firefly.core.lending.renting.interfaces.dtos.assets.v1.RentingAssetDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/renting-agreements/{rentingAgreementId}/assets")
@Tag(name = "RentingAsset", description = "Operations on rented assets under a renting agreement")
@RequiredArgsConstructor
public class RentingAssetController {

    private final RentingAssetService service;

    @GetMapping
    @Operation(summary = "List or search assets for a renting agreement")
    public Mono<ResponseEntity<PaginationResponse<RentingAssetDTO>>> findAll(
            @PathVariable UUID rentingAgreementId,
            @ModelAttribute FilterRequest<RentingAssetDTO> filterRequest) {

        return service.findAll(rentingAgreementId, filterRequest)
                .map(ResponseEntity::ok);
    }

    @PostMapping
    @Operation(summary = "Create a new asset record under a renting agreement")
    public Mono<ResponseEntity<RentingAssetDTO>> create(
            @PathVariable UUID rentingAgreementId,
            @RequestBody RentingAssetDTO dto) {

        return service.create(rentingAgreementId, dto)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/{rentingAssetId}")
    @Operation(summary = "Get an asset by ID")
    public Mono<ResponseEntity<RentingAssetDTO>> getById(
            @PathVariable UUID rentingAgreementId,
            @PathVariable UUID rentingAssetId) {

        return service.getById(rentingAgreementId, rentingAssetId)
                .map(ResponseEntity::ok);
    }

    @PutMapping("/{rentingAssetId}")
    @Operation(summary = "Update an asset record")
    public Mono<ResponseEntity<RentingAssetDTO>> update(
            @PathVariable UUID rentingAgreementId,
            @PathVariable UUID rentingAssetId,
            @RequestBody RentingAssetDTO dto) {

        return service.update(rentingAgreementId, rentingAssetId, dto)
                .map(ResponseEntity::ok);
    }

    @DeleteMapping("/{rentingAssetId}")
    @Operation(summary = "Delete an asset record")
    public Mono<ResponseEntity<Void>> delete(
            @PathVariable UUID rentingAgreementId,
            @PathVariable UUID rentingAssetId) {

        return service.delete(rentingAgreementId, rentingAssetId)
                .thenReturn(ResponseEntity.noContent().build());
    }
}