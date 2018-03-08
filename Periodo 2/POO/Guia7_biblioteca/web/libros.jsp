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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion libros</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        
        <div class="d-flex justify-content-center mt-3">
            <div class="card" style="width: 38rem;">
                <h5 class="card-header">Nuevo libro:</h5>
                <div class="card-body">
                    <!-- Insertar libros -->
                    <form action='accionLibros' method='POST'>
                        <p>
                            <label for="txtNuevoId">Indice del libro:</label>
                            <input id="txtNuevoId" class="form-control" type='number' value='' name='id'/>
                        </p>
                        
                        <div id="errorId" class="alert alert-danger d-none" role="alert">
                            This is a danger alert—check it out!
                        </div>

                        <p>
                            <label for="txtNuevoTitulo">Titulo del libro:</label>
                            <input id="txtNuevoTitulo" class="form-control" type='text' value='' name='titulo'/>
                        </p>

                        <div id="errorTitulo" class="alert alert-danger d-none" role="alert">
                            This is a danger alert—check it out!
                        </div>
                        
                        <p>
                            <label for="txtNuevaCantidad">Cantidad del libro:</label>
                            <input id="txtNuevaCantidad" class="form-control" type='number' value='' name='cantidad'/>
                        </p>

                        <div id="errorCantidad" class="alert alert-danger d-none" role="alert">
                            This is a danger alert—check it out!
                        </div>
                        
                        <p>
                            <label for="selecNuevaCategoria">Categoria del libro:</label>
                            <select id="selecNuevaCategoria" class="form-control" name='categoria'>
                            <%
                                Conexion conecxion;

                                if ((conecxion = Conexion.establecerConexion()) != null) {
                                    ResultSet categorias = conecxion.crearQuery("categoria_libro").select();

                                    while(categorias.next()){
                                        out.println("<option value=" + categorias.getString("id") + ">" + categorias.getString("categoria") + "</option>");
                                    }

                                    conecxion.cerrarConexion();
                                }
                            %>
                        </select>
                        </p>

                        <input id="btnNuevoLibro" type='submit' class="btn btn-success" value='Guardar' name='Accion'/>
                    </form>
                </div>
            </div>
        </div>
        
        <!-- Lista de los libros -->
        <table class="table table-dark text-center table-hover table-bordered mt-2">
            <tr>
                <td>ID</td>
                <td>Titulo</td>
                <td>Cantidad</td>
                <td>Categoria</td>
                <td colspan="2">Opciones:</td>
            </tr>
        
            <% 
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
            %>
        </table>
        
        <script>
            
            document.getElementById("btnNuevoLibro").onclick = function(){
                
                // Obtenemos los valores
                var txtNuevoId = document.getElementById("txtNuevoId");
                var txtNuevoTitulo = document.getElementById("txtNuevoTitulo");
                var txtNuevaCantidad = document.getElementById("txtNuevaCantidad");
                var selecNuevaCategoria = document.getElementById("selecNuevaCategoria");
                
                var estado = true;
                
                var errorId = document.getElementById("errorId");
                var errorTitulo = document.getElementById("errorTitulo");
                var errorCantidad = document.getElementById("errorCantidad");
                
                if (!Number.isNaN(txtNuevaCantidad.value.toString().trim())) {
                    if(txtNuevaCantidad.value <= 0){
                        estado = false;
                        errorCantidad.classList.remove('d-none');
                        errorCantidad.innerHTML = "Error: la cantidad debe de ser mayor que 0";
                    } else {
                        errorCantidad.classList.add('d-none');
                    }
                } else{
                    estado = false;
                    errorCantidad.classList.remove('d-none');
                    errorCantidad.innerHTML = "Error: la cantidad debe de ser numerico";
                }
                
                if (!Number.isNaN(txtNuevoId.value.toString().trim())) {
                    if(txtNuevoId.value <= 0){
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
                
                if(txtNuevoTitulo.value.toString().trim() == "") {
                    estado = false;
                    errorTitulo.classList.remove('d-none');
                    errorTitulo.innerHTML = "Error: el titulo es un campo obligatorio";
                } else
                    errorTitulo.classList.add('d-none');
                
                if (!Number.isNaN(txtNuevoId.value.toString().trim())) {
                    if(txtNuevoId.value <= 0){
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
                
                if(!estado)
                    return false;
            }
            
        </script>
    </body>
</html>
