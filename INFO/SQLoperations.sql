-- Select operations:
--Find the title of each film
SELECT title FROM Movies;
--Find the director of each film
SELECT director FROM Movies;
--Find the title and director of each film
SELECT title, director FROM Movies;
--Find the title and year of each film
SELECT title, year FROM Movies;
--Find all the information about each film
SELECT * FROM Movies;

--Condition operation:
--Find the movies released in the years between 2000 and 2010
SELECT * FROM Movies WHERE year BETWEEN 2000 AND 2010;
--Find the movies not released in the years between 2000 and 2010
SELECT * FROM Movies WHERE year NOT BETWEEN 2000 AND 2010;
--Find the movies and their year released in years (2000, 2010, 2020)
SELECT title, year FROM Movies WHERE year IN (2000, 2010, 2020);
--Find the movies with title starting with either "b", "s", or "p"
SELECT * FROM Movies WHERE title LIKE 'b%' OR title LIKE 's%' OR title LIKE 'p%';

--Filtering and sorting:
--List all directors ordered (alphabetically) without duplicates for movies after 2005
SELECT DISTINCT director
FROM Movies
WHERE year > 2005
ORDER BY director ASC;

--JOINs:
--Find title, domestic_sale, international_sales for each movie
SELECT m.title, b.domestic_sale, b.international_sale
FROM Movies m
JOIN Boxoffice b ON m.id = b.movie_id;
--Find title, director, rating of each movie where international_sales > domestic_sales
SELECT m.title, m.director, b.rating
FROM Movies m
JOIN Boxoffice b ON m.id = b.movie_id
WHERE b.international_sale > b.domestic_sale;
--List all the movies by their ratings in descending order
SELECT m.title, b.rating
FROM Movies m
JOIN Boxoffice b ON m.id = b.movie_id
ORDER BY b.rating DESC;
--List all movies titles and their combined sales
SELECT m.title, (b.domestic_sale + b.international_sale) AS combined_sales
FROM Movies m
JOIN Boxoffice b ON m.id = b.movie_id;
--List all movies that were released on even number years
SELECT *
FROM Movies
WHERE year % 2 = 0;
--Find director, the number of movies and average rating each director has directed
SELECT m.director, COUNT(*) AS num_movies, AVG(b.rating) AS avg_rating
FROM Movies m
JOIN Boxoffice b ON m.id = b.movie_id
GROUP BY m.director;
--Find director, the total domestic and international sales made by each director
SELECT m.director, SUM(b.domestic_sale) AS total_domestic_sales, SUM(b.international_sale) AS total_international_sales
FROM Movies m
JOIN Boxoffice b ON m.id = b.movie_id
GROUP BY m.director;
