using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Registro : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (Session["numero_cuenta"] != null) Response.Redirect("/Depositar.aspx");
    }

    protected void btn_aceptar_Click(object sender, EventArgs e)
    {
        // Obtenemos los valores
        string numero_cuenta = this.txt_codigo_cuenta.Text.Trim();
        string nombre_completo = this.txt_nombre_completo.Text.Trim();
        string pin = this.txt_pin.Text.Trim();
        decimal saldo = Decimal.Parse(this.txt_saldo_inicial.Text.Trim());

        BancoWebService.BancoWebServiceSoapClient banco = new BancoWebService.BancoWebServiceSoapClient();

        bool estado = banco.Registrar(numero_cuenta, nombre_completo, pin, saldo);

        if (estado)
        {
            Session["numero_cuenta"] = numero_cuenta;
            Response.Redirect("/Depositar.aspx");
        }
        else
            Response.Write("<div class='alert alert-warning alert-dismissible fade show' role='alert'>"
                           + "<strong> Error </strong> No se ha podido registrar."
                           + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                           + "<span aria-hidden='true'>&times;</span></button></div>");
    }
}