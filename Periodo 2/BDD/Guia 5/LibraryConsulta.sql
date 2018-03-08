use Library
go

/*
Seleccionar los datos de la tabla adult, donde en el campo expr_date los datos se
encuentren en el rango 01/12/2006 y 30/06/2007
*/

select * from adult where expr_date between '2006-12-01' and '2007-06-30'

-- Seleccionar los datos de la tabla reservationselect * from reservation-- Mostrar los autores (author) de la tabla title que comiencen con la letra Mselect author from title where author like 'M%'/*Mostrar el nombre del autor (author) y el titulo (title) de la tabla title y ordenarlos de forma
ascendente por el nombre del autor*/select author, title where title order by author asc/*Seleccionar los datos de la tabla loan donde el campo isbn tenga los siguientes datos: 509,
519, 529 y 539*/select * from loan where isbn in (509, 519, 529, 539)