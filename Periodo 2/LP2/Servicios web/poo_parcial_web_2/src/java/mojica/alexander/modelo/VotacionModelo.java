/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojica.alexander.modelo;

import java.sql.ResultSet;
import mojica.alexander.mvc.Conexion;

/**
 *
 * @author MekakuZero
 */
public class VotacionModelo {
    
    public static boolean existeVoto(int id_libro, int id_usuario){
        Conexion con = Conexion.obtenerConexion();
        
        con.conectar();
        
        con.crearQuery("SELECT * FROM votacion WHERE id_libro = ? AND id_usuario = ?");
        
        con.agregarParametro(1, id_libro);
        con.agregarParametro(2, id_usuario);
        
        boolean resultado = false;
        
        ResultSet rs = con.getResultSet();
        
        try {
            resultado = rs.next();
        } catch(Exception error){ System.out.println(error); }
        
        con.desconectar();
        
        return resultado;
    }
    
    public static int obtenerVoto(int id_libro, int id_usuario){
        Conexion con = Conexion.obtenerConexion();
        
        con.conectar();
        
        con.crearQuery("SELECT * FROM votacion WHERE id_libro = ? AND id_usuario = ?");
        
        con.agregarParametro(1, id_libro);
        con.agregarParametro(2, id_usuario);
        
        int resultado = 0;
        
        ResultSet rs = con.getResultSet();
        
        try {
            if (rs.next()){
                resultado = rs.getInt("voto");
            }
        } catch(Exception error){ System.out.println(error); }
        
        con.desconectar();
        
        return resultado;
    }
    
    public static boolean votar(int voto, int id_libro, int id_usuario){
        boolean resultado = false;

        boolean existe = existeVoto(id_libro, id_usuario);

        // En el caso que exista
        if (existe) {
            if (obtenerVoto(id_libro, id_usuario) == voto) {
                Conexion con = Conexion.obtenerConexion();
                con.conectar();

                con.crearQuery("DELETE FROM votacion WHERE id_libro = ? AND id_usuario = ?");

                con.agregarParametro(1, id_libro);
                con.agregarParametro(2, id_usuario);

                resultado = con.ejecutarQuery() > 0;

                con.desconectar();

                return resultado;
            }
        }
        
        Conexion con = Conexion.obtenerConexion();

        con.conectar();
        String sql = "";
        
        if (!existe)
            sql = "INSERT INTO votacion (voto, id_libro, id_usuario) VALUES (?, ?, ?)";
        else
            sql = "UPDATE votacion SET voto = ? WHERE id_libro = ? AND id_usuario = ?";
       
        con.crearQuery(sql);
        
        con.agregarParametro(1, voto);
        con.agregarParametro(2, id_libro);
        con.agregarParametro(3, id_usuario);
        
        resultado = con.ejecutarQuery() > 0;
        
        con.desconectar();
        
        return resultado;
    }
}
