<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="conexion.jsp"%>
<jsp:useBean id="codigo" class="sv.edu.udb.guia9.CodigoBean"/>
<%
    int total_registros=0;
    rs = st.executeQuery("select count(*) from empleados");
%>
<% while (rs.next()) {
    total_registros=rs.getInt(1);
}%>
<jsp:setProperty name="codigo" property="apellido1" param="apellido1"/>
<jsp:setProperty name="codigo" property="apellido2" param="apellido2"/>
<jsp:setProperty name="codigo" property="cantidad_registros" value="<%=total_registros%>"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
