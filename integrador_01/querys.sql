-- Script SQL para crear la base de datos y las tablas de películas

CREATE DATABASE IF NOT EXISTS peliculas_db;

USE peliculas_db;

CREATE TABLE IF NOT EXISTS peliculas (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    url VARCHAR(255),
    imagen_promocional VARCHAR(255),
    generos VARCHAR(255)
);

INSERT INTO peliculas (titulo, url, imagen_promocional, generos)
VALUES ('Mad Max', 'https://www.youtube.com/watch?v=2OEGx_yIS6M', 'https://assets.afcdn.com/album/D20160812/phalbm24886928_w320cxt0cyt0cxb809cyb1200.webp', 'Acción, Aventura'),
       ('Ted', 'https://www.youtube.com/watch?v=bWcVNC6bcE0', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRrz83rBUFZYah8aa67ycnf5-mrrLU7mpyeuEgISsjMPQ&s', 'Comedia');
       
       SELECT * FROM peliculas;