<%-- 
    Document   : consulta
    Created on : 14-mar-2018, 14:43:40
    Author     : MekakuZero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body>

        <%@ include file="conexion.jsp"%>

        <%
            if (request.getParameter("error") != null) {
        %>
            <div class="alert alert-danger mb-3">
                <strong>Error!</strong> <%=request.getParameter("error")%>
            </div>
        <%
            }
        %>

        <%
            if (request.getParameter("msg") != null) {
        %>
            <div class="alert alert-primary mb-3">
                <strong>Exito!</strong> <%=request.getParameter("msg")%>
            </div>
        <%
            }
        %>
        
        <div class="row col-md-7">
        <table class="table table-dark table-bordered text-center m-5 table-hover">
            <thead>
            
                <tr>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Telefono</th>
                    <th>Operaciones</th>
                </tr>
                
                </thead>
                <tbody>
                    <%
                        st = conexion.prepareStatement("select * from Empleados");
                        rs = st.executeQuery();
                        while (rs.next()) {
                    %>
                    
                    <tr>
                        <td><%=rs.getString("nombre")%></td>
                        <td><%=rs.getString("apellidos")%></td>
                        <td><%=rs.getString("telefono")%></td>
                        <td>
                            <a class="btn btn-danger" href='eliminar.jsp?id=<%=rs.getString("codigo")%>'>Eliminar</a>
                        </td>
                    </tr>
                    <%
                    }
                    conexion.close();
                    %>
                 </tbody>
             </table>
        </div>
    </body>
</html>
