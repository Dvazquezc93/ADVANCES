--1.1
create table Ficheros(
    codigo int primary key,
    nombre varchar2(80),
    tipo varchar2(50),
    espacio number(6,2),
    fecha_creacion date,
    referencia_proyecto varchar2(10)
);

alter table Ficheros add FOREIGN key(referencia_proyecto) REFERENCES proyectos;
--1.2
insert into ficheros (codigo, nombre,tipo,espacio,fecha_creacion,referencia_proyecto) values(1,'Diseño','Diseño',1000.25,'01/01/2021','P001');
COMMIT;
insert into ficheros (codigo, nombre,tipo,espacio,fecha_creacion,referencia_proyecto) values(2,'Imagen','Diseño',750,'15/05/2025','P001');
COMMIT;
insert into ficheros (codigo, nombre,tipo,espacio,fecha_creacion,referencia_proyecto) values(3,'Estilos','Web',4500.33,'30/01/2026','P002');
COMMIT;
insert into ficheros (codigo, nombre,tipo,espacio,fecha_creacion,referencia_proyecto) values(4,'Cabecera','Web',80.50,'31/03/2026','P002');
COMMIT;
--1.3
update ficheros set tipo='App',fecha_creacion='12/12/2022' where codigo=1;
COMMIT;
--1.4
Delete from ficheros where CODIGO=4;
COMMIT;
SELECT * FROM FICHEROS;
--2.1
select descripcion, clientes.nombre from proyectos join clientes on clientes.NIF = PROYECTOS.NIF_CLIENTE where fecha_fin=(select min(fecha_fin)from PROYECTOS);
--2.2
alter session set nls_language='SPANISH';
select referencia, fecha_inicio from PROYECTOS where upper(trim(to_char(fecha_inicio,'day'))) ='DOMINGO';
--2.3
select upper(descripcion) "PROYECTO" from PROYECTOS where importe BETWEEN 15000 and 20000 and tipo_proyecto='INTERNACIONAL'order by 1;
--2.4
SELECT nombre, alcance from METODOLOGIAS 
where ALCANCE IS NOT NULL AND (upper(substr(nombre,4,1)) ='A' OR upper(substr(nombre,4,1)) ='E'
OR upper(substr(nombre,4,1)) ='I'OR upper(substr(nombre,4,1)) ='O'OR  upper(substr(nombre,4,1)) ='U');
--2.5
SELECT APELLIDOS ||': '|| LENGTH(APELLIDOS) FROM EMPLEADOS WHERE LENGTH(APELLIDOS) = (SELECT MAX(LENGTH(APELLIDOS))FROM EMPLEADOS);
--2.6
SELECT DNI, NOMBRE, APELLIDOS FROM EMPLEADOS WHERE TFNO LIKE '91%' AND TIPO_TECNICO ='PROGRAMADOR';
--2.7
SELECT NOMBRE, APELLIDOS FROM EMPLEADOS 
JOIN CERTIFICACIONES_EMPLEADOS ON CERTIFICACIONES_EMPLEADOS.DNI_EMPLEADO =EMPLEADOS.DNI
JOIN CERTIFICACIONES ON CERTIFICACIONES.CODIGO =CERTIFICACIONES_EMPLEADOS.CODIGO_CERTIFICACION WHERE CERTIFICACIONES.ENTIDAD ='Oracle'or CERTIFICACIONES.ENTIDAD ='Microsoft';
--2.8 
select tipo_empleado, count(*) from empleados group by tipo_empleado having count(*) =(select max(count(*)) from empleados group by tipo_empleado );
--2.9
select empleados.nombre, count(*) from CERTIFICACIONES JOIN CERTIFICACIONES_EMPLEADOS ON CERTIFICACIONES.CODIGO =CERTIFICACIONES_EMPLEADOS.CODIGO_CERTIFICACION
join EMPLEADOS on CERTIFICACIONES_EMPLEADOS.DNI_EMPLEADO =EMPLEADOS.DNI group by empleados.nombre having count(*)>2;
--2.10
select dni, email from TRABAJADORES where NIF_CLIENTE IN(select unique nif from clientes where nombre like '%SL');
--2.11
select DISTINCT substr(email,1,(instr(email,'@',1)-1))"DOMINIO DEL EMAIL"  from TRABAJADORES where email is not NULL;
--2.12
select referencia, descripcion,fecha_inicio"FECHA" from proyectos where upper(trim(to_char(fecha_inicio,'MONTH','NLS_LANGUAGE =SPANISH')))='FEBRERO'; 
--2.13
select upper(id),upper(anyos),upper(lenguaje) from ESPECIALIDADES where LENGUAJE like 'Ja%';
--2.14
select lower(metodologias.tipo),count(*) from PROYECTOS join METODOLOGIAS on METODOLOGIAS.ID =PROYECTOS.ID_METODOLOGIA 
group by metodologias.tipo having count(*)= (select max(count(*))from PROYECTOS join METODOLOGIAS on METODOLOGIAS.ID = PROYECTOS.ID_METODOLOGIA 
group by metodologias.tipo);
--2.15
select empleados.nombre"TRABAJADOR", certificaciones_empleados.fecha"FECHA CERT", CERTIFICACIONES.ENTIDAD "EMPRESA CERT" from empleados join CERTIFICACIONES_EMPLEADOS on CERTIFICACIONES_EMPLEADOS.dni_empleado=empleados.dni
join CERTIFICACIONES on CERTIFICACIONES.CODIGO =CERTIFICACIONES_EMPLEADOS.CODIGO_CERTIFICACION where certificaciones_empleados.fecha ='12/02/2023';
--2.16
select descripcion from PROYECTOS where importe=(select min(importe)from PROYECTOS);
--3
DECLARE
usuario proyectos.IMPORTE%TYPE:=&METEIMPORTE;
contador int:=0;
begin
for i in(select * from proyectos where importe=usuario)loop
DBMS_output.put_line('LA REFERENCIA DE SU PROYECTO '||I.REFERENCIA);
for ib in(select * from proyectos where importe<usuario)loop
contador:=contador+1;
end loop;
DBMS_output.put_line('HAY '||CONTADOR||' PROYECTOS CON UN IMPORTE INFERIOR.');
CONTADOR:=0;
for ib in(select * from proyectos where importe>usuario)loop
contador:=contador+1;
end loop;
DBMS_output.put_line('HAY '||CONTADOR||' PROYECTOS CON UN IMPORTE SUPERIOR.');
CONTADOR:=0;
end loop;
end;
/
undefine METEIMPORTE;
--4
 DECLARE
CURSOR TIPO IS SELECT DISTINCT TIPO_EMPLEADO FROM EMPLEADOS;
CONTADOR INT:=0;
 BEGIN
    FOR I IN TIPO LOOP
    DBMS_OUTPUT.PUT_LINE('SU TIPO DE EMPLEADO ES '||I.TIPO_EMPLEADO);
    FOR IJ IN (SELECT * FROM EMPLEADOS WHERE TIPO_EMPLEADO=I.TIPO_EMPLEADO) LOOP
    SELECT COUNT(*) INTO CONTADOR FROM ESPECIALIDADES JOIN ESPECIALIDADES_PROGRAMADORES ON ESPECIALIDADES_PROGRAMADORES.ID_ESPECIALIDAD= ESPECIALIDADES.ID 
    JOIN EMPLEADOS ON EMPLEADOS.DNI =ESPECIALIDADES_PROGRAMADORES.DNI_EMPLEADO_TECNICO_PROGRAMADOR WHERE EMPLEADOS.DNI=IJ.DNI;
    DBMS_OUTPUT.PUT_LINE('SU  EMPLEADO ES '||IJ.APELLIDOS||', '||IJ.NOMBRE|| ' ('||CONTADOR||')');
    END LOOP;
    END LOOP;
END;
/

