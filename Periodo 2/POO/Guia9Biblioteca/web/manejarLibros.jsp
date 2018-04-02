<%-- 
    Document   : manejarLibros
    Created on : 14-mar-2018, 15:47:12
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
<link href="css/bootstrap.min.css" rel="stylesheet" />

<% String accion = request.getParameter("accion"); %>

<div class="d-flex justify-content-center mt-3">
    <div class="card" style="width: 38rem;">
        <h5 class="card-header bg-danger text-white">
            <%= (accion.equals("1"))? "Nuevo libro:" : "Modificar libro" %>
        </h5>
        <div class="card-body">
            <%--
                String id = "";
                String titulo = "";
                String isbn = "";
                String descripcion = "";
                String edicion = "";
                String cantidad = "";
                String categoria = "";
                
                if ((accion.equals("2"))){
                    Conexion con;

                    if ((con = Conexion.establecerConexion()) != null) {
                        ResultSet libro = con.crearQuery("libro").where("id", Integer.valueOf(request.getParameter("id"))).select();

                        if (libro.next()) {
                            id = ""+libro.getInt("id");
                            titulo = libro.getNString("titulo");
                            isbn = libro.getNString("isbn");
                            descripcion = libro.getNString("descripcion");
                            edicion = libro.getNString("edicion");
                            cantidad = "" + libro.getInt("cantidad");
                            categoria = "" + libro.getInt("categoria");
                        }

                        con.cerrarConexion();
                    }
                }
            --%>
            
            <!-- Insertar libros -->
            <form action='accionLibros' method='POST'>
                <p>
                    <label for="txtId">Indice del libro:</label>
                    <input id="txtId" class="form-control" type='number' value="<%=id%>" name='id' <%=accion.equals("2")? "readonly='true'" : ""%>/>
                </p>
                
                <div id="errorId" class="alert alert-danger d-none" role="alert"></div>

                <p>
                    <label for="txtTitulo">Titulo del libro:</label>
                    <input id="txtTitulo" class="form-control" type='text' value="<%=titulo%>" name='titulo'/>
                </p>

                <div id="errorTitulo" class="alert alert-danger d-none" role="alert"></div>

                <!-- Nuevos -->

                <p>
                    <label for="txtIsbn">ISBN del libro:</label>
                    <input id="txtIsbn" class="form-control" type='text' value="<%=isbn%>" name='isbn'/>
                </p>

                <div id="errorIsbn" class="alert alert-danger d-none" role="alert"></div>
                
                <p>
                    <label for="txtDescripcion">Descripcion del libro:</label>
                    <textarea id="txtDescripcion" class="form-control" name='descripcion'><%=descripcion%></textarea>
                </p>


                <p>
                    <label for="txtEdicion">Edicion del libro:</label>
                    <input id="txtEdicion" class="form-control" type='text' value="<%=edicion%>" name='edicion'/>
                </p>

                <div id="errorEdicion" class="alert alert-danger d-none" role="alert"></div>
                
                <!-- ///////////////////////////////////////// -->

                <p>
                    <label for="txtCantidad">Cantidad en existencia:</label>
                    <input id="txtCantidad" class="form-control" type='number' value="<%=cantidad%>" name='cantidad'/>
                </p>

                <div id="errorCantidad" class="alert alert-danger d-none" role="alert"></div>

                <p>
                    <label for="selecCategoria">Categoria del libro:</label>
                    <select id="selecCategoria" class="form-control" name='categoria'>
                    <%
                        Conexion conecxion;

                        if ((conecxion = Conexion.establecerConexion()) != null) {
                            ResultSet categorias = conecxion.crearQuery("categoria_libro").select();

                            while(categorias.next()){
                                if (categorias.getString("id").equals(categoria)) {
                                    out.println("<option value=" + categorias.getString("id") + " selected>" + categorias.getString("categoria") + "</option>");
                                } else
                                    out.println("<option value=" + categorias.getString("id") + ">" + categorias.getString("categoria") + "</option>");
                            }

                            conecxion.cerrarConexion();
                        }
                    %>
                </select>
                </p>
                
                <% if (accion.equals("1")){ %>
                    <input id="btnAccion" type='submit' class="mt-2 btn btn-success" value='Guardar' name='Accion'/>
                <% } else { %>
                    <input id='btnAccion' class='mt-2 btn btn-primary' type='submit' value='GuardarCambio' name='Accion'/>
                <% } %>
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
            if(txt.value.toString().trim() == "") {
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