create table personas(
    Dni char(9) primary key,
    Telefono_fijo VARCHAR2(100),
    Movil VARCHAR2(100),
    Nombre VARCHAR2(100),
    Apellidos VARCHAR2(100),
    Codigo_Personal int,
    Es_cliente CHAR(2),
    Es_trabajador char(2)
);
alter table personas add check(dni in('{0-9}[8]{A-Z}'));
alter table personas add check(Es_cliente in('si','no'));
alter table personas add check(Es_trabajador in('si','no'));
create table Compras (
    codigo_comprar int,
    dni_cliente char(9),
    codigo_Inmueble int,
    Valor number(8,2),
    fecha date,
    hora char(5)
);
alter table compras add PRIMARY key(dni_cliente,codigo_inmueble);
create table Inmuebles(
    codigo int primary key,
)
