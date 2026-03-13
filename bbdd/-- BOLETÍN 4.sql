-- BOLETÍN 4
-- bbdd 5. BBDD Futbolistas con peso y altura
-- 1. Se quieren saber todos los campos/datos de los partidos que se hayan disputado entre el 01-01-2020 y el 31-01-2020.
select * from PARTIDOS where fecha BETWEEN'01-01-2020' and '31-01-2020';
-- 2. Devuelve todos los árbitros de los partidos sin repetir resultados.
 select DISTINCT arbitro from partidos;
-- 3. Se quiere saber el id y resultado de la tabla partidos en los que el resultado haya terminado en -00. Debes usar un alias de tabla para partidos, que sea p, y debes usarlo en tus columnas id y resultado.
SELECT p.id  ,p.resultado from partidos P where resultado like '%-00';
-- 4. Devuelve el id, árbitro y estadio de los partidos pero ordenado de la siguiente forma: 1º por estadio en orden descendente, luego por árbitro y finalmente por id descendente.
select id, arbitro, estadio from PARTIDOS order by ESTADIO desc, arbitro,id desc;
-- 5. Devuelve el nombre (solo mayúscula la primera letra), el presupuesto reducido en 250000 seguido por un espacio y la palabra euros,
-- el presupuesto actual seguido por un espacio y la palabra euros, y el presupuesto más el 10% del mismo seguido de un espacio y la palabra euros, 
--correspondiente a los equipos y ordenados por el presupuesto en orden descendente. Utiliza los siguientes alias de columna en este orden para los 
--presupuestos: "2022-23", "2023-24", "2024-25".
select initcap(nombre),presupuesto-250000 ||' euros' "2022-23"  ,presupuesto||' euros' "2022-23",presupuesto*1.10||' euros' "2022-23" from equipos order by presupuesto desc;
-- 6. Se quiere el nombre en minúsculas, la fecha de nacimiento y el salario dividido entre 12. Este salario debe redondearse para que tenga solo dos decimales, y concatenar usando la función CONCAT con un espacio y la palabra euros. Los resultados deben estar ordenados por orden descendete de salario de futbolista.
select lower(nombre), fecha_nacimiento, concat(round(salario/12,2),' euros') from futbolistas order by SALARIO desc;
-- 7. Devuelve el nombre (con tres caracteres) seguido de un "-" y el apellido de los fubtolistas en una columna que tenga por alias "NOM-APELLIDO" 
--(emplea la función CONCAT), y en otra columna el tamaño/número de caracteres del campo apellido de los futbolistas, usando el alias de columna "CARACTERES APELLIDO".
-- Debe ordenarse descendentemente por ese tamaño de caracteres de apellido.
select concat(concat(substr(nombre,1,3),' - '), apellidos) "NOM-APELLIDO",length(apellidos) "CARACTERES APELLIDO" from futbolistas order by length(apellidos) desc;
-- 8. Queremos un listado de los nombres de los futbolistas quitando los segundos nombres (nombres compuestos, por ejemplo, borrar LUIS de PEDRO LUIS, quedando solo PEDRO) y poner como alias de columna "SOLO NOMBRE".
select nvl(substr(nombre,1,instr(nombre,' ',1)-1), nombre)  "SOLO NOMBRE" from futbolistas;
-- 9. Devuelve el nombre del futbolista cuyo salario es el más bajo posible de todos los futbolistas nacidos entre 1985 y 1990.
select nombre from futbolistas where salario =(select min(salario) from futbolistas where trim(to_char(fecha_nacimiento,'yyyy')) between 1985 and 1990);
-- 10. Indica cuántos futbolistas que no juegan de portero tienen un apellido que termina en ez.
select count(*) from futbolistas where posicion = 'PORTERO' and apellidos like '%EZ';
select * from futbolistas;
-- 11. Devuelve el id del equipo con alias "id equipo", el número de futbolistas con alias "Número de futbolistas" y el salario medio redondeado a 2 decimales con alias "Salario medio" de los futbolistas agrupado por el equipo en el que juegan.
select id "id equipo", count(*) from futbolistas
-- 12. ¿Cuántos partitos ha jugado como local EQUIPO A? Debes usar el campo nombre de equipos.

-- 13. ¿Cuál es el nombre del equipo en el que juega el futbolista de menor peso?

-- 14. Devuelve en una única columna la fase: El futbolista NOMBRE juega en el equipo NOMBRE, correspondiendo al campo nombre de futbolista y de equipo
<<<<<<< HEAD
BEGIN
FOR cur_rec IN (SELECT table_name FROM user_tables)
LOOP
EXECUTE IMMEDIATE 'DROP TABLE ' || cur_rec.table_name || ' CASCADE CONSTRAINTS';
END LOOP;
END;
/
=======
ALTER SESSION SET nls_date_format='DD-MM-YYYY HH24:MI:SS';
DROP TABLE FUTBOLISTAS CASCADE CONSTRAINTS;
DROP TABLE EQUIPOS CASCADE CONSTRAINTS;
DROP TABLE PARTIDOS CASCADE CONSTRAINTS;

CREATE TABLE FUTBOLISTAS(
ID CHAR(6) PRIMARY KEY CHECK( REGEXP_LIKE( ID, 'F[0-9][0-9][0-9]20' )),
NOMBRE VARCHAR(100),
APELLIDOS VARCHAR(300),
FECHA_NACIMIENTO DATE,
POSICION VARCHAR(50) CHECK( POSICION LIKE 'PORTERO' OR POSICION LIKE 'DEFENSA' OR POSICION LIKE 'MEDIOCENTRO' OR POSICION LIKE 'DELANTERO' ),
SALARIO NUMBER(12,2) CHECK( SALARIO > 50000),
ID_EQUIPO INT
);

CREATE TABLE EQUIPOS(
ID INT PRIMARY KEY,
NOMBRE VARCHAR(100),
ESTADIO VARCHAR(100),
PRESUPUESTO NUMBER(20,2)
);

CREATE TABLE PARTIDOS(
ID INT PRIMARY KEY,
ARBITRO VARCHAR(200),
RESULTADO VARCHAR(5) CHECK( REGEXP_LIKE( RESULTADO, '[0-9][0-9]-[0-9][0-9]' )),
ESTADIO VARCHAR(100),
FECHA DATE,
ID_EQUIPO_CASA INT,
ID_EQUIPO_FUERA INT
);

ALTER TABLE FUTBOLISTAS
ADD CHECK (FECHA_NACIMIENTO > '31/DEC/1974');
ALTER TABLE FUTBOLISTAS
ADD FOREIGN KEY (ID_EQUIPO) REFERENCES EQUIPOS(ID);

ALTER TABLE PARTIDOS
ADD FOREIGN KEY (ID_EQUIPO_CASA) REFERENCES EQUIPOS(ID);
ALTER TABLE PARTIDOS
ADD FOREIGN KEY (ID_EQUIPO_FUERA) REFERENCES EQUIPOS(ID);

DELETE FROM EQUIPOS;
INSERT INTO EQUIPOS VALUES (1,'EQUIPO A', 'ESTADIO A',1000000);
INSERT INTO EQUIPOS VALUES (2,'EQUIPO B', 'ESTADIO B',2000000);
INSERT INTO EQUIPOS VALUES (3,'EQUIPO C', 'ESTADIO C',3000000);

DELETE FROM FUTBOLISTAS;
INSERT INTO FUTBOLISTAS VALUES ('F00120','PEDRO','GOMEZ','22/01/1980','PORTERO',100000,1);
INSERT INTO FUTBOLISTAS VALUES ('F00220','PEDRO LUIS','GOMEZ','20/04/1985','DEFENSA',110000,1);
INSERT INTO FUTBOLISTAS VALUES ('F00320','LUIS','GALVEZ','12/01/1990','DELANTERO',80000,1);
INSERT INTO FUTBOLISTAS VALUES ('F00420','ANTONIO','DOMINGUEZ','25/06/1981','PORTERO',340000,2);
INSERT INTO FUTBOLISTAS VALUES ('F00520','JESUS','FERNANDEZ','02/01/1995','MEDIOCENTRO',140000,2);
INSERT INTO FUTBOLISTAS VALUES ('F00620','DIEGO','DIAZ','05/04/1987','PORTERO',160000,2);
INSERT INTO FUTBOLISTAS VALUES ('F00720','PABLO','CARO','27/01/1988','DEFENSA',200000,3);
INSERT INTO FUTBOLISTAS VALUES ('F00820','ESTEBAN','BENITEZ','29/09/2000','DEFENSA',300000,3);
INSERT INTO FUTBOLISTAS VALUES ('F00920','ENRIQUE','ALVAREZ','30/09/2001','MEDIOCENTRO',120000,3);

DELETE FROM PARTIDOS;
INSERT INTO PARTIDOS VALUES (1,'ARBITRO A','00-00','ESTADIO A','01/01/2020',1,2);
INSERT INTO PARTIDOS VALUES (2,'ARBITRO B','01-00','ESTADIO A','08/01/2020',1,3);
INSERT INTO PARTIDOS VALUES (3,'ARBITRO C','01-01','ESTADIO B','15/01/2020',2,3);
INSERT INTO PARTIDOS VALUES (4,'ARBITRO B','02-00','ESTADIO B','22/01/2020',2,1);
INSERT INTO PARTIDOS VALUES (5,'ARBITRO A','04-01','ESTADIO C','29/01/2020',3,1);
INSERT INTO PARTIDOS VALUES (6,'ARBITRO A','03-03','ESTADIO C','05/02/2020',3,2);

UPDATE FUTBOLISTAS SET ID_EQUIPO = 2 WHERE ID LIKE 'F00120';
UPDATE FUTBOLISTAS SET ID_EQUIPO = 3 WHERE ID LIKE 'F00420';
UPDATE FUTBOLISTAS SET ID_EQUIPO = 1 WHERE ID LIKE 'F00920';

DELETE FROM FUTBOLISTAS WHERE ID LIKE 'F00120' OR ID LIKE 'F00420';

ALTER TABLE FUTBOLISTAS
ADD ALTURA INT;
ALTER TABLE FUTBOLISTAS
ADD PESO NUMBER(4,1);
UPDATE FUTBOLISTAS SET ALTURA = 179, PESO = 76 WHERE NOMBRE LIKE 'PEDRO
LUIS';
UPDATE FUTBOLISTAS SET ALTURA = 174, PESO = 71.5 WHERE NOMBRE LIKE 'LUIS';
UPDATE FUTBOLISTAS SET ALTURA = 169, PESO = 66 WHERE NOMBRE LIKE 'JESUS';
UPDATE FUTBOLISTAS SET ALTURA = 189, PESO = 82 WHERE NOMBRE LIKE 'DIEGO';
UPDATE FUTBOLISTAS SET ALTURA = 183, PESO = 84 WHERE NOMBRE LIKE 'PABLO';
UPDATE FUTBOLISTAS SET ALTURA = 180, PESO = 81.5 WHERE NOMBRE LIKE
'ESTEBAN';
UPDATE FUTBOLISTAS SET ALTURA = 162, PESO = 60 WHERE NOMBRE LIKE 'ENRIQUE';
>>>>>>> 4554b7b2ddb0496ee282b3cbe2690c866e1facd2
