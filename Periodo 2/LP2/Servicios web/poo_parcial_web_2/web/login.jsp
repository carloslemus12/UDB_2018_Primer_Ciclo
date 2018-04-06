<%-- 
    Document   : login
    Created on : 05-abr-2018, 2:48:30
    Author     : MekakuZero
--%>

<%
    if (session.getAttribute("usuario") != null) {
        response.sendRedirect("/poo_parcial_web_2/index.jsp");
    }
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <style>
            body, form, html{
                height: 100%;
            }
            body{
                background: url('img/back_repeat.jpg');
            }
        </style>
    </head>
    <body>
        <div class="container w-100 h-100 d-flex justify-content-center align-items-center">
            <div class="card" style="width: 20rem;">
                <center><img class="card-img-top w-75" src="img/bookshelf.svg" alt="Card image cap"></center>
                <div class="card-body">
                    
                    <form action="login" method="POST">
                        <div class="form-group">
                            <label for="txt_username">Username</label>
                            <input name="username" class="form-control" id="txt_username" placeholder="Username">
                        </div>
                        <div class="form-group">
                            <label for="txt_password">Password</label>
                            <input name="password" type="password" class="form-control" id="txt_password" placeholder="Password">
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Ingresar</button>
                    </form>
                    
                    <% if (request.getAttribute("mensaje_Error") != null) {%>
                        <div class="alert alert-danger alert-dismissible fade show mt-2 mb-0" role="alert">
                            <% out.println(request.getAttribute("mensaje_Error")); %>
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                              <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    <%}%>
                    
                </div>
            </div>
        </div>
    </body>
</html>
