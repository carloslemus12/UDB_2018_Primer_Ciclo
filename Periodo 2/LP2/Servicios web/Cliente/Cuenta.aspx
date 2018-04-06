<%@ Page Title="" Language="C#" MasterPageFile="~/Master.master" AutoEventWireup="true" CodeFile="Cuenta.aspx.cs" Inherits="Cuenta" %>

<asp:Content ID="cont_titulo" ContentPlaceHolderID="content_titulo" Runat="Server">
    Mi cuenta
</asp:Content>
<asp:Content ID="cont_cuerpo" ContentPlaceHolderID="content_cuerpo" Runat="Server">
    <div class="w-100 d-flex justify-content-center align-items-center">
        <div class="card w-50">
            <img class="card-img-top" src="Img/city_light_1.jpg" />
            <div class="card-body row">
                <div class="form-group col-md-6">
                    <label for="txt_codigo_cuenta">Numero de cuenta</label>
                    <asp:TextBox ID="txt_codigo_cuenta" class="form-control" runat="server" placeholder="Numero de cuenta" ReadOnly="true"/>
                </div>

                <div class="form-group col-md-6">
                    <label for="txt_nombre_completo">Nombre completo</label>
                    <asp:TextBox ID="txt_nombre_completo" class="form-control" runat="server" placeholder="Nombre completo" ReadOnly="true"/>
                </div>

                <div class="form-group col-md-6">
                    <label for="txt_pin">Pin</label>
                    <asp:TextBox ID="txt_pin" class="form-control" runat="server" placeholder="xxxx" ReadOnly="true"/>
                </div>
                
                <div class="form-group col-md-6">
                    <label for="txt_saldo_inicial">Saldo inicial</label>
                    <asp:TextBox ID="txt_saldo_inicial" class="form-control" runat="server" Text="0.00" min="0" step="0.01" TextMode="Number" placeholder="0.00" ReadOnly="true"/>
                </div>
            </div>
        </div>
    </div>
</asp:Content>

