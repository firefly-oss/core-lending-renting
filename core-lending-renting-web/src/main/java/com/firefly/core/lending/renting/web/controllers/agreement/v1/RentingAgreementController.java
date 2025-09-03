package com.firefly.core.lending.renting.web.controllers.agreement.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.lending.renting.core.services.agreement.v1.RentingAgreementService;
import com.firefly.core.lending.renting.interfaces.dtos.agreement.v1.RentingAgreementDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/renting-agreements")
@Tag(name = "RentingAgreement", description = "Operations on renting (operating lease) agreements")
@RequiredArgsConstructor
public class RentingAgreementController {

    private final RentingAgreementService service;

    @GetMapping
    @Operation(summary = "List or search renting agreements")
    public Mono<ResponseEntity<PaginationResponse<RentingAgreementDTO>>> findAll(
            @ModelAttribute FilterRequest<RentingAgreementDTO> filterRequest) {

        return service.findAll(filterRequest)
                .map(ResponseEntity::ok);
    }

    @PostMapping
    @Operation(summary = "Create a new renting agreement")
    public Mono<ResponseEntity<RentingAgreementDTO>> create(@RequestBody RentingAgreementDTO dto) {
        return service.create(dto)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/{rentingAgreementId}")
    @Operation(summary = "Get a renting agreement by ID")
    public Mono<ResponseEntity<RentingAgreementDTO>> getById(
            @PathVariable UUID rentingAgreementId) {

        return service.getById(rentingAgreementId)
                .map(ResponseEntity::ok);
    }

    @PutMapping("/{rentingAgreementId}")
    @Operation(summary = "Update an existing renting agreement")
    public Mono<ResponseEntity<RentingAgreementDTO>> update(
            @PathVariable UUID rentingAgreementId,
            @RequestBody RentingAgreementDTO dto) {

        return service.update(rentingAgreementId, dto)
                .map(ResponseEntity::ok);
    }

    @DeleteMapping("/{rentingAgreementId}")
    @Operation(summary = "Delete a renting agreement")
    public Mono<ResponseEntity<Void>> delete(@PathVariable UUID rentingAgreementId) {
        return service.delete(rentingAgreementId)
                .thenReturn(ResponseEntity.noContent().build());
    }
}
