using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        BancoWeb.BancoWebServiceSoapClient banco = new BancoWeb.BancoWebServiceSoapClient();
        string json = banco.ObtenerCuentaJSON("12");
        Response.Write(json);
    }
}