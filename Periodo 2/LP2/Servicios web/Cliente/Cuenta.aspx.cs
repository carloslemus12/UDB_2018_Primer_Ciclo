using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Cuenta : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (Session["numero_cuenta"] != null)
        {
            BancoWebService.BancoWebServiceSoapClient banco = new BancoWebService.BancoWebServiceSoapClient();
            var cuenta = banco.IniciarSecion(Session["numero_cuenta"].ToString());
            
            this.txt_codigo_cuenta.Text = cuenta.numero_cuenta;
            this.txt_nombre_completo.Text = cuenta.nombre_propietario;
            this.txt_pin.Text = cuenta.pin;
            this.txt_saldo_inicial.Text = Double.Parse(cuenta.saldo.ToString()).ToString();
        }
    }
}