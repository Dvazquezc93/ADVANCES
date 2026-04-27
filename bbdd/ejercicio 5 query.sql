-- 1. Mostrar todos los datos de los empleados de aquellos que trabajan en el mismo departamento que SCOTT, 
--ganen más que lo que gana SMITH y tenga el mismo oficio que MILLER.
SELECT *  from emp where DEPTNO= (select deptno from emp where ename ='SCOTT') and sal >(select sal from emp where ename ='Smith') and job =(select job from emp where ename ='MILLER');
-- 2. Mostrar nombre y el salario de los empleados que trabajan en el mismo departamento que FORD y tengan 
--su mismo sueldo. Ordenar primero por el nombre ascendentemente y luego por el salario descendentemente.
select ename, sal from emp where deptno =(select deptno from emp where ename='FORD') and sal =(select sal from emp where ename ='FORD') order by ename, sal desc;
-- 3. Obtener el nombre del futbolista más mayor que jugó en el equipo de casa el 01/01/20 
--y el nombre de su equipo
SELECT F.NOMBRE,E.NOMBRE
    FROM FUTBOLISTAS F
    JOIN EQUIPOS E ON E.ID = F.ID_EQUIPO
    JOIN PARTIDOS P ON P.ID_EQUIPO_CASA = E.ID
    WHERE P.FECHA = '01/01/2020' AND FECHA_NACIMIENTO = (
            SELECT MIN(FECHA_NACIMIENTO)
                FROM FUTBOLISTAS F
                JOIN EQUIPOS E ON E.ID = F.ID_EQUIPO
                JOIN PARTIDOS P ON P.ID_EQUIPO_CASA = E.ID
                WHERE P.FECHA = '01/01/2020'
            );
-- 4. Obtener los apellidos del futbolista de menor edad que jugó en el equipo de fuera el 08/01/20 
--y el nombre de su equipo
SELECT futbolistas.APELLIDOS, EQUIPOS.NOMBRE
    FROM FUTBOLISTAS 
    JOIN EQUIPOS ON EQUIPOS.ID = FUTBOLISTAS.ID_EQUIPO
    JOIN PARTIDOS ON PARTIDOS.ID_EQUIPO_FUERA = EQUIPOS.ID
    WHERE PARTIDOS.FECHA = '08/01/2020' AND FECHA_NACIMIENTO = (
            SELECT Max(FECHA_NACIMIENTO)
                FROM FUTBOLISTAS 
                JOIN EQUIPOS ON EQUIPOS.ID = Fubolistas.ID_EQUIPO
                JOIN PARTIDOS ON PARTIDOS.ID_EQUIPO_FUERA = EQUIPOS.ID
                WHERE PARTIDOS.FECHA = '08/01/2020'
            );
-- 5. Devuelve el equipo y resultado del partido jugado el 15/01/20 con este formato "EQUIPO A 00-00 
--EQUIPO B" en una única columna.
select equipocasa.nombre || ' ' || resultado || ' ' ||equipofuera.nombre from partidos 
join equipos equipocasa on equipocasa.ID = partidos.ID_EQUIPO_CASA 
join equipos equipofuera on equipofuera.ID = partidos.ID_EQUIPO_FUERA where fecha ='15/01/2020';
-- 6. ¿En qué ciudad trabaja el empleado que más cobra de la empresa?
select loc from dept join emp on emp.DEPTNO = dept.DEPTNO where emp.sal = (select max(sal)from emp);
-- 7. ¿Cómo se llama el departamento del empleado que tiene menor salario?

-- 8. ¿Cómo se llama el futbolista de más altura que jugó el día 22/01/20?

-- 9. Se quiere saber el nombre del departamento y el nombre del empleado que tiene comisión y esta 
--es mayor de 500

--10. Devuelve el nombre del empleado y el nombre del departamento de aquel que haya sido 
--contratado antes en el año 1981.

--11. Devuelve el nombre del empleado junto al nombre de su jefe con este formato en una columna: 
--"El jefe de SMITH es JACOB".

--12. Devuelve el nombre del departamento que tiene más trabajadores junto al número de trabajadores.
