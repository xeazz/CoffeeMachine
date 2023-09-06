CREATE SCHEMA IF NOT EXISTS coffee_machine;

CREATE TABLE IF NOT EXISTS coffee_machine.operations
(
    id          BIGSERIAL,
    datetime    TIMESTAMP,
    status      VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS coffee_machine.drink
(
    id          BIGSERIAL,
    name        VARCHAR(255) NOT NULL,
    cost        DOUBLE PRECISION,
    volume      DOUBLE PRECISION,
    description VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS coffee_machine.ingredients
(
    drink_id BIGINT,
    key      VARCHAR(255) NOT NULL,
    value    VARCHAR(255) NOT NULL,
    FOREIGN KEY (drink_id) REFERENCES coffee_machine.drink
);
