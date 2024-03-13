CREATE TABLE users(
    id text primary key unique NOT NULL,
    login text not null unique,
    password text NOT NULL,
    role text NOT NULL
);