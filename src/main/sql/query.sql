USE SenderosUV;
-- DROP DATABASE senderosuv;
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

CREATE TABLE zona(
	id_zona SERIAL,
	nombre VARCHAR (50),
	PRIMARY KEY (id_zona)
);

CREATE TABLE sede(
	id_sede SERIAL,
	nombre VARCHAR (50),
	PRIMARY KEY (id_sede)
);
	
CREATE TABLE sendero(
	id_sendero SERIAL,
	nombre VARCHAR (50),
	id_sede int,
	anio_fundacion date,
	id_zona INT,
    PRIMARY KEY (id_sendero),
    FOREIGN KEY (id_sede) REFERENCES sede(id_sede)
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

CREATE TABLE cartel (
	id_cartel SERIAL,
	descripcion VARCHAR (200),
	PRIMARY KEY (id_cartel)
);

CREATE TABLE tipo_recurso (
	id_tipo_recurso SERIAL,
	tipo VARCHAR (20),
	PRIMARY KEY (id_tipo_recurso)
);

CREATE TABLE recurso (
	id_recurso SERIAL,
	url VARCHAR (100),
    creditos varchar (100),
    id_tipo_recurso INT,
    
	PRIMARY KEY (id_recurso),
    FOREIGN KEY (id_tipo_recurso) REFERENCES tipo_recurso(id_tipo_recurso)
);

CREATE TABLE sendero_estacion(
	id_sendero INT,
	id_estacion INT,
	
	FOREIGN KEY (id_sendero) REFERENCES sendero(id_sendero),
	FOREIGN KEY (id_estacion) REFERENCES estacion(id_estacion)
);

CREATE TABLE estacion_cartel(
	id_estacion INT,
	id_cartel INT,
	
	FOREIGN KEY (id_estacion) REFERENCES estacion(id_estacion),
	FOREIGN KEY (id_cartel) REFERENCES cartel(id_cartel)
);

CREATE TABLE  cartel_recurso(
	id_cartel INT,
	id_recurso INT,
	
	FOREIGN KEY (id_cartel) REFERENCES cartel(id_cartel),
	FOREIGN KEY (id_recurso) REFERENCES recurso(id_recurso)
);

INSERT INTO rol_usuario (rol_usuario) VALUES ('admin');
INSERT INTO rol_usuario (rol_usuario) VALUES ('editor');
INSERT INTO usuario (nombre, contrasena, id_rol_usuario) VALUES ('Administrador', 'password123', 1);
/*
DROP TABLE cartel_recurso;
DROP TABLE estacion_cartel;
DROP TABLE sendero_estacion;
DROP TABLE recurso;
DROP TABLE tipo_recurso;
DROP TABLE cartel;
DROP TABLE estacion;
DROP TABLE zona_sendero;
DROP TABLE sendero;
DROP TABLE sede;
DROP TABLE zona;
DROP TABLE usuario;
*/

