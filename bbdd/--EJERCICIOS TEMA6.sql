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
create or replace function VERSALARIO(MIEMPNO EMP.EMPNO%TYPE)
return VARCHAR2
is
MINOMBRE EMP.ENAME%TYPE;
MISALARIO EMP.SAL%TYPE;
EXISTE INT:=0;
BEGIN
    SELECT COUNT(*) INTO EXISTE FROM EMP WHERE EMPNO =MIEMPNO;
    SELECT ENAME, SAL INTO MINOMBRE, MISALARIO FROM EMP WHERE EMPNO=MIEMPNO;
    IF EXISTE =1 THEN
    RETURN 'El nombre del empleado es '|| MINOMBRE|| ' y su salario es '|| MISALARIO;
    ELSE
    RAISE EMPNO_NOEXISTE;
    END IF;
    EXCEPTION
    WHEN no_data_found THEN
    return'EL EMPNO NO EXISTE';
END VERSALARIO;
/
BEGIN
    DBMS_OUTPUT.PUT_LINE(VERSALARIO(7839));
end;
/

--8. 
--Realiza una función a la que se le pase por parámetro un valor de empno de la tabla EMP, y si existe, que borre el registro completo.
--En el supuesto de que no haya encontrado ningún empno en la tabla EMP con dicho valor, que llame a una excepción que muestre por pantalla "No se ha podido borrar, el valor no existe en la base de datos".
create or replace function DELETEAR(MIEMPNO EMP.EMPNO%TYPE)
return VARCHAR2
is
MINOMBRE EMP.ENAME%TYPE;
MISALARIO EMP.SAL%TYPE;
EXISTE INT:=0;
EMPNO_NOEXISTE EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO EXISTE FROM EMP WHERE EMPNO =MIEMPNO;
    IF (EXISTE = 1) THEN
    DELETE FROM EMP WHERE EMPNO=MIEMPNO;
    COMMIT;
    return'SU EMPNO HA SIDO DELETEADO';
    else
    RAISE EMPNO_NOEXISTE;
    end if;
 exception
 when EMPNO_NOEXISTE then
   return'No se ha podido borrar, el valor no existe en la base de datos'; 
END DELETEAR;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE(DELETEAR(1));
end;

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
--10.Realiza una función que devuelva el número total de empleados de la tabla EMP.Si el número total es mayor de 5, crea una excepción que muestre el mensaje "hay más de 5 empleados".
create or replace function numeroTotalEmp
return NUMBER
is
contador int:=0;
MUCHOS_EMP EXCEPTION;
begin
select count(*) into contador from emp;
if contador>5 then 
raise MUCHOS_EMP;
else
return contador;
end if;
exception
when MUCHOS_EMP then
DBMS_OUTPUT.PUT_LINE('hay más de 5 empleados');
return null;
end numeroTotalEmp;
/
Begin
DBMS_OUTPUT.PUT_LINE(numeroTotalEmp);
end;
/
--18. Hacer una función obtenerNombreEmp que dado por parámetro un empno te devuelva el ename.
create or replace function obtenerNombreEmp(MIEMPNO EMP.EMPNO%TYPE)
return emp.ename%TYPE
is
miename emp.ename%TYPE;
ename_null EXCEPTION;
BEGIN
    select ename into miename from emp where EMPNO = MIEMPNO;
    if length(miename)>0 then
    return 'El nombre de su empleado es '||miename;
    ELSE
    raise ename_null;
    end if;
    exception
    when ename_null THEN
    return 'Su empleado no existe';
    end obtenerNombreEmp;
    /
    BEGIN
        DBMS_OUTPUT.PUT_LINE(obtenerNombreEmp(7839));
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
--32. Haz una función llamada DevolverCodDept que reciba el nombre de un departamento y devuelva su código.
create or replace function DevolverCodDept(MIDNAME dept.dname%type)
return dept.deptno%TYPE
is
MIDEPTNO dept.deptno%TYPE;
MIDEPTNO_NULL EXCEPTION;

BEGIN
    select deptno into MIDEPTNO from DEPT where upper(dname) =upper(MIDNAME);
    if MIDEPTNO>0  THEN
    RETURN MIDEPTNO;
    ELSE
    raise MIDEPTNO_NULL;
    end if;
    EXCEPTION
    when MIDEPTNO_NULL THEN
    DBMS_OUTPUT.PUT_LINE('ESE NOMBRE NO EXISTE');
    RETURN null;
    end DevolverCodDept;
    /
BEGIN
    DBMS_OUTPUT.PUT_LINE(DevolverCodDept('sales'));
    end;
    /
select * from DEPT;
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
--34.Realiza una función llamada CalcularCosteSalarial que reciba un nombre de departamento y devuelva la suma de los salarios y comisiones de los empleados de dicho departamento. Trata las excepciones que consideres necesarias.
create or replace function CalcularCosteSalarial(nombredepartamento dept.dname%type)
return emp.sal%TYPE
is
 cursor miemp is select * from emp join dept on dept.DEPTNO=emp.DEPTNO where upper(dept.DNAME)= upper(nombredepartamento);
 salarios emp.SAL%TYPE:=0;
Begin
for i in miemp LOOP
salarios:= Salarios+ i.sal;
if i.comm is not null THEN
salarios:= Salarios+ i.comm;
end if;
end loop;
return salarios;
end;
/
BEGIN
    DBMS_OUTPUT.PUT_LINE('El salario total del departamento es '||CalcularCosteSalarial('sales'));
    DBMS_OUTPUT.PUT_LINE('El salario total del departamento es '||CalcularCosteSalarial('RESEARCH'));
    end;
    /
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
 --37. Realiza un procedimiento MostrarMasAntiguos que muestre el nombre del empleado más antiguo 
 --de cada departamento junto con el nombre del departamento. Trata las excepciones que consideres necesarias.
create or replace procedure MostrarMasAntiguos
is

begin
for i in (select * from dept) loop
for ie in (select * from emp where deptno=i.deptno and hiredate=(select min(hiredate) from emp where deptno=i.deptno )) loop
DBMS_OUTPUT.PUT_LINE('EL empleado mas antiguo es '||ie.ename||' del departamento '||i.dname);
end loop;
end loop;
end MostrarMasAntiguos;
/
declare
 begin
    MostrarMasAntiguos;
    end;
--38. Realiza un procedimiento MostrarJefes que reciba el nombre de un departamento y
--muestre los nombres de los empleados de ese departamento que son jefes de otros empleados.Trata las excepciones que consideres necesarias.
create or REPLACE procedure MostrarJefes(nombredepartamento dept.dname%type)
IS

CURSOR empleadodepartamento IS
  SELECT DISTINCT e.ename
  FROM emp e
  JOIN dept d ON d.deptno = e.deptno
  WHERE d.dname = nombredepartamento
    AND e.empno IN (SELECT mgr FROM emp WHERE mgr IS NOT NULL);

BEGIN
    for i in empleadodepartamento LOOP
    DBMS_OUTPUT.PUT_LINE(i.ENAME);
    end loop;
EXCEPTION
    when no_data_found THEN
    DBMS_OUTPUT.PUT_LINE('ESE DEPARTAMENTO NO EXISTE');
 end MostrarJefes;
 /
select * from emp;
select * from dept;

DECLARE
depto dept.dname%type:='&METEDEPTO';
BEGIN
MostrarJefes(upper(depto));
end;
/
UNDEFINE METEDEPTO;
--PROCEDIMIENTO QUE MUESTRE EL NOMBRE Y SALARIO DEL EMPLEADO CUYO CÓDIGO EMPNO SE PASE POR PARÁMETRO. CONTROLAR QUE EL EMPNO EXISTE
--OPCIÓN 1 NO_DATA_FOUND, OPCIÓN 2 EXCEPCIÓN PERSONALIZADA
create or replace procedure MostrarDatosEmpleados(codigoempno emp.empno%type)
IS
nombre emp.ename%type;
salario emp.sal%type;
begin
select ename, sal into nombre, salario from emp where empno =codigoempno;
DBMS_OUTPUT.PUT_LINE('El empleado con codigo '||codigoempno||' se llama '||nombre||' y su salario es '|| salario);
exception
when no_data_found then 
DBMS_OUTPUT.PUT_LINE('No hay empleado en empno');
end MostrarDatosEmpleados;
/

create or replace procedure MostrarDatosEmpleados(codigoempno emp.empno%type)
IS
cursor empleados is select * from emp where empno=codigoempno;
contador int:=0;
NO_EMP EXCEPTION;
begin
 for i in empleados LOOP
   DBMS_OUTPUT.PUT_LINE('El empleado con codigo '||codigoempno||' se llama '||i.ename||' y su salario es '|| i.sal);
   contador:=contador+1;
    end loop;
if contador=0 then
raise NO_EMP;
end if;
exception
when NO_EMP then 
DBMS_OUTPUT.PUT_LINE('No hay empleado en empno');
end MostrarDatosEmpleados;
/

DECLARE
empno emp.empno%type:='&METEEMPNO';
BEGIN
MostrarDatosEmpleados(empno);
end;
/
UNDEFINE METEEMPNO;


--39. Realiza un procedimiento MostrarMejoresVendedores que muestre los nombres de los dos vendedores con más comisiones. 
--Trata las excepciones que consideres necesarias.
create or replace procedure MostrarMejoresVendedores 
IS
cursor vendedores is select * from emp where job = 'SALESMAN' order by comm;
contador int:=0;
BEGIN
    for i in vendedores loop
     contador:= contador+1;
 DBMS_OUTPUT.PUT_LINE('El vendedor numero '||contador|| ' es '|| i.ename);
 if contador =2 then 
 exit;
 end if;
 end loop;
 exception
when no_data_found then 
DBMS_OUTPUT.PUT_LINE('No hay Vendedores');
 end MostrarMejoresVendedores;
 /

 DECLARE
 BEGIN
   MostrarMejoresVendedores;
   end;
   / 
 

 

--40. Realiza un procedimiento MostrarsodaelpmE que reciba el nombre de un departamento al revés y muestre los nombres de los empleados de ese departamento. Trata las excepciones que consideres necesarias.
create or replace procedure Mostrarsodaelpm(reves dept.dname%type)
is
derecho dept.dname%type;
contador int:=0;
contador2 int:=0;
NO_EMP EXCEPTION;
Begin
contador:=length(reves);
FOR i in 0 ..contador-1 loop
derecho:= derecho||SUBSTR(reves,contador-i,1);
end loop;
DBMS_OUTPUT.PUT_LINE('EL DEPARTAMENTO '||upper(derecho));
for i in (select * from emp join dept on dept.DEPTNO = emp.DEPTNO  where dept.dname =upper(derecho))loop
    DBMS_OUTPUT.PUT_LINE('NOMBRE DEL EMPLEADO '||i.ename);
    contador2:=contador2+1;
end loop;
if contador2 =0 THEN
raise NO_EMP;
end if;
EXCEPTION
when NO_EMP THEN
DBMS_OUTPUT.PUT_LINE('EL DEPARMENTO '||upper(derecho)||' NO EXISTE');
end Mostrarsodaelpm;
/


 DECLARE
 nombredept dept.DNAME%TYPE:='selas';
 BEGIN
   Mostrarsodaelpm(nombredept);
   end;
   / 

 

--41. Realiza un procedimiento RecortarSueldos que recorte el sueldo un 20% a los empleados cuyo nombre empiece 
--por la letra que recibe como parámetro.Trata las excepciones que consideres necesarias.
create or replace procedure RecortarSuelos(letra emp.ename%type)
is 
cursor nemp  is select * from emp where ename like upper(letra) ||'%';
salold emp.SAL%TYPE;
contador int:=0;
NO_EMP EXCEPTION;
BEGIN
for i in nemp LOOP
update emp set sal =(sal/1.20) where empno = i.empno;
select sal into salold from emp where empno = i.empno;
DBMS_OUTPUT.PUT_LINE('El empleado '||i.ename|| ' cobraba '|| i.sal||' y ahora cobra '||salold);
contador:=contador+1;
end loop;
if contador =0 THEN
RAISE NO_EMP;
end if;
EXCEPTION
when no_emp THEN
DBMS_OUTPUT.PUT_LINE('NO HAY EMPLEADOS QUE EMPIECEN POR ESA LETRA');
end RecortarSuelos;
/
DECLARE
BEGIN
RECORTARSUELOS('t');
END;
 

 

--42. Realiza un procedimiento BorrarBecarios que borre a los dos empleados más nuevos de cada departamento. Trata las excepciones que consideres necesarias.
create or replace procedure BorrarBecarios
is 
cursor nuevos is select * from emp order by hiredate desc;
contador int:=0;
BEGIN
for i in nuevos loop
delete from emp where empno= i.empno;
DBMS_OUTPUT.PUT_LINE('El empleado '||i.ename|| ' ha sido borrado');
contador:=contador+1;
if contador =2 then 
exit;
end if;
end loop;
ROLLBACK;
end BorrarBecarios;
/
BEGIN
    BorrarBecarios;
end;
