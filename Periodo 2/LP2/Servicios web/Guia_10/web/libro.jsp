<%-- 
    Document   : libro
    Created on : 04-abr-2018, 5:27:05
    Author     : MekakuZero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="lemus.alexander.Libros"%>
<jsp:useBean id="modelo_libro" class="lemus.alexander.Libros" scope="session" />
<% 
    int id = 0;
    boolean nuevo = true;
    
    if (request.getParameter("id") != null) {
        nuevo = false;
        id = Integer.valueOf(request.getParameter("id")); 
        modelo_libro = Libros.obtenerLibro(id);
    }
     
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <title>Nuevo Libro</title>
        <style>
            body{
                background: url(css/back.jpg);
            }
        </style>
    </head>
    <body>
        <%= modelo_libro.getCategoria() %>
        <div class="d-flex justify-content-center my-3">
            <div class="card" style="width: 38rem;">
                <h5 class="card-header bg-danger text-white">
                    <%= (nuevo)? "Agregar libros" : "Modificar libros" %>
                </h5>
                <div class="card-body">
                    <form action='/Guia_10/libro_info.jsp' method='POST'>
                        <input name="tipo" value="<%= (nuevo)? "1" : "2" %>" type="hidden" />
                        <div>
                            <label for="txtId">Indice del libro:</label>
                            <input id="txtId" class="form-control" type='number' min="1" value="<%= (nuevo)? "1" : (""+id) %>" name='txtId' <%= (nuevo)? "" : "readonly" %> />
                        </div>
                        <div id="errorId" class="alert alert-danger d-none" role="alert"></div>
                        <p>
                            <label for="txtTitulo">Titulo del libro:</label>
                            <input id="txtTitulo" class="form-control" type='text' name='titulo' value="<%= (nuevo)? "" : modelo_libro.getTitulo() %>"/>
                        </p>
                        <div id="errorTitulo" class="alert alert-danger d-none" role="alert"></div>
                        <p>
                            <label for="txtIsbn">ISBN del libro:</label>
                            <input id="txtIsbn" class="form-control" type='text' name='isbn' value="<%= (nuevo)? "" : modelo_libro.getIsbn() %>"/>
                        </p>
                        <div id="errorIsbn" class="alert alert-danger d-none" role="alert"></div>
                        <p>
                            <label for="txtDescripcion">Descripcion del libro:</label>
                            <textarea id="txtDescripcion" class="form-control" name='descripcion'><%= (nuevo)? "" : modelo_libro.getDescripcion() %></textarea>
                        </p>
                        <p>
                            <label for="txtEdicion">Edicion del libro:</label>
                            <input id="txtEdicion" class="form-control" type='text' name='edicion' value="<%= (nuevo)? "" : modelo_libro.getEdicion() %>"/>
                        </p>
                        <div id="errorEdicion" class="alert alert-danger d-none" role="alert"></div>
                        <p>
                            <label for="txtCantidad">Cantidad en existencia:</label>
                            <input id="txtCantidad" class="form-control" type='number' name='cantidad' value="<%= (nuevo)? "" : ""+modelo_libro.getCantidad() %>" />
                        </p>
                        <div id="errorCantidad" class="alert alert-danger d-none" role="alert"></div>
                        <p>
                            <label for="selecCategoria">Categoria del libro:</label>
                            <select id="selecCategoria" class="form-control" name='categoria'>
                            <sql:query var="categorias" dataSource="jdbc/mysql">
                                SELECT * from categoria_libro
                            </sql:query>
                            
                            <c:forEach var="categoria" items="${categorias.rows}">
                                
                                <c:choose>
                                    <c:when test="${not nuevo}">
                                        <c:choose>
                                            <c:when test="${modelo_libro.getCategoria() == categoria.id}">
                                                <option value="<c:out value="${categoria.id}"/>" selected><c:out value="${categoria.categoria}"/></option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="<c:out value="${categoria.id}"/>">Hola:<c:out value="${categoria.categoria}"/></option>
                                            </c:otherwise>
                                        </c:choose>
                                        
                                    </c:when>
                                    
                                    <c:otherwise>
                                        <option value="<c:out value="${categoria.id}"/>"><c:out value="${categoria.categoria}"/></option>
                                    </c:otherwise>
                                </c:choose>
                                
                            </c:forEach>
                                
                            </select>
                        </p>
                        
                        <input id="btnAccion" type='submit' class="mt-2 btn <%= (nuevo)? "btn-success" : "btn-primary" %>" value='<%= (nuevo)? "Guardar libro" : "Modificar libro" %>' name='Accion'/>
                    </form>
                </div>
            </div> 
        </div>  
        
        <script>
            document.getElementById("btnAccion").onclick = function(){

            // Obtenemos los campos que comprobaremos
            var txtId = document.getElementById("txtId");
            var txtTitulo = document.getElementById("txtTitulo");
            var txtCantidad = document.getElementById("txtCantidad");
            var txtIsbn = document.getElementById("txtIsbn");
            var txtEdicion = document.getElementById("txtEdicion");

            // Estado para saber que todo esta bien
            var estado = true;

            // Obtenemos la referencias de errores
            var errorId = document.getElementById("errorId");
            var errorTitulo = document.getElementById("errorTitulo");
            var errorCantidad = document.getElementById("errorCantidad");
            var errorIsbn = document.getElementById("errorIsbn");
            var errorEdicion = document.getElementById("errorEdicion");

            // Funcion para saber que todo esta bien
            function validarNumero(txt, error, campo){
                if (!Number.isNaN(txt.value.toString().trim())) {
                    if(txt.value <= 0){
                        estado = false;
                        error.classList.remove('d-none');
                        error.innerHTML = "Error: el campo " + campo + " debe de ser mayor que 0";
                    } else {
                        error.classList.add('d-none');
                    }
                } else{
                    estado = false;
                    error.classList.remove('d-none');
                    error.innerHTML = "Error: el campo " + campo + " debe de ser numerico";
                }
            }

            function validarTexto(txt, error, campo){
                if(txt.value.toString().trim().equals("")) {
                    estado = false;
                    error.classList.remove('d-none');
                    error.innerHTML = "Error: el campo " + campo + " es un campo obligatorio";
                } 
                else
                    error.classList.add('d-none');
            }

            validarNumero(txtId, errorId, "ID");
            validarTexto(txtTitulo, errorTitulo, "Titulo");
            validarNumero(txtCantidad, errorCantidad, "Cantidad");
            validarTexto(txtIsbn, errorIsbn, "ISBN");
            validarTexto(txtEdicion, errorEdicion, "Edicion");

            if(!estado)
                return false;
        }

    </script>
</html>
