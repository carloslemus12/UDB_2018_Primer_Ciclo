<%-- 
    Document   : libros
    Created on : 07-mar-2018, 15:51:00
    Author     : MekakuZero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.ResultSet" %>
<%@page import = "java.util.ArrayList" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.Map" %>
<%@page import = "javax.swing.table.DefaultTableModel" %>
<%@page import = "mojica.alexander.consulta.Conexion" %>
<%@page import = "mojica.alexander.consulta.Query" %>
<%@page import = "mojica.alexander.utilidades.*"%>
<%@include file="comprobar.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion libros</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body class="bg-dark">
        
        <%@include file="menu.jsp" %>
        
        <jsp:include page="manejarLibros.jsp">
            <jsp:param name="accion" value="1" />
        </jsp:include>
        
        <!-- Lista de los libros -->
        <!--table class="table table-dark text-center table-hover table-bordered mt-2 mb-0">
            <tr>
                <td>ID</td>
                <td>Titulo</td>
                <td>Cantidad</td>
                <td>Categoria</td>
                <td colspan="2">Opciones:</td>
            </tr>
        
            <%-- 
                Conexion con;

                if ((con = Conexion.establecerConexion()) != null) {
                        ResultSet libros = con.crearQuery("libro").select();

                        while(libros.next()){
                            out.println("<form action='accionLibros' method='POST'>");
                            out.println("<input name='id' type='hidden' value='" + libros.getString("id") + "' />");
                            out.println("<input name='titulo' type='hidden' value='" + libros.getString("titulo") + "' />");
                            out.println("<input name='cantidad' type='hidden' value='" + libros.getString("cantidad") + "' />");
                            out.println("<input name='categoria' type='hidden' value='" + libros.getString("categoria") + "' />");
                            
                            int idCategoria = libros.getInt("categoria");
                            
                            out.println("<tr>");
                            out.println("<td>"+ libros.getString("id") +"</td>");
                            out.println("<td>"+ libros.getString("titulo") +"</td>");
                            out.println("<td>"+ libros.getString("cantidad") +"</td>");
                            
                            ResultSet categoria = con.crearQuery("categoria_libro").where("id", idCategoria).select();
                            
                            if (categoria.next()) 
                                out.println("<td>"+ categoria.getString("categoria") +"</td>");
                            else
                                out.println("<td>None</td>");
                            
                            out.println("<td><input class='btn btn-primary' type='submit' value='Eliminar' name='Accion'/></td>");
                            out.println("<td><input class='btn btn-danger' type='submit' value='Modificar' name='Accion'/></td>");
                            out.println("</tr>");
                            out.println("</form>");
                        }
                        
                        con.cerrarConexion();
                    }
            --%>
        </table-->
    </body>
</html>
