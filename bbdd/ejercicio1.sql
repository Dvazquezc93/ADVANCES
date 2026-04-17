create table categorias(
    codigo int PRIMARY key,
    descripcion varchar2(50)
);
create table productos(
    id int primary key,
    Nombre varchar2(50),
    Precio number(1,13)
);
alter table productos MODIFY precio number(3,1);
create table videojuegos(
    id int primary key,
    nombre varchar2(50),
    precio number(6,2)
);
CREATE TABLE ESTUDIANTES (
    codigo           NUMBER PRIMARY KEY,
    dni              VARCHAR2(10),
    nombre           VARCHAR2(50),
    apellidos        VARCHAR2(50),
    fecha_nacimiento DATE
);

INSERT INTO ESTUDIANTES (codigo,dni, nombre, apellidos, fecha_nacimiento)
VALUES (1,'75812952P', 'Ricardo','Lopez Lopez', to_date('10/10/1999','dd/mm/yyyy'));

INSERT INTO ESTUDIANTES (codigo,dni, nombre, apellidos, fecha_nacimiento)
VALUES (2,'48956895Q', 'Marta','Carrasco Perez', to_date('10/10/1998','dd/mm/yyyy'));

INSERT INTO ESTUDIANTES (codigo,dni, nombre, apellidos, fecha_nacimiento)
VALUES (3,'58268587L', 'Blanca','Baron Santos', to_date('01/05/1999','dd/mm/yyyy'));

INSERT INTO ESTUDIANTES (codigo, dni, nombre, apellidos, fecha_nacimiento)
VALUES (4,'28388914P', 'Ana','Ramirez Gomez', to_date('08/04/1999','dd/mm/yyyy'));

INSERT INTO ESTUDIANTES (codigo, dni, nombre, apellidos, fecha_nacimiento)
VALUES (5,'97898989T', 'Marta','Valencia Cabello', to_date('15/06/1999','dd/mm/yyyy'));


CREATE TABLE ASIGNATURAS(
    codigo          NUMBER(10) PRIMARY KEY,
    curso           NUMBER(1),
    descripcion     VARCHAR2(50),
    profesor        VARCHAR2(50)
);

INSERT INTO ASIGNATURAS VALUES (1,1,'Redes','Elena Perez');
INSERT INTO ASIGNATURAS VALUES (2,1,'Gestion de Base de datos','Ricardo Del Valle');
INSERT INTO ASIGNATURAS VALUES (3,1,'Social','Sofia Islas');
INSERT INTO ASIGNATURAS VALUES (4,1,'Matematicas','Federico Lopez');
INSERT INTO ASIGNATURAS VALUES (5,1,'Ingles','Dolores Martin');

INSERT INTO ASIGNATURAS VALUES (6,2,'Educacion Fisica','David Gomez');
INSERT INTO ASIGNATURAS VALUES (7,2,'Musica','Teresa Jimenez');
INSERT INTO ASIGNATURAS VALUES (8,2,'Lengua','Pepa de la Puerta');
INSERT INTO ASIGNATURAS VALUES (9,2,'Natural','Inma Alonso');
INSERT INTO ASIGNATURAS VALUES (10,2,'Aleman','Marta Jimenez');


CREATE TABLE MATRICULAS(
    cod_alumno      NUMBER(10),
    cod_asignatura  NUMBER(10),
    nota            VARCHAR2(4),
    PRIMARY KEY (cod_alumno,cod_asignatura),
    FOREIGN KEY (cod_alumno) REFERENCES estudiantes(codigo),
    FOREIGN KEY (cod_asignatura) REFERENCES ASIGNATURAS(codigo)
);

INSERT INTO MATRICULAS VALUES (1,1,4.5);
INSERT INTO MATRICULAS VALUES (1,2,5);
INSERT INTO MATRICULAS VALUES (1,3,8);
INSERT INTO MATRICULAS VALUES (2,2,6);
INSERT INTO MATRICULAS VALUES (2,6,9);
INSERT INTO MATRICULAS VALUES (2,9,8);
INSERT INTO MATRICULAS VALUES (3,5,10);
INSERT INTO MATRICULAS VALUES (3,8,9);
INSERT INTO MATRICULAS VALUES (4,2,10);
INSERT INTO MATRICULAS VALUES (4,4,9);
INSERT INTO MATRICULAS VALUES (4,6,4);
INSERT INTO MATRICULAS VALUES (4,8,6);
INSERT INTO MATRICULAS VALUES (5,5,10);
INSERT INTO MATRICULAS VALUES (5,6,9);
INSERT INTO MATRICULAS VALUES (5,7,10);
INSERT INTO MATRICULAS VALUES (5,9,6);

commit;
Update personas set fecha_nacimiento ='26/02/95' where dni ='77884422F';
select * from personas;