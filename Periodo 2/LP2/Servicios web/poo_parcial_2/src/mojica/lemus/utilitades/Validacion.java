/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojica.lemus.utilitades;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author MekakuZero
 */
public class Validacion {
    
    // Constante de valor
    private static final int SOLOTEXTO = 1;
    
    private Map<String, javax.swing.JTextField> textboxs;
    private Map<String, javax.swing.JTextArea> textareas;
    private Map<String, List<Integer>> validaciones;
    private Map<String, String> igualdad;
    private List<String> vacios;
    private List<String> errores;
    
    public Validacion() {
        this.textboxs = new HashMap<>();
        this.validaciones = new HashMap<>();
        this.igualdad = new HashMap<>();
        this.vacios = new ArrayList<>();
        this.textareas = new HashMap<>();
    }
    
    public void msgError(String titulo){
        String msg_Error = "";
        
        boolean estado = false;
        for (String error : this.errores) {
            msg_Error += ((estado)? "\n* ": "* ") +  error;
            estado = true;
        }
        
        Mensaje.error(titulo, msg_Error);
    }
    
    public Validacion addTextBox(javax.swing.JTextField txt, String campo){
    
        // Si es un nuevo campo
        if (!this.textboxs.containsKey(campo)) {
            this.textboxs.put(campo, txt);
            this.validaciones.put(campo, new ArrayList<>());
        }
        
        return this;
    }
    
    public Validacion addTextArea(javax.swing.JTextArea txt, String campo){
    
        // Si es un nuevo campo
        if (!this.textareas.containsKey(campo)) {
            this.textareas.put(campo, txt);
            this.validaciones.put(campo, new ArrayList<>());
        }
        
        return this;
    }
    
    // Añadimos las validaciones
    public Validacion validarNoVacios(String[] campos){
    
        for(String campo: campos){
            if (this.textboxs.containsKey(campo) || this.textareas.containsKey(campo)) {
                this.vacios.add(campo);
            }
        }
        
        return this;
    }
    
    public Validacion validarSoloTexto(String[] campos){
    
        for(String campo: campos){
            if (this.textboxs.containsKey(campo) || this.textareas.containsKey(campo)) {
                this.validaciones.get(campo).add(SOLOTEXTO);
            }
        }
        
        return this;
    }
    
    public Validacion comprobarIgualdad(String campo, String campo_comparar){
        if ((this.textboxs.containsKey(campo) && this.textboxs.containsKey(campo_comparar)) || (this.textareas.containsKey(campo)|| this.textareas.containsKey(campo_comparar))) {
            this.igualdad.put(campo, campo_comparar);
        }
        
        return this;
    }
    
    // Validaciones
    public static String soloTexto(String campo, javax.swing.JTextField txt){
        String error = "";
        
        Pattern p = Pattern.compile("^[a-zA-Z ]+$");
        Matcher m = p.matcher(txt.getText());
        
        if (!m.find()) {
            error = "El campo " + campo + " solo puede contener texto";
        }
        
        return error;
    }
    
    public static String soloTexto(String campo, javax.swing.JTextArea txt){
        String error = "";
        
        Pattern p = Pattern.compile("^[a-zA-Z ]+$");
        Matcher m = p.matcher(txt.getText());
        
        if (!m.find()) {
            error = "El campo " + campo + " solo puede contener texto";
        }
        
        return error;
    }
    
    // Comprobamos si todo esta bien
    public boolean validar(){
        errores = new ArrayList<>();
        
        for(Entry<String, JTextField> dato: this.textboxs.entrySet() ){
            String campo = dato.getKey();
            
            if (dato.getValue().getText().trim().equals("")){
                if (this.vacios.contains(campo))
                    errores.add("El campo " + campo + " no puede estar vacio");
                continue;
            }
            
            // Primeros realizamos las comprobacions
            if (this.validaciones.containsKey(campo)) {
                List<Integer> comprobaciones = this.validaciones.get(campo);
                
                for(int accion: comprobaciones){
                    String error = "";
                    switch(accion){
                        case SOLOTEXTO:
                            error = soloTexto(campo, dato.getValue());
                            break;
                    }
                    
                    // Si posee algun error
                    if (!error.isEmpty()) {
                        errores.add(error);
                    }
                }
            }
            
            if (this.igualdad.containsKey(campo)) {
                String campo_comparar = this.igualdad.get(campo);
                
                if (!dato.getValue().getText().trim().equals(this.textboxs.get(campo_comparar).getText().trim()))
                    errores.add("El campo " + campo + " debe de ser similar al campo " + campo_comparar);
            }
        }
        
        for(Entry<String, JTextArea> dato: this.textareas.entrySet() ){
            String campo = dato.getKey();
            
            if (dato.getValue().getText().trim().equals("")){
                if (this.vacios.contains(campo))
                    errores.add("El campo " + campo + " no puede estar vacio");
                continue;
            }
            
            // Primeros realizamos las comprobacions
            if (this.validaciones.containsKey(campo)) {
                List<Integer> comprobaciones = this.validaciones.get(campo);
                
                for(int accion: comprobaciones){
                    String error = "";
                    switch(accion){
                        case SOLOTEXTO:
                            error = soloTexto(campo, dato.getValue());
                            break;
                    }
                    
                    // Si posee algun error
                    if (!error.isEmpty()) {
                        errores.add(error);
                    }
                }
            }
            
            if (this.igualdad.containsKey(campo)) {
                String campo_comparar = this.igualdad.get(campo);
                
                if (!dato.getValue().getText().trim().equals(this.textboxs.get(campo_comparar).getText().trim()))
                    errores.add("El campo " + campo + " debe de ser similar al campo " + campo_comparar);
            }
        }
        
        return errores.size() == 0;
    }
    
    // Obtenemos texto
    public String getText(String campo){
        if (this.textboxs.containsKey(campo) || this.textareas.containsKey(campo)) {
            return this.textboxs.get(campo).getText().trim();
        }
        
        if (this.textareas.containsKey(campo)) {
            return this.textareas.get(campo).getText().trim();
        }
        
        return "";
    }
    
    public String getTextFilter(String campo){
        if (this.textboxs.containsKey(campo) || this.textareas.containsKey(campo)) {
            String txt = this.textboxs.get(campo).getText().trim();
            return txt.replaceAll("[p,P][u,U][t,T][a,A]", "****").replaceAll("[m,M][i,I][e,E][r,R][d,D][a,A]", "******").replaceAll("[p,P][e,E][n,N][d,D][e,E][j,J][o,O]", "*******");
        }
        
        if (this.textareas.containsKey(campo)) {
            String txt = this.textareas.get(campo).getText().trim();
            return txt.replaceAll("[p,P][u,U][t,T][a,A]", "****").replaceAll("[m,M][i,I][e,E][r,R][d,D][a,A]", "******").replaceAll("[p,P][e,E][n,N][d,D][e,E][j,J][o,O]", "*******");
        }
        
        return "";
    }
    
    public static String filtar(String txt){
        return txt.replaceAll("[p,P][u,U][t,T][a,A]", "****").replaceAll("[m,M][i,I][e,E][r,R][d,D][a,A]", "******").replaceAll("[p,P][e,E][n,N][d,D][e,E][j,J][o,O]", "*******");
    }
    
    public static boolean isEmpty(javax.swing.JTextField txt){
        return txt.getText().trim().isEmpty();
    }
    
    public static boolean isEmpty(javax.swing.JTextArea txt){
        return txt.getText().trim().isEmpty();
    }
}
