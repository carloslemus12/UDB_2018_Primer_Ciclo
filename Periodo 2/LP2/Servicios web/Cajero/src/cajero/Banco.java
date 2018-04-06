/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import org.tempuri.Cuentas;

/**
 *
 * @author MekakuZero
 */
public class Banco {

    public static String iniciarSecionJSON(java.lang.String numeroCuenta) {
        org.tempuri.BancoWebService service = new org.tempuri.BancoWebService();
        org.tempuri.BancoWebServiceSoap port = service.getBancoWebServiceSoap();
        return port.iniciarSecionJSON(numeroCuenta);
    }

    public static Cuentas iniciarSecion(java.lang.String numeroCuenta) {
        org.tempuri.BancoWebService service = new org.tempuri.BancoWebService();
        org.tempuri.BancoWebServiceSoap port = service.getBancoWebServiceSoap();
        return port.iniciarSecion(numeroCuenta);
    }

    public static boolean depositar(java.lang.String numeroCuenta, java.math.BigDecimal monto) {
        org.tempuri.BancoWebService service = new org.tempuri.BancoWebService();
        org.tempuri.BancoWebServiceSoap port = service.getBancoWebServiceSoap();
        return port.depositar(numeroCuenta, monto);
    }

    public static boolean retirar(java.lang.String numeroCuenta, java.math.BigDecimal monto) {
        org.tempuri.BancoWebService service = new org.tempuri.BancoWebService();
        org.tempuri.BancoWebServiceSoap port = service.getBancoWebServiceSoap();
        return port.retirar(numeroCuenta, monto);
    }
    
}
