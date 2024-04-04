USE senderosuv;
-- DROP DATABASE senderosuv;

CREATE TABLE zona(
	id_zona INT NOT null AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR (50)
);

CREATE TABLE sede(
	id_sede INT NOT null AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR (50)
);
	
CREATE TABLE sendero(
	id_sendero INT NOT null AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR (50),
	id_sede int,
	anio_fundacion date,
	id_zona INT,
    
    FOREIGN KEY (id_sede) REFERENCES sede(id_sede)
);

CREATE TABLE zona_sendero(
	id_zona INT,
	id_sendero INT,
	
	FOREIGN KEY (id_zona) REFERENCES zona(id_zona),
	FOREIGN KEY (id_sendero) REFERENCES sendero(id_sendero)
);

CREATE TABLE estacion(
	id_estacion INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	numero INT,
	nombre VARCHAR (50),
	descripcion VARCHAR (200),
	latitud VARCHAR (20),
	longitud VARCHAR (20)
);

CREATE TABLE cartel (
	id_cartel INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	descripcion VARCHAR (200)
);

CREATE TABLE tipo_recurso (
	id_tipo_recurso INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	tipo VARCHAR (20)
);

CREATE TABLE recurso (
	id_recurso INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	url VARCHAR (100),
    creditos varchar (100),
    id_tipo_recurso INT,
    
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

