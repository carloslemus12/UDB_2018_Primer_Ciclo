<%-- 
    Document   : menu
    Created on : 14-mar-2018, 19:30:38
    Author     : MekakuZero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession info = request.getSession(); %>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a href="categorias.jsp" class="nav-link"> Administrar categorias </a>
      </li>
      <li class="nav-item">
          <a href="libros.jsp" class="nav-link"> Administrar libros </a>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Informacion de la cuenta (<%= info.getAttribute("usuario").toString() %>)
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a href="cerrarsesion.jsp" class="dropdown-item"> Cerrar sesion </a>
            <a href="borrar.jsp" class="dropdown-item"> Borrar cuenta </a>
            <a href="modificar.jsp" class="dropdown-item"> Modificar cuenta </a>
        </div>
      </li>
    </ul>
  </div>
</nav>

<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>