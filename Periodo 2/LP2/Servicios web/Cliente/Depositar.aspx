<%@ Page Title="" Language="C#" MasterPageFile="~/Master.master" AutoEventWireup="true" CodeFile="Depositar.aspx.cs" Inherits="Depositar" %>

<asp:Content ID="cont_titulo" ContentPlaceHolderID="content_titulo" Runat="Server">
    Depositar
</asp:Content>
<asp:Content ID="cont_cuerpo" ContentPlaceHolderID="content_cuerpo" Runat="Server">
    <div class="h-100 w-100 d-flex justify-content-center align-items-center mt-3">
        <div class="card w-50">
            <img class="card-img-top" src="Img/city_light.jpg" />
            
           <div class="row">
               <div class="form-group col mt-3">
                    <asp:Label ID="lbl_monto" runat="server" Text="Saldo total: 0.00$" CssClass="text-danger ml-3"></asp:Label>
                </div>
           </div>
            
            <div class="card-body row">

                <div class="form-group col">
                    <label for="txt_monto">Cantidad a ingresar</label>
                    <asp:TextBox ID="txt_monto" class="form-control" runat="server" Text="0.00" min="0" step="0.01" TextMode="Number" placeholder="0.00" />
                    <asp:RequiredFieldValidator ControlToValidate="txt_monto" ErrorMessage="El saldo de la cuenta es obligatorio" Display="None" runat="server" />
                </div>

            </div>

            <asp:ValidationSummary ID="validacion" CssClass="alert alert-danger" DisplayMode="BulletList" runat="server" />

            <div class="card-footer text-muted p-0">
                <div class="form-group col mt-2 w-100 d-flex justify-content-md-between">
                    <asp:Button ID="btn_aceptar" runat="server" Text="Depositar" CssClass="btn btn-success" OnClick="btn_aceptar_Click"/>
                    <button class="btn btn-danger" type="reset">Limpiar</button>
                </div>
            </div>
        </div>
    </div>
</asp:Content>

