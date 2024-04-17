CREATE TABLE Owners
(
    id        bigint PRIMARY KEY not null generated always as identity,
    name      VARCHAR(100),
    birthdate DATE
);
