-- Crear la base de datos
CREATE DATABASE turnos_db;
USE turnos_db;

-- Crear la tabla ciudadano
CREATE TABLE ciudadano (
    idCiudadano BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL
);

-- Crear la tabla tramite
CREATE TABLE tramite (
    idTramite BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Crear la tabla intermedia para la relación Many-to-Many entre ciudadano y tramite
CREATE TABLE ciudadano_tramite (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    idCiudadano BIGINT NOT NULL,
    idTramite BIGINT NOT NULL,
    FOREIGN KEY (idCiudadano) REFERENCES ciudadano(idCiudadano) ON DELETE CASCADE,
    FOREIGN KEY (idTramite) REFERENCES tramite(idTramite) ON DELETE CASCADE,
    UNIQUE (idCiudadano, idTramite) 
);

-- Crear la tabla turnos
CREATE TABLE turno (
    idTurno BIGINT AUTO_INCREMENT PRIMARY KEY,
    idCiudadano BIGINT NOT NULL,
    fecha DATE NOT NULL,
    estado ENUM('atendido', 'espera') NOT NULL,
    FOREIGN KEY (idCiudadano) REFERENCES ciudadano(idCiudadano) ON DELETE CASCADE
);

-- Insertar ciudadanos
INSERT INTO ciudadano (nombre, apellido)
VALUES 
('Juan', 'Pérez'),
('María', 'González'),
('Carlos', 'López'),
('Ana', 'Martínez'),
('Lucía', 'Ramírez');

-- Insertar tipos de trámites
INSERT INTO tramite (nombre)
VALUES 
('Renovación de DNI'),
('Actualización de domicilio'),
('Solicitud de pasaporte'),
('Inscripción al programa social'),
('Consulta tributaria');

-- Asignar tipos de trámites a ciudadanos (Many-to-Many)
INSERT INTO ciudadano_tramite (idCiudadano, idTramite)
VALUES 
(1, 1),
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(5, 1),
(5, 3);

-- Insertar turnos para ciudadanos (One-to-Many)
INSERT INTO turno (idCiudadano, fecha, estado)
VALUES 
(1, '2025-01-18', 'espera'),
(1, '2025-01-20', 'atendido'),
(2, '2025-01-19', 'espera'),
(3, '2025-01-21', 'espera'),
(4, '2025-01-22', 'espera'),
(5, '2025-01-23', 'atendido');
