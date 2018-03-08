<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AgregarRegistroLINQ.aspx.cs" Inherits="AgregarRegistroLINQ" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Bolsa de Trabajo en Línea - Universidad Don Bosco</title>
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
<header id="header" class="skel-layers-fixed">
    <h1 id="logo"><a href="/">Página Principal</a></h1>
</header>

<!-- Header --><style>
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
<section>
<h3>Edición de Registros</h3>
<div class="row uniform 50%">
<asp:HiddenField ID="ProductID" runat="server" />
<div class="6u 12u$(xsmall)">
<asp:Label runat="server" Text="Nombre de Producto"></asp:Label>
<asp:TextBox ID="ProductName" runat="server"></asp:TextBox>
</div>
<div class="6u 12u$(xsmall)">
Proveedor
<div class="select-wrapper"><asp:DropDownList
ID="SupplierID" runat="server"></asp:DropDownList></div>
</div>
<div class="6u 12u$(xsmall)">
Categoría
<div class="select-wrapper">
<asp:DropDownList ID="CategoryID" runat="server"></asp:DropDownList>
</div>
</div>
<div class="6u 12u$(xsmall)">
<asp:Label runat="server" Text="Cantidad por unidad" />
<asp:TextBox ID="QuantityPerUnit" runat="server" />
</div>
<div class="6u 12u$(xsmall)">
<asp:Label runat="server" Text="Precio por unidad" />
<asp:TextBox ID="UnitPrice" runat="server" />
</div>
<div class="6u 12u$(xsmall)">
<asp:Label runat="server" Text="Unidades en ventas" />
<asp:TextBox ID="UnitsInStock" runat="server" />
</div>
<div class="6u$ 12u$(xsmall)">
<asp:Label runat="server" Text="Unidades por orden" />
<asp:TextBox ID="UnitsOnOrder" runat="server" />
</div>
    <div class="2u 12u$(xsmall)">
<br />
<asp:Button OnClientClick="return confirm('¿Desea
agregar un nuevo registro?');" ID="btnAgregar" runat="server" Text="Agregar" Width="100%"
CssClass="special" OnClick="btnAgregar_Click" />
</div>
</div>
</section>
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
<li>&copy; 2016. All rights reserved.</li>
</ul>
</footer>
</body>
</html>