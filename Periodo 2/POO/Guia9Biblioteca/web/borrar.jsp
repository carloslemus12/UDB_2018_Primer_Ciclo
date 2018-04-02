<%-- 
    Document   : borrar
    Created on : 14-mar-2018, 22:04:50
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

<% 
    HttpSession info = request.getSession(); 
    int id = Integer.valueOf(info.getAttribute("id").toString());
    
    Conexion con;
            
    if ((con = Conexion.establecerConexion()) != null) {
        if (con.crearQuery("usuario").where("id", id).delete() > 0) {
            HttpSession sesionOk = request.getSession();
            sesionOk.invalidate();
            
            %>
            <jsp:forward page="index.jsp">
                <jsp:param name="msg" value="Se ha eliminado el usuario" />
            </jsp:forward>
<%
        } else {
            
        %>
        
        <jsp:forward page="index.jsp">
            <jsp:param name="error" value="No se ha podido eliminar" />
        </jsp:forward>
        
        <%
        }
    }
%>
