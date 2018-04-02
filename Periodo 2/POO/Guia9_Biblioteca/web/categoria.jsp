<%-- 
    Document   : categoria
    Created on : 30-mar-2018, 18:25:22
    Author     : MekakuZero
--%>

<%@page import="lemus.alexander.Categorias"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="model_categoria" class="lemus.alexander.Categorias" scope="session" />
<% 
    int id = 0;
    boolean nuevo = true;
    
    if (request.getParameter("id") != null) {
        nuevo = false;
        id = Integer.valueOf(request.getParameter("id")); 
        model_categoria = Categorias.obtenerCategoria(id);
    }
     
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <title>Categoria</title>
        <style>
            body{
                background: url(css/back.jpg);
            }
        </style>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        
        <div class="d-flex justify-content-center mt-3">
            <div class="card" style="width: 38rem;">
                <h5 class="card-header">Nueva categoria:</h5>
                <div class="card-body">
                    <!-- Ingresar las categorias -->
                    <form action='manejo_categorias' method='POST'>
                        <p>
                            <label for='id'> ID de la categoria: </label>
                            <input id='id' class="form-control" name='id' type='number' value='<%= (nuevo)? "1" : (""+id) %>' <%= (nuevo)? "" : "readonly" %> />
                        </p>

                        <div id="errorId" class="alert alert-danger d-none" role="alert"></div>
                        
                        <p>
                            <label for='nombre'> Nombre de la categoria: </label>
                            <input id='nombre' class="form-control" name='nombre' type='text' value='<%= (nuevo)? "" : (model_categoria.getCategoria()) %>' />
                        </p>
                        
                        <div id="errorNombre" class="alert alert-danger d-none" role="alert"></div>

                        <input id="btnAccion" class="btn <%= (nuevo)? "btn-success" : "btn-primary" %>" type='submit' value='<%= (nuevo)? "Guardar" : "Modificar" %>' name='Accion'/>
                    </form>
                </div>
            </div>
         </div>
        
        <script>
            document.getElementById("btnAccion").onclick = function(){
                var id = document.getElementById("id");
                var cat = document.getElementById("nombre");

                var estado = true;

                var errorId = document.getElementById("errorId");
                var errorNombre = document.getElementById("errorNombre");

                if (!Number.isNaN(id.value.toString().trim())) {
                    if(id.value <= 0){
                        estado = false;
                        errorId.classList.remove('d-none');
                        errorId.innerHTML = "Error: el id debe de ser mayor que 0";
                    } else {
                        errorId.classList.add('d-none');
                    }
                } else{
                    estado = false;
                    errorId.classList.remove('d-none');
                    errorId.innerHTML = "Error: el id debe de ser numerico";
                }

                if(cat.value.toString().trim() == "") {
                    estado = false;
                    errorNombre.classList.remove('d-none');
                    errorNombre.innerHTML = "Error: el nombre es un campo obligatorio";
                } else
                    errorNombre.classList.add('d-none');
                
                if(!estado)
                    return false;
            }
        </script>
    </body>
</html>
