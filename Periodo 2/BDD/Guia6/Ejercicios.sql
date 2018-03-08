use master
go

create database ControlAlumnoLG171618
go

use ControlAlumnoLG171618
go

create table Alumno(
	Carnet char(8) not null,
	NombreCompleto varchar(50),
	constraint pk_alumno primary key (Carnet)
)

create table Materia(
	Codigo char(5) not null,
	Nombre varchar(30),
	UV int,
	constraint pk_materia primary key (Codigo),
	constraint u_nombre unique (Nombre),
	constraint ck_uv check (uv >= 2 and uv <= 5)
)

create table Inscripcion(
	Carnet char(8),
	CodigoMateria char(5),
	Ciclo char(5),
	constraint pk_inscripcion primary key (Carnet, CodigoMateria, Ciclo)
)

alter table Inscripcion
add constraint fk_alumno_ins foreign key (Carnet)
references Alumno(Carnet)
on update cascade
on delete cascade
go

alter table Inscripcion
add constraint fk_materia_ins foreign key (CodigoMateria)
references Materia(Codigo)
on update cascade
on delete cascade
go

insert into Alumno values
('GH121214', 'Gerardo Hierro'),
('VN121415', 'Veronica Nuñez'),
('CD121515', 'Cesar Deras'),
('HL130334', 'Helen Lara'),
('GM119056', 'Gricelda Martinez')

select * from Alumno

insert into Materia values ('BD01', 'Base de datos I', 4)
insert into Materia values ('IP01', 'Introduccion a la programacion', 4)
insert into Materia values ('AL01', 'Algebra lineal', 3)
insert into Materia values ('RD02', 'Redes de area amplia', 5)
insert into Materia values ('GE01', 'Gestion empresarial', 2)
insert into Materia values ('HM02', 'Humanistica II', 3)

select * from Materia

insert into Inscripcion (Carnet, CodigoMateria, Ciclo)
values ('GH121214', 'BD01', 'C1-15')

insert into Inscripcion (CodigoMateria, Carnet, Ciclo)
values ('GE01', 'GH121214', 'C1-15')

insert into Inscripcion (Ciclo, Carnet, CodigoMateria)
values ('C1-15', 'GH121214', 'HM02')

SELECT * FROM Inscripcion

update Alumno set NombreCompleto = 'Gerardo Hernandez'
where Carnet = 'GH121214'

select * from Alumno
select * from Inscripcion

update Alumno set Carnet = 'GH111214'
where NombreCompleto = 'Gerardo Hernandez'

select * from Alumno
select * from Inscripcion

delete from Alumno where Carnet = 'GH111214'

select * from Alumno
select * from Inscripcion