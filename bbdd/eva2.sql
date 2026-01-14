create table METEREOLOGIAS(
    id int primary key,
    fecha date,
    hora char(5),
    temperatura number(5,2),
    condicion varchar2(50),
    Humedad number (5,2),
    codigo_carrera int
);
create table carreras(
    codigo int
);
alter table carreras add PRIMARY key(codigo);
alter table METEREOLOGIAS add FOREIGN KEY(codigo_carrera) REFERENCES carreras;
insert into carreras values(1001);
COMMIT;
insert into METEREOLOGIAS values(2,'02-01-24','11:30',9.5,'Soleado',64.75,1001);
COMMIT;
insert into carreras values(1002);
COMMIT;
insert into METEREOLOGIAS values(3,'21-03-24','17:00',14,'Nuboso',78.50,1002);
COMMIT;
insert into carreras values(1003);
COMMIT;
insert into METEREOLOGIAS values(4,'15-06-24','10:00',29.3,'Soleado',26.50,1003);
COMMIT;
insert into carreras values(1004);
COMMIT;
insert into METEREOLOGIAS values(5,'29-09-24','22:00',21,'Noche',91.2,1004);
COMMIT;
insert into carreras values(1005);
COMMIT;
insert into METEREOLOGIAS values(7,'15-01-25','09:30',4.5,'Lluvia',91.2,1005);
COMMIT;
UPDATE METEREOLOGIAS set hora = '17:15', temperatura=null, humedad=84.44 where id=3;
COMMIT;
delete from METEREOLOGIAS where condicion ='Soleado';
COMMIT;
SELECT * from METEREOLOGIAS;
SELECT TEMPERATURA Humedad from METEREOLOGIAS;
SELECT TEMPERATURA Humedad from METEREOLOGIAS WHERE temperatura>20;
UPDATE METEREOLOGIAS set condicion ='noche' where condicion='Lluvia';
COMMIT;
SELECT CONDICION from METEREOLOGIAS;
SELECT DISTINCT CONDICION from METEREOLOGIAS;


