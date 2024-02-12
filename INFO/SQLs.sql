CREATE DATABASE demo_db;

CREATE TABLE accounts (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    country VARCHAR(255),
    birthday DATE,
    balance DOUBLE,
    gender VARCHAR(10)
);

INSERT INTO accounts (first_name, last_name, country, birthday, balance, gender)
VALUES
    ('John', 'Doe', 'USA', '1990-01-12', 16000.0, 'MALE'),
    ('Alice', 'Johnson', 'Canada', '1995-03-05', 18000.0, 'FEMALE'),
    ('Bob', 'Smith', 'UK', '2000-08-22', 13000.0, 'MALE'),
    ('Emily', 'Clark', 'Germany', '1992-07-15', 12000.0, 'FEMALE'),
    ('Michael', 'Williams', 'USA', '1985-09-30', 20000.0, 'MALE'),
    ('Sophia', 'Brown', 'Canada', '1988-12-10', 22000.0, 'FEMALE'),
    ('James', 'Jones', 'UK', '1997-05-18', 15000.0, 'MALE'),
    ('Emma', 'Miller', 'Germany', '1991-04-25', 14000.0, 'FEMALE'),
    ('William', 'Davis', 'USA', '1989-11-03', 19000.0, 'MALE'),
    ('Olivia', 'Wilson', 'Canada', '1994-06-20', 17000.0, 'FEMALE');

