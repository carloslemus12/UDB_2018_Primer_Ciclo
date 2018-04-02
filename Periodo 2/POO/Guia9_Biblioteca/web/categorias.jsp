<%-- 
    Document   : categoria
    Created on : 30-mar-2018, 18:25:22
    Author     : MekakuZero
--%>

<%@page import="lemus.alexander.Categorias"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
            <table class="table table-dark table-bordered table-hover text-center mb-0">
            <tr>
                <td>ID:</td>
                <td>Categoria:</td>
                <td colspan="2">Opciones:</td>
            </tr>
            <% 
                List<Categorias> categorias = Categorias.obtenerCategorias();

                for (Categorias categoria : categorias) {
                
                    out.println("<form action='manejo_categorias' method='POST'>");
                    out.println("<input name='id' type='hidden' value='" + categoria.getId() + "' />");
                    out.println("<tr>");
                    out.println("<td>"+ categoria.getId() +"</td>");
                    out.println("<td>"+ categoria.getCategoria() +"</td>");
                    out.println("<td><input type='submit' class='btn btn-primary' value='Eliminar' name='Accion'/></td>");
                    out.println("</form>");
                    out.println("<td><a class='btn btn-danger' href='/Guia9_Biblioteca/categoria.jsp?id=" + categoria.getId() + "' >Modificar</a></td>");
                    out.println("</tr>");
                    
                }
            %>
            </table>
        
        </div>
    </body>
</html>
