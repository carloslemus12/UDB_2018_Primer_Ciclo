<%-- 
    Document   : error
    Created on : 30-mar-2018, 19:13:53
    Author     : MekakuZero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <title>Error</title>
        <style>
            body{
                background: url(css/back.jpg);
            }
        </style>
        <style>
            body{
                background: url(css/back.jpg);
            }
            
            html, body, form {
                height: 100%;
            }
            
            .fill { 
                min-height: 100%;
                height: 100%;
            }
        </style>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        
        <div class="mt-5 d-flex justify-content-center align-items-center">
        <div class="jumbotron">
        <h1 class="display-4">Ha ocurrido algun error inesperado</h1>
        <p class="lead">Lo sentimos pero el error no se ha podido identificar</p>
        <hr class="my-4">
        <small>Recarge la pagina de ser necesario.</small>
        </div>
            </div>
    </body>
</html>
