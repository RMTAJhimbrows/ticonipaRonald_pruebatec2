CREATE DATABASE entidad_gob;
USE entidad_gob;

-- Dropping and creating the 'usuario' table
DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,   -- Unique identifier for the user
  `nombre` varchar(255) NOT NULL,      -- First name of the user
  `apellido` varchar(255) NOT NULL,    -- Last name of the user
  PRIMARY KEY (`id`)                   -- Primary key is 'id'
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Inserting sample data into 'usuario' table
INSERT INTO `usuario` VALUES 
(1,'Juan','Pérez'),
(2,'María','Gómez'),
(3,'Luis','Martínez'),
(4,'Ana','López'),
(5,'Carlos','Fernández'),
(6,'Sofía','Ramírez'),
(7,'Pedro','Hernández'),
(8,'Laura','Torres'),
(9,'Jorge','Méndez'),
(10,'Elena','Cruz'),
(11,'pipo','pipa'),
(12,'pipo','pipas'),
(13,'manu','kike'),
(14,'kikko','kike'),
(15,'manu','Torrez'),
(16,'pepe','kike');

-- Dropping and creating the 'tramite' table
DROP TABLE IF EXISTS `tramite`;

CREATE TABLE `tramite` (
  `id` int NOT NULL AUTO_INCREMENT,   -- Unique identifier for the process
  `nombre` varchar(255) NOT NULL,      -- Name of the process (e.g., "Solicitud de Pasaporte")
  PRIMARY KEY (`id`)                   -- Primary key is 'id'
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Inserting sample data into 'tramite' table
INSERT INTO `tramite` VALUES 
(1, 'Solicitud de Pasaporte'),
(2, 'Renovación de Licencia de Conducir'),
(3, 'Registro de Nacimiento'),
(4, 'Actualización de INE'),
(5, 'Pago de Impuestos');

-- Dropping and creating the 'turno' table
DROP TABLE IF EXISTS `turno`;

CREATE TABLE `turno` (
  `id` int NOT NULL AUTO_INCREMENT,      -- Unique identifier for the appointment
  `codigo` int NOT NULL,                 -- Appointment code (unique identifier for the turn)
  `fecha` date NOT NULL,                 -- Date of the appointment
  `estado` enum('ATENDIDO','ESPERA') NOT NULL,  -- Status of the appointment (ATENDIDO or ESPERA)
  `usuario_id` int NOT NULL,             -- Foreign key to the 'usuario' table (user)
  `tramite_id` int NOT NULL,             -- Foreign key to the 'tramite' table (process)
  PRIMARY KEY (`id`),                    -- Primary key is 'id'
  KEY `usuario_id` (`usuario_id`),       -- Index for 'usuario_id'
  KEY `tramite_id` (`tramite_id`),       -- Index for 'tramite_id'
  CONSTRAINT `turno_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),  -- Foreign key constraint to 'usuario'
  CONSTRAINT `turno_ibfk_2` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`)   -- Foreign key constraint to 'tramite'
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Inserting sample data into 'turno' table
INSERT INTO `turno` VALUES 
(1,1001,'2025-01-20','ESPERA',1,1),
(2,1002,'2025-01-21','ATENDIDO',2,2),
(3,1003,'2025-01-21','ESPERA',3,3),
(4,1004,'2025-01-22','ATENDIDO',4,4),
(5,1005,'2025-01-22','ESPERA',5,5),
(6,1006,'2025-01-23','ESPERA',6,1),
(7,1007,'2025-01-23','ATENDIDO',7,2),
(8,1008,'2025-01-24','ESPERA',8,3),
(9,1009,'2025-01-24','ATENDIDO',9,4),
(10,1010,'2025-01-25','ESPERA',10,5),
(11,1011,'2025-01-26','ESPERA',4,3),
(12,1012,'2025-01-25','ESPERA',3,5),
(13,1013,'2025-01-31','ESPERA',11,1),
(14,1014,'2025-01-30','ESPERA',14,3),
(15,1015,'2025-01-24','ESPERA',7,2),
(16,1016,'2025-01-25','ESPERA',3,3),
(17,1017,'2025-01-25','ESPERA',16,4);

-- End of dump
