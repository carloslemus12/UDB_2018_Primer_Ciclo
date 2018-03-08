<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Ejercicio 3</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <style>
        html, body, form {
            height: 100%;
        }

        .fill { 
            min-height: 100%;
            height: 100%;
        }
        body {
            background: url(../img/fondo.jpg);
            background-size: 100% 100%;
            background-repeat: no-repeat;
        }
        .card-lemus {
            border-radius: 0.5em;
            box-shadow: 5px 5px 25px black;
            background-color: #FFFAFA;
        }
        .shadow {
            -webkit-box-shadow: 7px 0 10px -2px gray;<asp:SqlDataSource runat="server"></asp:SqlDataSource>
            box-shadow: 7px 0 10px -2px gray;
        }
        /* The snackbar - position it at the bottom and in the middle of the screen */
        #snackbar {
            visibility: hidden; /* Hidden by default. Visible on click */
            min-width: 250px; /* Set a default minimum width */
            margin-left: -125px; /* Divide value of min-width by 2 */
            background-color: #333; /* Black background color */
            color: #fff; /* White text color */
            text-align: center; /* Centered text */
            border-radius: 2px; /* Rounded borders */
            padding: 16px; /* Padding */
            position: fixed; /* Sit on top of the screen */
            z-index: 1; /* Add a z-index if needed */
            left: 50%; /* Center the snackbar */
            bottom: 30px; /* 30px from the bottom */
        }

        /* Show the snackbar when clicking on a button (class added with JavaScript) */
        #snackbar.show {
            visibility: visible; /* Show the snackbar */

        /* Add animation: Take 0.5 seconds to fade in and out the snackbar. 
        However, delay the fade out process for 2.5 seconds */
            -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
            animation: fadein 0.5s, fadeout 0.5s 2.5s;
        }

        /* Animations to fade the snackbar in and out */
        @-webkit-keyframes fadein {
            from {bottom: 0; opacity: 0;} 
            to {bottom: 30px; opacity: 1;}
        }

        @keyframes fadein {
            from {bottom: 0; opacity: 0;}
            to {bottom: 30px; opacity: 1;}
        }

        @-webkit-keyframes fadeout {
            from {bottom: 30px; opacity: 1;} 
            to {bottom: 0; opacity: 0;}
        }

        @keyframes fadeout {
            from {bottom: 30px; opacity: 1;}
            to {bottom: 0; opacity: 0;}
        }
    </style>
</head>
<body>
    
    <!-- Formulario principal -->
    <form id="frm_principal" class="w-100 h-100 d-flex justify-content-center align-items-center" runat="server">

        <asp:SqlDataSource ID="sqlUsuarios" runat="server" ConnectionString="<%$ ConnectionStrings:UsuariosBaseConnectionString %>" DeleteCommand="DELETE FROM [Usuarios] WHERE [Codigo] = @Codigo" InsertCommand="INSERT INTO [Usuarios] ([Codigo], [NombreUsuario], [ClaveUsuario], [Coreo], [TipoUsuario], [Estado]) VALUES (@Codigo, @NombreUsuario, @ClaveUsuario, @Coreo, @TipoUsuario, @Estado)" SelectCommand="SELECT Usuarios.Codigo, Usuarios.NombreUsuario, REPLICATE('*',LEN(Usuarios.ClaveUsuario)) as [Clave], Usuarios.Coreo, CASE WHEN Usuarios.Estado = 1 THEN 'Activo' ELSE 'Desactivado' END AS Estado, Tipo_Usuario.Tipo FROM Usuarios INNER JOIN Tipo_Usuario ON Usuarios.TipoUsuario = Tipo_Usuario.Id WHERE (Usuarios.TipoUsuario = @tipo OR @tipo = 0)" UpdateCommand="UPDATE [Usuarios] SET [NombreUsuario] = @NombreUsuario, [ClaveUsuario] = @ClaveUsuario, [Coreo] = @Coreo, [TipoUsuario] = @TipoUsuario, [Estado] = @Estado WHERE [Codigo] = @Codigo">
            <DeleteParameters>
                <asp:Parameter Name="Codigo" Type="String" />
            </DeleteParameters>
            <InsertParameters>
                <asp:Parameter Name="Codigo" Type="String" />
                <asp:Parameter Name="NombreUsuario" Type="String" />
                <asp:Parameter Name="ClaveUsuario" Type="String" />
                <asp:Parameter Name="Coreo" Type="String" />
                <asp:Parameter Name="TipoUsuario" Type="Int32" />
                <asp:Parameter Name="Estado" Type="Byte" />
            </InsertParameters>
            <SelectParameters>
                <asp:ControlParameter ControlID="ddlFiltro" DbType="Int32" DefaultValue="" Name="tipo" PropertyName="SelectedValue" />
            </SelectParameters>
            <UpdateParameters>
                <asp:Parameter Name="NombreUsuario" Type="String" />
                <asp:Parameter Name="ClaveUsuario" Type="String" />
                <asp:Parameter Name="Coreo" Type="String" />
                <asp:Parameter Name="TipoUsuario" Type="Int32" />
                <asp:Parameter Name="Estado" Type="Byte" />
                <asp:Parameter Name="Codigo" Type="String" />
            </UpdateParameters>
        </asp:SqlDataSource>

        <section class="d-flex card-lemus" style="height: 80%; width:85%;">
            
            <nav class="bg-danger w-25 shadow" style="border-top-left-radius: 0.5em; border-bottom-left-radius: 0.5em;">
                <nav class="navbar navbar-dark bg-dark" style="border-top-left-radius: 0.5em;">
                    <span class="navbar-brand">USUARIOS:</span>
                </nav>

                <article class="p-3 text-white">
                    <div class="form-group">
                        <label for="ddlFiltro">Tipo de usuario:</label>
                   
                        <asp:DropDownList AppendDataBoundItems="true" AutoPostBack="true" ID="ddlFiltro" runat="server" CssClass="form-control" DataSourceID="sqlTipoUsuario" DataTextField="Tipo" DataValueField="Id">
                            <asp:ListItem Selected = "True" Value="0">Mostrar todos los usuarios</asp:ListItem > 
                        </asp:DropDownList>
                        <asp:SqlDataSource ID="sqlTipoUsuario" runat="server" ConnectionString="<%$ ConnectionStrings:UsuariosBaseConnectionString %>" SelectCommand="SELECT Id, Tipo FROM Tipo_Usuario"></asp:SqlDataSource>

                    </div>
                </article>
            </nav>

            <section class="w-75 p-4">
                <asp:ScriptManager ID="smContenedor" runat="server"></asp:ScriptManager>
                <script>
                    Sys.WebForms.PageRequestManager.getInstance().add_endRequest(InitialiseSettings);
                    
                    function InitialiseSettings() {
                        mostrarMsg();
                    }
                </script>
                <asp:UpdatePanel ID="upContenedor" runat="server">
                    <ContentTemplate>
                        <asp:Timer ID="tmusuario" runat="server" Interval="30000" OnTick="tmusuario_Tick"></asp:Timer>
                        <asp:GridView ID="tableUsuario" PageSize="6" CssClass="table table-dark table-hover text-center" runat="server" AutoGenerateColumns="False" DataKeyNames="Codigo" DataSourceID="sqlUsuarios" AllowPaging="True">
                            <Columns>
                                <asp:BoundField DataField="Codigo" HeaderText="Codigo" ReadOnly="True" SortExpression="Codigo" />
                                <asp:BoundField DataField="NombreUsuario" HeaderText="Username" SortExpression="NombreUsuario" />
                                <asp:BoundField DataField="Clave" HeaderText="Password" SortExpression="Clave" ReadOnly="True" />
                                <asp:BoundField DataField="Coreo" HeaderText="Coreo" SortExpression="Coreo" />
                                <asp:BoundField DataField="Estado" HeaderText="Estado" ReadOnly="True" SortExpression="Estado" />
                                <asp:BoundField DataField="Tipo" HeaderText="Tipo" SortExpression="Tipo" />
                                <asp:CommandField ButtonType="Image" DeleteImageUrl="~/img/delete.png" HeaderText="Opciones" ShowDeleteButton="True" />
                            </Columns>
                        </asp:GridView>
                    </ContentTemplate>

                    <Triggers>
                        <asp:AsyncPostBackTrigger ControlID="tmusuario" EventName="Tick" />
                        <asp:AsyncPostBackTrigger ControlID="ddlFiltro" EventName="SelectedIndexChanged" />
                    </Triggers>
                </asp:UpdatePanel>
                <asp:UpdateProgress ID="uprContenedor" runat="server" DynamicLayout="true" AssociatedUpdatePanelID="upContenedor">
                    <ProgressTemplate>
                        <div class="progress">
                            <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%"></div>
                        </div>
                    </ProgressTemplate>
                </asp:UpdateProgress>
            </section>

        </section>

        <div id="snackbar">Se han actualizado los usuarios</div>
    </form>

    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
        function mostrarMsg() {
            var msg = document.getElementById("snackbar");
            msg.className = "show";
            setTimeout(function () {
                msg.className = msg.className.replace("show", "");
            }, 3000);
        }
    </script>
</body>
</html>
