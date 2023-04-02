drop table if exists movies;
drop table if exists locations;
CREATE TABLE movies
(
    id          long,
    movie_name  varchar(255),
    description varchar(255),
    location    varchar(255),
    PRIMARY KEY (id)
);
CREATE TABLE locations
(
    id          long,
    city  varchar(255),
    description varchar(255),
    country    varchar(255),
    PRIMARY KEY (id)
);

INSERT INTO movies (id, movie_name, description, location)
VALUES (1, 'Spy','Spy desc',1),
       (2, 'MI Fantom Protocol','MI IV desc',1),
       (3, 'World War Z','WWZ desc',1),
       (4, 'Bourne','Wow super Bourne такой пау-пау',2);

INSERT INTO locations (id,city,country,description)
VALUES (1,'Budapest','Hungary','Capital of Hungary'),
       (2,'Wien','Austria','Capital of Austria'),
       (3,'Saint-Petersburg','Russia','home');
