--Boletín ejercicios con cursores
--1 Se quiere visualizar el nombre y la fecha de alta de todos los empleados, ordenados por el nombre de Z a A.
declare
cursor datosempleados is select ename, hiredate from emp order by ENAME desc;
BEGIN
    for i in datosempleados LOOP
    DBMS_OUTPUT.PUT_LINE(I.ENAME|| '|'||I.hiredate);
    END LOOP;
end;
/

--2 Encuentra el primer empleado con un sueldo mayor que 2000�. Muestra su nombre y su salario (solo del primero). NOTA: siempre puedes salir de un bucle con exit;
DECLARE
cursor datosempleados is select ename, SAL from emp WHERE SAL> 2000;
BEGIN
    FOR I IN datosempleados LOOP
    DBMS_OUTPUT.PUT_LINE(I.ENAME|| '|'||I.SAL);
    EXIT;
    END LOOP;
END;
/
--3 Pide al usuario que introduzca un empno y te muestre por la salida el empno, ename y la loc del departamento en el que trabaja
DECLARE
MIEMPNO EMP.EMPNO%TYPE:=&METEEMPNO;
CURSOR DATOSEMPLEADOS IS SELECT EMPNO, ENAME, LOC FROM EMP JOIN DEPT ON EMP.DEPTNO =DEPT.DEPTNO WHERE EMPNO =MIEMPNO;
CONTARDOR INT:=0;
BEGIN
    FOR I IN DATOSEMPLEADOS LOOP
    DBMS_OUTPUT.PUT_LINE(I.EMPNO|| ' | '||I.ENAME||' | '||I.LOC);
    CONTADOR:=CONTADOR+1;
    END LOOP;
    IF CONTADOR=0 THEN
    DBMS_OUTPUT.PUT_LINE('NO HAY DATOS DE ESE EMPNO');
    END IF;
END;
/
UNDEFINE METEEMPNO;

--4 En la tabla EMP incrementar el salario el 10% a los empleados que tengan una comisi�n superior al 5% del salario. Para ello recorre cada uno de los empleados, y en caso de que se de esa condici�n del 5%, realiza el update y muestra un mensaje con el nombre del empleado con sal actualizado.

--5 Modifica el ejercicio anterior para, tras actualizar el salario, mostrar el nombre del empleado, la comisi�n, el salario antiguo y el salario nuevo. Adem�s, cuando no se actualice el salario, indicar un mensaje "El empleado XXX no ha tenido subida en su salario".

--6 Pide que introduzca el usuario una cadena de caracteres por teclado. Muestra el empno y el ename de todos los empleados que tengan en su ename esa cadena introducida. Al finalizar, muestra un mensaje con el n�mero total de empleados que lo tienen.

--7 Muestra el nombre de cada departamento junto al n�mero de empleados que tiene, incluso si no tiene empleados.

--8 Busca todos los empleados que tienen salario + comisi�n mayor a 2000, y asignarles como salario esa suma. Solo puedes hacerlo si tienen comisi�n. Muestra por la salida el nombre de todos los empleados que modifiquen su salario, as� como el n�mero total de empleados que se han actualizados.

--9 Muestra el ename y sal de los cinco empleados con el salario m�s alto.

--10 Por cada puesto de trabajo (job), muestra el puesto y luego los dos empleados que tienen ese puesto y cobran menos. Si hay menos de dos empleados, muestra los que haya.BEGIN
