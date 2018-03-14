<%@ Page Language="C#" AutoEventWireup="true" CodeFile="TipoClientes.aspx.cs" Inherits="TipoClientes" %>


<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="../Assets/css/bootstrap.min.css" rel="stylesheet" />
    <title>Tipo de de clientes</title>
</head>
<body>
    <form id="form1" runat="server">
    <div class="container">
        <div class="row">
            <h2>Tipos de clientes</h2>
        </div>
        <div class="row col-md-6">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3>
                        <asp:Label ID="lblTitulo" runat="server" /></h3>
                </div>
                <div class="panel-body">
                    
                    <div class="form-group">
                        <label for="txtId">Ingrese el ID del tipo de cliente:</label>
                        <asp:TextBox ID="txtId" runat="server" CssClass="form-control" ></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" ControlToValidate="txtId" Display="Dynamic" runat="server" ErrorMessage="El id es obligatorio" ForeColor="Red"></asp:RequiredFieldValidator>
                    </div>
                    <div class="form-group">
                        <label for="txtTipo">Ingrese el nombre del tipo:</label>
                        <asp:TextBox ID="txtTipo" runat="server" CssClass="form-control" ></asp:TextBox>
                       <asp:RequiredFieldValidator ID="RequiredFieldValidator2" ControlToValidate="txtTipo" Display="Dynamic" runat="server" ErrorMessage="El nombre del tipo es obligatorio" ForeColor="Red"></asp:RequiredFieldValidator>
                    </div>
                    <div class="form-group">
                        <label for="txtDescripcion">Ingrese la descripción del tipo:</label>
                        <asp:TextBox ID="txtDescripcion" runat="server" CssClass="form-control" ></asp:TextBox>
                       <asp:RequiredFieldValidator ID="RequiredFieldValidator3" ControlToValidate="txtDescripcion" Display="Dynamic" runat="server" ErrorMessage="El carnet es obligatorio" ForeColor="Red"></asp:RequiredFieldValidator>
                        
                    </div>
                   
                    <asp:HiddenField ID="hfOp" runat="server" />
                    <asp:Button ID="btnAceptar" runat="server" Text="Aceptar" CssClass="btn btn-success" OnClick="btnAceptar_Click" />
                 
                </div>
                <asp:Label ID="lblError" runat="server" Text="" ForeColor="Red"></asp:Label>
            </div>
        </div>
        
    </div>
    </form>
</body>
</html>

