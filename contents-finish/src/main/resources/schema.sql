DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id integer primary key autoincrement,
    username text unique,
    bio text,
    email text,
    phone text,
    avatar text
);