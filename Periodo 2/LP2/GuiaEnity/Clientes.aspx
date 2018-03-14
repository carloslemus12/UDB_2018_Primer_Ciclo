<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Clientes.aspx.cs" Inherits="Clientes" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Clientes</title>
    <link href="../Assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../Assets/css/alertify.core.css" rel="stylesheet" />
    <link href="../Assets/css/alertify.default.css" rel="stylesheet" />

    <script src="../Assets/js/alertify.js"></script>
    <script>
        function mostrarMensaje(inputType, inputText) {


            if (inputType == 'Error') {
                alertify.error(inputText);
                return false;
            }
            else if (inputType == 'Success') {
                alertify.success(inputText);
                return false;
            }
            else {
                alertify.log(inputText, "", 10000);
                return false;
            }
        }
    </script>
</head>
<body>
    <form id="form1" runat="server">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Roaming Guatemala</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/Clientes.aspx">Clientes</a></li>
                    <li><a href="/Default.aspx">Tipos de clientes</a></li>
                </ul>
            </div>
        </nav>
            
        <div class="container">
            <div class="row">
                <h1>Tipos de clientes</h1>
            </div>
            <div class="row">
                <p><a href="ActualizarClientes.aspx" class="btn btn-info">Nuevo cliente</a></p>
           
                <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" 
                    DataKeyNames="Id"
                    EmptyDataText="No hay registros de datos para mostrar."
                    CssClass="table table-bordered" AllowSorting="True"
                    OnRowDeleting="GridView1_RowDeleting"
                    OnSelectedIndexChanging="GridView1_SelectedIndexChanging"
                    >
                    <Columns>
                        <asp:BoundField DataField="Id" HeaderText="Id" ReadOnly="True" SortExpression="Id" />

                        <asp:TemplateField HeaderText="Codigo" SortExpression="Codigo">
                            <ItemTemplate>
                                <asp:Label  runat="server" ID="lblCodigo" ><%# Eval("Codigo") %></asp:Label>
                            </ItemTemplate>
                        </asp:TemplateField>

                        <asp:TemplateField HeaderText="Nombre completo" SortExpression="NombreCompleto">
                            <ItemTemplate>
                                <asp:Label  runat="server" ID="lblNombreCompleto" ><%# Eval("NombreCompleto") %></asp:Label>
                            </ItemTemplate>
                        </asp:TemplateField>

                        <asp:TemplateField HeaderText="Numero telefonico" SortExpression="Telefono">
                            <ItemTemplate>
                                <asp:Label  runat="server" ID="lblTelefono" ><%# Eval("Telefono") %></asp:Label>
                            </ItemTemplate>
                        </asp:TemplateField>

                        <asp:TemplateField HeaderText="DUI" SortExpression="Dui">
                            <ItemTemplate>
                                <asp:Label  runat="server" ID="lblDui" ><%# Eval("Dui") %></asp:Label>
                            </ItemTemplate>
                        </asp:TemplateField>

                        <asp:TemplateField HeaderText="Tipo cliente" SortExpression="Tipo">
                            <ItemTemplate>
                                <asp:Label  runat="server" ID="lblTipo" ><%# Eval("Tipo") %></asp:Label>
                            </ItemTemplate>
                        </asp:TemplateField>

                        <asp:TemplateField HeaderText="Opciones">
                            <ItemTemplate>
                                <asp:Button ID="btnModificar" Text="Modificar" CssClass="btn btn-success"
                                    runat="server" CommandName="Select" />
                                    <asp:Button ID="btnEliminar" Text="Eliminar" CssClass="btn btn-danger"
                                    runat="server" CommandName="Delete" OnClientClick="return confirm('¿Realmente desea borrar este dato?')" />
                            </ItemTemplate>
                       
                        </asp:TemplateField>
                  
               
                    
                    </Columns>
                </asp:GridView>
            


            </div>
       
            <asp:Label  ID="lblError"  runat="server" />
        </div>

    </form>
</body>
</html>
