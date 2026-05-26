create table  pilotos ( 
    id int primary key,
    nombre VARCHAR2(50),
    apellidos VARCHAR2(50),
    fecha_nacimiento date,
    nacionalidad VARCHAR2(50) ,
    id_rol int,
    id_equipo int
);
create table  Equiposp ( 
    id int primary key,
    nombre VARCHAR2(50),
    sede VARCHAR2(50),
    director VARCHAR2(50),
    motor VARCHAR2(50),
    num_titulos int,
    num_empleados int
);
create table  roles ( 
    id int primary key,
    rol VARCHAR2(50)
);
alter table pilotos add FOREIGN key(id_rol) REFERENCES roles;
alter table pilotos add FOREIGN key(id_equipo) REFERENCES Equiposp;
alter table pilotos add check (nacionalidad in ('ESPAÑOLA','HOLANDESA','BRITANICA'));
alter table equiposp add check (num_empleados>0);
insert into roles values(1,'PRIMER PILOTO');
insert into roles values(2,'SEGUNDO PILOTO');
insert into roles values(3,'PILOTO PRUEBAS');
insert into equiposp values(1,'ASTON MARTIN','SILVERSTONE','ADRIAN NEWEY','MERCERDES',0,800);
insert into equiposp values(2,'RED BULL','MILTON KEYNES','CHRISTIAN HORNER','HONDA',6,1000);
insert into equiposp values(3,'FERRARI','MARANELLO','JOHN ELKHANN','FERRARI',16,1200);
insert into equiposp values(4,'WILLIANS','GROVE','JAMES VOWLES','MERCERDES',9,750);
insert into pilotos values(1,'FERNANDO','ALONSO','29/07/1981','ESPAÑOLA',1,1);
insert into pilotos values(2,'MAX','VERSTAPPEN','30/09/1964','HOLANDESA',1,2);
insert into pilotos values(3,'LEWIS','HAMILTON','07/01/1985','BRITANICA',1,3);
insert into pilotos values(4,'CARLOS','SAINZ','01/09/1981','ESPAÑOLA',1,4);
COMMIT;

--## Parte 2

--Realiza las siguientes consultas.

--1. Indica por cada nacionalidad de los pilotos, el número de estos que hay. Ordena el resultado por el número de estos de mayor a menor, y en caso de que empate, por nacionalidad en orden alfabético.
SELECT NACIONALIDAD, COUNT(*) FROM PILOTOS GROUP BY NACIONALIDAD ORDER BY COUNT(*) DESC, NACIONALIDAD;
--2. Indica en una única columna con el siguiente formato (APELLIDOS, NOMBRE - NOMBRE_EQUIPO ) aquellos pilotos que tenga rol PRIMER PILOTO.
SELECT PILOTOS.APELLIDOS ||', '|| PILOTOS.NOMBRE||' - '|| ROLES.ROL from PILOTOS join ROLES on ROLES.ID = PILOTOS.ID_ROL where ROLES.ROL='PRIMER PILOTO';
--3. Muestra el nombre del motor y la suma de títulos que se ha conseguido con ese motor actualmente. Ej.: MERCEDES, 9; HONDA 6; FERRARI 16.
select motor ||','|| sum(num_titulos) from equiposp GROUP by motor;
--4. ¿Cuántos pilotos han nacido en día impar?
select count(*) from PILOTOS where mod(to_char(FECHA_NACIMIENTO,'DD'),2)!=0;
--5. Muestra el nombre, apellidos de los pilotos, además del nombre del director de su equipo y el rol que ocupa dicho piloto actualmente.
select pilotos.nombre, pilotos.apellidos, equiposp.director, roles.rol from PILOTOS join equiposp on equiposp.ID = pilotos.ID_EQUIPO
join roles on roles.id = pilotos.ID_ROL;
--6. ¿Cuántas vocales tiene el apellido del piloto que está en el equipo que tiene más empleados?
select length(apellidos)-length(replace(replace(replace(replace(replace(upper(apellidos),'A'),'E'),'I'),'O'),'U')),apellidos from pilotos join equiposp on equiposp.ID = pilotos.ID_EQUIPO where equiposp.NUM_EMPLEADOS =(select max(num_empleados) from EQUIPOSP);
--## Parte 3

--Realiza un bloque de código anónimo que haga lo siguiente.

--1. Realiza llamadas a la tabla equipos y guarda dichos resultados en variables con SELECT INTO.
--2. Debes emplear el tipo de datos de los campos de la tabla equipos para tus variables.
--3. Debes mostrar un primer mensaje por la salida indicando: "El número total de campeonatos disputados es de XXX", donde XXX debe ser el número sumatorio de títulos obtenidos por los equipos guardados en la tabla equipos.
--4. Debes mostrar un segundo mensaje por la salida indicando: "El motor más empleado es XXX con un total de YYY equipos que lo usan", donde XXX es el nombre del motor que se emplea más veces, e YYY el número de equipos que usan ese motor más usado.
DECLARE
numerotitu equiposp.NUM_TITULOS%TYPE;
nombremotor equiposp.MOTOR%TYPE;
numeroequipos int:=0;
BEGIN
    select sum(num_titulos) into numerotitu from equiposp;
    DBMS_OUTPUT.PUT_LINE('El número total de campeonatos disputados es de '||numerotitu);
    select count(*), motor into numeroequipos, nombremotor from equiposp group by motor having count(*)=(select max(count(*)) from equiposp group by motor );
    DBMS_OUTPUT.PUT_LINE('El motor más empleado es '||nombremotor || ' con un total de '||numeroequipos || ' equipos que lo usan');
end;
/