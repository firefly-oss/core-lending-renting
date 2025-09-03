package com.firefly.core.lending.renting.core.services.event.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.lending.renting.interfaces.dtos.event.v1.RentingServiceEventDTO;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface RentingServiceEventService {

    /**
     * Retrieves a paginated list of Renting Service Event DTOs based on the provided filtering criteria.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to filter the events by
     * @param rentingAssetId the unique identifier of the renting asset associated with the events
     * @param filterRequest the filtering criteria and pagination details for querying the renting service events
     * @return a reactive Mono containing the paginated response with the list of RentingServiceEventDTO objects
     */
    Mono<PaginationResponse<RentingServiceEventDTO>> findAll(UUID rentingAgreementId,
                                                             UUID rentingAssetId,
                                                             FilterRequest<RentingServiceEventDTO> filterRequest);

    /**
     * Creates a new renting service event associated with a specific renting agreement and renting asset.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to associate the event with
     * @param rentingAssetId the unique identifier of the renting asset to associate the event with
     * @param dto the data transfer object containing the details of the renting service event to be created
     * @return a reactive Mono containing the newly created RentingServiceEventDTO
     */
    Mono<RentingServiceEventDTO> create(UUID rentingAgreementId,
                                        UUID rentingAssetId,
                                        RentingServiceEventDTO dto);

    /**
     * Retrieves a specific renting service event based on the provided identifiers.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement associated with the event
     * @param rentingAssetId the unique identifier of the renting asset associated with the event
     * @param rentingServiceEventId the unique identifier of the renting service event to retrieve
     * @return a reactive Mono containing the details of the RentingServiceEventDTO, or an empty Mono if not found
     */
    Mono<RentingServiceEventDTO> getById(UUID rentingAgreementId,
                                         UUID rentingAssetId,
                                         UUID rentingServiceEventId);

    /**
     * Updates an existing renting service event associated with specified renting agreement
     * and renting asset identifiers.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement associated with the service event
     * @param rentingAssetId the unique identifier of the renting asset associated with the service event
     * @param rentingServiceEventId the unique identifier of the renting service event to be updated
     * @param dto the data transfer object containing the updated details of the renting service event
     * @return a reactive Mono containing the updated RentingServiceEventDTO, or an error if the update fails
     */
    Mono<RentingServiceEventDTO> update(UUID rentingAgreementId,
                                        UUID rentingAssetId,
                                        UUID rentingServiceEventId,
                                        RentingServiceEventDTO dto);

    /**
     * Deletes a specific renting service event associated with the given renting agreement,
     * renting asset, and renting service event identifiers.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement the service event is associated with
     * @param rentingAssetId the unique identifier of the renting asset the service event relates to
     * @param rentingServiceEventId the unique identifier of the renting service event to be deleted
     * @return a {@code Mono<Void>} indicating the completion of the delete operation
     */
    Mono<Void> delete(UUID rentingAgreementId,
                      UUID rentingAssetId,
                      UUID rentingServiceEventId);
}
