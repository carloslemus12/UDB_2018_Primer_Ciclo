/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemus.alexander;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public Libros(int id) {
        this.id = id;
        this.titulo = "";
        this.cantidad = 0;
        this.categoria = 0;
        this.isbn = "";
        this.descripcion = "";
        this.edicion = "";
    }
    
    public Libros(ResultSet info) throws Exception {
        this.id = info.getInt("id");
        this.titulo = info.getString("titulo");
        this.cantidad = info.getInt("cantidad");
        this.categoria = info.getInt("categoria");
        this.isbn = info.getString("isbn");
        this.descripcion = info.getString("descripcion");
        this.edicion = info.getString("edicion");
    }
    
    public Libros() {
        this.id = 0;
        this.titulo = "";
        this.cantidad = 0;
        this.categoria = 0;
        this.isbn = "";
        this.descripcion = "";
        this.edicion = "";
    }
    
    public static Libros obtenerLibro(int id) {
        Libros l = new Libros();
        
        l.conectar();
        
        Libros libro = new Libros();
        
        l.crearQuery("SELECT * FROM libro where id = ?");
        
        l.agregarParametro(1, id);
        
        ResultSet rs = l.getResultSet();
        
        try {
            if(rs.next())
                libro = new Libros(rs);
        } catch(Exception error){}
        
        l.desconectar();
        
        return libro;
    }
    
    public static List<Libros> obtenerLibros() {
        Libros l = new Libros();
        
        l.conectar();
        
        List<Libros> libros = new ArrayList<>();
        
        l.crearQuery("SELECT * FROM libro");
        
        ResultSet rs = l.getResultSet();
        
        try {
            while(rs.next())
                libros.add(new Libros(rs));
        } catch(Exception error){}
        
        l.desconectar();
        
        return libros;
    }
    
    @Override
    public boolean guardar() {
        this.conectar();
        
        this.crearQuery("INSERT INTO libro VALUES (?,?,?,?,?,?,?)");
        
        this.agregarParametro(1, id);
        this.agregarParametro(2, titulo);
        this.agregarParametro(3, cantidad);
        this.agregarParametro(4, categoria);
        this.agregarParametro(5, isbn);
        this.agregarParametro(6, descripcion);
        this.agregarParametro(7, edicion);
        
        boolean estado = this.ejecutarQuery() > 0;
        
        this.desconectar();
        
        return estado;
    }

    @Override
    public boolean eliminar() {
        this.conectar();
        
        this.crearQuery("DELETE FROM libro WHERE id = ?");
        
        this.agregarParametro(1, id);
        
        boolean estado = this.ejecutarQuery() > 0;
        
        this.desconectar();
        
        return estado;
    }

    @Override
    public boolean actualizar() {
        this.conectar();
        
        this.crearQuery("UPDATE libro SET titulo = ?, cantidad = ?, categoria = ?, isbn = ?, descripcion = ?, edicion =? WHERE id = ?");
        
        this.agregarParametro(1, titulo);
        this.agregarParametro(2, cantidad);
        this.agregarParametro(3, categoria);
        this.agregarParametro(4, isbn);
        this.agregarParametro(5, descripcion);
        this.agregarParametro(6, edicion);
        this.agregarParametro(7, id);
        
        boolean estado = this.ejecutarQuery() > 0;
        
        this.desconectar();
        
        return estado;
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
        if (titulo.trim().equals(""))
            this.titulo = null;
        else
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
        if (isbn.trim().equals(""))
            this.isbn = null;
        else
            this.isbn = isbn;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion.trim().equals(""))
            this.descripcion = null;
        else
            this.descripcion = descripcion;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        if (edicion.trim().equals(""))
            this.edicion = null;
        else
            this.edicion = edicion;
    }

    public Categorias getModelCategoria(){
        Categorias categoria = Categorias.obtenerCategoria(this.categoria);
        return categoria;
    }
    
    @Override
    public String toString() {
        return "Libros{" + "id=" + id + ", titulo=" + titulo + ", cantidad=" + cantidad + ", categoria=" + categoria + ", isbn=" + isbn + ", descripcion=" + descripcion + ", edicion=" + edicion + '}';
    }
    
}
