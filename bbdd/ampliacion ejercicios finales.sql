--# Ejercicio 1

--Se quiere realizar ciertas operaciones sobre las tablas dept y emp:

--1. Muestra por pantalla el nombre de cada departamento, seguido por el salario medio de ese departamento con dos decimales.
--*Ejemplo: RESEARCH: 2175, SALES: 1566,67, etc.**Nota: puedes poner un alias a los campos de tu select de un cursor explícito y luego llamarlo con notación de puntos. Ej.: cursor nombreCursor is select sum(a) nombreAlias from ... y luego dbms_output.put_line(variableCursor.nombreAlias)**
DECLARE
salariomedio emp.SAL%TYPE:=0;
BEGIN
    for i in (select * from dept)loop
    select round(avg(sal),2) into salariomedio from emp where DEPTNO=i.deptno;
    if salariomedio is not null THEN
    DBMS_OUTPUT.PUT_LINE('Su deptartamento es '|| i.dname||' su salario medio es '||salariomedio);
    else
    DBMS_OUTPUT.PUT_LINE('Su deptartamento es '|| i.dname||' no tiene empleados');
    end if;
    end loop;
    END;
    /

--2. Inserta un nuevo empleado en la tabla emp con los siguientes datos que debes pedirlos por teclado:
  --  empno: 7999
    --ename: STEVEN
    --job: MANAGER
    --mgr: 7839
    --hiredate: 01/01/23
    --sal: 3000
    --comm: 0
    --deptno: 10
DECLARE
miempno emp.EMPNO%TYPE:=&meteempno;
miename emp.ENAME%TYPE:='&meteename';
mijob emp.JOB%TYPE:='&metejob';
mimgr emp.MGR%TYPE:=&metemgr;
mihiredate emp.HIREDATE%TYPE:='&metehiredate';
misal emp.SAL%TYPE:=&mmetesal;
micomm emp.COMM%TYPE:=&metecomm;
midepno emp.DEPTNO%TYPE:=&metedepno;
BEGIN
    insert into emp VALUES(miempno,miename,mijob,mimgr,mihiredate,misal,micomm,midepno);
    DBMS_OUTPUT.PUT_LINE('Ha sido insertado empleado');
    commit;
end;
/
undefine meteempno;
undefine meteename;
undefine metejob;
undefine metemgr;
undefine metehiredate;
undefine metesal;
undefine metecomm;
undefine metedepno;
--3. Devuelve el número total de empleados del departamento anterior.
DECLARE
numeroemp int:=0;
begin
select count(*) into numeroemp from emp;
dbms_output.PUT_LINE('El número total de empleados es '||numeroemp);
end;
/

--4. Actualiza el salario de los empleados que cobren más del valor del salario medio actual. Debes subirle el sueldo de estos empleados 200 más.
-- Debes mostrar el nombre de los trabajadores junto a su salario nuevo pero solo de los trabajadores que hayan visto modificado su salario.
DECLARE
cursor empleados is select * from emp where sal>(select avg(sal) from emp);
BEGIN
    for i in empleados loop
    update emp set sal=sal+200 where empno=i.empno;
    COMMIT;
    dbms_output.PUT_LINE('El trabajador es '||i.ename||' su antiguo salario es '||i.sal||' y su nuevo salario es '||(i.sal+200));
    end loop;
    end;
    /

--# Ejercicio 2 Hay que usar la tabla estudiantes. Se quiere guardar en una tabla el código de los estudiantes con una condición, solo se va a guardar en dicha tabla los códigos que sean pares (divisibles entre dos).
-- Una vez obtenida dicha información, recorre la tabla mostrando el nombre y los apellidos de cada alumno cuyo código esté en dicha tabla (usa la tabla para tus consultas).

--# Ejercicio 3Hay que usar la tabla estudiantes. Muestra por la salida el día (número) de nacimiento de aquellos estudiantes cuyos apellidos (campo apellidos) tengan 5 o más vocales.

# Ejercicio 4

1--. Crea una función obtenerNumMes que reciba como parámetro de entrada el nombre de un mes (ej.: SEPTIEMBRE, ENERO, JUNIO, etc.) y devuelva el número que corresponda a ese mes (09, 01, 06, etc.).
create or replace function obtenerNumMes(mes varchar2)
return int is
contador int :=0;
TYPE tipo_tabla IS TABLE OF varchar2(50) INDEX BY BINARY_INTEGER;
tipo_mes tipo_tabla;
begin
tipo_mes(1):='ENERO'; 
tipo_mes(2):='FEBRERO';
tipo_mes(3):='MARZO';
tipo_mes(4):='ABRIL';
tipo_mes(5):='MAYO';
tipo_mes(6):='JUNIO';
tipo_mes(7):='JULIO';      
tipo_mes(8):='AGOSTO';
tipo_mes(9):='SEPTIEMBRE';
tipo_mes(10):='OCTUBRE';
tipo_mes(11):='NOVIEMBRE';
tipo_mes(12):='DICIEMBRE';
for i in 1..12 loop
if tipo_mes(i)= upper(mes) THEN
return i;
end if;
end loop;
return 0;
end obtenerNumMes;
/
begin
dbms_output.put_line('El dia del mes de octubre es '||obtenerNumMes('OCTUBRE'));
end;
/
--2. Crea una función obtenerSalEmpMes que reciba como parámetro de entrada el número de un mes y devuelva la suma total de los salarios de los empleados que fueron contratados en ese mes pasado como parámetro.
 create or replace function obtenerSalEmpMes(numeroMes int)
 return emp.sal%TYPE IS
total int:=0;
 begin
 select sum(sal) into total from emp where trim(to_char(hiredate,'MM'))=numeroMes;
 if total is null then 
 return 0;
 end if;
 return total;
 end obtenerSalEmpMes;
 /
 begin
dbms_output.put_line('El salario del mes de octubre es '||obtenerSalEmpMes(05));
end;
/
select * from emp;
--3. Crea un paquete llamado libreriaEmp que contenga las funciones obtenerNumMes y obtenerSalEmpMes.
create or replace package libreriaEmp
IS
 function obtenerNumMes(mes varchar2)
return int;

 function obtenerSalEmpMes(numeroMes int)
 return emp.sal%TYPE;

end libreriaEmp;
/

create or replace  package body libreriaEmp is
function obtenerNumMes(mes varchar2)
return int is
contador int :=0;
TYPE tipo_tabla IS TABLE OF varchar2(50) INDEX BY BINARY_INTEGER;
tipo_mes tipo_tabla;
begin
tipo_mes(1):='ENERO'; 
tipo_mes(2):='FEBRERO';
tipo_mes(3):='MARZO';
tipo_mes(4):='ABRIL';
tipo_mes(5):='MAYO';
tipo_mes(6):='JUNIO';
tipo_mes(7):='JULIO';      
tipo_mes(8):='AGOSTO';
tipo_mes(9):='SEPTIEMBRE';
tipo_mes(10):='OCTUBRE';
tipo_mes(11):='NOVIEMBRE';
tipo_mes(12):='DICIEMBRE';
for i in 1..12 loop
if tipo_mes(i)= upper(mes) THEN
return i;
end if;
end loop;
return 0;
end obtenerNumMes;
function obtenerSalEmpMes(numeroMes int)
 return emp.sal%TYPE IS
total int:=0;
 begin
 select sum(sal) into total from emp where trim(to_char(hiredate,'MM'))=numeroMes;
 if total is null then 
 return 0;
 end if;
 return total;
 end obtenerSalEmpMes;
 end libreriaEmp;
 /
begin
dbms_output.put_line('El salario del mes de mayo es '||libreriaEmp.obtenerSalEmpMes(libreriaEmp.obtenerNumMes('Mayo')));
end;
/

--4. Crea un procedimiento mostrarSumSalEmpMes que reciba por parámetro un mes con letras (ej.: SEPTIEMBRE, ENERO, JUNIO, etc.) y muestre por la pantalla la suma total de los salarios de los empleados que fueron contratados en ese mes. Para ello debes usar el paquete libreriaEmp y las dos funciones que contiene dentro de la librería.

--5. Crea un bloque de código anónimo que guarde en una variable 'FEBRERO' y se le pase dicha variable al procedimiento mostrarSumSalEmpMes.

--6. Excepciones a tener en cuenta:
    - El mes introducido con letras debe existir. En caso contrario, crear una excepción personalizada que indique "Ese mes no existe" y devolver -1.
    - Hay al menos un empleado en la tabla EMP que fuera contratado (hiredate) en ese mes. En caso contrario, crear una excepción personalizada que indique por pantalla "No hay empleados contratados en ese mes" y devolver -1.

# Ejercicio 5

1. Crea una función obtenerEmpJobSal que tenga como parámetros el job, un valor de sal mínimo y un valor de sal máximo. Debe mostrar por pantalla el nombre (ename) de los empleados junto a su código empno que trabajen del puesto job pasado por parámetro, y además su salario (sal) se encuentre entre el sal mínimo y sal máximo pasados ambos como parámetros. Esta función debe devolver como return el número total de empleados que cumplan las condiciones anteriores y hayan sido mostrados por pantalla (solo el número).

2. Crear un bloque de código anónimo que llame a obtenerEmpJobSal con los siguientes parámetros:
    - SALESMAN
    - 1300
    - 1800

3. Excepciones a tener en cuenta:
    - El job pasado por parámetro debe existir en al menos un empleado. En caso contrario, usar una excepción personalizada mostrando el mensaje "No hay ese job en la tabla emp" y devolviendo -1.
    - Los valores mínimo y máximo pasados por parámetro deben cumplir que ambos son mayores que cero, y que el valor mínimo es menor que el valor máximo (segundo y tercer parámetro, en ese orden). En caso contrario, crear una excepción personalizada llamada condicionValNoCumple que muestre por pantalla "Los parámetros con los valores de sal no cumplen las condiciones adecuadas" y debe devolver -1.

# Ejercicio 6

Crea un procedimiento que se llame errorYear1981 que no tenga parámetros y que se encargue de modificar la tabla emp para que todos aquellos empleados que fueron contratados en el año 81 (hiredate) pasen a haber sido contratados en el año 82. Una vez actualizados los datos, mostrar por pantalla el número total de registros que hayan sido modificados con el siguiente mensaje "Se han actualizado xx filas de la tabla emp".

Crea un bloque de código anónimo que llame a este procedimiento errorYear1981.