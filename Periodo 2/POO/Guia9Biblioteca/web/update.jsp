<%-- 
    Document   : update
    Created on : 14-mar-2018, 22:35:28
    Author     : MekakuZero
--%>

<%@page session="true" language="java" import="java.util.*" %>
<%@page import = "java.sql.ResultSet" %>
<%@page import = "java.util.ArrayList" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.Map" %>
<%@page import = "javax.swing.table.DefaultTableModel" %>
<%@page import = "mojica.alexander.consulta.Conexion" %>
<%@page import = "mojica.alexander.consulta.Query" %>
<%@page import = "mojica.alexander.utilidades.*"%>

<%
    int id = Integer.valueOf(request.getParameter("id"));
    String usuario = request.getParameter("usuario");
    String clave = request.getParameter("clave");
    String clave1 = request.getParameter("clave1");
    
    if (clave.isEmpty() && clave1.isEmpty()){
    %>

    <%
    
    Conexion con;

    if ((con = Conexion.establecerConexion()) != null) {
            if (con.crearQuery("usuario")
                .agregarCampoValor("username", usuario)
                .where("id", id)
                .update()> 0) {

                HttpSession sesionOk = request.getSession();
                sesionOk.setAttribute("id", id);
                sesionOk.setAttribute("usuario", usuario);

                con.cerrarConexion();

                String site = new String("libros.jsp");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", site);
%>

<%
        } else {
%>        

            <jsp:forward page="modificar.jsp">
                <jsp:param name="error" value="No se ha podido registrar " />
            </jsp:forward>

<%
            }
        }
    }
%>
    
<%
    if (clave.isEmpty() || clave1.isEmpty()) {
    %>
    
    <jsp:forward page="modificar.jsp">
        <jsp:param name="error" value="Las claves son obligatorias" />
    </jsp:forward>
    
    <%
        }
    %>
    
    <%
    if (!clave.equals(clave1)) {
    %>

     <jsp:forward page="modificar.jsp">
        <jsp:param name="error" value="Las claves no coinciden" />
    </jsp:forward>
     
<%   
    }
    
    Conexion con;

    if ((con = Conexion.establecerConexion()) != null) {
            if (con.crearQuery("usuario")
                .agregarCampoValor("username", usuario)
                .agregarCampoValorSha1("password", clave)
                .where("id", id)
                .update()> 0) {

                HttpSession sesionOk = request.getSession();
                sesionOk.setAttribute("id", id);
                sesionOk.setAttribute("usuario", usuario);

                con.cerrarConexion();

                String site = new String("libros.jsp");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", site);
%>

<%
        } else {
%>        

            <jsp:forward page="modificar.jsp">
                <jsp:param name="error" value="No se ha podido registrar " />
            </jsp:forward>

<%
            }
        }
%>
