--Ejercicio 1 (1 punto total)
--1.1 Crear Tabla: Crear la tabla PATROCINADORES con campos codigo (PK), 
--nombre, localidad, direccion, email y nif_club (FK a CLUBES).
create table PATROCINADORES(
    codigo int PRIMARY key,
    nombre varchar2(50),
    localidad varchar2(50),
    direccion varchar2(100),
    email VARCHAR2(100),
    nif_club char(9)
);
alter table PATROCINADORES  add  FOREIGN key(nif_club) REFERENCES clubes;
select * from clubes;
--1.2 Inserción: Insertar 4 registros 
insert into PATROCINADORES (codigo,nombre) values(1,'Supermercados García');
insert into PATROCINADORES (codigo,nombre) values(2,'Cerveza Malagueña');
insert into PATROCINADORES (codigo,nombre) values(3,'Electrónica Completa');
insert into PATROCINADORES (codigo,nombre) values(4,'Cementos S.L.U.');
COMMIT;
--(Supermercados García, Cerveza Malagueña, Electrónica Completa, Cementos S.L.U.).
--1.3 Modificación:
 --Editar el email de "Supermercados García" y cambiar su club patrocinado al NIF C17902088.
 update PATROCINADORES set email='supergarcia@falsa.com',nif_club='C17902088' where codigo=1;
 COMMIT;
 --1.4 
 --Borrado: Eliminar el registro de "Cerveza Malagueña".
 delete from PATROCINADORES where codigo=2;
  COMMIT;
  SELECT * from PATROCINADORES;
 --Ejercicio 2 (Consultas SQL - 0.375p cada una)
 --2.1 Contar atletas del 'Club Atlético Málaga' (Alias: "Total").
 select count(*) "total" from atletas join clubes on clubes.nif = atletas.NIF_CLUB
  where clubes.NOMBRE= 'Club Atlético Málaga';
 --2.2 Nombres de entrenamientos únicos realizados por el 'Club Atlético Sevilla'.
 select entrenamientos.nombre from ENTRENAMIENTOS join ATLETAS_REALIZAN_ENTRENAMIENTOS on ATLETAS_REALIZAN_ENTRENAMIENTOS.ID_ENTRENAMIENTO = ENTRENAMIENTOS.ID
 JOIN ATLETAS ON ATLETAS.DNI = ATLETAS_REALIZAN_ENTRENAMIENTOS.DNI_ATLETA join clubes on clubes.nif = atletas.NIF_CLUB  where clubes.NOMBRE= 'Club Atlético Sevilla';
 --2.3 Apellidos y nombre concatenados en mayúsculas de atletas con al menos una victoria.
 SELECT UPPER(APELLIDOS) ||' ' || UPPER(NOMBRE),NUM_VICTORIAS_PROFESIONAL FROM ATLETAS WHERE ATLETAS.NUM_VICTORIAS_PROFESIONAL>0;
 --2.4 DNI y nombre de atletas de 'Vallecas Deportivo' (usando solo subconsultas, orden descendente por DNI).
 SELECT DNI, NOMBRE FROM ATLETAS WHERE ATLETAS.NIF_CLUB =(SELECT NIF FROM CLUBES WHERE NOMBRE='Vallecas Deportivo') ORDER BY DNI DESC;
 --2.5 Nombre del club y número de atletas, solo para clubes con entre 3 y 5 atletas.
 SELECT COUNT(*), CLUBES.NOMBRE FROM ATLETAS JOIN CLUBES on clubes.nif = atletas.NIF_CLUB
   GROUP BY CLUBES.NOMBRE HAVING COUNT(*) BETWEEN 3 AND 5;
 --2.6 Nombre, apellidos y longitud del apellido del atleta con el apellido más largo.
 SELECT NOMBRE, APELLIDOS ,LENGTH(APELLIDOS) FROM ATLETAS WHERE LENGTH(APELLIDOS) =(SELECT MAX(LENGTH(APELLIDOS)) FROM ATLETAS );
 --2.7 Nombre, apellidos y número de carreras de los atletas que más han participado.
 SELECT ATLETAS.NOMBRE, ATLETAS.APELLIDOS, COUNT(*) FROM CARRERAS JOIN CARRERAS_PARTICIPAN_ATLETAS ON CARRERAS_PARTICIPAN_ATLETAS.CODIGO_CARRERA = CARRERAS.CODIGO
 JOIN ATLETAS ON ATLETAS.DNI = CARRERAS_PARTICIPAN_ATLETAS.DNI_ATLETA GROUP BY ATLETAS.NOMBRE,ATLETAS.APELLIDOS HAVING COUNT(*) =(SELECT MAX(COUNT(*)) FROM CARRERAS JOIN CARRERAS_PARTICIPAN_ATLETAS ON CARRERAS_PARTICIPAN_ATLETAS.CODIGO_CARRERA = CARRERAS.CODIGO
 JOIN ATLETAS ON ATLETAS.DNI = CARRERAS_PARTICIPAN_ATLETAS.DNI_ATLETA GROUP BY ATLETAS.NOMBRE,ATLETAS.APELLIDOS);
 --2.8 Datos de clubes con responsable "Pedro" y un '9' en su NIF.
 select * from clubes where responsable like 'Pedro%' and nif like'%9%';
 --2.9 Nombre de los atletas con menos entrenamientos realizados.
 select atletas.nombre, count(*) from entrenamientos join ATLETAS_REALIZAN_ENTRENAMIENTOS on ATLETAS_REALIZAN_ENTRENAMIENTOS.ID_ENTRENAMIENTO
 = entrenamientos.ID join atletas on atletas.dni = ATLETAS_REALIZAN_ENTRENAMIENTOS.DNI_ATLETA group by atletas.nombre having count(*) =(select min(count(*))
 from ENTRENAMIENTOS join ATLETAS_REALIZAN_ENTRENAMIENTOS on ATLETAS_REALIZAN_ENTRENAMIENTOS.ID_ENTRENAMIENTO
 = entrenamientos.ID join atletas on atletas.dni = ATLETAS_REALIZAN_ENTRENAMIENTOS.DNI_ATLETA group by atletas.nombre);
 --2.10 Día de la semana de inicio y día del mes de fin de inscripción para carreras que NO sean en 'Córdoba'.
 select trim(to_char(F_inicio_inscrip,'day','NLS_DATE_LANGUAGE = SPANISH')), trim(to_char(F_fin_inscrip,'MONTH','NLS_DATE_LANGUAGE = SPANISH')) from carreras where localidad !='Cordoba';
--2.11 Nombre de carrera y número de espacios en dicho nombre (Alias: "Nun.espacios").
select nombre, length(nombre) "Nun.espacios"  from carreras;
 --2.12 Nombre y apellidos del atleta de mayor edad.
 select nombre, apellidos from atletas where fecha_nacimiento =(select min(fecha_nacimiento) from atletas);
 --2.13 Nombre del club (en minúsculas) del atleta más joven.
 select  nombre from clubes where nif=(select nif_club from atletas where fecha_nacimiento=(select max(FECHA_NACIMIENTO) from atletas));
 --2.14 Suma de las horas del tiempo empleado en la carrera 'Grand Prix Madrid'.
select sum(to_number(SUBSTR(tiempo,2,1))) from CARRERAS_PARTICIPAN_ATLETAS join carreras on carreras.CODIGO =
CARRERAS_PARTICIPAN_ATLETAS.CODIGO_CARRERA where carreras.NOMBRE = 'Grand Prix Madrid';
select * from CARRERAS_PARTICIPAN_ATLETAS;
 --2.15 Nombre del entrenamiento (en mayúsculas) con dureza 10 y duración entre 50 y 100.
 select upper(nombre) from entrenamientos where dureza=10 and duracion BETWEEN 50 and 100;
 --2.16 Dorsales que participaron en carreras con ID par.
 select dorsal from CARRERAS_PARTICIPAN_ATLETAS where mod(codigo_carrera,2)=0;
 --Ejercicio 3 (PL/SQL - 3 puntos)Se requiere un bloque anónimo que:Pida un DNI al usuario.
 --Defina un record (tipoAtleta) y una variable (miAtleta) con dni y nombre.
 --Verifique la existencia del DNI: si no existe, lanzar mensaje "No hay atletas con el DNI AAA".
 --Si existe pero no tiene carreras: mostrar "El atleta con nombre BBB no ha disputado ninguna carrera" 
 --y guardar datos en miAtleta.
 --Si tiene carreras: mostrar el nombre de todas las carreras y el dorsal utilizado.
DECLARE
    -- Pide DNI al usuario
    usuario atletas.DNI%TYPE := '&METEDNI';
    
    -- Define un record (tipoAtleta) y una variable (miAtleta)
    TYPE tipoAtleta IS RECORD (
        dni char(9),
        nombre varchar2(50)
    );
    miAtleta tipoAtleta;
    
    numeroCarreras INT := 0;
    atletaExiste INT := 0;
BEGIN
    -- 1. Verificar la existencia del DNI
    SELECT count(*) INTO atletaExiste FROM atletas WHERE dni = usuario;

    IF atletaExiste = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No hay atletas con el DNI ' || usuario);
    ELSE
        -- 2. Si existe, obtenemos sus datos y los guardamos en miAtleta
        SELECT dni, nombre INTO miAtleta.dni, miAtleta.nombre 
        FROM atletas 
        WHERE dni = usuario;

        -- 3. Contamos sus carreras
        SELECT count(*) INTO numeroCarreras 
        FROM CARRERAS_PARTICIPAN_ATLETAS 
        WHERE dni_atleta = usuario;

        IF numeroCarreras = 0 THEN
            -- Si no tiene carreras: mensaje y ya tenemos los datos en miAtleta
            DBMS_OUTPUT.PUT_LINE('El atleta con nombre ' || miAtleta.nombre || ' no ha disputado ninguna carrera');
        ELSE
            -- 4. Si tiene carreras: mostrar nombre de la carrera y dorsal
            -- Hacemos un JOIN para sacar el nombre de la tabla 'carreras'
            FOR ic IN (
                SELECT c.nombre, pa.dorsal 
                FROM CARRERAS_PARTICIPAN_ATLETAS pa
                JOIN carreras c ON pa.codigo_carrera = c.codigo
                WHERE pa.dni_atleta = usuario
            ) LOOP
                DBMS_OUTPUT.PUT_LINE('Carrera: ' || ic.nombre || ' | Dorsal: ' || ic.dorsal);
            END LOOP;
        END IF;
    END IF;
END;
/
select * from CARRERAS_PARTICIPAN_ATLETAS;
undefine &METEDNI;