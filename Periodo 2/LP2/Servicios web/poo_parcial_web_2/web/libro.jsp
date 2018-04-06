<%-- 
    Document   : libro
    Created on : 05-abr-2018, 16:22:48
    Author     : MekakuZero
--%>

<%@page import="mojica.alexander.pojo.Usuario"%>
<%@page import="mojica.alexander.pojo.Libro"%>
<%@page import="mojica.alexander.modelo.LibroModelo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="libro" scope="session" class='mojica.alexander.pojo.Libro' />
<%
    if (session.getAttribute("usuario") == null) {
        request.setAttribute("mensaje_Error", "Debe de iniciar la sesion");
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }
    
    Usuario usuario = (Usuario)session.getAttribute("usuario");
    
    Integer id = Integer.valueOf(request.getParameter("id"));
    LibroModelo.encontrar(libro, id);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= libro.getTitulo() %></title>
        
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <style>
            body {
                background: url('img/back_repeat_book.jpg');
            }
        </style>
        <script>
            
        </script>
    </head>
    <body>
        <jsp:include page="Menu.jsp" />
        
        <div class="bg-danger text-dark display-4 text-dark w-100 p-3 z-depth-5 text-center" style="background: url('img/back_paper.jpg');">
            <%= libro.getTitulo() %>
        </div>
        
        <div class="container w-100 h-100 d-flex justify-content-center align-items-center">
            <div class="card bg-transparent" style="width: 40rem;">
                <center><img class="card-img-top w-75 my-3" src="<%= (libro.getUrl_Img() != null)? libro.getUrl_Img() : "img/bookshelf.svg" %>" alt="Card image cap"></center>
                
                <div class="card-body bg-primary p-2">
                    
                    <div class="row text-white text-center">
                        <div class="col">
                            <strong class="mr-2">Autor:</strong><%= libro.getAutor()%>
                        </div>
                    </div>
                    
                </div>
                
                <div class="card-body bg-dark p-2">
                
                    <div id="estrella" class="row p-0 m-0">
                        <jsp:include page="Estrellas.jsp" />
                    </div>
                    
                </div>
                
                <div class="card-body bg-danger text-white">
                    <p class="card-text"><%= (libro.getDescripcion() != null)? libro.getDescripcion() : "No posee descripcion" %></p>
                </div>
                <ul class="list-group bg-white list-group-flush">
                
                    <div id="comentarios">
                        <jsp:include page="Comentarios.jsp" >
                            <jsp:param name="id" value='<%= id %>'/>
                        </jsp:include>
                    </div>

                    <div id="msg"></div>
                    <li class="list-group-item bg-secondary rounded-0">
                        <div class="form-row">
                            <div class="col-11">
                                <input id="txt_msg" type="text" class="form-control" placeholder="Comentario" />
                            </div>
                            <div class="col d-flex align-items-center">
                                <img id="img_enviar" src="img/send.svg" style="height: 30px;" />
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
                
        <script>
            var id = <%= id %>;
            var id_user = <%= usuario.getId() %>;
            
            $(document).ready(function(){
                
                
                
               // Envio de comentarios
               $("#img_enviar").click(function(){
                   var msg = $("#txt_msg").val();
                   
                   if (msg != "") {
                       var url = "/poo_parcial_web_2/Libro_Comentario";
                        $.post( url, { msg: msg, id_libro: id, id_usuario: id_user }, function( data ) {

                            var datos = jQuery.parseJSON( data );

                            if (datos.tipo === 1) {
                                $('#msg').html("<li class='list-group-item rounded-0 alert alert-danger alert-dismissible fade show' role='alert'>"
                                               + datos.msg
                                               + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                                               + "<span aria-hidden='true'>&times;</span>"
                                               + "</button></li>"
                                          );
                            } else {
                                $( "#comentarios" ).load( "Comentarios.jsp", { id : id } );
                                $("#txt_msg").val("");
                            }
                        });
                    } else
                        alert("Debe de escribir un comentario");
               });
            });
        </script>
    </body>
</html>
