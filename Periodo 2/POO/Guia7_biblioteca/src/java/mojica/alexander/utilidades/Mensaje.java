/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojica.alexander.utilidades;

import javax.swing.JOptionPane;

/**
 *
 * @author MekakuZero
 */
public class Mensaje {
    // Mensaje de error
    public static void Error(String cuerpo, String titulo){
        JOptionPane.showMessageDialog(null, "Error: "+cuerpo, titulo, JOptionPane.ERROR_MESSAGE);
    }
    
    // Mensaje de informacion
    public static void Informacion(String cuerpo, String titulo){
        JOptionPane.showMessageDialog(null, cuerpo, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
