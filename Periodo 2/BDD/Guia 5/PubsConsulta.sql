use Pubs
go

-- Seleccionar de la tabla employee los datos en donde el campo lname contenga la letra K
select * from employee where lname like '%k%'

/*
Seleccionar de la tabla employee los datos del campo emp_id que comience con cualquiera
de las letras que se encuentren en el rango de la F a la M
*/

select emp_id from employee where emp_id like '[F-M]%'

/*
Mostrar de la tabla sales los datos donde la fecha de perdido (ord_date) sean mayores o
iguales a 01/01/1994
*/

select * from sales where ord_date >= '1994-01-01'

-- Seleccionar de la tabla stores los datos donde el campo state sea igual a CA

select * from stores where state = 'CA'

-- Seleccionar de la tabla title los 5 libros más caros (price) que se encuentran almacenados

select top 5 * from titles order by price desc