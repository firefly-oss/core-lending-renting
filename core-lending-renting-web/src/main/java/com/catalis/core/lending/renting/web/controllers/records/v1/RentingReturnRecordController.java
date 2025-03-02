package com.catalis.core.lending.renting.web.controllers.records.v1;

import com.catalis.core.lending.renting.core.services.records.v1.RentingReturnRecordService;
import com.catalis.core.lending.renting.interfaces.dtos.records.v1.RentingReturnRecordDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/renting-agreements/{rentingAgreementId}/assets/{rentingAssetId}/return-record")
@Tag(name = "RentingReturnRecord", description = "Tracks the final return details of a rented asset.")
@RequiredArgsConstructor
public class RentingReturnRecordController {

    private final RentingReturnRecordService service;

    @GetMapping
    @Operation(summary = "Get the return record of an asset (if any)")
    public Mono<ResponseEntity<RentingReturnRecordDTO>> getByAsset(
            @PathVariable Long rentingAgreementId,
            @PathVariable Long rentingAssetId) {

        return service.getByAsset(rentingAgreementId, rentingAssetId)
                .map(ResponseEntity::ok);
    }

    @PostMapping
    @Operation(summary = "Create a return record (once the asset is returned)")
    public Mono<ResponseEntity<RentingReturnRecordDTO>> create(
            @PathVariable Long rentingAgreementId,
            @PathVariable Long rentingAssetId,
            @RequestBody RentingReturnRecordDTO dto) {

        return service.create(rentingAgreementId, rentingAssetId, dto)
                .map(ResponseEntity::ok);
    }

    @PutMapping
    @Operation(summary = "Update the return record (e.g., if damageCost changes)")
    public Mono<ResponseEntity<RentingReturnRecordDTO>> update(
            @PathVariable Long rentingAgreementId,
            @PathVariable Long rentingAssetId,
            @RequestBody RentingReturnRecordDTO dto) {

        return service.update(rentingAgreementId, rentingAssetId, dto)
                .map(ResponseEntity::ok);
    }

    @DeleteMapping
    @Operation(summary = "Delete the return record for an asset")
    public Mono<ResponseEntity<Void>> delete(
            @PathVariable Long rentingAgreementId,
            @PathVariable Long rentingAssetId) {

        return service.delete(rentingAgreementId, rentingAssetId)
                .thenReturn(ResponseEntity.noContent().build());
    }
}