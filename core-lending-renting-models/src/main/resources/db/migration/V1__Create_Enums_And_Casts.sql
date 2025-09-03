-- V1 - CREATE ENUMS AND CASTS FOR RENTING (OPERATING LEASE) SUBMODULE

-- ========================================================================
-- CREATE ENUMS
-- ========================================================================

-- renting_agreement -> agreement_status
CREATE TYPE agreement_status AS ENUM (
    'ACTIVE',
    'SUSPENDED',
    'CLOSED',
    'TERMINATED',
    'DEFAULTED'
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

-- ========================================================================
-- CREATE CASTS USING "WITH INOUT AS IMPLICIT"
-- ========================================================================

-- agreement_status cast
CREATE CAST (varchar AS agreement_status)
    WITH INOUT
    AS IMPLICIT;

-- event_type cast
CREATE CAST (varchar AS event_type)
    WITH INOUT
    AS IMPLICIT;