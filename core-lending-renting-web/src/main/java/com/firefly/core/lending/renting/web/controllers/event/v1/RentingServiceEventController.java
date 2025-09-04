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

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/renting-agreements/{rentingAgreementId}/assets/{rentingAssetId}/service-events")
@Tag(name = "RentingServiceEvent", description = "Maintenance/repair service events for a rented asset")
@RequiredArgsConstructor
public class RentingServiceEventController {

    private final RentingServiceEventService service;

    @GetMapping
    @Operation(summary = "List or search service events for an asset")
    public Mono<ResponseEntity<PaginationResponse<RentingServiceEventDTO>>> findAll(
            @PathVariable UUID rentingAgreementId,
            @PathVariable UUID rentingAssetId,
            @ModelAttribute FilterRequest<RentingServiceEventDTO> filterRequest) {

        return service.findAll(rentingAgreementId, rentingAssetId, filterRequest)
                .map(ResponseEntity::ok);
    }

    @PostMapping
    @Operation(summary = "Create a new service event record")
    public Mono<ResponseEntity<RentingServiceEventDTO>> create(
            @PathVariable UUID rentingAgreementId,
            @PathVariable UUID rentingAssetId,
            @RequestBody RentingServiceEventDTO dto) {

        return service.create(rentingAgreementId, rentingAssetId, dto)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/{rentingServiceEventId}")
    @Operation(summary = "Get a service event by ID")
    public Mono<ResponseEntity<RentingServiceEventDTO>> getById(
            @PathVariable UUID rentingAgreementId,
            @PathVariable UUID rentingAssetId,
            @PathVariable UUID rentingServiceEventId) {

        return service.getById(rentingAgreementId, rentingAssetId, rentingServiceEventId)
                .map(ResponseEntity::ok);
    }

    @PutMapping("/{rentingServiceEventId}")
    @Operation(summary = "Update a service event record")
    public Mono<ResponseEntity<RentingServiceEventDTO>> update(
            @PathVariable UUID rentingAgreementId,
            @PathVariable UUID rentingAssetId,
            @PathVariable UUID rentingServiceEventId,
            @RequestBody RentingServiceEventDTO dto) {

        return service.update(rentingAgreementId, rentingAssetId, rentingServiceEventId, dto)
                .map(ResponseEntity::ok);
    }

    @DeleteMapping("/{rentingServiceEventId}")
    @Operation(summary = "Delete a service event record")
    public Mono<ResponseEntity<Void>> delete(
            @PathVariable UUID rentingAgreementId,
            @PathVariable UUID rentingAssetId,
            @PathVariable UUID rentingServiceEventId) {

        return service.delete(rentingAgreementId, rentingAssetId, rentingServiceEventId)
                .thenReturn(ResponseEntity.noContent().build());
    }
}