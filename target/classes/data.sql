drop table if exists movies;
CREATE TABLE movies
(
    id           long,
    MOVIE_NAME varchar(255),
    description varchar(255),
    location varchar(255),
    PRIMARY KEY (id)
);