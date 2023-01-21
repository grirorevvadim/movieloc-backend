drop table if exists movies;
CREATE TABLE movies
(
    id          long,
    movie_name  varchar(255),
    description varchar(255),
    location    varchar(255),
    PRIMARY KEY (id)
);

INSERT INTO movies (id, movie_name, description, location)
VALUES (1, 'Spy','Spy desc',1);
INSERT INTO movies (id, movie_name, description, location)
VALUES (2, 'MI Fantom Protocol','MI IV desc',1);
INSERT INTO movies (id, movie_name, description, location)
VALUES (3, 'World War Z','WWZ desc',1);
INSERT INTO movies (id, movie_name, description, location)
VALUES (4, 'Bourne','Wow super Bourne такой пау-пау',2);
