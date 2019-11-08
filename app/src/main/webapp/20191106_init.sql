CREATE SEQUENCE hibernate_sequence_2;

CREATE TABLE category
(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    categoryName VARCHAR NOT NULL
);

CREATE TABLE auction
(
    id BIGSERIAL NOT NULL,
    auctionName TEXT NOT NULL,
    auctionDescription TEXT,
    auctionPrice BIGSERIAL NOT NULL,
    //add img
);