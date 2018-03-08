use master
go

create database Guia6
go

use Guia6
go

create table Categoria(
	CodigoCategoria int not null,
	NombreCategoria varchar(50),
	constraint pk_Categoria primary key (CodigoCategoria)
)

create table Producto(
	CodigoProducto int not null,
	NombreProducto varchar(50),
	PrecioUnitario decimal (18, 2),
	CodigoCategoria int,
	constraint pk_Producto primary key (CodigoProducto),
	constraint fk_Categoria foreign key (CodigoCategoria) references Categoria(CodigoCategoria)
)

insert into Categoria values (1, 'Bebidas')

insert into Categoria (CodigoCategoria, NombreCategoria) values (2, 'Carne rojas')

insert into Categoria values (3, 'Harinas')

insert into Categoria values (4, 'Vegetales'),(5, 'Frutas'),(6, 'Mariscos')

insert into Producto values
(1, 'Soda Coca cola', 1.25, 1),
(2, 'Carne bistec', 3.50, 2),
(3, 'Camarones pequeños', 1.15, 6),
(4, 'Harina blanca', 0.75, 3),
(5, 'Te verde', 1.0, 1),
(6, 'Lomo de aguja', 4.50, 2),
(7, 'Soda de naranja', 1.25, 1),
(8, 'Chiles verdes', 0.25, 4),
(9, 'Tomates', 0.2, 4),
(10, 'Manzana verde', 0.25, 5)

select * into [Producto CategoriaBebidas]
from Producto
where CodigoCategoria = 1

select * from [Producto CategoriaBebidas]

create table [Producto CategoriaVegerales](
	CodigoProducto int not null,
	NombreProducto varchar(50),
	PrecioUnitario decimal(18,2),
	CodigoCategoria int,
	constraint pk_Producto1 primary key (CodigoProducto),
	constraint fk_Categoria1 foreign key (CodigoCategoria)
	references Categoria(CodigoCategoria)
)

select * from [Producto CategoriaVegerales]

insert into [Producto CategoriaVegerales]
select CodigoProducto, NombreProducto, PrecioUnitario, CodigoCategoria
from Producto
where CodigoCategoria = 4

select * from [Producto CategoriaVegerales]

update [Producto CategoriaBebidas] set PrecioUnitario = 1.50

select * from [Producto CategoriaBebidas]

update [Producto CategoriaBebidas] set PrecioUnitario = 1.25 where CodigoProducto = 1

select * from [Producto CategoriaBebidas]

update [Producto CategoriaBebidas] set PrecioUnitario = 1.75
where CodigoProducto = 1 and CodigoCategoria = 1

select * from [Producto CategoriaBebidas]

delete from [Producto CategoriaBebidas]

select * from [Producto CategoriaBebidas]

delete from Producto where CodigoCategoria = 4

select * from Producto

select * from Categoria

delete from Categoria where CodigoCategoria = 6

select * from Categoria

alter table Producto
drop constraint fk_Categoria

alter table Producto
add constraint fk_Categoria
foreign key (CodigoCategoria)
references Categoria(CodigoCategoria)
on delete cascade
on update cascade

delete from Categoria where CodigoCategoria = 6

select * from Categoria

select * from Producto

create table [Producto CategoriaFrutas](
	CodigoProducto int not null,
	NombreProducto varchar(50),
	PrecioUnitario decimal(18, 2),
	CodigoCategoria int,
	constraint pk_Producto2 primary key (CodigoProducto),
	constraint fk_Categoria2 foreign key (CodigoCategoria)
	references Categoria(CodigoCategoria)
	on delete cascade
	on update cascade
)