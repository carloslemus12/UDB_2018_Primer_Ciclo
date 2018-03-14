<%-- 
    Document   : PrimeraJSP
    Created on : 14-mar-2018, 14:22:11
    Author     : MekakuZero
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.*"%>
<%! String titulo = "Mi primer ejemplo con JSP";
 String cadena = "Primer ejemplo";
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title><%= titulo%></title>
        
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        
        <link rel="stylesheet" href="css/bootstrap.min.css" />
    </head>
    
    <body>
        
        <%
            //Obteniendo la fecha actual
            Date fechaActual = new Date();
            //Formateando la fecha
            DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
            DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        %>


        <div class="container">
            <div class="row">
                <h3><%= titulo%></h3>
            </div>

            <div class="card">
                <div class="card-header bg-primary text-white">
                    <%= cadena%>
                </div>

                <div class="card-body">
                    <p><%= "La fecha actual es: " + formatoFecha.format(fechaActual)%></p>
                    <p><%= "La hora actual es: " + formatoHora.format(fechaActual)%></p>
                    <p><%= " El tamaño de la cadena ‘"+ cadena + "’ es: " + cadena.length()%></p>
                </div>
            </div>
        </div>
    </body>
</html>
