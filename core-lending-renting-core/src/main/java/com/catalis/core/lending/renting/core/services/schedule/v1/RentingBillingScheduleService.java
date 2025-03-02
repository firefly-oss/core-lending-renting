package com.catalis.core.lending.renting.core.services.schedule.v1;

import com.catalis.common.core.filters.FilterRequest;
import com.catalis.common.core.queries.PaginationResponse;
import com.catalis.core.lending.renting.interfaces.dtos.schedule.v1.RentingBillingScheduleDTO;
import reactor.core.publisher.Mono;

public interface RentingBillingScheduleService {

    /**
     * Retrieves a paginated list of Renting Billing Schedule DTOs associated with a specific renting agreement
     * based on the provided filtering criteria.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to filter the billing schedules by
     * @param filterRequest the filtering criteria and pagination details for querying the billing schedules
     * @return a reactive Mono containing the paginated response with the list of RentingBillingScheduleDTO objects
     */
    Mono<PaginationResponse<RentingBillingScheduleDTO>> findAll(Long rentingAgreementId,
                                                                FilterRequest<RentingBillingScheduleDTO> filterRequest);

    /**
     * Creates a new renting billing schedule for a specific renting agreement.
     *
     * @param rentingAgreementId the ID of the renting agreement to associate the billing schedule with
     * @param dto the data transfer object containing the details of the billing schedule to be created
     * @return a reactive Mono containing the newly created RentingBillingScheduleDTO
     */
    Mono<RentingBillingScheduleDTO> create(Long rentingAgreementId, RentingBillingScheduleDTO dto);

    /**
     * Retrieves a specific renting billing schedule associated with a given renting agreement ID and billing schedule ID.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement
     * @param rentingBillingScheduleId the unique identifier of the renting billing schedule to retrieve
     * @return a reactive Mono containing the RentingBillingScheduleDTO representing the billing schedule details,
     *         or an empty Mono if not found
     */
    Mono<RentingBillingScheduleDTO> getById(Long rentingAgreementId, Long rentingBillingScheduleId);

    /**
     * Updates an existing renting billing schedule associated with a specific renting agreement.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to which the billing schedule belongs
     * @param rentingBillingScheduleId the unique identifier of the billing schedule to be updated
     * @param dto the data transfer object containing the updated details of the renting billing schedule
     * @return a reactive Mono containing the updated RentingBillingScheduleDTO, or an error if the update fails
     */
    Mono<RentingBillingScheduleDTO> update(Long rentingAgreementId, Long rentingBillingScheduleId,
                                           RentingBillingScheduleDTO dto);

    /**
     * Deletes a renting billing schedule associated with a specific renting agreement.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to which the billing schedule belongs
     * @param rentingBillingScheduleId the unique identifier of the billing schedule to be deleted
     * @return a {@code Mono<Void>} signaling the completion of the delete operation
     */
    Mono<Void> delete(Long rentingAgreementId, Long rentingBillingScheduleId);
}
