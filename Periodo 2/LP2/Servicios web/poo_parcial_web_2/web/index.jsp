<%-- 
    Document   : index
    Created on : 05-abr-2018, 6:03:52
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
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <style>
            body{
                background: url('img/back_repeat_book.jpg');
            }
        </style>
        <%
            if (session.getAttribute("usuario") == null) {
                request.setAttribute("mensaje_Error", "Debe de iniciar la sesion");
                RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
            }
        %>
    </head>
    <body>
        
        <jsp:include page="Menu.jsp" />
        
        <div class="container mt-3">
            <div class="card-columns">
                <sql:query var="libros" dataSource="jdbc/mysql">
                    SELECT * FROM libro
                </sql:query>

                <c:forEach var="libro" items="${libros.rows}">
                    <div class="card bg-transparent mb-3" style="max-width: 18rem;">
                        <div class="card-header bg-success border-success text-white">Titulo: <c:out value="${libro.titulo}"/></div>
                        <div class="card-body text-success p-0">
                            <center><img class="card-img-top w-100 border-0" style="height: 12rem;" src="${ (libro.url_img == null)? 'img/bookshelf.svg' : libro.url_img }" alt="Card image cap"></center>
                        </div>
                        <div class="card-footer bg-danger border-danger p-0 border-0 d-flex justify-content-center">
                            <a href="/poo_parcial_web_2/libro.jsp?id=<c:out value="${libro.id}"/>" class="btn btn-danger"><i class="material-icons">remove_red_eye</i></a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        
    </body>
</html>
