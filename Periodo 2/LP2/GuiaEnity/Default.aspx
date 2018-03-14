<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Tipos de clientes</title>
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
                <li><a href="/Clientes.aspx">Clientes</a></li>
                <li class="active"><a href="/Default.aspx">Tipos de clientes</a></li>
            </ul>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <h1>Tipos de clientes</h1>
        </div>
        <div class="row">
            <p><a href="TipoClientes.aspx" class="btn btn-info">Nuevo tipo de cliente</a></p>
           
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" 
                DataKeyNames="idtipocliente"
                EmptyDataText="No hay registros de datos para mostrar."
                CssClass="table table-bordered" AllowSorting="True"
                OnRowDeleting="GridView1_RowDeleting"
                OnSelectedIndexChanging="GridView1_SelectedIndexChanging"
                >
                <Columns>
                    <asp:BoundField DataField="idtipocliente" HeaderText="Id" 
                        ReadOnly="True" SortExpression="idtipocliente" />
                    <asp:TemplateField HeaderText="Nombre" SortExpression="nombre_tipo">
                        <ItemTemplate>
                            <asp:Label  runat="server" ID="lblNombre" ><%# Eval("nombre_tipo") %></asp:Label>
                        </ItemTemplate>
                       

                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Descripción" SortExpression="Descripcion">
                        <ItemTemplate>
                            <asp:Label  runat="server" ID="lblDescripcion" ><%# Eval("Descripcion") %></asp:Label>
                        </ItemTemplate>
                        
                    </asp:TemplateField>
                    <asp:TemplateField>
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
