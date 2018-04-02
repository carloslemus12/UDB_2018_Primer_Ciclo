<%-- 
    Document   : menu
    Created on : 30-mar-2018, 19:04:23
    Author     : MekakuZero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Categorias
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a href="/Guia9_Biblioteca/categoria.jsp" class="dropdown-item"> Añadir categoria </a>
                <a href="/Guia9_Biblioteca/categorias.jsp" class="dropdown-item"> Mostrar categorias </a>
            </div>
       </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Libros
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a href="/Guia9_Biblioteca/libro.jsp" class="dropdown-item"> Añadir libro </a>
            <a href="/Guia9_Biblioteca/libros.jsp" class="dropdown-item"> Mostrar libros </a>
        </div>
      </li>
    </ul>
  </div>
</nav>

<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
