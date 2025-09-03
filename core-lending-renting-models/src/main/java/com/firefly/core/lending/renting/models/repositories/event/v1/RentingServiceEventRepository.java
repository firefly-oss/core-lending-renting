package com.firefly.core.lending.renting.models.repositories.event.v1;

import com.firefly.core.lending.renting.models.entities.event.v1.RentingServiceEvent;
import com.firefly.core.lending.renting.models.repositories.BaseRepository;

import java.util.UUID;

public interface RentingServiceEventRepository extends BaseRepository<RentingServiceEvent, UUID> {
}
