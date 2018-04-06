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
    bd_serviciosEntities banco;
    public BancoWebService()
    {
        banco = new bd_serviciosEntities();
        //Uncomment the following line if using designed components 
        //InitializeComponent(); 
    }

    // Metodos del banco
    [WebMethod]
    public bool Registrar(string numero_cuenta, string propietario, string pin, decimal saldo)
    {
        if (saldo < 100) return false;

        cuentas cuenta = new cuentas();
        cuenta.numero_cuenta = numero_cuenta;
        cuenta.nombre_propietario = propietario;
        cuenta.pin = pin;
        cuenta.saldo = saldo;

        try
        {
            banco.cuentas.Add(cuenta);
            banco.SaveChanges();
            return true;
        }
        catch (Exception) { return false; } 
    }

    // Inicio de seccion
    [WebMethod]
    public cuentas IniciarSecion(string numero_cuenta)
    {
        return banco.cuentas.Find(numero_cuenta);
    }

    [WebMethod]
    public string IniciarSecionJSON(string numero_cuenta)
    {
        JavaScriptSerializer serial = new JavaScriptSerializer();
        return serial.Serialize(banco.cuentas.Find(numero_cuenta));
    }

    [WebMethod]
    public bool Depositar(string numero_cuenta, decimal monto)
    {
        cuentas cuenta = banco.cuentas.Find(numero_cuenta);

        if (cuenta == null || monto <= 0) return false;

        cuenta.saldo += monto;

        try
        {
            banco.SaveChanges();
            return true;
        }
        catch (Exception) { return false; }
    }

    [WebMethod]
    public bool Retirar(string numero_cuenta, decimal monto)
    {
        cuentas cuenta = banco.cuentas.Find(numero_cuenta);

        if (cuenta == null || monto <= 0 || monto > cuenta.saldo) return false;

        cuenta.saldo -= monto;

        try
        {
            banco.SaveChanges();
            return true;
        }
        catch (Exception) { return false; }
    }
}
