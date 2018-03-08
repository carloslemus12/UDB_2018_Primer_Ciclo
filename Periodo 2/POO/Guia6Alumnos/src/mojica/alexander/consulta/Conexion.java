/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojica.alexander.consulta;

import java.sql.*;

/**
 *
 * @author MekakuZero
 */
public class Conexion {
    private Connection conexion;
    
    // Creamos una nueva conexion
    public static Conexion establecerConexion(){
        try{
            Conexion con = new Conexion();
            
            Class.forName("com.mysql.jdbc.Driver");
            con.conexion = DriverManager.getConnection("jdbc:mysql://localhost/guia4_poo1", "root", "");
            
            return con;
        } catch(Exception ex){
            System.out.println("Clase conexion: " + ex.getMessage());
            return null;
        }
    }
    
    protected PreparedStatement crearPreparedStatement(String consulta) throws SQLException{
        return this.conexion.prepareStatement(consulta);
    }
    
    public Query crearQuery(String tabla){
        Query select = new Query(this, tabla);
        return select;
    }
    
    // Cerramos la conexion
    public void cerrarConexion(){
        try{
            this.conexion.close();
        } catch (Exception ex){
            System.out.println("Clase conexion: " + ex.getMessage());
        }
    }
}
