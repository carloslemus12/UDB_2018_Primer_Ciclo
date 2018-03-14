<%-- 
    Document   : forJSP
    Created on : 14-mar-2018, 14:30:42
    Author     : MekakuZero
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.*"%>
<%! 
    String titulo = "Tabla de multiplicar";
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
                <h3>Tabla de multiplicar:</h3>
            </div>

            <%
                for (int i = 1; i <= 10; i++) {
            %>
            
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <%= "Tabla del " + i%>
                </div>

                <div class="card-body">
                    <%
                        for (int j = 1; j <= 10; j++) {
                            out.println("<p>"+i + " x " + j + " = " + (i * j) + "</p>");
                        }
                    %>
                </div>
            </div>
            
            <%
                }
            %>
        </div>
    </body>
</html>
