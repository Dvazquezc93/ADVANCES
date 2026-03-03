--1 ¿Cuántos atletas pertenecen al club 'Club Atlético Málaga'? Ponle como alias de columna "Total".
select count(*) "TOTAL" from ATLETAS join clubes on ATLETAS.NIF_CLUB = clubes.nif where clubes.NOMBRE='Club Atlético Málaga';
--2 ¿Qué nombre de entrenamiento, sin repetir, han realizado los atletas del club 'Club Atlético Sevilla'?
SELECT distinct entrenamientos.nombre from entrenamientos 
join ATLETAS_REALIZAN_ENTRENAMIENTOS on ATLETAS_REALIZAN_ENTRENAMIENTOS.ID_ENTRENAMIENTO = entrenamientos.ID 
join ATLETAS on ATLETAS.DNI =ATLETAS_REALIZAN_ENTRENAMIENTOS.DNI_ATLETA
join clubes on ATLETAS.NIF_CLUB = clubes.nif where clubes.NOMBRE = 'Club Atlético Sevilla';
--3 Se quiere saber los apellidos junto al nombre, separado por coma y en una única columna, de los atletas que hayan conseeguido al menos una victoria. El resultado debe devolverse con todos los caracteres en mayúsculas. Ejemplo: GARCÍA SÁNCHEZ, IVÁN
select upper(APELLIDOS),upper(nombre) from ATLETAS WHERE NUM_VICTORIAS_PROFESIONAL >=1;
--4 ¿Cuál es el dni y el nombre de los atletas que pertenecen al club 'Vallecas Deportivo'? Ordena el resultado por el dni de mayor a menor, y no uses join, solo subconsultas.
select dni, nombre from ATLETAS where nif_club=(select nif from clubes where nombre='Vallecas Deportivo') order by dni desc;
--5 Se quiere mostrar el nombre del club junto al número de atletas que hay en él. Solo se quieren mostrar los clubes que tengan entre 3 y 5 atletas (inclusive 3 y 5) y ordena el resultado de mayor a menor número de atletas.
select nombre, count(*) from ATLETAS join clubes on ATLETAS.NIF_CLUB =clubes.NIF group by clubes.NOMBRE having COUNT(*)>=3 and COUNT(*)<=4 order by COUNT(*) desc;
--6 Indica el nombre, apellidos y número de caracteres del campo apellidos (ponle como alias de columnas "Num. caracteres") del atleta que tiene más letras en su apellido.
SELECT NOMBRE , APELLIDOS, LENGTH(apellidos)"Num.Caracteres" from atletas where LENGTH(apellidos)=(SELECT max(length(apellidos))from atletas);
--7 Se quiere saber el nombre, los apellidos y el número de carreras de los atletas que han participado en más carreras. Ordena el resultado por orden alfabético de los apellidos.
select atletas.nombre, atletas.apellidos, count(*) from CARRERAS 
join CARRERAS_PARTICIPAN_ATLETAS on CARRERAS_PARTICIPAN_ATLETAS.CODIGO_CARRERA =CARRERAS.CODIGO 
join ATLETAS on ATLETAS.DNI = CARRERAS_PARTICIPAN_ATLETAS.DNI_ATLETA  
group by atletas.nombre, atletas.apellidos having count(*)=(select max(count(*)) from CARRERAS 
join CARRERAS_PARTICIPAN_ATLETAS on CARRERAS_PARTICIPAN_ATLETAS.CODIGO_CARRERA =CARRERAS.CODIGO 
join ATLETAS on ATLETAS.DNI = CARRERAS_PARTICIPAN_ATLETAS.DNI_ATLETA group by atletas.nombre, atletas.apellidos) order by ATLETAS.APELLIDOS;

--8 Devuelve todos los campos de los clubes cuyo responsable tiene por nombre Pedro y el nif del club tiene un 9 entre sus dígitos.
select * from clubes where responsable like'Pedro%' and nif like '%9%';

--9 ¿Cuál es el nombre de los atletas que han realizado menos entrenamientos?
SELECT nombre, COUNT(*)
FROM ATLETAS
JOIN ATLETAS_REALIZAN_ENTRENAMIENTOS ON ATLETAS_REALIZAN_ENTRENAMIENTOS.DNI_ATLETA = ATLETAS.DNI
GROUP BY nombre, ATLETAS.DNI
HAVING COUNT(*) = (
    SELECT MIN(count(*))
        FROM ATLETAS_REALIZAN_ENTRENAMIENTOS
        GROUP BY DNI_ATLETA
    );

--10 Devuelve el día de la semana de la fecha de inicio de inscripción en carreras (alias de columna "Día inicio") y el día del mes de la fecha de fin de inscripción en carreras (alias de columna "Mes fin") para aquellas carreras que NO se celebren en la localidad de "Córdoba".
select to_Char(f_inicio_inscrip,'Day','nls_date_language=Spanish')"Día inicio",to_char(f_fin_inscrip,'MONTH','nls_date_language=Spanish')"Mes fin" from CARRERAS where localidad !='Cordoba';
--11 Devuelve el nombre de la carrera y el número de espacios que tiene el nombre de la carrera. Para esta segunda columna, usa el alias de columna "Nun.espacios".
select nombre, length(nombre)-length(replace(nombre,' '))"Nun.espacios" from carreras;
--12 ¿Cuál es el nombre y los apellidos del atleta que es mayor?
select nombre, apellidos from atletas where fecha_nacimiento =(select min(fecha_nacimiento) from ATLETAS);
--13 ¿Cuál es el nombre del club donde está el atleta más joven? Devuelve el resultado con todas las letras en minúsculas.
select clubes.nombre from clubes join atletas on atletas.NIF_CLUB =clubes.NIF where atletas.FECHA_NACIMIENTO =(select max(fecha_nacimiento) from ATLETAS);
--14 Si solo sumamos las horas del tiempo que han empleado los participantes de la carrera 'Grand Prix Madrid', ¿qué valor da?
select sum(to_number(substr(tiempo,0,2))) from CARRERAS_PARTICIPAN_ATLETAS
 join CARRERAS on CARRERAS.CODIGO = CARRERAS_PARTICIPAN_ATLETAS.CODIGO_CARRERA where CARRERAS.NOMBRE ='Grand Prix Madrid';

--15 Se quiere el nombre del entrenamiento con todas sus letras en mayúsculas que tiene dureza igual a 10 y además, la duración está entre 50 y 100.
select upper(nombre) from ENTRENAMIENTOS where dureza = 10 and duracion BETWEEN 50 and 100;

--16 Devuelve el número de dorsal de todos aquellos dorsales que han participado en carreras que sean un número PAR.
select dorsal from CARRERAS_PARTICIPAN_ATLETAS  where mod(dorsal,2)=0; 