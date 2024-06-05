
-- DROP DATABASE SenderosUV;

CREATE TABLE zona(
	id_zona SERIAL,
	nombre VARCHAR (50),
	PRIMARY KEY (id_zona)
);
	
CREATE TABLE sendero(
	id_sendero SERIAL,
	nombre VARCHAR (50),
	sede VARCHAR (50),
	anio_fundacion date,
	id_zona INT,
	url_recursos VARCHAR(255),
    PRIMARY KEY (id_sendero)
);

CREATE TABLE zona_sendero(
	id_zona INT,
	id_sendero INT,
	
	FOREIGN KEY (id_zona) REFERENCES zona(id_zona),
	FOREIGN KEY (id_sendero) REFERENCES sendero(id_sendero)
);

CREATE TABLE estacion(
	id_estacion SERIAL,
	numero INT,
	nombre VARCHAR (50),
	descripcion VARCHAR (200),
	latitud VARCHAR (20),
	longitud VARCHAR (20),
	PRIMARY KEY (id_estacion)
);


CREATE TABLE sendero_estacion(
	id_sendero INT,
	id_estacion INT,
	
	FOREIGN KEY (id_sendero) REFERENCES sendero(id_sendero),
	FOREIGN KEY (id_estacion) REFERENCES estacion(id_estacion)
);


CREATE TABLE usuario(
	id_usuario SERIAL,
	nombre VARCHAR (20),
	contrasena VARCHAR (20),
	id_rol_usuario int,
	PRIMARY KEY (id_usuario)
);

CREATE TABLE rol_usuario(
	id_rol_usuario SERIAL,
	rol_usuario VARCHAR (20),
	PRIMARY KEY (id_rol_usuario)
);

INSERT INTO rol_usuario (rol_usuario) 
VALUES 
    ('Administrador'),
    ('Editor');

INSERT INTO usuario (nombre, contrasena, id_rol_usuario) 
VALUES 
    ('Admin', '123', 1),
    ('Eddy', '123', 2),
    ('Eddy2', '123', 2);

INSERT INTO zona (nombre) 
VALUES 
    ('Xalapa'),
    ('Veracruz'),
    ('Orizaba-Córdoba'),
    ('Poza Rica-Tuxpan'),
    ('Coatzacoalcos-Minatitlán');

/*
DROP TABLE rol_usuario;
DROP TABLE usuario;
DROP TABLE sendero_estacion;
DROP TABLE estacion;
DROP TABLE zona_sendero;
DROP TABLE sendero;
DROP TABLE zona;

*/

