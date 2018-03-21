use Northwind
go

/* 
Haciendo uso de INNER JOIN mostrar los campos OrderDate y ProductID de las tablas Orders y Order
Details donde el dato almacenado en el campo OrderDate sea igual 8 de Julio de 1996
*/

select detalle.ProductID AS [ID del producto], cast(orden.OrderDate as date) as Fecha from Orders as orden inner join [Order Details] as detalle on orden.OrderID = detalle.OrderID where orden.OrderDate < '08-07-1996'

/*
Se desea mostrar cuantas cantidades de cada producto se han vendido y la fecha de la venta de cada uno
de ellos, se debe tomar en cuenta el siguiente diagrama relacional:Campos a mostrar: ProductID, ProductName, Quantity y OrderDate
*/

select producto.ProductID as [ID del producto], producto.ProductName as [Nombre del producto], detalle.Quantity as [Cantidad], cast(orden.OrderDate as date) as [Fecha de la orden]
from Orders as orden 
inner join [Order Details] as detalle 
on orden.OrderID = detalle.OrderID
inner join Products as producto
on producto.ProductID = detalle.ProductID

/*
Haciendo uso de SUBCONSULTAS mostrar los campos OrderID, ProductID y Quantity de la tabla Orders
Details donde la fecha de pedido (OrderDate de la tabla Orders) sea la más antigua
*/

select Orders.OrderID, detalle.ProductID, detalle.Quantity, OrderDate
from Orders, [Order Details] as detalle
where Orders.OrderID = detalle.OrderID
and OrderDate = (select top 1 OrderDate from Orders order by OrderDate desc)

/*
Ingrese un nuevo registro a la tabla Employees

Dos nuevos registros a la tabla Orders, en el primer registro en el campo EmployeeID debe agregar el
código del nuevo empleado y en el segundo registro debe ingresar para ese campo un valor NULL

Crear consultas que implemente el uso de FULL, LEFT Y RIGHT JOIN

Campos a mostrar: LastName, EmployeeID de la tabla Employees
OrderDate de la tabla Orders

Al final del ejercicio y después de hacer las pruebas necesarias, elimine de las tablas los datos que agrego.
*/

-- Insertar campos
insert into Employees (LastName, FirstName) values ('Mojica', 'Alexander');

-- Insertamos 
insert into Orders (EmployeeID, OrderDate) values ((select top 1 EmployeeID from Employees where LastName = 'Mojica' and FirstName = 'Alexander'), getdate());
insert into Orders (OrderDate) values (cast(getdate() as date));

-- FULL
select Employees.LastName, Employees.EmployeeID, Orders.OrderDate
from Orders
full join Employees
on Orders.EmployeeID = Employees.EmployeeID

-- Left
select Employees.LastName, Employees.EmployeeID, Orders.OrderDate
from Orders
left join Employees
on Orders.EmployeeID = Employees.EmployeeID

-- right
select Employees.LastName, Employees.EmployeeID, Orders.OrderDate
from Orders
right join Employees
on Orders.EmployeeID = Employees.EmployeeID

-- Eliminar campos
delete from Orders where EmployeeID = (select top 1 EmployeeID from Employees where LastName = 'Mojica' and FirstName = 'Alexander');
delete from Orders where OrderDate = cast(getdate() as date);
delete from Employees where LastName = 'Mojica' and FirstName = 'Alexander';

-- Ejercicios en clase

-- Ejercicio 1
select top 5 provedor.CompanyName, producto.ProductID, count(producto.ProductID) as [Cantidad]
from Products as producto
inner join [Order Details] as detalle
on producto.ProductID = detalle.ProductID
inner join Suppliers as provedor
on producto.SupplierID = provedor.SupplierID
group by provedor.CompanyName, producto.ProductID
order by [Cantidad] DESC

-- Ejercicio 2
select top 1 teritorio.TerritoryDescription, count(trabajador.EmployeeID) as [Cantidad de empleados]
from Employees as trabajador
inner join [EmployeeTerritories] as [territorio empleado]
on trabajador.EmployeeID = [territorio empleado].EmployeeID
inner join [Territories] as teritorio
on teritorio.TerritoryID = [territorio empleado].TerritoryID
group by teritorio.TerritoryDescription
order by [Cantidad de empleados] desc

-- Ejercicio 3
select provedor.CompanyName, producto.ProductName, count(detalle.Quantity) as [Cantidad]
from Products as producto
inner join [Order Details] as detalle
on producto.ProductID = detalle.ProductID
inner join Suppliers as provedor
on producto.SupplierID = provedor.SupplierID
group by provedor.CompanyName, producto.ProductName
having sum(detalle.Quantity) > ((
	select sum(detalle.Quantity) / 77
	from Products as producto
	inner join [Order Details] as detalle
	on producto.ProductID = detalle.ProductID
) + ((
	select sum(detalle.Quantity) / 77
	from Products as producto
	inner join [Order Details] as detalle
	on producto.ProductID = detalle.ProductID
) * 0.05))

-- Ejercicio 4 
select producto.ProductID as id, sum(detalle.Quantity) as cantidad
from Products as producto
inner join [Order Details] as detalle
on producto.ProductID = detalle.ProductID
group by producto.ProductID
having sum(detalle.Quantity) < (
	select sum(detalle.Quantity) / 77
	from Products as producto
	inner join [Order Details] as detalle
	on producto.ProductID = detalle.ProductID * 0.25
)