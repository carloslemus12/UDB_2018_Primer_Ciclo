<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Registro.aspx.cs" Inherits="Registro" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Registrarse</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <style>
        html, body, form {
            height: 100%;
        }

        body {
            background: url("/Img/repat.jpg");
        }

        .fill { 
            min-height: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
    <form id="frm_registro" runat="server" class="w-100 d-flex justify-content-center align-items-center py-3">
        
        <div class="card w-50">
            <img class="card-img-top" src="Img/city_night.jpg" />
            <div class="card-body row">
                
                <div class="form-group col-md-6">
                    <label for="txt_codigo_cuenta">Numero de cuenta</label>
                    <asp:TextBox ID="txt_codigo_cuenta" class="form-control" runat="server" placeholder="Numero de cuenta" />
                    <asp:RequiredFieldValidator ControlToValidate="txt_codigo_cuenta" ErrorMessage="El numero de la cuenta es obligatorio" Display="None" runat="server" />
                </div>

                <div class="form-group col-md-6">
                    <label for="txt_nombre_completo">Nombre completo</label>
                    <asp:TextBox ID="txt_nombre_completo" class="form-control" runat="server" placeholder="Nombre completo" />
                    <asp:RequiredFieldValidator ControlToValidate="txt_nombre_completo" ErrorMessage="Es obligatorio ingresar el nombre completo" Display="None" runat="server" />
                </div>

                <div class="form-group col-md-6">
                    <label for="txt_pin">Pin</label>
                    <asp:TextBox ID="txt_pin" class="form-control" runat="server" placeholder="xxxx" />
                    <asp:RequiredFieldValidator ControlToValidate="txt_pin" ErrorMessage="El pin de la cuenta es obligatorio" Display="None" runat="server" />
                </div>
                
                <div class="form-group col-md-6">
                    <label for="txt_saldo_inicial">Saldo inicial</label>
                    <asp:TextBox ID="txt_saldo_inicial" class="form-control" runat="server" Text="0.00" min="0" step="0.01" TextMode="Number" placeholder="0.00" />
                    <asp:RequiredFieldValidator ControlToValidate="txt_saldo_inicial" ErrorMessage="El saldo de la cuenta es obligatorio" Display="None" runat="server" />
                </div>
            </div>

            <asp:ValidationSummary ID="validacion" CssClass="alert alert-danger" DisplayMode="BulletList" runat="server" />

            <div class="card-footer text-muted p-0">
                <div class="form-group col mt-2 w-100 d-flex justify-content-between">
                    <asp:Button ID="btn_aceptar" runat="server" Text="Registrarse" CssClass="btn btn-success" OnClick="btn_aceptar_Click"/>
                    <button class="btn btn-danger" type="reset">Limpiar</button>
                </div>
            </div>
        </div>

    </form>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
