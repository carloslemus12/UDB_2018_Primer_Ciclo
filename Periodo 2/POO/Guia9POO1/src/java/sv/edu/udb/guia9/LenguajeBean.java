/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.guia9;

/**
 *
 * @author MekakuZero
 */
public class LenguajeBean implements java.io.Serializable {
    private String nombre;
    private String lenguaje;
    private String comentarios;

    public LenguajeBean() {
        this.nombre = "";
        this.lenguaje = "";
        this.comentarios = "";
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }
    
}
