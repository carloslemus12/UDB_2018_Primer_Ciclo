/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojica.alexander.pojo;

import java.io.Serializable;

/**
 *
 * @author MekakuZero
 */
public class Libro implements Serializable {
    private int id;
    private String titulo;
    private String descripcion;
    private String url_Img;
    private String autor;

    public Libro() {
    }

    public Libro(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0)
            this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.isEmpty())
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.isEmpty())
        this.descripcion = descripcion;
    }

    public String getUrl_Img() {
        return url_Img;
    }

    public void setUrl_Img(String url_Img) {
        if (url_Img != null && !url_Img.isEmpty())
            this.url_Img = url_Img;
        else
            this.url_Img = null;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor != null && !autor.isEmpty())
            this.autor = autor;
        else
            this.autor = null;
    }
    
}
