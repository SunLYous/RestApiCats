CREATE TABLE CatFriends
(
    cat_id        INT REFERENCES Cats (id) not null,
    friend_cat_id INT REFERENCES Cats (id) not null,
    PRIMARY KEY (cat_id, friend_cat_id)
);
