CREATE TABLE users_tickets
(
    user_id  BIGINT REFERENCES users (id),
    tickets_id BIGINT REFERENCES tickets (id)
);
