<%-- 
    Document   : login
    Created on : 14-mar-2018, 19:47:16
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
    String usuario=request.getParameter("usuario");
    String clave=request.getParameter("clave");
    
    Conexion con;

    if ((con = Conexion.establecerConexion()) != null) {
            ResultSet user = con.crearQuery("usuario").where("username", usuario).whereSha1("password", clave).select();

            if (user.next()){
                HttpSession sesionOk = request.getSession();
                
                sesionOk.setAttribute("id", user.getInt("id"));
                sesionOk.setAttribute("usuario", user.getString("username"));
                
                con.cerrarConexion();
                
                String site = new String("libros.jsp");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", site);
            } else {
                con.cerrarConexion();
%>

<jsp:forward page="index.jsp">
    <jsp:param name="error" value="El usuario no existe" />
</jsp:forward>

<%
            }
        }
%>