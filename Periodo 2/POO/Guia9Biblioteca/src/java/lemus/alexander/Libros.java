/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemus.alexander;

/**
 *
 * @author MekakuZero
 */
public class Libros extends mojica.alexander.mvc.Conexion implements java.io.Serializable{

    // Propiedades del libro a modelar
    private int id;
    private String titulo;
    private int cantidad;
    private int categoria;
    private String isbn;
    private String descripcion;
    private String edicion;

    public Libros() {
        this.id = 0;
        this.titulo = "";
        this.cantidad = 0;
        this.categoria = 0;
        this.isbn = "";
        this.descripcion = "";
        this.edicion = "";
    }
    
    @Override
    public boolean guardar() {
        return false;
    }

    @Override
    public boolean eliminar() {
        return false;
    }

    @Override
    public boolean actualizar() {
        return false;
    }

    /// Obtener y especificar informacion
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }
    
}
