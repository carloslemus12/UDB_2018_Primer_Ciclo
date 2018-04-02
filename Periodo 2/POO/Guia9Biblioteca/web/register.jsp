<%-- 
    Document   : register
    Created on : 14-mar-2018, 21:17:03
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
    String usuario = request.getParameter("usuario");
    String clave = request.getParameter("clave");
    String clave1 = request.getParameter("clave1");
    
    if (clave.isEmpty() || clave1.isEmpty()) {
    %>
    
    <jsp:forward page="registrar.jsp">
        <jsp:param name="error" value="Las claves son obligatorias" />
    </jsp:forward>
    
    <%
        }
    %>
    
    <%
    if (!clave.equals(clave1)) {
    %>

     <jsp:forward page="registrar.jsp">
        <jsp:param name="error" value="Las claves no coinciden" />
    </jsp:forward>
     
<%   
    }
    
    Conexion con;

    if ((con = Conexion.establecerConexion()) != null) {
            if (con.crearQuery("usuario")
                .agregarCampoValor("username", usuario)
                .agregarCampoValorSha1("password", clave)
                .insert()> 0) {
                
                ResultSet user = con.crearQuery("usuario").select();

                if (user.last()) {
                    HttpSession sesionOk = request.getSession();
                    sesionOk.setAttribute("id", user.getInt("id"));
                    sesionOk.setAttribute("usuario", usuario);

                    con.cerrarConexion();

                    String site = new String("libros.jsp");
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                    response.setHeader("Location", site);
                }
%>

<%
        } else {
%>        

            <jsp:forward page="registrar.jsp">
                <jsp:param name="error" value="No se ha podido registrar" />
            </jsp:forward>

<%
            }
        }
%>