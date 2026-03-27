set SERVEROUTPUT on;
BEGIN
    DBMS_OUTPUT.PUT_LINE('HOLA MUNDO');
END;
/
DECLARE HM VARCHAR2(100):= 'HOLA MUNDO';
BEGIN

    DBMS_OUTPUT.PUT_LINE(HM);
END;
/
DECLARE HM VARCHAR2(100):= 'HOLA MUNDO ';
        NUMERO INT:=32;
BEGIN

    DBMS_OUTPUT.PUT_LINE(HM||NUMERO);
END;
/
DECLARE
    MIFECHA DATE;
    MIFECHA2 DATE:= '23/01/2026';
    NONULA NUMBER(3,2) NOT NULL:=111;
    SALE NUMBER (4,2) := 10.99;
    CLASE VARCHAR2(15):= 'CLASE DE DAMDAW';
    CE CONSTANT INT:=11;
BEGIN

END;
/
DECLARE
    NOMBREEMPLEADO EMP.ENAME%TYPE := 'TOMAS';
    MIEMPLEADO EMP%ROWTYPE;
BEGIN
    MIEMPLEADO.ENAME := 'MARIA';
    DBMS_OUTPUT.PUT_LINE(NOMBREEMPLEADO);
    DBMS_OUTPUT.PUT_LINE(MIEMPLEADO.SAL);
    DBMS_OUTPUT.PUT_LINE(MIEMPLEADO.ENAME);
END;
/
DECLARE
MICLIENTE CLIENTES%ROWTYPE;
BEGIN
SELECT ID, NOMBRE, TFNO INTO MICLIENTE FROM CLIENTES WHERE NOMBRE ='ANDRES PEREZ';
DBMS_OUTPUT.PUT_LINE(MICLIENTE.ID);
DBMS_OUTPUT.PUT_LINE(MICLIENTE.NOMBRE);
DBMS_OUTPUT.PUT_LINE(MICLIENTE.TFNO);
END;
/
DECLARE
    NOMBRE EMP.ENAME%TYPE;
    EMPLEADO EMP%ROWTYPE;
BEGIN
    SELECT ENAME INTO NOMBRE FROM EMP WHERE EMPO=7839;
    SELECT * INTO EMPLEADO FROM EMP WHERE EMPO =7698;
    DBMS_OUTPUT.PUT_LINE(EMPLEADO.ENAME|| ' '||NOMBRE);
END;
/
DECLARE
NUMERO INT:=&METE_UN_NUMERO;
BEGIN
    DBMS_OUTPUT.PUT_LINE('SU NUMERO  '||NUMERO);
END;
/
UNDEFINE METE_UN_NUMERO;

DECLARE
BASE INT:=&METE_LA_BASE;
ALTURA INT:=&METE_LA_ALTURA;
AREA NUMBER(5,2):=ROUND(BASE*ALTURA/2);
BEGIN
    
    DBMS_OUTPUT.PUT_LINE('SU AREA ES: '|| AREA);
END;
/
UNDEFINE METE_LA_BASE;
UNDEFINE METE_LA_ALTURA;

DECLARE
NOMBRE VARCHAR2(10):= '&DIME_TU_NOMBRE';
APELLIDO VARCHAR2(10):= '&DIME_TU_APELLIDO';
BEGIN
    
    DBMS_OUTPUT.PUT_LINE('SU NOMBRE COMPLETO ES '|| NOMBRE|| ' ' ||APELLIDO);
END;
/
UNDEFINE DIME_TU_NOMBRE;
UNDEFINE DIME_TU_APELLIDO;

DECLARE
NUMERO1 INT:= &DIME_TU_PRIMER_NUMERO;
NUMERO2 INT:= &DIME_TU_SEGUNDO_NUMERO;
SUMA INT := NUMERO1+NUMERO2;
RESTA INT:=NUMERO1-NUMERO2;
MULTIPLICACION INT :=NUMERO1*NUMERO2;
DIVISION NUMBER(5,2):=NUMERO1/NUMERO2;
BEGIN
    
    DBMS_OUTPUT.PUT_LINE(' SU SUMA ES: '||SUMA|| ' SU RESTA ES: '|| RESTA|| ' SU MULTIPLICACION ES: '||MULTIPLICACION||' SU DIVISION ES: '||DIVISION);
END;
/
UNDEFINE DIME_TU_PRIMER_NUMERO;
UNDEFINE DIME_TU_SEGUNDO_NUMERO;

DECLARE
NUMERO1 INT:= &DIME_TU_PRIMER_NUMERO;
NUMERO2 INT:= &DIME_TU_SEGUNDO_NUMERO;
RESTA INT:=NUMERO1-NUMERO2;
BEGIN
IF NUMERO1 >= NUMERO2 THEN

    DBMS_OUTPUT.PUT_LINE( ' SU RESTA ES: '|| RESTA );
    ELSE
    DBMS_OUTPUT.PUT_LINE(NUMERO1 || ' ES MENOR QUE '|| NUMERO2);
    END IF;
END;
/
UNDEFINE DIME_TU_PRIMER_NUMERO;
UNDEFINE DIME_TU_SEGUNDO_NUMERO;

DECLARE
NUMERO1 INT:= &DIME_TU_PRIMER_NUMERO;
NUMERO2 INT:= &DIME_TU_SEGUNDO_NUMERO;
SUMA INT := NUMERO1+NUMERO2;
BEGIN
IF NUMERO1 > NUMERO2 THEN

    DBMS_OUTPUT.PUT_LINE( ' SU SUMA ES: '|| SUMA );
    ELSE
    DBMS_OUTPUT.PUT_LINE('SU NUMERO NO ES CORRECTO');
    END IF;
END;
/
UNDEFINE DIME_TU_PRIMER_NUMERO;
UNDEFINE DIME_TU_SEGUNDO_NUMERO;

DECLARE
NOTA INT:= &DIME_TU_NOTA;

BEGIN
IF NOTA>=9 THEN

    DBMS_OUTPUT.PUT_LINE( 'TIENE UN SOBRESALIENTE');
    ELSIF NOTA>=7 THEN
    DBMS_OUTPUT.PUT_LINE( 'TIENE UN NOTABLE');
    ELSIF NOTA>=6 THEN
     DBMS_OUTPUT.PUT_LINE( 'TIENE UN BIEN');
     ELSIF NOTA >=5 THEN
    DBMS_OUTPUT.PUT_LINE( 'TIENE UN APROBADO');
    ELSIF NOTA<5 THEN
    DBMS_OUTPUT.PUT_LINE( 'TIENE UN SUSPENSO');
    ELSE
    DBMS_OUTPUT.PUT_LINE("SU NUMERO ES ERRONEO ");
  
    END IF;
END;
/
UNDEFINE DIME_TU_NOTA;
DECLARE
NOTA INT:= &DIME_TU_NOTA;
BEGIN
WHEN NOTA>=9 THEN

    DBMS_OUTPUT.PUT_LINE( 'TIENE UN SOBRESALIENTE');
    WHEN NOTA>=7 THEN
    DBMS_OUTPUT.PUT_LINE( 'TIENE UN NOTABLE');
    WHEN NOTA>=6 THEN
     DBMS_OUTPUT.PUT_LINE( 'TIENE UN BIEN');
     WHEN NOTA >=5 THEN
    DBMS_OUTPUT.PUT_LINE( 'TIENE UN APROBADO');
    WHEN NOTA<5 THEN
    DBMS_OUTPUT.PUT_LINE( 'TIENE UN SUSPENSO');
    ELSE
    DBMS_OUTPUT.PUT_LINE("SU NUMERO ES ERRONEO ");
  
    END IF;
END;
/
UNDEFINE DIME_TU_NOTA;


DECLARE
NUMERO EMP.EMPNO%TYPE:= &DIME_UN_MUMERO;
NOMBRE EMP.ENAME%TYPE;
BEGIN
    SELECT ENAME INTO NOMBRE FROM EMP WHERE EMPNO =NUMERO;
    DBMS_OUTPUT.PUT_LINE('EL NOMBRE DEL EMPLEADO ES '|| NOMBRE);
END;
/
UNDEFINE DIME_UN_MUMERO;

DECLARE
NUMERO EMP.EMPNO%TYPE:= &DIME_UN_MUMERO;
NOMBRE EMP.ENAME%TYPE;
BEGIN
    SELECT ENAME INTO NOMBRE FROM EMP WHERE EMPNO =NUMERO;
    IF LENGTH(NOMBRE)>0 THEN
    DBMS_OUTPUT.PUT_LINE('EL NOMBRE DEL EMPLEADO ES '|| NOMBRE||'.');
    ELSE
    DBMS_OUTPUT.PUT_LINE('EL EMPLEADO NO EXISTE.');
    END IF;
END;
/
UNDEFINE DIME_UN_MUMERO;

DECLARE
GOLES_CASA INT:= &GOLES_CASA;
GOLES_FUERA INT:= &GOLES_FUERA;
BEGIN
    IF GOLES_CASA>GOLES_FUERA then
     DBMS_OUTPUT.PUT_LINE('El equipo local ha ganado.');
     ELSIF GOLES_CASA<GOLES_FUERA then
     DBMS_OUTPUT.PUT_LINE('El equipo visitante ha ganado');
     ELSE
     DBMS_OUTPUT.PUT_LINE('El resultado del partido ha sido empate');
     END if;
END;
/
UNDEFINE GOLES_CASA;
UNDEFINE GOLES_FUERA;

DECLARE
numero int;
BEGIN
    numero:=1;
loop
    DBMS_OUTPUT.PUT_LINE(numero);
    numero:=numero+1;
    exit when numero = 80 ;
END loop;
end;
/
--13
DECLARE
numero int;
BEGIN
    numero:=0;
loop
    DBMS_OUTPUT.PUT_LINE(numero);
    numero:=numero+1;
    exit when numero >20 ;
END loop;
end;
/

DECLARE
numero int;
BEGIN
    numero:=0;
loop
    DBMS_OUTPUT.PUT_LINE(numero);
    numero:=numero+1;
   if numero >20 then exit;
   end if;
END loop;
end;
/

DECLARE
numero int;
BEGIN
    numero:=0;
while numero<=20 loop 
   DBMS_OUTPUT.PUT_LINE(numero);
    numero:=numero+1;

END loop;
end;
/
DECLARE
numero int;
BEGIN
    numero:=0;
for indice in 0..20 loop
   DBMS_OUTPUT.PUT_LINE(numero);
    numero:=numero+1;

END loop;
end;
/

DECLARE
numero int;
BEGIN
    numero:=0;
for indice in reverse 0..20 loop
   DBMS_OUTPUT.PUT_LINE(numero);
    numero:=numero+1;

END loop;
end;
/
--17
DECLARE
numero int;
BEGIN
    numero:=20;
for indice in reverse 0..20 loop
   DBMS_OUTPUT.PUT_LINE(numero);
    numero:=numero-1;

END loop;
end;
/
--18
DECLARE
numero int;
BEGIN
    numero:=0;
for numero in  1..40 loop
if mod(numero,2)=0 then
   DBMS_OUTPUT.PUT_LINE(numero);
   End if;
END loop;
end;
/
--19
DECLARE
numero int;
variable int;
resultado int;
BEGIN
    numero:=0;
    variable:=0;
for numero in 1..10 loop

    for variable in  0..9 loop
resultado:=numero*variable;
   DBMS_OUTPUT.PUT_LINE(numero||'  X '||variable||' = '|| resultado);
    END loop;
      END loop;
end;
/
--20
select * from dept;
DECLARE
NUMEROMaxº
dept.depno%TYPE;

BEGIN
   
for numero in 10..40 loop
select dname from dept where depno=numero
DBMS_OUTPUT.PUT_LINE();

END loop;
end;
/
DECLARE
    TYPE TPERSONA IS RECORD(
        CODIGO NUMBER(4,2),
        NOMBRE VARCHAR2(100),
        EDAD INT
    );
    TYPE ALUMNO IS RECORD(
        NOMBRE VARCHAR(100),
        PROFESOR TPERSONA
    );
    ALUMNO1 ALUMNO;
    ALUMNO2 ALUMNO;
BEGIN
   ALUMNO1.NOMBRE:='PEPE';
   ALUMNO1.PROFESOR.NOMBRE:='PEPON';
   ALUMNO1.PROFESOR.CODIGO:=12.34;
   ALUMNO1.PROFESOR.EDAD:=60;
   ALUMNO2.NOMBRE:='PEPI';
     ALUMNO2.PROFESOR.CODIGO:=3.14;
   DBMS_OUTPUT.PUT_LINE(ALUMNO1.PROFESOR.NOMBRE);
    DBMS_OUTPUT.PUT_LINE(ALUMNO1.PROFESOR.CODIGO);
     DBMS_OUTPUT.PUT_LINE(ALUMNO1.NOMBRE);
      DBMS_OUTPUT.PUT_LINE(ALUMNO1.PROFESOR.EDAD); 
       DBMS_OUTPUT.PUT_LINE(ALUMNO2.NOMBRE);
        DBMS_OUTPUT.PUT_LINE(ALUMNO2.PROFESOR.CODIGO);
END;
/
DECLARE

TYPE TIPODEPT IS RECORD(
    
    ID DEPT.DEPTNO%TYPE,
    NOMBRE DEPT.DNAME%TYPE,
    LOCALIDAD DEPT.LOC%TYPE
);
fila TIPODEPT;
fila2 TIPODEPT;
BEGIN
    SELECT * INTO fila.ID, fila.NOMBRE,fila.LOCALIDAD FROM DEPT WHERE DEPTNO=10;
    SELECT DEPTNO, DNAME INTO fila2.ID, fila2.NOMBRE FROM DEPT WHERE DEPTNO=20;
    DBMS_OUTPUT.PUT_LINE(fila.ID);
    DBMS_OUTPUT.PUT_LINE(fila.NOMBRE);
    DBMS_OUTPUT.PUT_LINE(fila.LOCALIDAD);
    DBMS_OUTPUT.PUT_LINE(fila2.ID);
    DBMS_OUTPUT.PUT_LINE(fila2.NOMBRE);
    END;
    /
DECLARE

filacompleta dept%ROWTYPE;
BEGIN
select * into filacompleta from dept where DEPTNO= 30;
DBMS_OUTPUT.PUT_LINE(filacompleta.deptno|| ' ' || filacompleta.dname|| ' ' ||filacompleta.loc);
end;
/
DECLARE
filacompleta dept%ROWTYPE;
BEGIN
select deptno, loc into filacompleta.deptno, filacompleta.loc from dept where DEPTNO= 40;
DBMS_OUTPUT.PUT_LINE(filacompleta.deptno|| ' ' ||filacompleta.loc);
end;
/
--ej 7
Declare 
type mitipotabla is table of int index by Binary_integer;
mitabla mitipotabla;
BEGIN
for i in 0..20 loop
mitabla(i):=i;
end loop;
for i in 0..20 loop
DBMS_OUTPUT.PUT_LINE(mitabla(i));
end loop;
end;
/
Declare
type persona is record(
    nombre varchar(50),
    apellido1 varchar(100),
    apellido2 varchar(100)
);
type personas is table of persona index by binary_integer;
mipersona personas;
begin
for i in 1..2 loop
mipersona(i).nombre:='daniel'||i;
mipersona(i).apellido1:='vazquez'||i;
mipersona(i).apellido2:='Chinchilla'||i;
end loop;
for i in 1..2 loop
DBMS_OUTPUT.PUT_LINE(mipersona(i).nombre);
DBMS_OUTPUT.PUT_LINE(mipersona(i).apellido1);
DBMS_OUTPUT.PUT_LINE(mipersona(i).apellido2);
end loop;
end;
/
--ejercicio 9
Declare 
type mitipotabla is table of int index by Binary_integer;
mitabla mitipotabla;
BEGIN
for i in 0..20 loop
mitabla(i):=i;
end loop;
for i in mitabla.first..mitabla.last loop
DBMS_OUTPUT.PUT_LINE(mitabla(i));
end loop;
DBMS_OUTPUT.PUT_LINE('Su tabla tiene '||mitabla.count||' elementos.');
mitabla.delete(mitabla.last);
DBMS_OUTPUT.PUT_LINE('Su tabla tiene '||mitabla.count||' elementos.');
if mitabla.exists(10) then
DBMS_OUTPUT.PUT_LINE('Existe');
ELSE
DBMS_OUTPUT.PUT_LINE('No existe');
end if;
end;
/
--Ejercicio 10
DECLARE
usuario1 emp.EMPNO%type :=&DIME_USUARIO_1;
usuario2 emp.EMPNO%type :=&DIME_USUARIO_2;
TYPE EMPS IS TABLE OF EMP%ROWTYPE INDEX OF BINARY_INTEGER;
miemps emps;
numero int:=0;
BEGIN
FOR I  IN usuario1..usuario2 loop
select * into miemps(numero) form emp where empno =i;
numero:=numero+1
end loop;
for i in miemps.first..miemps.last loop
DBMS_OUTPUT.PUT_LINE(miemps(i).ENAME || ' | '|| miemps(i).job|| ' | '||miemps(i).empno)
end loop;
end;
UNDEFINE DIME_USUARIO_1;
UNDEFINE DIME_USUARIO_2;
/

DECLARE
    EMPNO12 CHAR(9) := '&METEEMPNO12';
    TYPE TEMPNOS IS TABLE OF EMP.EMPNO%TYPE INDEX BY BINARY_INTEGER;
    TABLAEMPNOS TEMPNOS;
    TYPE TEMP IS TABLE OF EMP%ROWTYPE INDEX BY BINARY_INTEGER;
    FILASEMP TEMP;
    CONTADOR INT := 1;
BEGIN
    TABLAEMPNOS(1) := TO_NUMBER(SUBSTR(EMPNO12,1,INSTR(EMPNO12,'|')-1));
    TABLAEMPNOS(2) := TO_NUMBER(SUBSTR(EMPNO12,INSTR(EMPNO12,'|')+1));

    FOR I IN TABLAEMPNOS.FIRST..TABLAEMPNOS.LAST LOOP
        SELECT *
            INTO FILASEMP(I)
            FROM EMP
            WHERE EMPNO = TABLAEMPNOS(I);
    END LOOP;
    WHILE CONTADOR <= FILASEMP.COUNT LOOP
        DBMS_OUTPUT.PUT_LINE(FILASEMP(CONTADOR).EMPNO);
        DBMS_OUTPUT.PUT_LINE(FILASEMP(CONTADOR).ENAME);
        CONTADOR := CONTADOR + 1;
    END LOOP;
END;
/
--Cursores
Declare
codigo asignaturas.codigo%type;
codigo2 asignaturas.codigo%type;
profe asignaturas.profesor%type;
begin
--select codigo into codigo  from asignaturas where descripcion= 'Programacion';
select profesor into profe from asignaturas where descripcion = 'Redes';
select codigo into codigo2 from asignaturas where descripcion in('Ingles','Frances');
DBMS_OUTPUT.PUT_LINE(profe);
exception
when  no_data_found then
    DBMS_OUTPUT.PUT_LINE('No existe esa asignatura.');

end;
/
--ejercicio1
declare 
midni estudiantes.dni%type:='&METEDNI';
minombre estudiantes.nombre%type;
miapellido estudiantes.apellidos%type;
begin
select nombre, apellidos into minombre, miapellido from estudiantes where dni = midni;
DBMS_OUTPUT.PUT_LINE(minombre|| ' '|| miapellido);
exception
when no_data_found then 
DBMS_OUTPUT.PUT_LINE('Ese dni no esta en la base de datos');
end;
/
UNDEFINE METEDNI;

--ejercicio2
declare
minombre estudiantes.nombre%type:='&METENOMBRE';
midni estudiantes.dni%type;
miapellido estudiantes.apellidos%type;
begin
select dni, apellidos into midni, miapellido from estudiantes where nombre= minombre;

DBMS_OUTPUT.PUT_LINE(midni||' '||miapellido);
exception
when too_many_rows then
DBMS_OUTPUT.PUT_LINE('Hay mas de un estudiante');
when no_data_found then
DBMS_OUTPUT.PUT_LINE('No hay datos');
end;
/
undefine METENOMBRE;
--ejercicio3
declare
cursor misestudiantes is select * from estudiantes;
fila estudiantes%ROWTYPE;
begin
open misestudiantes;
loop
fetch misestudiantes into fila;
if misestudiantes%notfound then
exit;
end if;
DBMS_OUTPUT.PUT_LINE(fila.nombre||' '|| fila.apellidos||' '||fila.dni);
DBMS_OUTPUT.PUT_LINE('El estudiante: '||misestudiantes%ROWCOUNT);
end loop;
close misestudiantes;
end;
/
declare
cursor misestudiantes is select * from estudiantes;
contador int:=1;
begin

for i in misestudiantes loop 
DBMS_OUTPUT.PUT_LINE(i.nombre||' '|| i.apellidos||' '||i.dni);
DBMS_OUTPUT.PUT_LINE('El estudiante: '||contador);
contador:=contador+1;
end loop;
end;
/
declare
cursor misestudiantes is select * from estudiantes;
contador int:=1;
begin

for i in misestudiantes loop 
DBMS_OUTPUT.PUT_LINE(i.nombre||' '|| i.apellidos||' '||i.fecha_nacimiento);
DBMS_OUTPUT.PUT_LINE('El estudiante: '||contador);
contador:=contador+1;
end loop;
end;
/
declare
minombre estudiantes.nombre%type:='&METEUNNOMBRE';
cursor misestudiantes is select nombre, APELLIDOS from estudiantes where upper(nombre) = upper(minombre);
contador int:=0;
begin

for i in misestudiantes loop 
DBMS_OUTPUT.PUT_LINE(upper(i.apellidos || ', ' ||i.nombre));
contador:= contador + 1;
end loop;
if contador=0 then
DBMS_OUTPUT.PUT_LINE('No existe estudiante con ese dni.');
end if;
exception
when too_many_rows then 
DBMS_OUTPUT.PUT_LINE('Demasiados datos para ese dni.');
end;
/
UNDEFINE METEUNNOMBRE;

--TERCERA EVALUACION
--EXCEPCIONES
declare
numero1 int:=0;
numero2 int:=0;
begin
numero2:=numero2/numero1;
exception
when others then
    DBMS_OUTPUT.PUT_LINE('Su división da este error '|| SQLCODE || ' '|| SQLERRM);

end;
/

declare
numero1 int:=0;
numero2 int:=0;
begin
numero2:=numero2/numero1;
exception
when ZERO_DIVIDE then
    DBMS_OUTPUT.PUT_LINE('El divisor no puede ser cero ');
end;
/

declare
NO_ALUMNOS exception;
numeroestudiantes int:=0;
begin
select count(*) into numeroestudiantes from estudiantes where codigo=20;
if numeroestudiantes=0 then
raise NO_ALUMNOS;
ELSE
DBMS_OUTPUT.PUT_LINE('Hay '||numeroestudiantes||' estudiantes.');
end if;
exception
when NO_ALUMNOS THEN
DBMS_OUTPUT.PUT_LINE('NO HAY ALUMNOS.');
when others then
DBMS_OUTPUT.PUT_LINE('El error es '|| SQLCODE|| ' '|| SQLERRM);
end;
/

declare
NO_ALUMNOS exception;
MUCHOS_ALUMNOS exception;
numeroestudiantes int:=0;
begin
select count(*) into numeroestudiantes from estudiantes ;
if numeroestudiantes=0 then
raise NO_ALUMNOS;
ELSIF numeroestudiantes>=5 then
raise MUCHOS_ALUMNOS;
ELSE
DBMS_OUTPUT.PUT_LINE('Hay '||numeroestudiantes||' estudiantes.');
end if;
exception
when NO_ALUMNOS THEN
DBMS_OUTPUT.PUT_LINE('NO HAY ALUMNOS.');
when MUCHOS_ALUMNOS THEN
DBMS_OUTPUT.PUT_LINE('TIENE QUE SER MENOS DE CINCO ALUMNOS');
when others then
DBMS_OUTPUT.PUT_LINE('El error es '|| SQLCODE|| ' '|| SQLERRM);
end;
/
--PROCEDIMIENTO
create or replace procedure nombredelprocedimiento (parametro1 in int)
is
begin
for i in 0..parametro1 loop
DBMS_OUTPUT.PUT_LINE('**');
end loop;
end nombredelprocedimiento;
/

begin
nombredelprocedimiento(8);
end;
/
create or replace procedure consultarempleado(v_empno in emp.empno%type, v_ename out emp.ENAME%type, v_job out emp.job%type)
is begin
select ename, job into v_ename, v_job from emp where empno = v_empno;
exception
when no_data_found then 
DBMS_OUTPUT.PUT_LINE('NO SE HAN ENCONTRADO DATOS DE '||v_empno);
end consultarempleado;
/
Declare
empno emp.empno%type:=&METEEMPNO;
nombre emp.ename%type;
trabajo emp.job%type;

begin
consultarempleado(empno,nombre, trabajo);
if nombre  is not null and trabajo is not null then
DBMS_OUTPUT.PUT_LINE('EL NOMBRE DE SU TRABAJADOR ES '|| nombre ||' y su trabajo es '||trabajo);
end if;
end;
/
undefine METEEMPNO;

create or replace procedure is_today (fecha out date)
is
begin
select sysdate into fecha from dual;
end is_today;
/
declare
fecha date;
begin
is_today(fecha);
DBMS_OUTPUT.PUT_LINE('La fecha de hoy es '|| fecha);
end;
/

create or replace procedure is_today2 (fecha out date)
is
begin
select sysdate into fecha from dual;
end is_today;