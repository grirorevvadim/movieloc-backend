drop table if exists movies;
CREATE TABLE movies
(
    id           long,
    movieName varchar(255),
    description varchar(255),
    location varchar(255),
    PRIMARY KEY (id)
);