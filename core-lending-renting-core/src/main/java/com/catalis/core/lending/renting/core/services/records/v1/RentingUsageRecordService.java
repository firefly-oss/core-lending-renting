package com.catalis.core.lending.renting.core.services.records.v1;

import com.catalis.common.core.filters.FilterRequest;
import com.catalis.common.core.queries.PaginationResponse;
import com.catalis.core.lending.renting.interfaces.dtos.records.v1.RentingUsageRecordDTO;
import reactor.core.publisher.Mono;

public interface RentingUsageRecordService {

    /**
     * Retrieves a paginated list of renting usage records associated with a specific renting agreement
     * and renting asset, based on the provided filtering criteria.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to filter the usage records by
     * @param rentingAssetId the unique identifier of the renting asset to filter the usage records by
     * @param filterRequest the filtering criteria and pagination details for querying the renting usage records
     * @return a reactive Mono containing the paginated response with the list of RentingUsageRecordDTO objects
     */
    Mono<PaginationResponse<RentingUsageRecordDTO>> findAll(Long rentingAgreementId,
                                                            Long rentingAssetId,
                                                            FilterRequest<RentingUsageRecordDTO> filterRequest);

    /**
     * Creates a new renting usage record associated with the specified renting agreement and asset.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to associate the usage record with
     * @param rentingAssetId the unique identifier of the renting asset to associate the usage record with
     * @param dto the data transfer object containing the details of the renting usage record to be created
     * @return a reactive Mono containing the newly created RentingUsageRecordDTO
     */
    Mono<RentingUsageRecordDTO> create(Long rentingAgreementId,
                                       Long rentingAssetId,
                                       RentingUsageRecordDTO dto);

    /**
     * Retrieves a specific usage record associated with a given renting agreement and renting asset.
     *
     * @param rentingAgreementId the ID of the renting agreement to which the usage record belongs
     * @param rentingAssetId the ID of the renting asset to which the usage record is related
     * @param rentingUsageRecordId the ID of the usage record to retrieve
     * @return a reactive Mono containing the details of the RentingUsageRecordDTO, or an empty Mono if not found
     */
    Mono<RentingUsageRecordDTO> getById(Long rentingAgreementId,
                                        Long rentingAssetId,
                                        Long rentingUsageRecordId);

    /**
     * Updates an existing renting usage record associated with a specific renting agreement and renting asset.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement
     * @param rentingAssetId the unique identifier of the renting asset
     * @param rentingUsageRecordId the unique identifier of the renting usage record to update
     * @param dto the data transfer object containing the updated details of the renting usage record
     * @return a reactive Mono containing the updated RentingUsageRecordDTO, or an error if the update operation fails
     */
    Mono<RentingUsageRecordDTO> update(Long rentingAgreementId,
                                       Long rentingAssetId,
                                       Long rentingUsageRecordId,
                                       RentingUsageRecordDTO dto);

    /**
     * Deletes a renting usage record identified by the given IDs.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to which the usage record belongs
     * @param rentingAssetId the unique identifier of the renting asset associated with the usage record
     * @param rentingUsageRecordId the unique identifier of the renting usage record to be deleted
     * @return a {@code Mono<Void>} signaling the completion of the delete operation
     */
    Mono<Void> delete(Long rentingAgreementId,
                      Long rentingAssetId,
                      Long rentingUsageRecordId);
}