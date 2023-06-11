CREATE TABLE event (
                       id BIGSERIAL PRIMARY KEY,
                       source VARCHAR(255) NOT NULL,
                       url VARCHAR(255) NOT NULL,
                       args JSONB,
                       recorded_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
