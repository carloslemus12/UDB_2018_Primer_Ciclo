<%-- 
    Document   : Bean1
    Created on : 21-mar-2018, 14:27:13
    Author     : MekakuZero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
String nom_cli="Rafael";
 String ape_cli="Torres";
 String dir_cli="My_House";
%>

<jsp:useBean id="cli_bean" class="sv.edu.udb.guia9.ClienteBean"/>
<jsp:setProperty name="cli_bean" property="nomb_cli" value="<%=nom_cli%>"/>
<jsp:setProperty name="cli_bean" property="ape_cli" value="<%=ape_cli%>"/>
<jsp:setProperty name="cli_bean" property="dir_cli" value="<%=dir_cli%>"/>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <div class="row"> &nbsp; </div>
            <div class="card">
                <div class="card-header bg-primary text-white">Datos personales</div>
                <div class="card-body">
                    <%
                    out.println("<h3>Nombre: " + cli_bean.getNomb_cli() + "</h3>");
                    out.println("<h3>Apellido: " + cli_bean.getApe_cli() + "</h3>");
                    out.println("<h3>Direcci&oacute;n: " + cli_bean.getDir_cli() + "</h3>");
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
