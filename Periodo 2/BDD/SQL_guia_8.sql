-- Investigacion complementaria

use master
go

-- Ejercicio 1
create database [control mecanica]
go

use [control mecanica]
go

-- Creamos la tabla
create table [Maquina](
	cod char(6) not null,
	descripcion varchar(150) constraint un_maquina_descripcion unique,
	marca varchar(30) not null,
	modelo varchar(30) not null,
	fecha_ingreso date not null constraint df_fecha_ingreso default getdate(),
	constraint pk_maquina primary key (cod)
)
go

create table [Empleado](
	id varchar(10) not null,
	nombres varchar(30) not null constraint un_empleados_nombres unique,
	apellido varchar(30) not null constraint un_empleados_apellido unique,
	fecha_nacimiento date,
	edad as datediff(year, fecha_nacimiento, getdate()),
	constraint pk_empleado primary key (id),
	constraint ch_fecha_macimiento check(fecha_nacimiento < getdate())
)
go

create table [Bitacora](
	correlativo int not null identity,
	empleado_id varchar(10) not null,
	maquina_cod char(6) not null,
	tiempo_uso int not null constraint df_tiempo_uso default 0,
	lugar varchar(200),
	constraint pk_bitacora primary key(correlativo),
	constraint ch_tiempo_uso check(tiempo_uso >= 0),
	constraint fk_maquina_cod foreign key (maquina_cod)
	references [Maquina](cod) on delete cascade on update cascade,
	constraint fk_empleado_id foreign key (empleado_id)
	references [Empleado](id) on delete cascade on update cascade
)
go

insert into [Empleado] (id, nombres, apellido, fecha_nacimiento) values 
('01234567-8', 'Carlos Fidel', 'Argueta Miranda', '2006-08-21'),
('12345678-9', 'Juan Francisco', 'Villalta Alvarado', '2010-02-27'),
('78901234-5', 'Raul Alejandro', 'Poncio Valladares', '2010-02-27'),
('89012345-6', 'Miguel Eduardo', 'Morales Claros', '2010-08-21'),
('90123456-7', 'Fabricio David', 'Alas Flores', '2008-12-01')

insert into [Maquina] values 
('M00001', 'Taladora de elementos varios', 'Caterpillar', 'EVO2000', '2006-01-31'),
('M00002', 'Aplanadora de suelos y otros', 'Caterpillar', 'FLU5000', '2006-01-31'),
('M00003', 'Pulverizadora de elementos', 'Caterpillar', 'ASD2001', '2006-01-31'),
('M00004', 'Concretera', 'MG', 'EDS', '2006-05-31'),
('M00005', 'Maquina especial para proyecto 10', 'MG', 'SFD', '2006-05-31'),
('M00006', 'Maquina especial para proyecto 30', 'MG', 'SFD', '2010-12-01')

insert into [Bitacora] values
('12345678-9', 'M00001', 250, 'Santiago monualco'),
('01234567-8', 'M00002', 300, 'Santiago monualco'),
('90123456-7', 'M00003', 500, 'Alegria usulutan'),
('89012345-6', 'M00004', 300, 'Alegria usulutan'),
('90123456-7', 'M00005', 250, 'Santiago monualco'),
('01234567-8', 'M00002', 150, 'Santiago monualco'),
('12345678-9', 'M00003', 375, 'Alegria usulutan'),
('12345678-9', 'M00004', 200, 'Alegria usulutan')

-- Consulta 1
select concat(e.nombres, ' ', e.apellido) as [Nombre completo], m.marca, m.modelo, m.descripcion
from [Empleado] as e
left join [Bitacora] as b
on e.id = b.empleado_id
left join [Maquina] as m
on m.cod = b.maquina_cod

-- Consulta 2
select concat(e.nombres, ' ', e.apellido) as [Nombre completo], b.maquina_cod
from [Empleado] as e
left join [Bitacora] as b
on e.id = b.empleado_id
where b.maquina_cod is null

-- Consulta 3
select  concat(e.nombres, ' ', e.apellido) as [Nombre completo], m.descripcion
from [Maquina] as m
left join [Bitacora] as b
on m.cod = b.maquina_cod
left join [Empleado] as e
on e.id = b.empleado_id
where b.maquina_cod is null

-- Ejercicio 2
use control_de_libros_lg171618
go

insert into autor values 
('abc12', 'Autor #1', 'Apellido', '1998-01-01', 'Salvadoreña'),
('xxx12', 'Autor #2', 'Apellido #2', '1998-01-01', 'Salvadoreño')

-- Consulta 1
select autor.nombre, autor.apellido, libro.titulo
from autor
inner join Detalle_AutorLibro
on Detalle_AutorLibro.codigo_autor = autor.codigo_autor
inner join libro
on libro.codigo_libro = Detalle_AutorLibro.codigo_libro

-- Consulta 2
select [Libro].titulo, [Editorial].nombre as [Editorial]
from [Libro]
inner join [Editorial]
on [Editorial].codigo_editorial = [Libro].codigo_editorial

-- Consulta 3
select [Libro].titulo, [Editorial].nombre as [Editorial]
from [Libro]
inner join [Editorial]
on [Editorial].codigo_editorial = [Libro].codigo_editorial
where [Editorial].pais = 'Inglaterra'

-- Consulta 4
select top 1 with ties autor.nombre, autor.apellido, libro.titulo, libro.año_edicion
from autor
inner join Detalle_AutorLibro
on Detalle_AutorLibro.codigo_autor = autor.codigo_autor
inner join libro
on libro.codigo_libro = Detalle_AutorLibro.codigo_libro
order by libro.año_edicion desc

-- Consulta 5
select top 1 with ties autor.nombre, autor.apellido, libro.titulo, libro.año_edicion
from autor
inner join Detalle_AutorLibro
on Detalle_AutorLibro.codigo_autor = autor.codigo_autor
inner join libro
on libro.codigo_libro = Detalle_AutorLibro.codigo_libro
order by libro.año_edicion asc

-- Consultas 6

-- Left join
select autor.nombre, autor.apellido, libro.titulo
from autor
left join Detalle_AutorLibro
on Detalle_AutorLibro.codigo_autor = autor.codigo_autor
left join libro
on libro.codigo_libro = Detalle_AutorLibro.codigo_libro
where libro.codigo_libro is null

-- RIGHT join
select autor.nombre, autor.apellido, libro.titulo
from autor
right join Detalle_AutorLibro
on Detalle_AutorLibro.codigo_autor = autor.codigo_autor
right join libro
on libro.codigo_libro = Detalle_AutorLibro.codigo_libro

-- Full join
select autor.nombre, autor.apellido, libro.titulo
from autor
full join Detalle_AutorLibro
on Detalle_AutorLibro.codigo_autor = autor.codigo_autor
full join libro
on libro.codigo_libro = Detalle_AutorLibro.codigo_libro