INSERT INTO user_account (user_id, balance)
SELECT u.id, 2000
FROM users u
ORDER BY u.id
    LIMIT 1;