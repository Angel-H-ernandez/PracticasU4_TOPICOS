-h localhost -u root -p;
--host localhost user root paswoord 123456
CREATE DATABASE DBPracticasU4;
use DBPracticasU4;
CREATE TABLE alumno();
CREATE TABLE alumno(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50),
    Calif1 INT,
    Calif2 INT,
    Calif3 INT,
    Promedio FLOAT);