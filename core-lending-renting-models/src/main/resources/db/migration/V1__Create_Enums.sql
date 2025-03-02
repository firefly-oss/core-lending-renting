-- V1 - CREATE ENUMS FOR RENTING (OPERATING LEASE) SUBMODULE

-- renting_agreement -> agreement_status
CREATE TYPE agreement_status AS ENUM (
    'ACTIVE',
    'SUSPENDED',
    'CLOSED',
    'TERMINATED',
    'DEFAULTED'
);

-- renting_asset -> asset_type
CREATE TYPE asset_type AS ENUM (
    'VEHICLE',
    'EQUIPMENT',
    'TECH_DEVICE',
    'MACHINERY',
    'OFFICE_EQUIPMENT'
);

-- renting_service_event -> event_type
CREATE TYPE event_type AS ENUM (
    'MAINTENANCE',
    'INSPECTION',
    'REPAIR',
    'ACCIDENT',
    'REPLACEMENT',
    'WARRANTY'
);