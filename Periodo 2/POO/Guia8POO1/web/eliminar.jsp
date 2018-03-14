<%-- 
    Document   : eliminar
    Created on : 14-mar-2018, 15:20:16
    Author     : MekakuZero
--%>

<%@ include file="conexion.jsp"%>

<%
    String id = request.getParameter("id");
    
    st = conexion.prepareStatement("delete from Empleados where codigo = ?");
    
    st.setInt(1, Integer.valueOf(id));
    
    if (st.executeUpdate() > 0) {
    %>
    <jsp:forward page="consulta.jsp">
        <jsp:param name="msg" value="El empleado ha sido eliminado corectamente"/>
    </jsp:forward>
<%
    } else {
%>

    <jsp:forward page="consulta.jsp">
        <jsp:param name="error" value="El empleado no se ha podido eliminar"/>
    </jsp:forward>

<%
    }
%>
