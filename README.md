## Proyecto Integrador Fase I


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
Java 1.8

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
    imagen_promocional VARCHAR(255),
    generos VARCHAR(255)
);
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