package com.firefly.core.lending.renting.core.services.agreement.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.lending.renting.interfaces.dtos.agreement.v1.RentingAgreementDTO;
import reactor.core.publisher.Mono;

public interface RentingAgreementService {

    /**
     * Retrieves a paginated list of Renting Agreement DTOs based on the provided filtering criteria.
     *
     * @param filterRequest the filtering criteria used to query the renting agreements
     * @return a Mono containing the paginated response with the list of Renting Agreement DTOs
     */
    Mono<PaginationResponse<RentingAgreementDTO>> findAll(FilterRequest<RentingAgreementDTO> filterRequest);

    /**
     * Creates a new renting agreement based on the provided data.
     *
     * @param dto the data transfer object containing the details of the renting agreement to be created
     * @return a reactive Mono containing the newly created RentingAgreementDTO
     */
    Mono<RentingAgreementDTO> create(RentingAgreementDTO dto);

    /**
     * Retrieves a renting agreement by its unique identifier.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to retrieve
     * @return a reactive Mono containing the retrieved RentingAgreementDTO, or an empty Mono if not found
     */
    Mono<RentingAgreementDTO> getById(Long rentingAgreementId);

    /**
     * Updates an existing renting agreement with the specified details.
     *
     * @param rentingAgreementId the ID of the renting agreement to be updated
     * @param dto the DTO containing updated details of the renting agreement
     * @return a Mono emitting the updated RentingAgreementDTO, or an error if the update fails
     */
    Mono<RentingAgreementDTO> update(Long rentingAgreementId, RentingAgreementDTO dto);

    /**
     * Deletes a renting agreement based on the provided renting agreement ID.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to be deleted
     * @return a {@code Mono<Void>} indicating the completion of the delete operation
     */
    Mono<Void> delete(Long rentingAgreementId);
}