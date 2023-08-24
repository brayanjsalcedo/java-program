CREATE TABLE tickets
(
    id       SERIAL PRIMARY KEY,
    category VARCHAR(50),
    user_id  BIGINT REFERENCES users (id),
    event_id BIGINT REFERENCES events (id),
    place    BIGINT
);