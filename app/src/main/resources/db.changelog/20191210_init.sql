drop sequence if exists hibernate_sequence;
CREATE SEQUENCE hibernate_sequence;

drop table if exists profile;
CREATE TABLE profile
(
    id   BIGSERIAL NOT NULL,
    name VARCHAR   NOT NULL,
    lastName VARCHAR   NOT NULL,
    username VARCHAR not null,
    password  VARCHAR not null,
    email   VARCHAR not null,
    birthDay   VARCHAR not null,
    PRIMARY KEY (id)
);



CREATE table section
(
    id   BIGSERIAL PRIMARY KEY ,
    name varchar not null

);

CREATE table category
(
    id   BIGSERIAL PRIMARY KEY ,
    name varchar not null ,
    description varchar not null ,
    section_id BIGINT not null,
    FOREIGN KEY (section_id) REFERENCES section (id)
);

CREATE table auction
(
    id   BIGSERIAL PRIMARY KEY,
    title varchar not null ,
    description varchar not null ,
    price NUMERIC not null,
    profile_id BIGINT not null,
    category_id BIGINT not null,
    FOREIGN KEY (profile_id) REFERENCES profile (id),
    foreign key (category_id) REFERENCES category (id)
);

create table photo
(
    id   BIGSERIAL PRIMARY KEY ,
    photo varchar not null
);

create table auction_photo
(
    author_id BIGINT not null ,
    photo_id BIGINT not null,
    FOREIGN KEY (author_id) REFERENCES auction (id),
    foreign key (photo_id) REFERENCES photo (id)

);

create table parameter
(
    id  BIGSERIAL PRIMARY KEY,
    description varchar not null


);

create table auction_parameter
(
    auction_id  BIGINT NOT NULL ,
    parameter_id  BIGINT NOT NULL ,
    values varchar not null,
    FOREIGN KEY (auction_id) REFERENCES auction (id),
    foreign key (parameter_id) REFERENCES parameter (id)

);