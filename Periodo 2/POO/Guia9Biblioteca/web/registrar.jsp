<%-- 
    Document   : registrar
    Created on : 14-mar-2018, 21:04:47
    Author     : MekakuZero
--%>

<%@page session="true" language="java" import="java.util.*" %>
<%@page import = "java.sql.ResultSet" %>
<%@page import = "java.util.ArrayList" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.Map" %>
<%@page import = "javax.swing.table.DefaultTableModel" %>
<%@page import = "mojica.alexander.consulta.Conexion" %>
<%@page import = "mojica.alexander.consulta.Query" %>
<%@page import = "mojica.alexander.utilidades.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body class="d-flex justify-content-center">        
        <div class="card mt-5" style="width: 30rem;">
            <div class="card-header">
              Login
            </div>
            <div class="card-body">
                <%
                    if (request.getParameter("error") != null) {
                %>
                    <div class="alert alert-danger">
                        <strong>Error!</strong> <%=request.getParameter("error")%>
                        <br>
                    </div>
                <%
                }//Fin del if
                %>
                <form method="post" action="register.jsp" >
                    <div class="form-group">
                        <label for="txtUsername">Username</label>
                        <input name="usuario" type="text" class="form-control" id="txtUsername" placeholder="Username">
                    </div>
                    
                    <div class="form-group">
                        <label for="txtPassword">Password</label>
                        <input name="clave" type="password" class="form-control" id="txtPassword" placeholder="Password">
                    </div>
                    
                    <div class="form-group">
                        <label for="txtPassword1">Confirmar password</label>
                        <input name="clave1" type="password" class="form-control" id="txtPassword1" placeholder="Password">
                    </div>
                    
                    <button type="submit" class="btn btn-primary">Registrarme</button>
                </form>
                
            </div>
        </div>
    </body>
</html>
