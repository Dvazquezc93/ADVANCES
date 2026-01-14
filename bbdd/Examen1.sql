create table restaurantes(
    calle VARCHAR2(100),
    Numero int,
    Precio_Medio_plato number(8,2),
    Localidad varchar2(100),
    Horario VARCHAR2(100)
);
alter table restaurantes add PRIMARY KEY(calle,numero);
create table empleados(
    dni char(9) PRIMARY key,
    Nombre VARCHAR2(100),
    Apellidos VARCHAR2(100),
    Codigo_Postal int,
    Fecha_Nacimiento date,
    Es_Camarero char(2),
    Es_Cocinero char(2),
    Es_Gerente char(2),
    Calle_restaurante VARCHAR2(100),
    Numero_Restaurante int
);
alter table empleados add FOREIGN key (calle_restaurante,numero_Restaurante) references restaurantes;
create table clientes(
    dni char(9) PRIMARY key,
    Nombre VARCHAR2(100),
    Apellidos VARCHAR2(100),
    Codigo_Postal int,
    Email VARCHAR2(50),
    Movil varchar2(50)
);
create table asistencias(
    Dni_Cliente char(9),
    Calle_restaurante varchar2(100),
    Numero_Restaurante int
);
alter table asistencias add PRIMARY KEY(Dni_cliente,Calle_restaurante,Numero_restaurante);
alter table asistencias add FOREIGN KEY(Calle_restaurante,Numero_restaurante) REFERENCES restaurantes;
alter table asistencias add FOREIGN KEY(Dni_cliente) REFERENCES clientes;
create table reservas(
    referencia int PRIMARY KEY,
    dia DATE,
    hora VARCHAR2(50),
    Dni_Cliente char(9)
);
alter table reservas add FOREIGN KEY(Dni_cliente) REFERENCES clientes;
create table proveedores(
    id int PRIMARY key,
    Nombre VARCHAR2(100),
    tipo VARCHAR2(100),
    volumen_Compras NUMBER(8,2)
);
create table disponibilidades(
    Calle_restaurante varchar2(100),
    Numero_Restaurante int,
    id_proveedor int
);
alter table disponibilidades add FOREIGN KEY(Calle_restaurante,Numero_restaurante) REFERENCES restaurantes;
alter table disponibilidades add FOREIGN KEY(id_proveedor) REFERENCES proveedores;
create table mesas(
    id int PRIMARY key,
    estado VARCHAR2(100),
    Material VARCHAR2(100),
    Numero_plaza int,
    Publicidad_terraza VARCHAR2(100),
    Silla_alta_barra char(2),
    Calle_restaurante varchar2(100),
    Numero_Restaurante int
);
alter table Mesas add FOREIGN KEY(Calle_restaurante,Numero_restaurante) REFERENCES restaurantes;
alter table clientes add check(REGEXP_LIKE(dni,'{0-9}[8]{A-Z}')); 
alter table mesas add check (estado is not null);
alter table mesas MODIFY  Numero_plaza int DEFAULT 0;

