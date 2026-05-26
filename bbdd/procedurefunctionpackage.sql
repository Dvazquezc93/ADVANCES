/*
Crea una función a la que se le pase por parámetro un empno y te devuelva su ename. Se debe llamar obtenerNombreEmpleado.
*/
create or replace function obtenerNombreEmpleado (miempno emp.empno%type)
return emp.ename%TYPE
IS
miename emp.ename%TYPE;
 begin 
 select ename into miename from emp where empno=miempno;
 return miename;
 EXCEPTION
when no_data_found THEN
DBMS_OUTPUT.PUT_LINE('NO HAY DATOS DE ESE EMPNO');
 end obtenerNombreEmpleado;
 /
 declare
 empnous emp.empno%type:=&METEEMPNO;
 BEGIN
DBMS_OUTPUT.PUT_LINE('El nombre del empleado es '||obtenerNombreEmpleado(empnous));
end;
/
undefine METEEMPNO;




/*
Crea un procedimiento que muestra el listado de empleados (sus nombres), llamado mostrarEmpleados, pero debes usar la función obtenerNombreEmpleado. Para ello, traéte todos los empno de la tabla emp y recórrelos llamando a dicha función para mostrar el resultado, es decir, el ename de cada empleado.
*/
create or replace PROCEDURE mostrarempleados
IS

BEGIN
for i in (select * from emp) LOOP
DBMS_OUTPUT.PUT_LINE('El nombre del empleado es '||obtenerNombreEmpleado(i.empno));
end loop;
end mostrarEmpleados;
/
BEGIN
MOSTRAREMPLEADOS;
end;
/

/*
Crea un paquete que se llame datosEmpleados que tenga la función obtenerNombreEmpleado y el procedimiento mostrarEmpleados.
*/
create or replace PACKAGE datosEmpleados
IS
function obtenerNombreEmpleado(miempno emp.empno%type)
return emp.ename%TYPE;
PROCEDURE mostrarEmpleados;
end datosEmpleados;
/
create or replace package body datosEmpleados
is
function obtenerNombreEmpleado(miempno emp.empno%type)
return emp.ename%TYPE
is
miename emp.ename%TYPE;
 begin 
 select ename into miename from emp where empno=miempno;
 return miename;
 EXCEPTION
when no_data_found THEN
DBMS_OUTPUT.PUT_LINE('NO HAY DATOS DE ESE EMPNO');
 end obtenerNombreEmpleado;
 
PROCEDURE mostrarempleados
IS
BEGIN
for i in (select * from emp) LOOP
DBMS_OUTPUT.PUT_LINE('El nombre del empleado es '||obtenerNombreEmpleado(i.empno));
end loop;
end mostrarEmpleados;
end datosEmpleados;
/

/*
Crea un bloque de código anónimo que llame al procedimiento mostrarEmpleados del paquete datosEmpleados
*/
declare
 empnous emp.empno%type:=&METEEMPNO;
 BEGIN
DBMS_OUTPUT.PUT_LINE('El nombre del empleado es '||datosEmpleados.obtenerNombreEmpleado(empnous));
mostrarEmpleados;
end;
/
undefine METEEMPNO;

select * from emp;


