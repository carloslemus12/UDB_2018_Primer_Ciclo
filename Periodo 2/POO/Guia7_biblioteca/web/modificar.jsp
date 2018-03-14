<%-- 
    Document   : modificar
    Created on : 14-mar-2018, 22:19:31
    Author     : MekakuZero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     HttpSession sesionOk = request.getSession();
%>
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
        <title>Modificar cuenta</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body class="d-flex justify-content-center bg-dark">
        <div class="card mt-5" style="width: 30rem;">
            <div class="card-header">
              Modificar usuario
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
                <form method="post" action="update.jsp" >
                    <input name="id" type="hidden" value="<%= sesionOk.getAttribute("id") %>" />
                    
                    <div class="form-group">
                        <label for="txtUsername">Username</label>
                        <input name="usuario" value="<%= sesionOk.getAttribute("usuario") %>" type="text" class="form-control" id="txtUsername" placeholder="Username">
                    </div>
                    
                    <div class="form-group">
                        <label for="txtPassword">Password</label>
                        <input name="clave" type="password" class="form-control" id="txtPassword" placeholder="Password">
                    </div>
                    
                    <div class="form-group">
                        <label for="txtPassword1">Confirmar password</label>
                        <input name="clave1" type="password" class="form-control" id="txtPassword1" placeholder="Password">
                    </div>
                    
                    <button type="submit" class="btn btn-primary">Modificar</button>
                </form>
                
            </div>
        </div>
    </body>
</html>
