package com.catalis.core.lending.renting.core.services.records.v1;

import com.catalis.core.lending.renting.interfaces.dtos.records.v1.RentingReturnRecordDTO;
import reactor.core.publisher.Mono;

public interface RentingReturnRecordService {

    /**
     * Retrieves the renting return record associated with the specified renting agreement ID and renting asset ID.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to which the return record belongs
     * @param rentingAssetId the unique identifier of the renting asset for which the return record is retrieved
     * @return a reactive Mono containing the details of the RentingReturnRecordDTO, or an empty Mono if not found
     */
    Mono<RentingReturnRecordDTO> getByAsset(Long rentingAgreementId, Long rentingAssetId);

    /**
     * Creates a new renting return record associated with a specific renting agreement
     * and renting asset using the provided data.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to which the return record belongs
     * @param rentingAssetId the unique identifier of the renting asset for which the return record is created
     * @param dto the data transfer object containing the details of the renting return record to be created
     * @return a reactive Mono containing the newly created RentingReturnRecordDTO
     */
    Mono<RentingReturnRecordDTO> create(Long rentingAgreementId, Long rentingAssetId, RentingReturnRecordDTO dto);

    /**
     * Updates an existing renting return record associated with a specific renting agreement and asset.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to which the return record belongs
     * @param rentingAssetId the unique identifier of the renting asset for which the return record is to be updated
     * @param dto the data transfer object containing the updated details of the renting return record
     * @return a reactive Mono containing the updated RentingReturnRecordDTO, or an error in case of failure
     */
    Mono<RentingReturnRecordDTO> update(Long rentingAgreementId, Long rentingAssetId, RentingReturnRecordDTO dto);

    /**
     * Deletes a renting return record associated with the specified renting agreement and renting asset.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to which the record belongs
     * @param rentingAssetId the unique identifier of the renting asset associated with the record to be deleted
     * @return a {@code Mono<Void>} indicating the completion of the delete operation
     */
    Mono<Void> delete(Long rentingAgreementId, Long rentingAssetId);
}
