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
select substr(nombre,1,3)
-- 8. Queremos un listado de los nombres de los futbolistas quitando los segundos nombres (nombres compuestos, por ejemplo, borrar LUIS de PEDRO LUIS, quedando solo PEDRO) y poner como alias de columna "SOLO NOMBRE".

-- 9. Devuelve el nombre del futbolista cuyo salario es el más bajo posible de todos los futbolistas nacidos entre 1985 y 1990.

-- 10. Indica cuántos futbolistas que no juegan de portero tienen un apellido que termina en ez.

-- 11. Devuelve el id del equipo con alias "id equipo", el número de futbolistas con alias "Número de futbolistas" y el salario medio redondeado a 2 decimales con alias "Salario medio" de los futbolistas agrupado por el equipo en el que juegan.

-- 12. ¿Cuántos partitos ha jugado como local EQUIPO A? Debes usar el campo nombre de equipos.

-- 13. ¿Cuál es el nombre del equipo en el que juega el futbolista de menor peso?

-- 14. Devuelve en una única columna la fase: El futbolista NOMBRE juega en el equipo NOMBRE, correspondiendo al campo nombre de futbolista y de equipo
