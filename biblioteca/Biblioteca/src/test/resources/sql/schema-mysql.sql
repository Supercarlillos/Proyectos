DROP TABLE  prestamo;
ALTER TABLE  libro DROP PRIMARY KEY;
ALTER TABLE  usuario DROP PRIMARY KEY;
--ALTER TABLE  usuario DROP INDEX numsocio;
DROP TABLE  usuario;
DROP TABLE  libro;

CREATE TABLE libro(
	identificador BIGINT NOT NULL auto_increment,
	isbn VARCHAR(50) NOT NULL,
	titulo VARCHAR(50) NOT NULL,
	autor VARCHAR(50) NOT NULL,
	sipnosis VARCHAR(50) NOT NULL,
	PRIMARY KEY (identificador),
	INDEX (identificador))
	ENGINE = INNODB;
	
CREATE TABLE usuario(
	numsocio BIGINT NOT NULL auto_increment,
	dni VARCHAR(9) NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	apellidos VARCHAR(50) NOT NULL,
	telefono INT(9) NOT NULL,
	PRIMARY KEY (numsocio),
	INDEX (numsocio))
	ENGINE = INNODB;
	
CREATE TABLE prestamo(
	identificador BIGINT NOT NULL,
	numsocio BIGINT NOT NULL,
	fechasalida DATE NOT NULL,
	fechalimiteentrega DATE NOT NULL,
	fechaentrega DATE,
	PRIMARY KEY(identificador,numsocio),
	INDEX (identificador,numsocio),
	FOREIGN KEY (identificador) REFERENCES libro(identificador),
	FOREIGN KEY (numsocio) REFERENCES usuario(numsocio)
	) ENGINE = INNODB;

