<%-- 
    Document   : libros
    Created on : 30-mar-2018, 16:49:09
    Author     : MekakuZero
--%>

<%@page import="lemus.alexander.Categorias"%>
<%@page import="java.util.List"%>
<%@page import="lemus.alexander.Libros"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="mojica.alexander.mvc.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libros</title>
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
        
        <div class="fill d-flex justify-content-center">
            <table class="table table-dark text-center table-hover mt-2 mb-0">
                <tr>
                    <td class="bg-danger">ID</td>
                    <td>Titulo</td>
                    <td>Cantidad</td>
                    <td>Categoria</td>
                    <td>Descripcion</td>
                    <td>Opciones:</td>
                </tr>

                <% 
                    List<Libros> libros = Libros.obtenerLibros();

                    for (Libros libro : libros) {
                        out.println("<form action='manejo_libros' method='POST'>");
                        out.println("<input name='txtId' type='hidden' value='" + libro.getId() + "' />");


                        out.println("<tr>");
                        out.println("<td class='bg-danger'>"+ libro.getId() +"</td>");
                        out.println("<td>"+ libro.getTitulo() +"</td>");
                        out.println("<td>"+ libro.getCantidad() +"</td>");

                        Categorias categoria = libro.getModelCategoria();

                        out.println("<td>"+ categoria.getCategoria() +"</td>");

                        out.println("<td>"+ libro.getDescripcion() +"</td>");
                        
                        out.println("<td><input class='btn btn-danger' type='submit' value='Eliminar' name='Accion'/>");
                        out.println("</form>");
                        out.println("<a class='btn btn-primary ml-2' href='/Guia9_Biblioteca/libro.jsp?id=" + libro.getId() + "'> Seleccionar </a></td>");
                        out.println("</tr>");
                        
                    }
                %>
            </table>
        </div>
    </body>
</html>
