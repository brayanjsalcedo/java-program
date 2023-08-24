INSERT INTO users (name, email)
VALUES ('John Doe', 'john@example.com'),
       ('Jane Smith', 'jane@example.com') ON CONFLICT DO NOTHING;

INSERT INTO events (title, date)
VALUES ('Event 1', '2023-08-25 10:00:00'),
       ('Event 2', '2023-09-05 15:30:00') ON CONFLICT DO NOTHING;

INSERT INTO tickets (category, user_id, event_id, place)
VALUES ('BAR', 1, 1, 100),
       ('PREMIUM', 2, 1, 50) ON CONFLICT DO NOTHING;
