<%@ Page Language="C#" AutoEventWireup="true" CodeFile="NuevoRegistro.aspx.cs" Inherits="NuevoRegistro" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Edición de Producto</title>
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
<section>
 <h3>Edición de Registros</h3>
 <div class="row uniform 50%">
 <asp:HiddenField ID="ProductID" runat="server" />
 <div class="6u 12u$(xsmall)">
 <asp:Label runat="server" Text="Nombre de
Producto"></asp:Label>
 <asp:TextBox ID="ProductName" runat="server"></asp:TextBox>
     <asp:RequiredFieldValidator ControlToValidate="ProductName" Display="Dynamic" runat="server" ErrorMessage="Error: Campo obligatorio" />
</div>
 <div class="6u 12u$(xsmall)">
 Proveedor
<div class="select-wrapper"><asp:DropDownList
ID="SupplierID" runat="server"></asp:DropDownList></div>
</div>
 <div class="6u 12u$(xsmall)">
 Categoría
<div class="select-wrapper"><asp:DropDownList
ID="CategoryID" runat="server"></asp:DropDownList></div>
</div>
 <div class="6u 12u$(xsmall)">
 <asp:Label runat="server" Text="Cantidad por
Unidad"></asp:Label>
 <asp:TextBox ID="QuantityPerUnit" runat="server"></asp:TextBox>
     <asp:RequiredFieldValidator ControlToValidate="QuantityPerUnit" Display="Dynamic" runat="server" ErrorMessage="Error: Campo obligatorio" />
</div>
 <div class="6u 12u$(xsmall)">
 <asp:Label runat="server" Text="Precio
Unitario"></asp:Label>
 <asp:TextBox ID="UnitPrice" runat="server"></asp:TextBox>
     <asp:RequiredFieldValidator ControlToValidate="UnitPrice" Display="Dynamic" runat="server" ErrorMessage="Error: Campo obligatorio" />
</div>
 <div class="6u 12u$(xsmall)">
 <asp:Label runat="server"
Text="Existencias"></asp:Label>
 <asp:TextBox ID="UnitsInStock" runat="server"></asp:TextBox>
     <asp:RequiredFieldValidator ControlToValidate="UnitsInStock" Display="Dynamic" runat="server" ErrorMessage="Error: Campo obligatorio" />
</div>
 <div class="6u$ 12u$(xsmall)">
 <asp:Label runat="server" Text="Unidades
Ordenadas"></asp:Label>
 <asp:TextBox ID="UnitsOnOrder" runat="server"></asp:TextBox>
     <asp:RequiredFieldValidator ControlToValidate="UnitsOnOrder" Display="Dynamic" runat="server" ErrorMessage="Error: Campo obligatorio" />
</div>
 <div class="2u 12u$(xsmall)">
 <br />
 <asp:Button ID="btn_Guardar" runat="server" Text="Guardar" Width="100%" CssClass="special" OnClick="btn_Guardar_Click" />
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
<li>&copy; 2018. All rights reserved.</li>
</ul>
</footer>
</body>
</html>