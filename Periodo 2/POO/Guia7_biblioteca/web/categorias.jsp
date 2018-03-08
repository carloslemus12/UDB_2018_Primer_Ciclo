<%-- 
    Document   : categorias
    Created on : 07-mar-2018, 14:50:26
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
        <title>Categoria</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        
         <div class="d-flex justify-content-center mt-3">
            <div class="card" style="width: 38rem;">
                <h5 class="card-header">Nueva categoria:</h5>
                <div class="card-body">
                    <!-- Ingresar las categorias -->
                    <form action='accionCategoria' method='POST'>
                        <p>
                            <label for='id'> ID de la categoria: </label>
                            <input id='id' class="form-control" name='id' type='number' value='' />
                        </p>

                        <div id="errorId" class="alert alert-danger d-none" role="alert"></div>
                        
                        <p>
                            <label for='nombre'> Nombre de la categoria: </label>
                            <input id='nombre' class="form-control" name='nombre' type='text' value='' />
                        </p>
                        
                        <div id="errorNombre" class="alert alert-danger d-none" role="alert"></div>

                        <input id="btnAccion" class="btn btn-success" type='submit' value='Guardar' name='Accion'/>
                    </form>
                </div>
            </div>
         </div>
        
        <br>
        <!-- Tabla con todas las categorias -->
        <table class="table table-dark table-bordered table-hover text-center">
        <tr>
            <td>ID:</td>
            <td>Categoria:</td>
            <td colspan="2">Opciones:</td>
        </tr>
        <% 
            Conexion con;
            
            if ((con = Conexion.establecerConexion()) != null) {
                    ResultSet categorias = con.crearQuery("categoria_libro").select();
                    
                    while(categorias.next()){
                        out.println("<form action='accionCategoria' method='POST'>");
                        out.println("<input name='id' type='hidden' value='" + categorias.getString("id") + "' />");
                        out.println("<input name='nombre' type='hidden' value='" + categorias.getString("categoria") + "' />");
                        out.println("<tr>");
                        out.println("<td>"+ categorias.getString("id") +"</td>");
                        out.println("<td>"+ categorias.getString("categoria") +"</td>");
                        out.println("<td><input type='submit' class='btn btn-primary' value='Eliminar' name='Accion'/></td>");
                        out.println("<td><input type='submit' class='btn btn-danger' value='Modificar' name='Accion'/></td>");
                        out.println("</tr>");
                        out.println("</form>");
                    }
                }
        %>
        </table>
        
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
