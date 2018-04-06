<%-- 
    Document   : libro
    Created on : 04-abr-2018, 4:30:11
    Author     : MekakuZero
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libros</title>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        
        <div class="row w-100">
            <div class="col">
                <a href="/Guia_10/libro.jsp" class="mt-3 ml-3 btn btn-success" >Nuevo libro</a>
            </div>
        </div>
        
        <section class="w-100 d-flex justify-content-center px-2 mt-3">
            <sql:query var="libros" dataSource="jdbc/mysql">
                SELECT libro.id as id, libro.titulo as titulo, libro.cantidad as cantidad, categoria_libro.categoria as categoria, libro.isbn as isbn, libro.edicion as edicion from libro inner join categoria_libro on categoria_libro.id = libro.categoria
            </sql:query>

            <table class="table table-dark table-bordered text-center">
                <thead>
                  <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Titulo</th>
                    <th scope="col">Categoria</th>
                    <th scope="col">Cantidad</th>
                    <th scope="col">ISBN</th>
                    <th scope="col">Edicion</th>
                    <th scope="col" colspan="2">Opciones</th>
                  </tr>
                </thead>
                <tbody>
                    <c:forEach var="libro" items="${libros.rows}">
                        <tr>
                            <th scope="row" class="bg-danger"><c:out value="${libro.id}"/></th>
                            <td><c:out value="${libro.titulo}"/></td>
                            <td><c:out value="${libro.cantidad}"/></td>
                            <td><c:out value="${libro.categoria}"/></td>
                            <td><c:out value="${libro.isbn}"/></td>
                            <td><c:out value="${libro.edicion}"/></td>
                            <td><a href="/Guia_10/libro.jsp?id=<c:out value="${libro.id}"/>" class="text-white" ><i class="material-icons">create</i></a></td>
                            <td><a href="#" class="text-white" ><i class="material-icons">delete</i></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
            
    </body>
</html>
