/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojica.alexander.consulta;

import java.sql.ResultSet;
import mojica.alexander.consulta.Conexion;

/**
 *
 * @author MekakuZero
 */
public class Consulta {
    public static final String STRING = "String";
    public static final String INT = "int";
    
    protected Conexion conexion;
    protected String tabla;

    public Consulta(Conexion conexion, String tabla) {
        this.conexion = conexion;
        this.tabla = tabla;
    }
}
