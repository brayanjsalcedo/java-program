CREATE TABLE user_account
(
    id      SERIAL PRIMARY KEY,
    user_id BIGINT,
    balance NUMERIC,
    FOREIGN KEY (user_id) REFERENCES users (id)
);