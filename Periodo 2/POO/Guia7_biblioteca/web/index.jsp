<%-- 
    Document   : index
    Created on : 14-mar-2018, 19:35:57
    Author     : MekakuZero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesionOk = request.getSession();
    
    if (sesionOk.getAttribute("usuario") != null) {
%>
        <jsp:forward page="libros.jsp" />
<%
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                
                <%
                    if (request.getParameter("msg") != null) {
                %>
                    <div class="alert alert-primary">
                        <strong>Informacion!</strong> <%=request.getParameter("msg")%>
                        <br>
                    </div>
                <%
                }//Fin del if
                %>
                
                <form method="post" action="login.jsp" >
                    <div class="form-group">
                        <label for="txtUsername">Username</label>
                        <input name="usuario" type="text" class="form-control" id="txtUsername" placeholder="Username">
                    </div>
                    
                    <div class="form-group">
                        <label for="txtPassword">Password</label>
                        <input name="clave" type="password" class="form-control" id="txtPassword" placeholder="Password">
                    </div>
                    
                    <button type="submit" class="btn btn-primary">Entrar</button>
                </form>
                
                <a href="registrar.jsp">Registrarme</a>
            </div>
        </div>
    </body>
</html>