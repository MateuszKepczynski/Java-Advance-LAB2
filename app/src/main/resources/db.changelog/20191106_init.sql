CREATE SEQUENCE hibernate_sequence_2;

CREATE TABLE auction
(
    id  BIGSERIAL NOT NULL PRIMARY KEY,
    title Varchar   NOT NULL, --tytuł
    owner_id  BIGSERIAL NOT NULL,
    category_id BIGSERIAL NOT NULL,
    photo_id BIGSERIAL NOT NULL, --zdjęcie
    price Integer, -- cena
    description VARCHAR, --opis
    FOREIGN KEY (photo_id) REFERENCES photo (id),
    FOREIGN KEY (category_id) REFERENCES category (id),
    FOREIGN KEY (owner_id) REFERENCES profile (id)
);

CREATE TABLE parameter
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR
);

CREATE TABLE auction_parameter
(
    auction_id BIGINT NOT NULL ,
    parameter_id BIGINT NOT NULL,
    FOREIGN KEY (auction_id) REFERENCES auction(id),
    FOREIGN KEY (parameter_id) REFERENCES parameter(id),
    CONSTRAINT auction_parameter_id PRIMARY KEY (auction_id,parameter_id)
);

CREATE TABLE photo
(
    id BIGSERIAL NOT NULL PRIMARY KEY ,
    auction_id BIGINT NOT NULL ,
    link VARCHAR,
    FOREIGN KEY (auction_id) REFERENCES auction (id)
);


CREATE TABLE category
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    section_id BIGINT NOT NULL ,
    name VARCHAR,
    FOREIGN KEY (section_id) REFERENCES Section (id)
);

CREATE TABLE section
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR
);