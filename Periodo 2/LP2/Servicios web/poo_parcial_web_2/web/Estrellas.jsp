<%-- 
    Document   : Estrellas
    Created on : 05-abr-2018, 22:38:08
    Author     : MekakuZero
--%>
<%@page import="mojica.alexander.pojo.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    boolean uso = false;
    Usuario usuario = (Usuario)session.getAttribute("usuario");
    int id = Integer.valueOf(request.getParameter("id"));
%>
<div class="col-sm-12 col-md-6">
    
    <sql:query var="votaciones" dataSource="jdbc/mysql">
        SELECT voto from votacion WHERE id_libro = <%= id %> and id_usuario = <%= usuario.getId() %>
    </sql:query>

    <c:forEach var="votacion" items="${votaciones.rows}">
        <% uso = true; %>
        <img id="img_star_1" src="${ (votacion.voto >= 1)? "img/star_on.png": "img/star_off.png"}" />
        <img id="img_star_2" src="${ (votacion.voto >= 2)? "img/star_on.png": "img/star_off.png"}" />
        <img id="img_star_3" src="${ (votacion.voto >= 3)? "img/star_on.png": "img/star_off.png"}" />
        <img id="img_star_4" src="${ (votacion.voto >= 4)? "img/star_on.png": "img/star_off.png"}" />
        <img id="img_star_5" src="${ (votacion.voto >= 5)? "img/star_on.png": "img/star_off.png"}" />
    </c:forEach>
    
    <c:if test="<%= !uso %>">
        <img id="img_star_1" src="img/star_off.png" />
        <img id="img_star_2" src="img/star_off.png" />
        <img id="img_star_3" src="img/star_off.png" />
        <img id="img_star_4" src="img/star_off.png" />
        <img id="img_star_5" src="img/star_off.png" />
    </c:if>
        
</div>

<div id="cont_start" class="col-sm-12 col-md-6 text-white d-flex justify-content-md-end">
    <sql:query var="votaciones_avg" dataSource="jdbc/mysql">
        SELECT cast(avg(voto) as int) as promedio from votacion WHERE id_libro = <%= id %>
    </sql:query>
    
    <c:forEach var="votacion_avg" items="${votaciones_avg.rows}">
        <script>
            for (var i = 0; i < ${ votacion_avg.promedio }; i++) {
                $( "#cont_start" ).append( "<img src='img/favorito.png' />" );
            }
        </script>    
    </c:forEach>
</div>
<script>
    function votar(puntuacion){
        $.post( "/poo_parcial_web_2/Votar", { votacion: puntuacion, id_libro: id, id_usuario: id_user }, function( data ) {
            $.get( "Estrellas.jsp", { id : id }, function(datos){
                $( "#estrella" ).html(datos);
            });
        });
    }

    $('#img_star_1').click(function(){
        votar(1);
    });

    $('#img_star_2').click(function(){
        votar(2);
    });

    $('#img_star_3').click(function(){
        votar(3);
    });

    $('#img_star_4').click(function(){
        votar(4);
    });

    $('#img_star_5').click(function(){
        votar(5);
    });
</script>