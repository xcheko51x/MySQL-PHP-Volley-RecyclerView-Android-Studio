CREATE DATABASE Equipos;

USE Equipos;

CREATE TABLE equipos(
  nombre varchar(100) NOT NULL PRIMARY KEY,
  escudo varchar(100),
  descripcion varchar(150)
);
