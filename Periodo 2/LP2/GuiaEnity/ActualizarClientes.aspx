<%@ Page Language="C#" AutoEventWireup="true" CodeFile="ActualizarClientes.aspx.cs" Inherits="ActualizarClientes" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <link href="../Assets/css/bootstrap.min.css" rel="stylesheet" />
    <title>Cliente</title>
</head>
<body>
    <form id="form1" runat="server">
        <div class="container">
            <div class="row">
                <h2>Cliente</h2>
            </div>
            <div class="row col-md-6">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h3>
                            <asp:Label ID="lblTitulo" runat="server" /></h3>
                    </div>
                    <div class="panel-body">
                    
                        <div class="form-group">
                            <label for="txtId">Ingrese el ID del cliente:</label>
                            <asp:TextBox ID="txtId" runat="server" CssClass="form-control" ></asp:TextBox>
                            <asp:RequiredFieldValidator ControlToValidate="txtId" Display="Dynamic" runat="server" ErrorMessage="El id es obligatorio" ForeColor="Red"></asp:RequiredFieldValidator>
                        </div>

                        <div class="form-group">
                            <label for="txtCodigo">Ingrese el codigo del cliente:</label>
                            <asp:TextBox ID="txtCodigo" runat="server" CssClass="form-control" ></asp:TextBox>
                           <asp:RequiredFieldValidator ControlToValidate="txtCodigo" Display="Dynamic" runat="server" ErrorMessage="El carnet es obligatorio" ForeColor="Red"></asp:RequiredFieldValidator>
                        </div>

                        <div class="form-group">
                            <label for="txtNombre">Ingrese el nombre del cliente:</label>
                            <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control" ></asp:TextBox>
                           <asp:RequiredFieldValidator ControlToValidate="txtNombre" Display="Dynamic" runat="server" ErrorMessage="El nombre del tipo es obligatorio" ForeColor="Red"></asp:RequiredFieldValidator>
                        </div>

                        <div class="form-group">
                            <label for="txtApellido">Ingrese el apellido del cliente:</label>
                            <asp:TextBox ID="txtApellido" runat="server" CssClass="form-control" ></asp:TextBox>
                           <asp:RequiredFieldValidator ControlToValidate="txtApellido" Display="Dynamic" runat="server" ErrorMessage="El nombre del tipo es obligatorio" ForeColor="Red"></asp:RequiredFieldValidator>
                        </div>

                        <div class="form-group">
                            <label for="ddlTipos">Ingrese el tipo del cliente:</label>
                            <asp:DropDownList ID="ddlTipos" runat="server" CssClass="form-control" DataTextField="nombre_tipo" DataValueField="idtipocliente"></asp:DropDownList>
                        </div>


                        <div class="form-group">
                            <label for="txtDui">Ingrese el DUI del cliente:</label>
                            <asp:TextBox ID="txtDui" runat="server" CssClass="form-control" ></asp:TextBox>
                           <asp:RequiredFieldValidator ControlToValidate="txtDui" Display="Dynamic" runat="server" ErrorMessage="El carnet es obligatorio" ForeColor="Red"></asp:RequiredFieldValidator>
                        </div>

                        <div class="form-group">
                            <label for="txtNit">Ingrese el NIT del cliente:</label>
                            <asp:TextBox ID="txtNit" runat="server" CssClass="form-control" ></asp:TextBox>
                           <asp:RequiredFieldValidator ControlToValidate="txtNit" Display="Dynamic" runat="server" ErrorMessage="El carnet es obligatorio" ForeColor="Red"></asp:RequiredFieldValidator>
                        </div>

                        <div class="form-group">
                            <label for="txtTelefono">Ingrese el Telefono del cliente:</label>
                            <asp:TextBox ID="txtTelefono" runat="server" CssClass="form-control" ></asp:TextBox>
                           <asp:RequiredFieldValidator ControlToValidate="txtTelefono" Display="Dynamic" runat="server" ErrorMessage="El carnet es obligatorio" ForeColor="Red"></asp:RequiredFieldValidator>
                        </div>

                        <div class="form-group">
                            <label for="ddlSexo">Ingrese el sexo del cliente:</label>
                            <asp:DropDownList ID="ddlSexo" runat="server" CssClass="form-control" >
                                <asp:ListItem Value="m">Masculino</asp:ListItem>
                                <asp:ListItem Value="f">Femenino</asp:ListItem>
                            </asp:DropDownList>
                        </div>

                        <div class="form-group">
                            <label for="ddlEstado">Ingrese el estado del cliente:</label>
                            <asp:DropDownList ID="ddlEstado" runat="server" CssClass="form-control" >
                                <asp:ListItem Value="t">Activo</asp:ListItem>
                                <asp:ListItem Value="f">Inactivo</asp:ListItem>
                            </asp:DropDownList>
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
