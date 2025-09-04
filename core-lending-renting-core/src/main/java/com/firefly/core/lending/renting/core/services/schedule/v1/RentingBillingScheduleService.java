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


package com.firefly.core.lending.renting.core.services.schedule.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.lending.renting.interfaces.dtos.schedule.v1.RentingBillingScheduleDTO;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface RentingBillingScheduleService {

    /**
     * Retrieves a paginated list of Renting Billing Schedule DTOs associated with a specific renting agreement
     * based on the provided filtering criteria.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to filter the billing schedules by
     * @param filterRequest the filtering criteria and pagination details for querying the billing schedules
     * @return a reactive Mono containing the paginated response with the list of RentingBillingScheduleDTO objects
     */
    Mono<PaginationResponse<RentingBillingScheduleDTO>> findAll(UUID rentingAgreementId,
                                                                FilterRequest<RentingBillingScheduleDTO> filterRequest);

    /**
     * Creates a new renting billing schedule for a specific renting agreement.
     *
     * @param rentingAgreementId the ID of the renting agreement to associate the billing schedule with
     * @param dto the data transfer object containing the details of the billing schedule to be created
     * @return a reactive Mono containing the newly created RentingBillingScheduleDTO
     */
    Mono<RentingBillingScheduleDTO> create(UUID rentingAgreementId, RentingBillingScheduleDTO dto);

    /**
     * Retrieves a specific renting billing schedule associated with a given renting agreement ID and billing schedule ID.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement
     * @param rentingBillingScheduleId the unique identifier of the renting billing schedule to retrieve
     * @return a reactive Mono containing the RentingBillingScheduleDTO representing the billing schedule details,
     *         or an empty Mono if not found
     */
    Mono<RentingBillingScheduleDTO> getById(UUID rentingAgreementId, UUID rentingBillingScheduleId);

    /**
     * Updates an existing renting billing schedule associated with a specific renting agreement.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to which the billing schedule belongs
     * @param rentingBillingScheduleId the unique identifier of the billing schedule to be updated
     * @param dto the data transfer object containing the updated details of the renting billing schedule
     * @return a reactive Mono containing the updated RentingBillingScheduleDTO, or an error if the update fails
     */
    Mono<RentingBillingScheduleDTO> update(UUID rentingAgreementId, UUID rentingBillingScheduleId,
                                           RentingBillingScheduleDTO dto);

    /**
     * Deletes a renting billing schedule associated with a specific renting agreement.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to which the billing schedule belongs
     * @param rentingBillingScheduleId the unique identifier of the billing schedule to be deleted
     * @return a {@code Mono<Void>} signaling the completion of the delete operation
     */
    Mono<Void> delete(UUID rentingAgreementId, UUID rentingBillingScheduleId);
}
