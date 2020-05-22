DROP DATABASE if exists bancoimagenes;

CREATE DATABASE bancoimagenes;

USE bancoimagenes;

DROP TABLE if exists clientes;
DROP TABLE if exists imagenes; 

CREATE TABLE clientes
	(
		codigo int(11) PRIMARY KEY AUTO_INCREMENT,
		nombre varChar(20),
		apellidos varChar(20),
		usuario varchar(20),
		contrasena varchar(500)
	) Engine = InnoDB;

CREATE TABLE imagenes
	(
		codigo int(11) PRIMARY KEY AUTO_INCREMENT,
		titulo varchar(20),
		categoria varchar(20),
		descripcion varChar(50),
		ruta varChar(500),
		codcliente int(11),
		FOREIGN KEY (codcliente)
			REFERENCES clientes (codigo)
				ON DELETE CASCADE ON UPDATE CASCADE
	) Engine = InnoDB;

INSERT INTO clientes VALUES (NULL, "Francisco", "Garcia Cordoba", "Ciscu24", "1fc819fe24143b7e9e62f24054d9801cae2b0f88540a749efc2b19b678f6a91086d034635741c59ed3fe5c8fb5b2a0cb6c3228facce6ab5a6da4e331d9dc3cf6");


INSERT INTO imagenes VALUES (NULL, "Windows", "PC", "Fondo de Windows", "utils\\img\\Imagen01.png", "1");
INSERT INTO imagenes VALUES (NULL, "Prisma", "PC", "Fondo de Pantalla en HD", "utils\\img\\Imagen02.png", "1");
INSERT INTO imagenes VALUES (NULL, "Dinosaurio", "Wallpaper", "Ojo de Dinosaurio HD", "utils\\img\\Imagen03.png", "1");
INSERT INTO imagenes VALUES (NULL, "Ubuntu", "PC", "Fondo de Pantalla de Ubuntu", "utils\\img\\Imagen04.png", "1");
INSERT INTO imagenes VALUES (NULL, "Lucha Infernal", "Wallpaper", "Fondo de Pantalla HD", "utils\\img\\Imagen05.png", "1");
INSERT INTO imagenes VALUES (NULL, "Leon Imperial", "Wallpaper", "Fondo de un Leon HD", "utils\\img\\Imagen06.png", "1");
INSERT INTO imagenes VALUES (NULL, "Gato Flama", "Avatar", "Fondo de Pantalla de un Gato con Gafas HD", "utils\\img\\Imagen07.png", "1");
INSERT INTO imagenes VALUES (NULL, "New Planet", "Wallpaper", "Fondo de Pantalla de un Planeta HD", "utils\\img\\Imagen08.png", "1");
