package com.catalis.core.lending.renting.core.services.assets.v1;

import com.catalis.common.core.filters.FilterRequest;
import com.catalis.common.core.queries.PaginationResponse;
import com.catalis.core.lending.renting.interfaces.dtos.assets.v1.RentingAssetDTO;
import reactor.core.publisher.Mono;

public interface RentingAssetService {

    /**
     * Retrieves a paginated list of renting assets associated with a specific renting agreement,
     * based on the provided filtering criteria.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to filter the assets by
     * @param filterRequest the filtering criteria and pagination details for querying the renting assets
     * @return a reactive Mono containing the paginated response with the list of RentingAssetDTO objects
     */
    Mono<PaginationResponse<RentingAssetDTO>> findAll(Long rentingAgreementId,
                                                      FilterRequest<RentingAssetDTO> filterRequest);

    /**
     * Creates a new renting asset associated with a specific renting agreement.
     *
     * @param rentingAgreementId the ID of the renting agreement to associate the new asset with
     * @param dto the data transfer object containing the details of the renting asset to be created
     * @return a reactive Mono containing the newly created RentingAssetDTO
     */
    Mono<RentingAssetDTO> create(Long rentingAgreementId, RentingAssetDTO dto);

    /**
     * Retrieves the renting asset details based on the specified renting agreement ID and renting asset ID.
     *
     * @param rentingAgreementId the ID of the renting agreement to which the asset belongs
     * @param rentingAssetId the ID of the renting asset to retrieve
     * @return a reactive Mono containing the details of the RentingAssetDTO, or an empty Mono if not found
     */
    Mono<RentingAssetDTO> getById(Long rentingAgreementId, Long rentingAssetId);

    /**
     * Updates an existing renting asset associated with a specific renting agreement.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement
     * @param rentingAssetId the unique identifier of the renting asset to be updated
     * @param dto the data transfer object containing the updated details of the renting asset
     * @return a reactive Mono containing the updated RentingAssetDTO, or an error if the update fails
     */
    Mono<RentingAssetDTO> update(Long rentingAgreementId, Long rentingAssetId, RentingAssetDTO dto);

    /**
     * Deletes a renting asset that is associated with a specific renting agreement.
     *
     * @param rentingAgreementId the unique identifier of the renting agreement to which the asset belongs
     * @param rentingAssetId the unique identifier of the renting asset to be deleted
     * @return a {@code Mono<Void>} signaling the completion of the delete operation
     */
    Mono<Void> delete(Long rentingAgreementId, Long rentingAssetId);
}