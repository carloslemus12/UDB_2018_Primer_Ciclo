/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.sql.*;
/**
 *
 * @author MekakuZero
 */
public class Conexion {
    // Objeto de conexion
    private Connection con;
    private PreparedStatement sentencia;
            
    // Base de datos
    private static String base = "";
    
    // Informacion de la conexion
    private static String sqlConexion = "jdbc:mysql://localhost/";
    private static String usuario = "root";
    private static String clave = "";
    
    // Creamos la conexion
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection(sqlConexion + base, usuario, clave);
        } catch(Exception error){
            System.out.println("Error conexion: " + error.getMessage());
        }
    }
    
    // Establecemos la consulta
    public void crearQuery(String consulta){
        try{
            this.sentencia = this.con.prepareStatement(consulta);
        } catch(Exception error){
            System.out.println("Error crear consulta: " + error.getMessage());
        }
    }
    
    // Añadimos el parametro
    public void agregarParametro(int posicion, int valor){
        try{
            this.sentencia.setInt(posicion, valor);
        } catch(Exception error){
            System.out.println("Error parametro: " + error.getMessage());
        }
    }
    
    public void agregarParametro(int posicion, String valor){
        try{
            this.sentencia.setString(posicion, valor);
        } catch(Exception error){
            System.out.println("Error parametro: " + error.getMessage());
        }
    }
    
    public ResultSet getResultSet(){
        try{
            return this.sentencia.executeQuery();
        } catch(Exception error){
            System.out.println("Error ResultSet: " + error.getMessage());
            return null;
        }
    }
    
    // Ejecutamos el query
    public int ejecutarQuery(){
        try{
            return this.sentencia.executeUpdate();
        } catch(Exception error){
            System.out.println("Error executeUpdate: " + error.getMessage());
            return 0;
        }
    }
    
    // Ceramos seccion
    public void desconectar(){
        try{
            this.sentencia.close();
            this.con.close();
        } catch(Exception error){
            System.out.println("Error desconexion: " + error.getMessage());
        }
    }
}
