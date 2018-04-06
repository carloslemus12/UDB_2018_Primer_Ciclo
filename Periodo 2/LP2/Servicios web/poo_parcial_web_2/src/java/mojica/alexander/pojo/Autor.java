/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojica.alexander.pojo;

/**
 *
 * @author MekakuZero
 */
public class Autor {
    private int id;
    private String nombre_Completo;
    private String seudonimo;

    public Autor(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0)
            this.id = id;
    }

    public String getNombre_Completo() {
        return nombre_Completo;
    }

    public void setNombre_Completo(String nombre_Completo) {
        if (nombre_Completo != null && !nombre_Completo.isEmpty())
            this.nombre_Completo = nombre_Completo;
    }

    public String getSeudonimo() {
        return seudonimo;
    }

    public void setSeudonimo(String seudonimo) {
        if (seudonimo != null && !seudonimo.isEmpty())
            this.seudonimo = seudonimo;
    }
    
}
