-- Create tables
CREATE TABLE IF NOT EXISTS employees (
    id                            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    name                          VARCHAR(128) NOT NULL,
    email                         VARCHAR(64) NOT NULL,
    phone_number                  VARCHAR(32) NOT NULL,
    address                       VARCHAR(255) NOT NULL,
    specialization                VARCHAR(32),
    shift                         VARCHAR(32),
    employee_type                 VARCHAR(64),
    PRIMARY KEY ( id )
);

CREATE TABLE IF NOT EXISTS equipments (
    id                            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    description                   VARCHAR(255) NULL,
    serial_number                 VARCHAR(64) NOT NULL,
    model                         VARCHAR(32) NOT NULL,
    type                          VARCHAR(32) NOT NULL,
    latitude                      DECIMAL(7,5) NULL,
    longitude                     DECIMAL(7,5) NULL,
    status                        VARCHAR(64) NOT NULL DEFAULT 'AVAILABLE',
    PRIMARY KEY ( id )
);

CREATE TABLE IF NOT EXISTS manufacture_orders (
    id                            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    order_number                  VARCHAR(64) NOT NULL,
    description                   VARCHAR(255) NULL,
    created_at                    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at                    DATETIME NULL,
    finished_at                   DATETIME NULL,
    equipment_id                  BIGINT UNSIGNED NOT NULL,
    employee_id                   BIGINT UNSIGNED NOT NULL,
    order_status                  VARCHAR(16) NOT NULL DEFAULT 'CREATED',
    PRIMARY KEY ( id ),
    CONSTRAINT fk_manufacture_order_equipment_id FOREIGN KEY ( equipment_id ) REFERENCES equipments ( id ),
    CONSTRAINT fk_manufacture_order_employee_id FOREIGN KEY ( employee_id ) REFERENCES employees ( id )
);

CREATE TABLE IF NOT EXISTS manufacture_order_items (
    id                            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    description                   VARCHAR(255) NULL,
    quantity                      INTEGER NOT NULL,
    non_conforming_quantity       INTEGER NOT NULL,
    unit                          VARCHAR(16) NOT NULL,
    shift                         VARCHAR(64) NOT NULL DEFAULT 'REGULAR',
    manufacture_order_id          BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY ( id ),
    CONSTRAINT fk_manufacture_order_item_order_id FOREIGN KEY ( manufacture_order_id ) REFERENCES manufacture_orders ( id )
);

CREATE TABLE IF NOT EXISTS maintenance_orders (
    id                            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    reason                        VARCHAR(500) NOT NULL,
    created_at                    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at                    DATETIME NULL,
    finished_at                   DATETIME NULL,
    equipment_id                  BIGINT UNSIGNED NOT NULL,
    type                          VARCHAR(16) NOT NULL DEFAULT 'PRODUCTION',
    priority                      VARCHAR(16) NOT NULL DEFAULT 'LOW',
    order_status                  VARCHAR(16) NOT NULL DEFAULT 'CREATED',
    PRIMARY KEY ( id ),
    CONSTRAINT fk_maintenance_order_equipment_id FOREIGN KEY ( equipment_id ) REFERENCES equipments ( id )
);

CREATE TABLE IF NOT EXISTS maintenance_order_items (
    id                            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    description                   VARCHAR(255) NULL,
    shift                         VARCHAR(64) DEFAULT 'REGULAR',
    employee_id                   BIGINT UNSIGNED,
    maintenance_order_id          BIGINT UNSIGNED,
    started_at                    DATETIME NULL,
    finished_at                   DATETIME NULL,
    PRIMARY KEY ( id ),
    CONSTRAINT fk_maintenance_order_item_employee_id FOREIGN KEY ( employee_id ) REFERENCES employees ( id ),
    CONSTRAINT fk_maintenance_order_item_order_id FOREIGN KEY ( maintenance_order_id ) REFERENCES maintenance_orders ( id )
);

-- Populate default values
INSERT INTO equipments
(id, description, serial_number, model, type, latitude, longitude)
VALUES
(123456, 'Equipamento Teste', 'SN-123456', 'XYZ', 'MACHINE', -29.63935, -50.78878);

INSERT INTO employees
(id, name, email, phone_number, address, specialization, employee_type)
VALUES
(1, 'John Doe', 'john@doe.com', '999999999', 'Test address', 'GENERAL', 'Technician'),
(2, 'John Mechanic', 'john@mec.com', '999999999', 'Test address', 'MECHANICAL', 'Technician'),
(3, 'John Electric', 'john@electric.com', '999999999', 'Test address', 'ELECTRICAL', 'Technician');