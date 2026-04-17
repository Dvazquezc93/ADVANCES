# Boletín 2 | bbdd fábrica.sql

--1. ¿Cuál es el tipo de pieza (mecanico, neumatico, etc.) que se usa en mayor cantidad en las máquinas?
SELECT TIPO FROM PIEZAS 
JOIN PIEZAS_MAQUINAS ON PIEZAS_MAQUINAS.ID_PIEZA =PIEZAS.IDPIE
 GROUP BY TIPO 
 HAVING SUM(CANTIDAD) = (SELECT MAX(SUM(CANTIDAD))FROM PIEZAS_MAQUINAS 
 JOIN PIEZAS ON PIEZAS.IDPIE = PIEZAS_MAQUINAS.ID_PIEZA GROUP BY TIPO);


--2. Queremos la primera palabra del nombre de empresa de todos los clientes que tienen en el cif una consonante 
--como primera letra (no tiene que ser una b pero seguro que no es una vocal y puede estar en mayúsculas o minúsculas).
-- Debe ir completamente en minúsculas y no deben haber espacios en blanco al principio o al final del nombre.
SELECT TRIM(LOWER(SUBSTR(NOMBRE_EMPRESA,1, INSTR(NOMBRE_EMPRESA, ' ')))) 
FROM CLIENTES WHERE SUBSTR(UPPER(CIF),1,1) NOT IN ('A','E','I','O','U');
--3. Se quiere mostrar todos los nombres de las piezas que empiecen por una letra consonante, 
--con la primera letra de cada palabra en mayúsculas, y cuyo estado sea NUEVA.
SELECT INITCAP(NOMBRE) FROM PIEZAS WHERE ESTADO = 'NUEVA' AND SUBSTR(UPPER(NOMBRE),1,1) NOT IN ('A','E','I','O','U');
--4. ¿Cuál es la diferencia de cantidad que hay entre la pieza que se usa en mayor cantidad y la que se usa menos? Expresa el valor añadiendo al final "unidades". Añade el alias de columna "Diferencia total" al resultado.
SELECT MAX(CANTIDAD),MIN(CANTIDAD), (MAX(CANTIDAD)-MIN(CANTIDAD)) FROM PIEZAS_MAQUINAS
--5. Se quiere mostrar el nombre deL CLIENTE pero con un formato diferente. Se quiere quitar las palabras "industrial",
-- "para" y "de", debe estar todo en minúsculas, y se debe incluir un punto y final al terminar de mostrar el nombre dEL CLIENTE. 
--No debe quedar ningún espacio ni al principio ni al final del nombre de la máquina.
SELECT lower(replace(replace(REPLACE(nombre,'industrial'),'para'),'de'))||'.' FROM maquinas;
--6. Indica el nombre de las máquinas que estaban en estado MONTAJE, sin repetir, en febrero y marzo de 2024.
-- Debes usar la palabra FEBRERO y MARZO para tu condición en la fecha, no días
select distinct nombre  from avances_lineas_fabricacion join maquinas on maquinas.ref =avances_lineas_fabricacion.id_maquina
 where avances_lineas_fabricacion.estado='MONTAJE'
  and to_char(fecha,'YYYY')= 2024 and trim(to_char(fecha, 'MONTH')) in ('FEBRERO','MARZO');
--7. Se quiere una lista con el nombre en minúsculas de todas las piezas que sean MECANICO y se encuentren en estado 2MANO.
SELECT LOWER(NOMBRE) FROM PIEZAS WHERE TIPO='MECANICO' AND ESTADO ='2MANO';
--8. Se quiere saber todos los tipos de piezas que haya, sin repetir resultado, ordenados en orden de la z a la a.
SELECT distinct TIPO FROM PIEZAS ORDER BY TIPO DESC;
--9. Se quiere saber cuántos registros hay de avances en las líneas de fabricación que se hayan realizado entre las 08:00 y las 16:00 horas (ambas inclusive) y entre los días 01/12/2023 y 31/12/2023.
SELECT COUNT(LINEA_FABRICACION) FROM avances_lineas_fabricacion 
WHERE HORA BETWEEN '08:00' AND '16:00' AND FECHA BETWEEN '01/12/2023' AND '31/12/2023';

--10. Muestra el nombre de la empresa, cif y localidad de los clientes que vivan en Vejer
-- (aunque el campo con el nombre de la población sea más largo), su cif contenga 11 y no empiece por C. Debes usar alias para nombrar las tres columnas, la primera será "Cliente", la segunda "cif/nif" y la tercera "Localización".
SELECT NOMBRE_EMPRESA "Cliente", CIF "CIF/NIF", LOC "LOCALIDAD" FROM CLIENTES 
where loc like 'Vejer%' and cif like '%11%' and cif not like 'C%';
--11. Muestra todos los datos de la tabla piezas en mayúsculas y que se encuentren en estado 2MANO.
select idpie,upper(nombre),tipo,estado from piezas where estado='2MANO';
--12. ¿Cuál es la pieza cuyo nombre tiene más caracteres/letras? Pon en una única columna el nombre de la pieza: número de caracteres. Ej.: Arandela tigre doble: 20
select nombre|| ': '||length(nombre) from piezas where length(nombre)=(select max(length(nombre)) from piezas);
--13. ¿Cuántos registros de los avances en las líneas de fabricación se han hecho en domingo? Debe dar 8.
select count(*) from avances_lineas_fabricacion where trim(to_char(fecha,'DAY','NLS_DATE_LANGUAGE = SPANISH')) ='DOMINGO';
--14. Se quiere saber el tiempo de fabricación de las distintas máquinas, pero con un término más adecuado.
 --Muestra el nombre de la máquina y el tiempo de fabricación (expresado con los términos "Poco" si es como máximo 99,
  --"Normal" si está entre 100 y 999, y "Mucho" si es 1000 o como máximo 9999). Ordena el resultado por ese tiempo de fabricación de términos/palabras
   --(Poco, Normal, Mucho), por orden alfabético, y después, por orden del nombre de la máquina también alfabético.
select nombre, decode(length(T_FABRICACION),1,'poco',2,'poco',3,'Normal',4,'Mucho') 
from maquinas order by T_fabricacion, nombre;
--15. Necesitamos una lista con el nombre de la empresa y la localidad de los clientes, pero el nombre debe tener todas las letras en mayúsculas y que no haya ningún espacio entre nombres compuestos. Ej.: INDUSTRIASCARNICAS.
select upper(replace(nombre_empresa,' ')), loc from clientes;
--16. Indica el valor medio del precio de venta de las máquinas con REDONDEO de dos decimales.
select round(avg(precio_venta),2) from maquinas;
select precio_venta from maquinas;
--17. Indica el nombre de la máquina más cara.
select nombre from maquinas where precio_venta=(select max(precio_venta) from maquinas);
--18. Indica la lista de piezas (nombre de la pieza y cantidad usada en 2 columnas diferentes) 
--de la máquina "Cortadora de cesped" ordenado por cantidad, de mayor a menor, y luego por orden alfabético del nombre de la pieza.
select piezas.nombre, PIEZAS_MAQUINAS.CANTIDAD from piezas join PIEZAS_MAQUINAS on piezas.idpie = Piezas_maquinas.ID_pieza 
join maquinas on maquinas.ref = PIEZAS_MAQUINAS.id_maquina
 where maquinas.nombre= 'Cortadora de cesped' order by PIEZAS_MAQUINAS.CANTIDAD desc, piezas.nombre;
--19. Indica la lista de piezas (nombre) de la máquina "Bomba para piscinas". Ordena el resultado por nombre de la z a la a.
select piezas.nombre  from piezas join PIEZAS_MAQUINAS on piezas.idpie = Piezas_maquinas.ID_pieza 
join maquinas on maquinas.ref = PIEZAS_MAQUINAS.id_maquina
 where maquinas.nombre= 'Bomba para piscinas' order by  piezas.nombre desc;
--20. Devuelve el nombre, el tipo y el estado de las piezas que empiezan por "A" sin usar LIKE.
select nombre, tipo, estado from piezas where SUBSTR(upper(nombre),1,1) ='A';

--21. ¿Cuántas piezas pertenecen al tipo ELECTRICO? Indica tan solo el número.
select count(*) from piezas where tipo ='ELECTRICO';
--22. ¿Cuánto dinero se ha obtenido de la fabricación de la máquina Lijadora industrial? Indica solo una columna con el importe con dos decimales.
-- Recuerda que para obtener dinero de una máquina, el avance de las líneas de fabricación de un producto debe haber llegado al estado FINALIZADO.
select round(sum(precio_venta),2) from maquinas join avances_lineas_fabricacion on maquinas.ref=avances_lineas_fabricacion.id_maquina 
where nombre ='Lijadora industrial' and avances_lineas_fabricacion.estado='FINALIZADO';

--23. ¿Cuál son los nombres de las piezas que se emplean en más máquinas (que se use en estas independientemente de la cantidad)?
select  nombre from piezas join piezas_maquinas on piezas.idpie =piezas_maquinas.id_pieza 
where piezas_maquinas.cantidad= (select max(cantidad)from piezas_maquinas);
--24. ¿En los nombres de qué maquinas se usa la pieza "Elastico"?
SELECT MAQUINAS.NOMBRE FROM MAQUINAS JOIN PIEZAS_MAQUINAS ON MAQUINAS.REF =PIEZAS_MAQUINAS.id_maquina 
JOIN PIEZAS ON PIEZAS.IDPIE= PIEZAS_MAQUINAS.ID_PIEZA WHERE piezas.nombre='Elastico';

--25. ¿Cuál es el nombre de la máquina que inició su puesta a punto el 11/11/2023 a las 20:05? No emplees join, solo subconsultas.
Select maquinas.nombre from maquinas where ref =(select id_maquina from avances_lineas_fabricacion where fecha ='11/11/2023' and hora ='20:05');

--26. ¿Cuántos registros de avances en las líneas de fabricación, independientemente de su estado, hay de la máquina "Amasadora pan"?
select count(*) from avances_lineas_fabricacion join maquinas on avances_lineas_fabricacion.id_maquina =maquinas.ref where maquinas.nombre ='Amasadora pan';
--27. Indica el nombre de la máquina cuyo precio es inferior a 1000 euros pero se tarda más de 500 minutos en fabricarla.
select nombre from maquinas  where precio_venta BETWEEN 500 and 1000 and T_FABRICACION =500;

--28. Indica los nombre de los clientes que tienen la máquina pedida para fabricar en estado FINALIZADO y por tanto ya pueden usarla.
select clientes.nombre_empresa from clientes join avances_lineas_fabricacion on avances_lineas_fabricacion.id_cliente =clientes.cif where avances_lineas_fabricacion.estado ='FINALIZADO';
--29. ¿Cuántos registros en los avances de las líneas de fabricación se han realizado desde la línea de fabricación 1 entre las 08:00 y las 15:00?
select count(*) from avances_lineas_fabricacion where LINEA_FABRICACION =1 and hora BETWEEN '08:00' and '15:00';

--30. Indica el tipo de la pieza Servomotor. Debes mostrar dicho tipo con el tamaño/número de caracteres que sea el tamaño del tipo que tenga menos letras. En este caso, es OTROS, que tiene 5 caracteres, pero no puedes usar el número 5, debes calcular en tu query ese tamaño mínimo.
select length(substr(tipo,1,(select min(length(tipo)) from piezas ))) from piezas where nombre ='Servomotor';

--31. Se quiere saber el nombre del cliente, el tiempo de fabricación de la máquina que pidió, el nombre de la pieza que se usa en mayor cantidad en dicha máquina que pidió y el tipo de dicha pieza, que se encuentren registradas en los avances de las líneas de fabricación en la línea de fabricación 1. Muestra los resultados sin repetir.
select distinct clientes.nombre_empresa, maquinas.T_FABRICACION, piezas.nombre, piezas.tipo 
from clientes
join avances_lineas_fabricacion on avances_lineas_fabricacion.id_cliente =clientes.cif 
join maquinas on maquinas.ref = avances_lineas_fabricacion.id_maquina join piezas_maquinas on piezas_maquinas.id_maquina =maquinas.ref join piezas on piezas.idpie =PIEZAS_MAQUINAS.id_pieza 
where  avances_lineas_fabricacion.LINEA_FABRICACION=1 and piezas_maquinas.cantidad =(select max(piezas_maquinas.cantidad) from clientes join avances_lineas_fabricacion on avances_lineas_fabricacion.id_cliente =clientes.cif 
join maquinas on maquinas.ref =avances_lineas_fabricacion.id_maquina join piezas_maquinas on piezas_maquinas.id_maquina =maquinas.ref join piezas on piezas.idpie =PIEZAS_MAQUINAS.id_pieza 
where  avances_lineas_fabricacion.LINEA_FABRICACION=1);

--32. Se quiere mostrar una lista con todas las piezas en una columna, y en otra columna la suma de la cantidad empleada de dicha pieza en cada máquina. Ordena por dicha suma de mayor a menor.
select piezas.NOMBRE, sum(piezas_maquinas.CANTIDAD) from piezas join piezas_maquinas on piezas_maquinas.id_pieza = piezas.IDPIE GROUP BY piezas.nombre ORDER by 2 desc;


