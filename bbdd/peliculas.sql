create table peliculas(
    id int primary key,
    titulos varchar2(50)
);
create table festivales(
    nombre varchar(100) primary key
);
create table Colaboradores(
    DNi char(9) primary key,
    nombre varchar2(50),
    tipo varchar(100),
    tipo_actor varchar2(100)
);
create table premios(
    id int primary key,
    cuantia NUMBER(8,2)
);
create table participaciones(
    id_peliculas int ,
    dni_colaborador NUMBER(8,2)
);
create table Logro_premio(
    nombre_Festival varchar(100),
    Id_premio int
);
alter table participaciones add CONSTRAINT id_peliculas_peliculas_FK FOREIGN KEY(id_peliculas) references peliculas;
alter table participaciones add CONSTRAINT Dni_colaborador_colaboradores_FK FOREIGN KEY(dni_colaborador) references peliculas;
alter table Logro_premio add CONSTRAINT Nombre_festival_festivales_FK FOREIGN KEY(Nombre_festival) references festivales;
alter table Logro_premio add CONSTRAINT id_premio_premios_FK FOREIGN KEY(id_premio) references premios;