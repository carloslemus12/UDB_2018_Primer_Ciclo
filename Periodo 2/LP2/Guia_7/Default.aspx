<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Control de Productos</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.scrolly.min.js"></script>
<script src="js/jquery.dropotron.min.js"></script>
<script src="js/jquery.scrollex.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/skel-layers.min.js"></script>
<script src="js/init.js"></script>
<noscript>
<link rel="stylesheet" href="css/skel.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/style-xlarge.css" />
</noscript>
<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
</head>
<body>
<!-- Header -->
<header id="header" class="skel-layers-fixed">
<h1 id="logo"><a href="/">Página Principal</a></h1>
<nav id="nav">
<ul>
<li><a href="AgregarRegistroLINQ.aspx" class="button special">Nuevo
Producto</a></li>
</ul>
</nav>
</header>
<style>
.pager table{
width: auto !important;
}
</style>
<!-- Main -->
<div id="main" class="wrapper style1">
<div class="container">
<!-- Formulario de Ingreso de Información -->
<section>
<form id="form1" runat="server">
<div class="row uniform 50%">
<div class="5u 12u$(xsmall)">
Categoría
<div class="select-wrapper"><asp:DropDownList
ID="ddlCategorias" runat="server"></asp:DropDownList></div>
</div>
<div class="5u 12u$(xsmall)">
Proveedor
    <div class="select-wrapper"><asp:DropDownList
ID="ddlProveedor" runat="server"></asp:DropDownList></div>
</div>
<div class="2u 12u$(xsmall)">
<br />
<asp:Button ID="btnBuscar" runat="server"
Text="Buscar" Width="100%" CssClass="special" OnClick="btnBuscar_Click" />
</div>
<div class="12u 12u$(xsmall)">
<asp:GridView ID="GridView1" Width="100%"
CssClass="alt" runat="server" OnPageIndexChanging="GridView1_PageIndexChanging" OnRowCommand="GridView1_RowCommand"></asp:GridView>
</div>
</div>
</form>
</section>
</div>
</div>
<!-- Footer -->
<footer id="footer">
<ul class="icons">
<li><a href="#" class="icon alt fa-twitter"><span
class="label">Twitter</span></a></li>
<li><a href="#" class="icon alt fa-facebook"><span
class="label">Facebook</span></a></li>
<li><a href="#" class="icon alt fa-envelope"><span
class="label">Email</span></a></li>
</ul>
<ul class="copyright">
<li>&copy; 2018. All rights reserved.</li>
</ul>
</footer>
</body>
</html>

