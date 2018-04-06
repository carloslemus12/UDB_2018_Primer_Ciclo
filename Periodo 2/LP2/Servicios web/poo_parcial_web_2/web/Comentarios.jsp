<%-- 
    Document   : Comentarios
    Created on : 05-abr-2018, 20:34:04
    Author     : MekakuZero
--%>
<%
    int id = Integer.valueOf(request.getParameter("id"));
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<sql:query var="comentarios" dataSource="jdbc/mysql">
    SELECT usuario.username as username, comentario as comentario from comentario inner join usuario on usuario.id = comentario.id_usuario WHERE id_libro = <%= id %>
</sql:query>

<c:forEach var="comentario" items="${comentarios.rows}">
    <li class="list-group-item"><strong class="mr-2 text-primary" style="font-size: 12px;">${comentario.username}--</strong>${comentario.comentario}</li>
</c:forEach>