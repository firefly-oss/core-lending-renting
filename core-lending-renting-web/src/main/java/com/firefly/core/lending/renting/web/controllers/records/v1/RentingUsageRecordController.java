/*
 * Copyright 2025 Firefly Software Solutions Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


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
