/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojica.lemus.utilitades;

import javax.swing.JOptionPane;

/**
 *
 * @author MekakuZero
 */
public class Mensaje {
    public static void informacion(String titulo, String msg){
        JOptionPane.showMessageDialog(null, msg, titulo,JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void error(String titulo, String msg){
        JOptionPane.showMessageDialog(null, msg, titulo,JOptionPane.ERROR_MESSAGE);
    }
}
