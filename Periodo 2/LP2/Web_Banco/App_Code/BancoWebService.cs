using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.Services;

/// <summary>
/// Summary description for BancoWebService
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
// [System.Web.Script.Services.ScriptService]
public class BancoWebService : System.Web.Services.WebService
{

    bd_serviciosEntities banco = new bd_serviciosEntities();

    public BancoWebService()
    {

        //Uncomment the following line if using designed components 
        //InitializeComponent(); 
    }

    [WebMethod]
    public bool Registrarse(string numero_cuenta, string propietario, string pin, decimal monto)
    {
        if (monto < 100) return false;

        cuenta c = new cuenta();
        c.numero_cuenta = numero_cuenta;
        c.nombre_propietario = propietario;
        c.pin = pin;
        c.saldo = monto;

        try
        {
            banco.cuentas.Add(c);
            banco.SaveChanges();
            return true;
        }
        catch (Exception ex) { Console.Write(ex.ToString());  return false; }
    }


    [WebMethod]
    public cuenta ObtenerCuenta(string numero_cuenta)
    {
        return banco.cuentas.Find(numero_cuenta);
    }

    [WebMethod]
    public String ObtenerCuentaJSON(string numero_cuenta)
    {
        JavaScriptSerializer serial = new JavaScriptSerializer();
        return serial.Serialize(banco.cuentas.Find(numero_cuenta));
    }

    [WebMethod]
    public bool Depositar(string numero_cuenta, decimal monto)
    {
        cuenta c = banco.cuentas.Find(numero_cuenta);
        if (c == null) return false;

        c.saldo += monto;
        banco.SaveChanges();
        return true;
    }

    [WebMethod]
    public bool ObtenerSaldo(string numero_cuenta, decimal monto)
    {
        cuenta c = banco.cuentas.Find(numero_cuenta);
        if (c == null) return false;
        
        c.saldo -= monto;
        banco.SaveChanges();
        return true;
    }
}
