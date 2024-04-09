-- Script SQL para crear la base de datos y las tablas de películas

CREATE DATABASE IF NOT EXISTS peliculas_db;

USE peliculas_db;

CREATE TABLE IF NOT EXISTS peliculas (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    url VARCHAR(255),
    imagen_promocional VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS generos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL    
);

CREATE TABLE IF NOT EXISTS pelicula_genero (
    id_pelicula INT,
	id_genero INT,
PRIMARY KEY (id_pelicula, id_genero),
FOREIGN KEY (id_pelicula) REFERENCES peliculas(codigo),
FOREIGN KEY (id_genero) REFERENCES generos(id)  
);


INSERT INTO peliculas (titulo, url, imagen_promocional)
VALUES ('Mad Max', 'https://www.youtube.com/watch?v=2OEGx_yIS6M', 'https://assets.afcdn.com/album/D20160812/phalbm24886928_w320cxt0cyt0cxb809cyb1200.webp'),
       ('Ted', 'https://www.youtube.com/watch?v=bWcVNC6bcE0', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRrz83rBUFZYah8aa67ycnf5-mrrLU7mpyeuEgISsjMPQ&s'),
       ('The Shawshank Redemption', 'https://www.youtube.com/watch?v=6hB3S9bIaco', 'https://m.media-amazon.com/images/I/51BgHp0VYxL._AC_.jpg'),    
		('The Godfather', 'https://www.youtube.com/watch?v=sY1S34973zA', 'https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg'),
		('The Dark Knight', 'https://www.youtube.com/watch?v=EXeTwQWrcwY', 'https://m.media-amazon.com/images/S/pv-target-images/e9a43e647b2ca70e75a3c0af046c4dfdcd712380889779cbdc2c57d94ab63902.jpg'),    
		('Schindler\'s List', 'https://www.youtube.com/watch?v=gG22XNhtnoY', 'https://www.tematika.com/media/catalog/Ilhsa/Imagenes/666871.jpg'),    
		('The Lord of the Rings: The Return of the King', 'https://www.youtube.com/watch?v=4fxfIvWheh0', 'https://goldenglobes.com/wp-content/uploads/2023/10/the_lord_of_the_rings_the_return_of_the_king_2003.jpg'),    
		('Pulp Fiction', 'https://www.youtube.com/watch?v=s7EdQ4FqbhY', 'https://m.media-amazon.com/images/I/81UTs3sC5hL._AC_UF894,1000_QL80_.jpg'),
		('Forrest Gump', 'https://www.youtube.com/watch?v=bLvqoHBptjg', 'https://m.media-amazon.com/images/S/pv-target-images/2d0c9e38968936e6711c7fb2bc7895b82d8bb9178b5a854e14dffa4b17b88487.jpg'),
		('Fight Club', 'https://www.youtube.com/watch?v=BdJKm16Co6M', 'https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/media/image/2016/12/club-lucha.jpg?tf=384x'),
		('Inception', 'https://www.youtube.com/watch?v=YoHD9XEInc0', 'https://m.media-amazon.com/images/I/912AErFSBHL._AC_UF894,1000_QL80_.jpg'),
		('The Matrix', 'https://www.youtube.com/watch?v=m8e-FF8MsqU', 'https://static.wikia.nocookie.net/doblaje/images/7/7a/Matrix.jpg/revision/latest?cb=20210703005220&path-prefix=es');

SELECT * FROM peliculas;

INSERT INTO generos (nombre)
VALUES 
	('Acción'),
	('Aventura'),
	('Comedia'),
	('Drama'),
	('Crimen'),
	('Biografía'),
	('Historia'),
	('Fantasía'),
	('Romance'),
	('Ciencia ficción');

-- Insertar relaciones entre películas y géneros en la tabla pelicula_genero

-- Mad Max
INSERT INTO pelicula_genero (id_pelicula, id_genero)
SELECT codigo, id
FROM peliculas
CROSS JOIN generos
WHERE titulo = 'Mad Max' AND nombre IN ('Acción', 'Aventura');

-- Ted
INSERT INTO pelicula_genero (id_pelicula, id_genero)
SELECT codigo, id
FROM peliculas
CROSS JOIN generos
WHERE titulo = 'Ted' AND nombre IN ('Comedia');

-- The Shawshank Redemption
INSERT INTO pelicula_genero (id_pelicula, id_genero)
SELECT codigo, id
FROM peliculas
CROSS JOIN generos
WHERE titulo = 'The Shawshank Redemption' AND nombre IN ('Drama');

-- The Godfather
INSERT INTO pelicula_genero (id_pelicula, id_genero)
SELECT codigo, id
FROM peliculas
CROSS JOIN generos
WHERE titulo = 'The Godfather' AND nombre IN ('Drama', 'Crimen');

-- The Dark Knight
INSERT INTO pelicula_genero (id_pelicula, id_genero)
SELECT codigo, id
FROM peliculas
CROSS JOIN generos
WHERE titulo = 'The Dark Knight' AND nombre IN ('Acción', 'Crimen', 'Drama');

-- Schindler's List
INSERT INTO pelicula_genero (id_pelicula, id_genero)
SELECT codigo, id
FROM peliculas
CROSS JOIN generos
WHERE titulo = 'Schindler\'s List' AND nombre IN ('Biografía', 'Drama', 'Historia');

-- The Lord of the Rings: The Return of the King
INSERT INTO pelicula_genero (id_pelicula, id_genero)
SELECT codigo, id
FROM peliculas
CROSS JOIN generos
WHERE titulo = 'The Lord of the Rings: The Return of the King' AND nombre IN ('Aventura', 'Drama', 'Fantasía');

-- Pulp Fiction
INSERT INTO pelicula_genero (id_pelicula, id_genero)
SELECT codigo, id
FROM peliculas
CROSS JOIN generos
WHERE titulo = 'Pulp Fiction' AND nombre IN ('Crimen', 'Drama');

-- Forrest Gump
INSERT INTO pelicula_genero (id_pelicula, id_genero)
SELECT codigo, id
FROM peliculas
CROSS JOIN generos
WHERE titulo = 'Forrest Gump' AND nombre IN ('Drama', 'Romance');

-- Fight Club
INSERT INTO pelicula_genero (id_pelicula, id_genero)
SELECT codigo, id
FROM peliculas
CROSS JOIN generos
WHERE titulo = 'Fight Club' AND nombre IN ('Drama');

-- Inception
INSERT INTO pelicula_genero (id_pelicula, id_genero)
SELECT codigo, id
FROM peliculas
CROSS JOIN generos
WHERE titulo = 'Inception' AND nombre IN ('Acción', 'Aventura', 'Ciencia ficción');

-- The Matrix
INSERT INTO pelicula_genero (id_pelicula, id_genero)
SELECT codigo, id
FROM peliculas
CROSS JOIN generos
WHERE titulo = 'The Matrix' AND nombre IN ('Acción', 'Ciencia ficción');

