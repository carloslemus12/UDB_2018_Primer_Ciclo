/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojica.alexander.modelo;

import java.sql.ResultSet;
import mojica.alexander.mvc.Conexion;
import mojica.alexander.pojo.Libro;

/**
 *
 * @author MekakuZero
 */
public class LibroModelo {
    public static void encontrar(Libro libro, int id){
        Conexion con = Conexion.obtenerConexion();
        
        con.conectar();
        
        con.crearQuery("SELECT libro.id, libro.titulo, libro.descripcion, libro.url_img, concat(CASE WHEN autor.nombre_completo is null THEN '' ELSE autor.nombre_completo END, ' [ ', CASE WHEN autor.seudonimo is null THEN ' ' ELSE autor.seudonimo END, ' ]') as nombre_autor  FROM libro inner join autor on autor.id = libro.id_autor WHERE libro.id = ?");
        
        con.agregarParametro(1, id);
        
        ResultSet rs = con.getResultSet();
        
        int autor = 0;
        
        try {
            if (rs.next()) {
                libro.setId(id);
                libro.setTitulo(rs.getString("titulo"));
                libro.setDescripcion(rs.getString("descripcion"));
                libro.setUrl_Img(rs.getString("url_img"));
                libro.setAutor(rs.getString("nombre_autor"));
            }
        } catch(Exception error){}
        
        con.desconectar();
    }
}
