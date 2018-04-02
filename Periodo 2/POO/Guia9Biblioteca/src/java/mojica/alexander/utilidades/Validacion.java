/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojica.alexander.utilidades;

/**
 *
 * @author MekakuZero
 */
public class Validacion {
    // Comprobamos que todos los textbox sean vacios
    public static boolean ComprobarDatosTextBox(javax.swing.JTextField textboxs[]){
        for (javax.swing.JTextField txt : textboxs)
            if (txt.getText().trim().equals(""))
                return false;
        
        return true;
    }
}
