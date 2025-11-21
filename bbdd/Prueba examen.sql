create table trabajadores(
    dni char(9) primary key,
    nombre varchar2(50),
    apellidos varchar2(100),
    id_equipo int,                                               
    dorsal_jugador int,
    fecha_nacimiento date,
    nacionalidad varchar2(100),
    tipo varchar2(50),
    posicion_jugador varchar2(50)
);
create table equipos(
    nombre varchar2(50),
    id int,                                               
    fecha_fundacion date,
    presupuesto number(12,2)
);
alter table equipos add constraint id_equipos_PK primary key (id);
create table estadios(
    nombre varchar2(50),
    codigo int primary key,                                               
    capacidad int,
    direccion varchar2(100),
    ciudad varchar2(100),
    compartido char(3),
    id_equipo integer
);
create table partidos(
    fecha date,
    id_equipo_local int,                                               
   id_equipo_visitante int,
    resultado varchar2(50),
    id_arbitro int
);
create table arbitros(
    id integer primary key,
    federacion varchar2(50) ,                                               
    nombre varchar2(50),
    apellidos varchar2(100),
    fecha_nacimiento date
);
create table notas_arbitrajes(
    id integer primary key,
    id_arbitro int,
    fecha_partido date,
    id_equipo_local_partido int,
    id_equipo_visitante_partido int,
    puntuacion number(3,2)
);
alter table notas_arbitrajes add FOREIGN KEY(id_arbitro) references arbitros;
alter table partidos add primary key(fecha,id_equipo_local,id_equipo_visitante);
alter table partidos add FOREIGN KEY(id_arbitro) references arbitros;
alter table partidos add FOREIGN KEY(id_equipo_local) references equipos;
alter table partidos add FOREIGN KEY(id_equipo_visitante) references equipos;
alter table estadios add FOREIGN KEY(id_equipo) references equipos;
alter table trabajadores add FOREIGN KEY(id_equipo) references equipos;
alter table estadios add responsable varchar2(50);
alter table estadios MODIFY responsable char(9);
alter table estadios rename column responsable to dni_responsable;
alter table estadios add constraint fk_responsable foreign key(dni_responsable) REFERENCES trabajadores;
alter table estadios rename CONSTRAINT fk_responsable to fk_responsable_estadio;
alter table estadios drop constraint fk_responsable_estadio;
alter table estadios drop COLUMN dni_responsable;
alter table notas_arbitrajes add foreign key(fecha_partido,id_equipo_local_partido,id_equipo_visitante_partido) references partidos;

create TABLE veteranos(
    dni char(9),
    nombre varchar(50),
    apellidos varchar(100),
    direccion varchar(100),
    localidad varchar(100),
    nombre_campeonato_retirados varchar(50)
);
create TABLE campeonatos_retirados(
    nombre varchar(50),
    kms number(5,1),
    localidad varchar(100),
    vueltas integer
);
alter table veteranos add primary key (dni);
alter table campeonatos_retirados add PRIMARY KEY(nombre);
alter table veteranos add FOREIGN KEY(nombre_campeonato_retirados) REFERENCES campeonatos_retirados;
alter table veteranos rename CONSTRAINT SYS_C009381 to fk_nom_camp;
rename veteranos to pilotos_veteranos;
alter table pilotos_veteranos add fecha_nacimiento date;
alter table pilotos_veteranos DROP PRIMARY key;
alter table pilotos_veteranos add constraint pk_dni_nombre_apellidos_pilotos_veteranos PRIMARY key(dni,nombre,apellidos);
alter table pilotos_veteranos DROP FOREIGN key fk_nom_camp;
alter table pilotos_veteranos drop column fecha_nacimiento;

