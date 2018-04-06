using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Depositar : System.Web.UI.Page
{
    string num_cuenta;

    protected void Page_Load(object sender, EventArgs e)
    {
        if (Session["numero_cuenta"] != null) {
            BancoWebService.BancoWebServiceSoapClient banco = new BancoWebService.BancoWebServiceSoapClient();
            num_cuenta = Session["numero_cuenta"].ToString();
            var cuenta = banco.IniciarSecion(num_cuenta);
            lbl_monto.Text = "Saldo actual: " + cuenta.saldo + "$";
        }
    }

    protected void btn_aceptar_Click(object sender, EventArgs e)
    {
        decimal monto = Decimal.Parse(txt_monto.Text.Trim());

        BancoWebService.BancoWebServiceSoapClient banco = new BancoWebService.BancoWebServiceSoapClient();

        if (!banco.Retirar(num_cuenta, monto))
        {
            Response.Write("<div class='alert alert-warning alert-dismissible fade show' role='alert'>"
                          + "<strong> Error: </strong> No se ha podido realizar la transaccion."
                          + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                          + "<span aria-hidden='true'>&times;</span></button></div>");
        }
    }
}