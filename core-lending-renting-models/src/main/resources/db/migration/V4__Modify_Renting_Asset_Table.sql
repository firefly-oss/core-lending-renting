-- V4 - MODIFY RENTING_ASSET TABLE

-- Add new asset_type_id column
ALTER TABLE renting_asset
    ADD COLUMN asset_type_id BIGINT;

-- Remove the asset_type column
ALTER TABLE renting_asset
DROP COLUMN asset_type;