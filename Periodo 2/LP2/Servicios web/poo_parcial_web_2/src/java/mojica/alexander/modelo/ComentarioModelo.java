/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojica.alexander.modelo;

import mojica.alexander.mvc.Conexion;

/**
 *
 * @author MekakuZero
 */
public class ComentarioModelo {
    public static boolean insertarComentario(int id_libro, int id_usuario, String msg){
        Conexion con = Conexion.obtenerConexion();
        
        con.conectar();
        
        con.crearQuery("INSERT INTO comentario VALUES (?, ?, ?)");
        
        con.agregarParametro(1, id_libro);
        con.agregarParametro(2, id_usuario);
        con.agregarParametro(3, msg);
        
        boolean result = con.ejecutarQuery() > 0;
        
        con.desconectar();
        
        return result;
    }
}
