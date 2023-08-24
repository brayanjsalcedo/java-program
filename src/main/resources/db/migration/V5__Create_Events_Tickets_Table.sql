CREATE TABLE events_tickets
(
    event_id  BIGINT REFERENCES events (id),
    tickets_id BIGINT REFERENCES tickets (id)
);
