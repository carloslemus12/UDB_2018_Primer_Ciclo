<%-- 
    Document   : libro_info
    Created on : 04-abr-2018, 5:50:25
    Author     : MekakuZero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="lemus.alexander.Libros"%>
<jsp:useBean id="modelo_libro" class="lemus.alexander.Libros" scope="session" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion del libro</title>
    </head>
    <body>
        <c:set target="${modelo_libro}" property="id" value="${param.txtId}"/>
        <c:set target="${modelo_libro}" property="titulo" value="${param.titulo}"/>
        <c:set target="${modelo_libro}" property="cantidad" value="${param.cantidad}"/>
        <c:set target="${modelo_libro}" property="categoria" value="${param.categoria}"/>
        <c:set target="${modelo_libro}" property="isbn" value="${param.isbn}"/>
        <c:set target="${modelo_libro}" property="descripcion" value="${param.descripcion}"/>
        <c:set target="${modelo_libro}" property="edicion" value="${param.edicion}"/>
        
        <c:if test="${param.tipo} == 1">
            <c:catch var="error_insert">
                <sql:update var="insertar" dataSource="jdbc/mysql">
                    INSERT INTO libro VALUES (?,?,?,?,?,?,?)
                    <sql:param value="${modelo_libro.id}"/>
                    <sql:param value="${modelo_libro.titulo}"/>
                    <sql:param value="${modelo_libro.cantidad}"/>
                    <sql:param value="${modelo_libro.categoria}"/>
                    <sql:param value="${modelo_libro.isbn}"/>
                    <sql:param value="${modelo_libro.descripcion}"/>
                    <sql:param value="${modelo_libro.edicion}"/>
                </sql:update>  
            </c:catch>
            <c:if test="${not empty error_insert}">
                <div class="alert alert-danger">
                    <strong>Se produjo un error:</strong> ${error_insert}
                </div>
            </c:if>
        </c:if>
                    
        <c:if test="${param.tipo} == 2">
            <c:catch var="error_insert">
                <sql:update var="update" dataSource="jdbc/mysql">
                    UPDATE libro SET titulo = ?, cantidad = ?, categoria = ?, isbn = ?, descripcion = ?, edicion =? WHERE id = ?
                    
                    <sql:param value="${modelo_libro.titulo}"/>
                    <sql:param value="${modelo_libro.cantidad}"/>
                    <sql:param value="${modelo_libro.categoria}"/>
                    <sql:param value="${modelo_libro.isbn}"/>
                    <sql:param value="${modelo_libro.descripcion}"/>
                    <sql:param value="${modelo_libro.edicion}"/>
                    <sql:param value="${modelo_libro.id}"/>
                </sql:update>  
            </c:catch>
            <c:if test="${not empty error_insert}">
                <div class="alert alert-danger">
                    <strong>Se produjo un error:</strong> ${error_insert}
                </div>
            </c:if>
        </c:if>
    </body>
</html>
