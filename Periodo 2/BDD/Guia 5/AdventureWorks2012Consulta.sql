use AdventureWorks2012
go

-- Seleccionar todos los datos de la tabla HumanResources.Department
select * from HumanResources.Department

/*
Seleccionar los campos BusinessEntityID, NationalIDNumber y JobTitle de la tabla
HumanResources.Employee en donde en el campo JobTitle se encuentre la palabra
Production
*/

select BusinessEntityID, NationalIDNumber, JobTitle from HumanResources.Employee where JobTitle like '%Production%'

/*
Seleccionar los datos de la tabla Sales.Customer donde en el campo CustomerID se
encuentren los siguientes datos: 2,4, 7 y 10
*/

select * from Sales.Customer where CustomerID in (2,4,7,10)

/*
Seleccionar los campos DepartmenID, Name de la tabla HumanResources.Department en
donde los datos del DepartmenID se encuentre entre los valores 5 y 12
*/

select DepartmentID, Name from HumanResources.Department where DepartmentID between 5 and 12

/*
Seleccionar los campos AddressID, City y StateProvinceID de la tabla Person.Address donde
en el campo City el dato comienza con la letra B
*/

select AddressID, City, StateProvinceID from Person.Address where City like 'B%'

/*
Seleccionar los datos de la tabla Production.Culture, donde el dato almacenado en el
campo Name se encuentre entre los valores: English o Spanish
*/

select * from Production.Culture where Name in ('English','Spanish')

-- Seleccionar el 50% de los datos de la tabla Sales.CreditCard
select top 50 percent * from Sales.CreditCard

-- Mostrar las 10 mejores ventas (LineTotal) de la tabla Sales.SalesOrderDetailselect top 10 * from Sales.SalesOrderDetail order by LineTotal desc/*Seleccionar el campo JobTitle de la tabla HumanResources.Employee, pero no deben
mostrarse datos duplicados, ordenar los datos de forma descendente*/select distinct JobTitle from HumanResources.Employee Order by JobTitle desc/*Mostrar los campos Name, ProductNumber y ListPrice y renombrar este campo como Price
de la tabla Production.Product donde la línea de productos (ProductLine) sea igual a R y el
valor correspondiente a los días para fabricar ( DaysToMafacture) sea inferior a 4*/select Name, ProductNumber, ListPrice as Price from Production.Product where ProductLine = 'R' and DaysToManufacture < 4