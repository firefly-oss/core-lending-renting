-- V2 - CREATE TABLES FOR THE RENTING (OPERATING LEASE) SUBMODULE WITH UUID PRIMARY KEYS

-- Create UUID extension if not exists
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- ========================================================================
-- TABLE: renting_agreement
-- ========================================================================
CREATE TABLE IF NOT EXISTS renting_agreement (
    renting_agreement_id      UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    contract_id               UUID, -- external reference (Contract domain, no FK)
    customer_id               UUID, -- external reference (Customer domain, no FK)
    agreement_status          agreement_status NOT NULL, -- e.g. ACTIVE, DEFAULTED
    start_date                DATE NOT NULL,
    end_date                  DATE,  -- might be extended or indefinite
    monthly_rent              DECIMAL(18,2),
    services_included         BOOLEAN DEFAULT FALSE,
    insurance_fee             DECIMAL(18,2) DEFAULT 0,
    remarks                   TEXT,
    created_at                TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at                TIMESTAMP NOT NULL DEFAULT NOW()
);

-- ========================================================================
-- TABLE: renting_asset
-- ========================================================================
CREATE TABLE IF NOT EXISTS renting_asset (
    renting_asset_id          UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    renting_agreement_id      UUID NOT NULL,
    asset_type_id             UUID, -- reference to external asset type table
    asset_description         VARCHAR(255) NOT NULL,
    asset_serial_number       VARCHAR(100),  -- e.g. VIN or S/N
    asset_value               DECIMAL(18,2),
    is_active                 BOOLEAN DEFAULT TRUE,
    note                      TEXT,
    created_at                TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at                TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_asset_agreement
        FOREIGN KEY (renting_agreement_id)
        REFERENCES renting_agreement (renting_agreement_id)
);

-- ========================================================================
-- TABLE: renting_billing_schedule
-- ========================================================================
CREATE TABLE IF NOT EXISTS renting_billing_schedule (
    renting_billing_schedule_id  UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    renting_agreement_id         UUID NOT NULL,
    installment_number           INT NOT NULL,
    due_date                     DATE NOT NULL,
    rent_amount                  DECIMAL(18,2) NOT NULL,
    service_fee                  DECIMAL(18,2) DEFAULT 0,
    total_due                    DECIMAL(18,2) NOT NULL,
    is_paid                      BOOLEAN DEFAULT FALSE,
    paid_date                    DATE,
    note                         TEXT,
    created_at                   TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at                   TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_billing_agreement
        FOREIGN KEY (renting_agreement_id)
        REFERENCES renting_agreement (renting_agreement_id)
);

-- ========================================================================
-- TABLE: renting_usage_record
-- ========================================================================
CREATE TABLE IF NOT EXISTS renting_usage_record (
    renting_usage_record_id   UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    renting_asset_id          UUID NOT NULL,
    usage_date                DATE NOT NULL,
    mileage                   INT,  -- or hours if it's machinery
    usage_detail              TEXT,
    created_at                TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at                TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_usage_asset
        FOREIGN KEY (renting_asset_id)
        REFERENCES renting_asset (renting_asset_id)
);

-- ========================================================================
-- TABLE: renting_service_event
-- ========================================================================
CREATE TABLE IF NOT EXISTS renting_service_event (
    renting_service_event_id  UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    renting_asset_id          UUID NOT NULL,
    event_date                DATE NOT NULL,
    event_type                event_type NOT NULL, -- e.g. MAINTENANCE, REPAIR
    cost                      DECIMAL(18,2) DEFAULT 0,
    note                      TEXT,
    created_at                TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at                TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_service_asset
        FOREIGN KEY (renting_asset_id)
        REFERENCES renting_asset (renting_asset_id)
);

-- ========================================================================
-- TABLE: renting_return_record
-- ========================================================================
CREATE TABLE IF NOT EXISTS renting_return_record (
    renting_return_record_id  UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    renting_asset_id          UUID NOT NULL,
    actual_return_date        DATE,
    condition_report          TEXT,
    damage_cost               DECIMAL(18,2) DEFAULT 0,
    is_finalized              BOOLEAN DEFAULT FALSE,
    note                      TEXT,
    created_at                TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at                TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_return_asset
        FOREIGN KEY (renting_asset_id)
        REFERENCES renting_asset (renting_asset_id)
);