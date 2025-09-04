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


package com.firefly.core.lending.renting.core.services.records.v1;

import com.firefly.core.lending.renting.interfaces.dtos.records.v1.RentingReturnRecordDTO;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface RentingReturnRecordService {

    /**
     * Retrieves the renting return record associated with the specified renting agreement ID and renting asset ID.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to which the return record belongs
     * @param rentingAssetId the unique identifier of the renting asset for which the return record is retrieved
     * @return a reactive Mono containing the details of the RentingReturnRecordDTO, or an empty Mono if not found
     */
    Mono<RentingReturnRecordDTO> getByAsset(UUID rentingAgreementId, UUID rentingAssetId);

    /**
     * Creates a new renting return record associated with a specific renting agreement
     * and renting asset using the provided data.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to which the return record belongs
     * @param rentingAssetId the unique identifier of the renting asset for which the return record is created
     * @param dto the data transfer object containing the details of the renting return record to be created
     * @return a reactive Mono containing the newly created RentingReturnRecordDTO
     */
    Mono<RentingReturnRecordDTO> create(UUID rentingAgreementId, UUID rentingAssetId, RentingReturnRecordDTO dto);

    /**
     * Updates an existing renting return record associated with a specific renting agreement and asset.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to which the return record belongs
     * @param rentingAssetId the unique identifier of the renting asset for which the return record is to be updated
     * @param dto the data transfer object containing the updated details of the renting return record
     * @return a reactive Mono containing the updated RentingReturnRecordDTO, or an error in case of failure
     */
    Mono<RentingReturnRecordDTO> update(UUID rentingAgreementId, UUID rentingAssetId, RentingReturnRecordDTO dto);

    /**
     * Deletes a renting return record associated with the specified renting agreement and renting asset.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to which the record belongs
     * @param rentingAssetId the unique identifier of the renting asset associated with the record to be deleted
     * @return a {@code Mono<Void>} indicating the completion of the delete operation
     */
    Mono<Void> delete(UUID rentingAgreementId, UUID rentingAssetId);
}
