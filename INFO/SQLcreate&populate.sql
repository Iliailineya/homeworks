CREATE DATABASE demo_db;

CREATE TABLE IF NOT EXISTS Movies (
    id INT PRIMARY KEY NOT NULL,
    title VARCHAR(255),
    director VARCHAR(255),
    year INT,
    length_min INT
);

INSERT INTO Movies (id, title, director, year, length_min) VALUES
(1, 'The Shawshank Redemption', 'Frank Darabont', 1994, 142),
(2, 'The Godfather', 'Francis Ford Coppola', 1972, 175),
(3, 'The Dark Knight', 'Christopher Nolan', 2008, 152),
(4, 'Pulp Fiction', 'Quentin Tarantino', 1994, 154),
(5, 'The Lord of the Rings: The Return of the King', 'Peter Jackson', 2003, 201);


CREATE TABLE IF NOT EXISTS Boxoffice (
    id INT PRIMARY KEY NOT NULL,
    movie_id INT,
    rating INT,
    domestic_sale BIGINT,
    international_sale BIGINT,
    FOREIGN KEY (movie_id) REFERENCES Movies(id)
);

INSERT INTO Boxoffice (id, movie_id, rating, domestic_sale, international_sale) VALUES
(1, 1, 9, 28341469, 28341469),
(2, 2, 9, 134821952, 135000000),
(3, 3, 9, 534858444, 469700000),
(4, 4, 8, 107928762, 213928762),
(5, 5, 9, 377845905, 742083616);

