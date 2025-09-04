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


package com.firefly.core.lending.renting.core.services.assets.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.lending.renting.interfaces.dtos.assets.v1.RentingAssetDTO;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface RentingAssetService {

    /**
     * Retrieves a paginated list of renting assets associated with a specific renting agreement,
     * based on the provided filtering criteria.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to filter the assets by
     * @param filterRequest the filtering criteria and pagination details for querying the renting assets
     * @return a reactive Mono containing the paginated response with the list of RentingAssetDTO objects
     */
    Mono<PaginationResponse<RentingAssetDTO>> findAll(UUID rentingAgreementId,
                                                      FilterRequest<RentingAssetDTO> filterRequest);

    /**
     * Creates a new renting asset associated with a specific renting agreement.
     *
     * @param rentingAgreementId the ID of the renting agreement to associate the new asset with
     * @param dto the data transfer object containing the details of the renting asset to be created
     * @return a reactive Mono containing the newly created RentingAssetDTO
     */
    Mono<RentingAssetDTO> create(UUID rentingAgreementId, RentingAssetDTO dto);

    /**
     * Retrieves the renting asset details based on the specified renting agreement ID and renting asset ID.
     *
     * @param rentingAgreementId the ID of the renting agreement to which the asset belongs
     * @param rentingAssetId the ID of the renting asset to retrieve
     * @return a reactive Mono containing the details of the RentingAssetDTO, or an empty Mono if not found
     */
    Mono<RentingAssetDTO> getById(UUID rentingAgreementId, UUID rentingAssetId);

    /**
     * Updates an existing renting asset associated with a specific renting agreement.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement
     * @param rentingAssetId the unique identifier of the renting asset to be updated
     * @param dto the data transfer object containing the updated details of the renting asset
     * @return a reactive Mono containing the updated RentingAssetDTO, or an error if the update fails
     */
    Mono<RentingAssetDTO> update(UUID rentingAgreementId, UUID rentingAssetId, RentingAssetDTO dto);

    /**
     * Deletes a renting asset that is associated with a specific renting agreement.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to which the asset belongs
     * @param rentingAssetId the unique identifier of the renting asset to be deleted
     * @return a {@code Mono<Void>} signaling the completion of the delete operation
     */
    Mono<Void> delete(UUID rentingAgreementId, UUID rentingAssetId);
}