# Proyecto Integrador Fase I


<p align="center">
  <img src="https://static.educacionit.com/educacionit/assets/imagotype-it-fill-v2-color.svg" alt="Educacion IT" width=500>
</p><br>



### Descripción del Proyecto
Este proyecto se centra en el desarrollo de una aplicación en Java que permite buscar películas por título o género, mostrar un listado de películas y obtener información detallada de una película seleccionada. Además, se utiliza una base de datos para almacenar información sobre las películas y se aplica el patrón de diseño DAO para interactuar con la base de datos.

### Pasos Realizados

1. **Creación del Repositorio Git**
   - Se creó una cuenta en GitHub.
   - Se creó el repositorio "Proyecto Integrador Fase I" en GitHub.

2. **Generación del Proyecto Localmente y Subida al Repositorio**
   - Se utilizó la herramienta `create-java-app` para generar el esqueleto del proyecto.
   - Se repasaron los comandos de Git para inicializar el repositorio local, agregar archivos, hacer commits y empujar los cambios al repositorio remoto en GitHub.

3. **Diseño del Programa de Búsqueda de Películas**
   - Se diseñó un programa en Java que permite buscar películas por título o género.

4. **Implementación de la Funcionalidad de Búsqueda y Visualización de Películas**
   - Se implementó la funcionalidad para mostrar un listado de películas después de realizar la búsqueda y permitir al usuario ver información detallada de una película seleccionada mediante su código.

5. **Uso de Proyectos Maven, Colecciones y Separación en Paquetes**
   - Se utilizó Maven para gestionar las dependencias del proyecto.
   - Se organizó el código en paquetes para una mejor estructuración y mantenimiento.

6. **Utilización de una Base de Datos**
   - Se crearon las tablas necesarias en una base de datos para almacenar información sobre las películas.
   - Se adjuntó en el proyecto un script SQL que crea la base de datos y las tablas utilizadas.

7. **Aplicación del Patrón de Diseño DAO**
   - Se implementó el patrón de diseño DAO para realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar) sobre la tabla de películas en la base de datos.

8. **Trabajo con Git y Ramas**
   - Se crearon diferentes ramas en el repositorio Git para representar las diferentes características desarrolladas.
   - Se fusionaron las ramas de características en la rama principal a medida que se completaban las funcionalidades.

### Opcional
- Se investigó y utilizó Markdown para editar el archivo `README.md`.
- Se agregó una descripción del proyecto, las tecnologías utilizadas, el script de la base de datos, la versión de Java utilizada, el autor del proyecto y un enlace a una red social del autor (LinkedIn).

### Tecnologías Utilizadas
- Java
- Maven
- Git
- MySQL

### Versión de Java Utilizada
Java 11

### Autor del Proyecto
Alejandro Daniel Di Stefano


---


### Script de la Base de Datos

```sql
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



```

<br><p align="center">
<img src="https://1000logos.net/wp-content/uploads/2020/09/Java-Logo.png" alt="Java" width=500></p>

<p align="center"> 
 <a href="#" target="_blank"> 
     <img src="https://cdn.icon-icons.com/icons2/2699/PNG/512/mysql_official_logo_icon_169938.png" alt="sql" height="100"/>
  </a> 
    &nbsp &nbsp &nbsp
 <a href="#" target="_blank"> 
  <img src="https://miro.medium.com/v2/resize:fit:1100/0*5FEJ7emIEAxZRCQF" alt="spring-boot"  height="100"/>
 </a> 
 </p>&nbsp
 <p align="center"> 
 <a href="#" target="_blank"> 
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original-wordmark.svg" alt="html5" width="120" />
  </a> 
  <a href="#" target="_blank">  
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original-wordmark.svg" alt="css3" width="120" />
 </a> 
 <a href="#" target="_blank">  
  <img src="https://cdn.icon-icons.com/icons2/2415/PNG/512/javascript_original_logo_icon_146455.png" alt="javascript" width="120" />
 </a> 
 </p>&nbsp
  <p align="center"> 
<a href="#" target="_blank"> 
  <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="120" /> 
  </a>
   &nbsp
  <a href="#" target="_blank"> 
  <img src="https://static-00.iconduck.com/assets.00/eclipse-icon-512x479-6ivkqawb.png" alt="Eclipse" width="120" /> 
  </a> 
   &nbsp
  <a href="#" target="_blank"> 
  <img src="https://static.educacionit.com/d/q_80/tecnologias/apache-maven/logo-color.svg" alt="Apache Maven" width="120" /> 
  </a> 
</p>&nbsp

---
