create table barcos(
    Martricula varchar2(100) primary key,
    Nombre varchar2(50),
    clase varchar2(100),
    Armador varchar(100),
    Capacidad int,
    nacionalidad varchar2(50)
);
create table Lotes2(
    Codigo int primary key,
    Martricula varchar2(100),
    Num_kg int,
 Precio_kg_Salida number(8,2),
   Precio_kg_Vendido number(8,2),
    Fecha_Venta date,
    Cod_especie int
);
create table Especies(
    Codigo int primary key,
    Nombre varchar2(100),
    tipo varchar2(100),
    Cupo_barco number(8,2),
   Caladero_PPAL int
);
create table Caladero(
    Codigo int primary key,
    Nombre varchar2(100),
    Ubicacion varchar2(100),
   Especie_ppal int
);
create table Fechas_capturas(
    cod_especie int ,
    cod_caladero int,
    Fecha_inicio date,
   Fecha_fin date
);
alter table fechas_capturas add constraint cod_especie_cod_caladero_fecha_capturas_PK primary key (cod_especie,cod_caladero);
alter table caladero add CONSTRAINT especie_ppal_especies_FK FOREIGN KEY (Especie_ppal) references especies;
alter table especies add CONSTRAINT caladero_ppal_caladero_FK FOREIGN KEY (Caladero_PPAL) references Caladero;
alter table lotes2 ADD CONSTRAINT cod_especies_especies_PK FOREIGN KEY (codigo) references Especies;
alter table lotes2 rename column martricula to matricula;
alter table Barcos rename column martricula to matricula;
alter table lotes2 add CONSTRAINT matricula_Barcos_FK FOREIGN KEY (Matricula) references Barcos;
alter table barcos add CONSTRAINT id_ship check(matricula in('[A-Z][A-Z][-][0-9][0-9][0-9][0-9]'));
alter table Lotes2 add CONSTRAINT Fecha_Venta_Not_Null check(Fecha_Venta is not null);
alter table Lotes2 add CONSTRAINT precio_kg_Vendido_Mayor check(Precio_Kg_Vendido>precio_kg_salida);
alter table Lotes2 add check(num_kg>0 and precio_kg_vendido>0 and precio_kg_salida>0);
alter table caladero add check (Nombre= UPPER(nombre) and ubicacion = upper(ubicacion));

alter table caladero add Nombre_Cientifico varchar2(100);
insert into barcos (matricula, nombre) values('TT-1993','PEPINO');

