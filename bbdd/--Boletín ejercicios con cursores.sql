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
CONTADOR INT:=0;
BEGIN
    FOR I IN DATOSEMPLEADOS LOOP
    DBMS_OUTPUT.PUT_LINE(I.EMPNO|| ' | '||I.ENAME||' | '||I.LOC);
    CONTADOR:=CONTADOR+1;
    END LOOP;
    IF CONTADOR=0 THEN
    DBMS_OUTPUT.PUT_LINE('NO HAY DATOS DE ESE EMPNO');
    END IF;
    EXCEPTION
    when too_many_rows then
    DBMS_OUTPUT.PUT_LINE('DEMASIADOS DATOS');
END;
/
UNDEFINE METEEMPNO;

--4 En la tabla EMP incrementar el salario el 10% a los empleados que tengan una comisi�n superior al 5% del salario. 
--Para ello recorre cada uno de los empleados, y en caso de que se de esa condici�n del 5%, realiza el update y muestra un mensaje con el nombre del empleado con sal actualizado.
DECLARE
Cursor empleados is Select * from emp where comm >SAL*0.05;
BEGIN
    for i in empleados LOOP
    UPDATE EMP set sal=i.sal*1.10 where empno =i.empno;
    DBMS_OUTPUT.PUT_LINE(i.ename|| ' | '|| i.sal);
    end loop;
    ROLLBACK;
end;
/
SELECT * from emp;

--3
--SE QUIERE MOSTRAR TODOS LOS EMPLEADOS SEPARADOS POR LA UBICACIÓN DE SU DEPARTAMENTO, ES DECIR, PRIMERO APAREZCA CHICAGO 
--Y DEBAJO TODOS LOS EMPLEADOS DE CHICAGO, LUEGO LA SIGUIENTE UBICACIÓN, ETC. SI NO HAY EMPLEADOS, QUE NO SE MUESTRE LA LOC
DECLARE
Cursor ciudad is select loc from dept;
ciudad2 dept.loc%type;
cursor empleado is select * from emp join dept on EMP.DEPTNO= dept.DEPTNO where dept.LOC = ciudad2;
hayempleado int:=0;
BEGIN
    for i in ciudad loop
     hayempleado:=0;
     ciudad2:=i.loc;
     for ij in empleado LOOP
     if hayempleado=0 THEN
      DBMS_OUTPUT.PUT_LINE('Su ciudad: '||i.loc);
     DBMS_OUTPUT.PUT_LINE('Sus trabajadores: ');
       hayempleado:= 1;
     end if;
     DBMS_OUTPUT.PUT_LINE(ij.ename);
     end loop;
    end loop;
end;
/
DECLARE
Cursor ciudad is select distinct loc from dept join emp on EMP.DEPTNO= dept.DEPTNO;
ciudad2 dept.loc%type;
cursor empleado is select * from emp join dept on EMP.DEPTNO= dept.DEPTNO where dept.LOC = ciudad2;
BEGIN
    for i in ciudad loop
     DBMS_OUTPUT.PUT_LINE('Su ciudad: '||i.loc);
     DBMS_OUTPUT.PUT_LINE('Sus trabajadores: ');
     ciudad2:=i.loc;
     for ij in empleado LOOP
     DBMS_OUTPUT.PUT_LINE(ij.ename);
     end loop;
    end loop;
end;
/
--5 Modifica el ejercicio anterior para, tras actualizar el salario, mostrar el nombre del empleado, la comisi�n, el salario antiguo y el salario nuevo. Adem�s, cuando no se actualice el salario, indicar un mensaje "El empleado XXX no ha tenido subida en su salario".
DECLARE
Cursor empleados is Select * from emp where comm >SAL*0.05;
nuevosal emp.sal%type;
BEGIN
    for i in empleados LOOP
    UPDATE EMP set sal=i.sal*1.10 where empno =i.empno;
    select sal into nuevosal from emp where empno =i.empno;
    DBMS_OUTPUT.PUT_LINE(i.ename||' | '|| i.sal|| ' | '|| nuevosal);
    end loop;
    ROLLBACK;
end;
/
--6 Pide que introduzca el usuario una cadena de caracteres por teclado. Muestra el empno y el ename de todos los empleados que tengan en su ename esa cadena introducida. Al finalizar, muestra un mensaje con el n�mero total de empleados que lo tienen.
declare
letra varchar2(100):='&METELETRA';
cursor empleados is select * from emp  where LENGTH(ename)!= LENGTH(replace(ename,letra));
contador int:=0;
begin
FOR i in empleados loop
DBMS_OUTPUT.PUT_LINE(i.ename||' | '||i.empno);
contador:=contador+1;
end loop;
if contador=0 then 
DBMS_OUTPUT.PUT_LINE('No hay empleados con esos caracteres');
else 
DBMS_OUTPUT.PUT_LINE('En estos caracteres hay '||contador||' empleados.');
end if;
end;
/
undefine METELETRA;
select * from emp;
--7 Muestra el nombre de cada departamento junto al n�mero de empleados que tiene, incluso si no tiene empleados.
DECLARE
cursor departamento is select * from dept;
ndept dept.dname%type;
cursor empleado is select * from emp join dept on dept.DEPTNO = emp.DEPTNO where dept.DNAME= ndept;
contador int:=0;
BEGIN
    for i in departamento LOOP
    DBMS_OUTPUT.PUT_LINE('Su departamento: '||i.dname);
    ndept:=i.dname;
    for ij in empleado LOOP
    if  ij.empno is not null then
    DBMS_OUTPUT.PUT_LINE('Su número de trabajador: '||ij.empno);
    contador:=contador+1;
    end if;
    end loop;
    DBMS_OUTPUT.PUT_LINE('Su departamento '||i.dname|| ' tiene: '||contador);
    contador:=0;
    end loop;
END;
/
--8 Busca todos los empleados que tienen salario + comisi�n mayor a 2000, y asignarles como salario esa suma. Solo puedes hacerlo si tienen comisi�n.
-- Muestra por la salida el nombre de todos los empleados que modifiquen su salario, as� como el n�mero total de empleados que se han actualizados.
DECLARE
cursor empleados is select * from emp where sal+COMM>2000;
salarioactualizado emp.SAL%TYPE;
contador int:=0;
BEGIN
    for i in empleados loop
    update emp set sal= i.sal+i.comm where empno =i.empno;
    select sal into salarioactualizado from emp where empno =i.empno; 
    DBMS_OUTPUT.PUT_LINE('El trabajador '|| i.ename ||' ganaba '|| i.sal || ' y ahora gana '|| salarioactualizado);
    contador:=contador+1;
    end loop;
    DBMS_OUTPUT.PUT_LINE('Ha modificado '||contador||' salarios.');
    ROLLBACK;
end;
/
select * from emp;
--9 Muestra el ename y sal de los cinco empleados con el salario m�s alto.
declare 
cursor empleados is select * from  emp order by sal desc;
contador int:=0;
begin 
for i in empleados loop
DBMS_OUTPUT.PUT_LINE('Su empleado: '||i.ename||'Su salario: '|| i.sal);
contador:=contador+1;
if contador=5 then
exit;
end if;
end loop;
end;
/
--10 Por cada puesto de trabajo (job), muestra el puesto y luego los dos empleados que tienen ese puesto y cobran menos. Si hay menos de dos empleados, muestra los que haya.BEGIN
DECLARE

cursor puesto is select distinct job from emp;
npuesto emp.job%type;
cursor empleados is select * from emp where JOB =npuesto order by sal;
contador int:=0;
BEGIN
    for i in puesto loop
    contador:=0;
    DBMS_OUTPUT.PUT_LINE('El puesto de trabajo es: '||i.job);
    npuesto:=i.job;
        for ie in empleados loop
            DBMS_OUTPUT.PUT_LINE('Su trabajador es: '||ie.ename);
            contador:=contador+1;
            if contador=2 THEN
                exit;
            end if;
        end loop;
    end loop;
end;
/