 --EJERCICIOS TEMA6

--1. 
--Se quiere saber si un año es bisiesto o no. 
--Para ello, se debe pedir por pantalla introducir un año, y luego se mostrará un mensaje por pantalla indicando 
--"El año es bisiesto" o "El año no es bisiesto", según corresponda.
 --Un año es bisiesto si el resto de dividir el año entre 4 es cero y además, el resto de dividir ese año entre 100 
 --es distinto de cero o bien el resto de dividir ese año entre 400 es cero.
DECLARE
AGE int:=&dime_el_AGE;
BEGIN
    IF To_number(To_char(last_day(to_date('01/02/'||age, 'DD/MM/YYYY')), 'DD'))=29  then
    DBMS_OUTPUT.PUT_LINE('El año es bisiesto');
    ELSE 
    DBMS_OUTPUT.PUT_LINE('El año no es bisiesto');
    END IF;
    END;
    /
    UNDEFINE dime_el_AGE;
--2. 
--Realiza el ejercicio anterior pero usando la siguiente condición para saber si es bisiesto: "un año bisiesto tiene 366 días".
DECLARE
AGE int:= &dime_el_AGE;
BEGIN
    IF TO_DATE('01/01/'||(age+1))-TO_DATE('01/01/'||age)=366  then
    DBMS_OUTPUT.PUT_LINE('El año es bisiesto');
    ELSE 
    DBMS_OUTPUT.PUT_LINE('El año no es bisiesto');
    END IF;
    END;
    /
  UNDEFINE dime_el_AGE;
--3. 
--Obtener dos listas con los pares e impares desde el 1 hasta el número que se introduzca por pantalla.
DECLARE
minumero int:=&Dime_un_Numero;
type lista is table of int index by BINARY_INTEGER;
mispares lista;
misimpares lista;
BEGIN
    for i in 1..minumero LOOP
    if mod(i,2)=0 then
    mispares(i):=i;
    ELSE
    misimpares(i):=i;
    end if;
    end loop;
    for i in 1..mispares.count loop
    if mispares.exists(i) then 
    DBMS_OUTPUT.PUT_LINE(mispares(i));
    end if;
    end loop;
    for i in 1..misimpares.count loop
    if misimpares.exists(i) then
    DBMS_OUTPUT.PUT_LINE(misimpares(i));
    end if;
    end loop;
end;
/
 UNDEFINE Dime_un_Numero;
--4. 
--Dado un determinado código de departamento (DEPTNO) de la tabla DEPT, devolver por pantalla el nombre (DNAME).
DECLARE
mideptno dept.deptno%type :=&METEDEPTNO;
midname dept.DNAME%type;
EXISTE int:=0;
begin
select count(*) into existe from dept where deptno=mideptno;
if existe=1 then
select dname into midname from dept where deptno=mideptno;
    DBMS_OUTPUT.PUT_LINE(midname);
ELSE
 DBMS_OUTPUT.PUT_LINE('No es un deptno valido, picha. ');
end if;
end;
/
undefine METEDEPTNO;

--5. 
--Obtener el nombre (ENAME) y puesto de trabajo (JOB) del empleado (tabla EMP) que tenga el código (EMPNO) igual a 7782.
DECLARE
MIENAME EMP.ENAME%TYPE;
MIJOB EMP.JOB%TYPE;
BEGIN
    SELECT ENAME, JOB INTO MIENAME, MIJOB FROM EMP WHERE EMPNO =7782;
    DBMS_OUTPUT.PUT_LINE(MIENAME||MIJOB);
END;
/
--6. 
--Pedir por pantalla un NIF (8 números y una letra). Comprobar si la letra es correcta y luego mostrar por pantalla si ese NIF es correcto.
DECLARE 
MINIF char(9):='&METEDNI';
NUMNIF INT:=TO_NUMBER(SUBSTR(MINIF,1,8));
CHARNIF CHAR(1):= SUBSTR(MINIF,9,1);
COMPARACION INT:=MOD(NUMNIF,23)+1;
VERIFICACION VARCHAR2(23):='TRWAGMYFPDXBNJZSQVHLCKE';
BEGIN
IF UPPER(CHARNIF) = SUBSTR(VERIFICACION,COMPARACION,1)THEN
   DBMS_OUTPUT.PUT_LINE('SU DNI ES CORRECTO');
ELSE 
    DBMS_OUTPUT.PUT_LINE('SU DNI NO ES CORRECTO');
END IF;
END;
/
UNDEFINE METEDNI;
--7. 
--Realiza una función a la que se le pase por parámetro un valor de empno de la tabla EMP, y devuelva los campos nombre y salario.
--En el supuesto de que no haya encontrado ningún empno en la tabla EMP con dicho valor, que llame a una excepción que muestre por pantalla "Valor no existe en la base de datos".
DECLARE
MIEMPNO EMP.EMPNO%TYPE:=&METEEMPNO;
MINOMBRE EMP.ENAME%TYPE;
MISALARIO EMP.SAL%TYPE;
EXISTE INT:=0;
BEGIN
    SELECT COUNT(*) INTO EXISTE FROM EMP WHERE EMPNO =MIEMPNO;
    SELECT ENAME, SAL INTO MINOMBRE, MISALARIO FROM EMP WHERE EMPNO=MIEMPNO;
    IF EXISTE =1 THEN
    DBMS_OUTPUT.PUT_LINE(MINOMBRE|| ' '|| MISALARIO);
    ELSE
    DBMS_OUTPUT.PUT_LINE('EL EMPNO NO ES CORRECTO');
    END IF;
END;
/
UNDEFINE METEEMPNO;

--8. 
--Realiza una función a la que se le pase por parámetro un valor de empno de la tabla EMP, y si existe, que borre el registro completo.
--En el supuesto de que no haya encontrado ningún empno en la tabla EMP con dicho valor, que llame a una excepción que muestre por pantalla "No se ha podido borrar, el valor no existe en la base de datos".
DECLARE
MIEMPNO EMP.EMPNO%TYPE:= &METEEMPNO;
MINOMBRE EMP.ENAME%TYPE;
MISALARIO EMP.SAL%TYPE;
EXISTE INT:=0;
BEGIN
    SELECT COUNT(*) INTO EXISTE FROM EMP WHERE EMPNO =MIEMPNO;
    
    IF EXISTE =1 THEN
    DELETE FROM EMP WHERE EMPNO=MIEMPNO;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('SU EMPNO HA SIDO DELETEADO');
    ELSE
    DBMS_OUTPUT.PUT_LINE('No se ha podido borrar, el valor no existe en la base de datos');
    END IF;
END;
/
UNDEFINE METEEMPNO;
--9. 
--Realiza un procedimiento que muestre por pantalla el nombre de todos los departamentos de la tabla DEPT.
create or replace PROCEDURE nombredepart 
is
BEGIN
    for i in (select * from dept) loop
    DBMS_OUTPUT.PUT_LINE(i.dname);
    end loop;

END nombredepart;
/

DECLARE
BEGIN
    nombredepart;
end;
/
--19. Hacer un procedimiento mostrarDatosEmp que reciba por parámetro un empno y muestre por pantalla el nombre del empleado y el nombre de su jefe. Utiliza la función obtenerNombreEmp.
create or REPLACE PROCEDURE mostrarDatosEmp(numeroempleado emp.empno%type)
IS
nombreempleado emp.ENAME%TYPE;
nombrejefe emp.ENAME%TYPE;
codigojefe emp.MGR%TYPE;
begin
select ename, mgr into nombreempleado,codigojefe from emp  where empno=numeroempleado;
select ename into nombrejefe from emp where mgr=codigojefe;
DBMS_OUTPUT.PUT_LINE('El empleado es '|| nombreempleado || ', El jefe es '||nombrejefe);
EXCEPTION
when no_data_found then
DBMS_OUTPUT.PUT_LINE('El empleado es '|| nombreempleado ||' No hay jefe ');

end mostrarDatosEmp;
select * from emp;

 DECLARE
 BEGIN
    mostrarDatosEmp(7839);
    end;
    /

--33. Realiza un procedimiento llamado HallarNumEmp que recibiendo un nombre de departamento, muestre en pantalla el número de empleados de dicho departamento. Puedes utilizar la función creada en el ejercicio 32. Si el departamento no tiene empleados deberá mostrar un mensaje informando de ello. Si el departamento no existe se tratará la excepción correspondiente.
create or REPLACE procedure HallarNumEmp (nombredepartamento dept.dname%type)
IS
existe dept.dname%type;
numeroempleados int:=0;
BEGIN
 select dname into existe from dept where dept.DNAME=nombredepartamento;
  select count(*) into numeroempleados from emp join dept on dept.deptno =EMP.DEPTNO where dept.DNAME=existe;
  IF existe is not null and numeroempleados>0 then
 DBMS_OUTPUT.PUT_LINE('El numero de empleados es '||numeroempleados|| ', su departamento '|| existe);
 ELSIF existe is not null and numeroempleados =0 then
DBMS_OUTPUT.PUT_LINE('El departamento no tiene empleados');

 end if;
 exception
 when no_data_found then 
DBMS_OUTPUT.PUT_LINE('El departamento no existe');
 end HallarNumEmp;
 /

 DECLARE
 BEGIN
    HallarNumEmp('sales');
    end;
    /

 select * from dept;

--35. Realiza un procedimiento MostrarCostesSalariales que muestre los nombres de todos los departamentos y el coste salarial de cada uno de ellos.
create or REPLACE procedure  MostrarCostesSalariales
IS
salario emp.SAL%TYPE:=0;
BEGIN
    for i in (select * from dept)loop
    select sum(SAL) into salario from emp join dept on dept.deptno =EMP.DEPTNO where dept.DEPTNO =i.deptno;
    if salario is not null then
    DBMS_OUTPUT.PUT_LINE('Su departamento es '|| i.dname || ' ' ||'Su coste salarial es '|| salario );
    else
    DBMS_OUTPUT.PUT_LINE('Su departamento es '|| i.dname || ' ' ||'No tiene coste salarial');
    end if;
    end loop;
end;
/
 DECLARE
 BEGIN
    MostrarCostesSalariales;
 end;
 /
 

 

--36. Realiza un procedimiento MostrarAbreviaturas que muestre las tres primeras letras del nombre de cada empleado.
create or REPLACE procedure MostrarAbreviaturas
IS

BEGIN
    for i in (select * from emp)LOOP
    DBMS_OUTPUT.PUT_LINE(SUBSTR(i.ename,1,3));
    end loop; 
 end MostrarAbreviaturas;
 /

 declare
 begin
    MostrarAbreviaturas;
    end;
 

--38. Realiza un procedimiento MostrarJefes que reciba el nombre de un departamento y muestre los nombres de los empleados de ese departamento que son jefes de otros empleados.Trata las excepciones que consideres necesarias.
create or REPLACE procedure MostrarJefes(nombredepartamento dept.dname%type)
IS
cursor empleadodepartamento is select * from emp join DEPT on DEPT.DEPTNO =emp.EMPNO join emp J on J.EMPNO = emp.EMPNO where DEPT.DNAME = nombredepartamento and emp.MGR =j.EMPNO;
BEGIN
    for i in empleadodepartamento LOOP
    DBMS_OUTPUT.PUT_LINE('');
    end loop;
EXCEPTION
    when no_data_found THEN
    DBMS_OUTPUT.PUT_LINE('ESE DEPARTAMENTO NO EXISTE');
 end;
 /
select * from emp;
 

--39. Realiza un procedimiento MostrarMejoresVendedores que muestre los nombres de los dos vendedores con más comisiones. Trata las excepciones que consideres necesarias.

 

 

--40. Realiza un procedimiento MostrarsodaelpmE que reciba el nombre de un departamento al revés y muestre los nombres de los empleados de ese departamento. Trata las excepciones que consideres necesarias.

 

 

--41. Realiza un procedimiento RecortarSueldos que recorte el sueldo un 20% a los empleados cuyo nombre empiece por la letra que recibe como parámetro.Trata las excepciones que consideres necesarias.

 

 

--42. Realiza un procedimiento BorrarBecarios que borre a los dos empleados más nuevos de cada departamento. Trata las excepciones que consideres necesarias.

