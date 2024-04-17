CREATE TABLE Cats
(
    id        bigint PRIMARY KEY not null generated always as identity ,
    name      VARCHAR(100),
    birthdate DATE,
    breed     VARCHAR(100),
    color     VARCHAR(50),
    owner_id  bigint REFERENCES Owners (id) not null
);